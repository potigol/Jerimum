package jerimum

import javax.sound.sampled.Clip
import javax.sound.sampled.AudioSystem
import br.edu.ifrn.potigol.Potigolutil._
import javax.sound.sampled.AudioInputStream
import java.io.File
import br.edu.ifrn.potigol.Potigolutil._
import javax.sound.sampled.AudioFormat
import javax.sound.sampled.LineListener
import javax.sound.sampled.LineEvent

case class Musica(arquivo: Texto) extends AutoCloseable {
  private val original = AudioSystem.getAudioInputStream(new File(arquivo))
  private val pcm = Musica.paraPcm16(original)
  private val clip = AudioSystem.getClip

  clip.open(pcm)

  private var posicaoPausada: Int = 0
  private var emLoop: Boolean = false

  clip.addLineListener(new LineListener {
    override def update(ev: LineEvent): Unit = {
      if (ev.getType == LineEvent.Type.STOP && !emLoop &&
          clip.getFramePosition >= clip.getFrameLength) {
        clip.setFramePosition(0)
      }
    }
  })

  def toque(loop: Lógico = verdadeiro): Unit = synchronized {
    emLoop = loop
    clip.stop()
    clip.setFramePosition(0)
    clip.loop(if (emLoop) Clip.LOOP_CONTINUOUSLY else 0)
    clip.start()
  }

  def tocando: Lógico = synchronized { clip.isRunning }

  def pare: Unit = synchronized {
    if (clip.isRunning) clip.stop()
    clip.setFramePosition(0)
    posicaoPausada = 0
  }

  def pause: Unit = synchronized {
    if (clip.isRunning) {
      posicaoPausada = clip.getFramePosition
      clip.stop()
    }
  }

  def pausado: Lógico = synchronized {
    !clip.isRunning &&
    posicaoPausada > 0 &&
    posicaoPausada < clip.getFrameLength
  }

  def continue: Unit = synchronized {
    if (!clip.isRunning) {
      if (posicaoPausada > 0 && posicaoPausada < clip.getFrameLength) {
        clip.setFramePosition(posicaoPausada)
      } else if (clip.getFramePosition >= clip.getFrameLength) {
        clip.setFramePosition(0)
      }
      clip.loop(if (emLoop) Clip.LOOP_CONTINUOUSLY else 0)
      clip.start()
    }
  }

  def feche(): Unit = close()

  override def close(): Unit = {
    try clip.stop() catch { case _: Throwable => }
    try clip.close() catch { case _: Throwable => }
    try pcm.close() catch { case _: Throwable => }
    try original.close() catch { case _: Throwable => }
  }
}

object Musica {
  def paraPcm16(in: AudioInputStream): AudioInputStream = {
    val f0 = in.getFormat
    val precisa =
      f0.getEncoding != AudioFormat.Encoding.PCM_SIGNED ||
      f0.getSampleSizeInBits != 16 ||
      f0.isBigEndian ||
      f0.getFrameSize != f0.getChannels * 2

    if (!precisa) in
    else {
      val destino = new AudioFormat(
        AudioFormat.Encoding.PCM_SIGNED,
        f0.getSampleRate,
        16,
        f0.getChannels,
        f0.getChannels * 2,
        f0.getSampleRate,
        false
      )
      AudioSystem.getAudioInputStream(destino, in)
    }
  }
}


case class Som(arquivo: Texto) {
  private val original = AudioSystem.getAudioInputStream(new File(arquivo))
  private val pcm = Musica.paraPcm16(original)
  private val clip = AudioSystem.getClip
  clip.open(pcm)

  def toque(): Unit = synchronized {
    clip.stop()
    clip.setFramePosition(0)
    clip.start()
  }

  def tocando: Lógico = synchronized { clip.isRunning }

  def pare: Unit = synchronized {
    if (clip.isRunning) clip.stop()
  }

}

