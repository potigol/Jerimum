package jerimum

import java.awt.event.{ KeyEvent, KeyListener }
import br.edu.ifrn.potigol.Potigolutil._

object Teclado extends KeyListener with TecladoLetras {
  protected[this] val teclas = new Array[Boolean](256)

  private[this] def update(e: KeyEvent, valor: Boolean) = {
    val cod = e.getKeyCode()
    if (cod >= 0 && cod < teclas.length)
      teclas(cod) = valor
  }

  override def keyPressed(e: KeyEvent) = this(e) = true

  override def keyReleased(e: KeyEvent) = this(e) = false

  override def keyTyped(e: KeyEvent) = {}
}

trait TecladoLetras {
  protected[this] val teclas: Array[Boolean]
  import java.awt.event.KeyEvent._
  def TECLA_A: Lógico = teclas(VK_A)
  def TECLA_B: Lógico = teclas(VK_B)
  def TECLA_C: Lógico = teclas(VK_C)
  def TECLA_D: Lógico = teclas(VK_D)
  def TECLA_E: Lógico = teclas(VK_E)
  def TECLA_F: Lógico = teclas(VK_F)
  def TECLA_G: Lógico = teclas(VK_G)
  def TECLA_H: Lógico = teclas(VK_H)
  def TECLA_I: Lógico = teclas(VK_I)
  def TECLA_J: Lógico = teclas(VK_J)
  def TECLA_K: Lógico = teclas(VK_K)
  def TECLA_L: Lógico = teclas(VK_L)
  def TECLA_M: Lógico = teclas(VK_M)
  def TECLA_N: Lógico = teclas(VK_N)
  def TECLA_O: Lógico = teclas(VK_O)
  def TECLA_P: Lógico = teclas(VK_P)
  def TECLA_Q: Lógico = teclas(VK_Q)
  def TECLA_R: Lógico = teclas(VK_R)
  def TECLA_S: Lógico = teclas(VK_S)
  def TECLA_T: Lógico = teclas(VK_T)
  def TECLA_U: Lógico = teclas(VK_U)
  def TECLA_V: Lógico = teclas(VK_V)
  def TECLA_W: Lógico = teclas(VK_W)
  def TECLA_X: Lógico = teclas(VK_X)
  def TECLA_Y: Lógico = teclas(VK_Y)
  def TECLA_Z: Lógico = teclas(VK_Z)
  def TECLA_0: Lógico = teclas(VK_0)
  def TECLA_1: Lógico = teclas(VK_1)
  def TECLA_2: Lógico = teclas(VK_2)
  def TECLA_3: Lógico = teclas(VK_3)
  def TECLA_4: Lógico = teclas(VK_4)
  def TECLA_5: Lógico = teclas(VK_5)
  def TECLA_6: Lógico = teclas(VK_6)
  def TECLA_7: Lógico = teclas(VK_7)
  def TECLA_8: Lógico = teclas(VK_8)
  def TECLA_9: Lógico = teclas(VK_9)
  def TECLA_ESPACO: Lógico = teclas(VK_SPACE)
  def TECLA_ESPAÇO: Lógico = TECLA_ESPACO
  def TECLA_ENTER: Lógico = teclas(VK_ENTER)
  def TECLA_PARA_CIMA: Lógico = teclas(VK_UP)
  def TECLA_PARA_BAIXO: Lógico = teclas(VK_DOWN)
  def TECLA_PARA_ESQUERDA: Lógico = teclas(VK_LEFT)
  def TECLA_PARA_DIREITA: Lógico = teclas(VK_RIGHT)
}