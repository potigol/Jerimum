package jerimum

import java.awt.Color.WHITE

import scala.util.Try
import scala.util.Success
import scala.util.Failure

object Jogo extends Runnable {
  var titulo: String = "Sem Nome"
  var largura = 640
  var altura = 480
  var fps = 60
  var display: Tela = _
  var running = false
  var thread: Thread = _

  var desenhe, atualize = () => {}

  def init() = {
    display = new Tela(titulo, largura, altura) {
      frame.addKeyListener(Teclado)
      frame.addMouseListener(Mouse)
      frame.addMouseMotionListener(Mouse)
      canvas.addMouseListener(Mouse)
      canvas.addMouseMotionListener(Mouse)
    }
  }

  def draw(x: Int = 0) = {
    Option(display.canvas.getBufferStrategy) match {
      case None =>
        display.canvas.createBufferStrategy(3)
      case Some(strategy) =>
        val g = strategy.getDrawGraphics
        g.clearRect(0, 0, largura, altura)
        Desenho.desenhe(g)
        strategy.show
        g.dispose()
    }
  }

  override def run() = {
    init()
    val frequencia = 1000000000.0 / fps
    var delta = 0.0
    var ultimo = System.nanoTime()
    var tempo = 0L
    var ciclos = 0
    while (running) {
      val agora = System.nanoTime()
      delta += (agora - ultimo) / frequencia
      tempo += agora - ultimo
      ultimo = agora
      if (delta >= 1) {
        atualize()
        draw()
        desenhe()
        ciclos += 1
        delta -= 1
      }
      if (tempo >= 1000000000) {
        ciclos = 0
        tempo = 0
      }
    }
    parar()
  }

  def iniciar(titulo: String = "Potigol com Jerimum", largura: Int = 640, altura: Int = 480, atualize: => Unit = {},
              desenhe: => Unit = {}, fps: Int = 60) = synchronized {
    this.titulo = titulo
    this.largura = largura
    this.altura = altura
    this.fps = fps
    this.atualize = atualize _
    this.desenhe = desenhe _
    if (!running) {
      running = true
      thread = new Thread(this) {
        start()
      }
    }
  }

  def parar() = synchronized {
    if (running) {
      running = false
      Try(thread.join()) match {
        case Failure(e) => e.printStackTrace()
        case _          =>
      }
    }
  }
}