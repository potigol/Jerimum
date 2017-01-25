package jerimum

import java.awt.event.{ KeyEvent, KeyListener }

object Teclado extends KeyListener with TecladoLetras {
  val teclas = new Array[Boolean](256)

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
  val teclas: Array[Boolean]
  import java.awt.event.KeyEvent._
  def TECLA_A = teclas(VK_A)
  def TECLA_B = teclas(VK_B)
  def TECLA_C = teclas(VK_C)
  def TECLA_D = teclas(VK_D)
  def TECLA_E = teclas(VK_E)
  def TECLA_F = teclas(VK_F)
  def TECLA_G = teclas(VK_G)
  def TECLA_H = teclas(VK_H)
  def TECLA_I = teclas(VK_I)
  def TECLA_J = teclas(VK_J)
  def TECLA_K = teclas(VK_K)
  def TECLA_L = teclas(VK_L)
  def TECLA_M = teclas(VK_M)
  def TECLA_N = teclas(VK_N)
  def TECLA_O = teclas(VK_O)
  def TECLA_P = teclas(VK_P)
  def TECLA_Q = teclas(VK_Q)
  def TECLA_R = teclas(VK_R)
  def TECLA_S = teclas(VK_S)
  def TECLA_T = teclas(VK_T)
  def TECLA_U = teclas(VK_U)
  def TECLA_V = teclas(VK_V)
  def TECLA_W = teclas(VK_W)
  def TECLA_X = teclas(VK_X)
  def TECLA_Y = teclas(VK_Y)
  def TECLA_Z = teclas(VK_Z)
  def TECLA_0 = teclas(VK_0)
  def TECLA_1 = teclas(VK_1)
  def TECLA_2 = teclas(VK_2)
  def TECLA_3 = teclas(VK_3)
  def TECLA_4 = teclas(VK_4)
  def TECLA_5 = teclas(VK_5)
  def TECLA_6 = teclas(VK_6)
  def TECLA_7 = teclas(VK_7)
  def TECLA_8 = teclas(VK_8)
  def TECLA_9 = teclas(VK_9)
  def TECLA_ESPACO = teclas(VK_SPACE)
  def TECLA_ESPAÇO = TECLA_ESPACO
  def TECLA_ENTER = teclas(VK_ENTER)
  def TECLA_PARA_CIMA = teclas(VK_UP)
  def TECLA_PARA_BAIXO = teclas(VK_DOWN)
  def TECLA_PARA_ESQUERDA = teclas(VK_LEFT)
  def TECLA_PARA_DIREITA = teclas(VK_RIGHT)
}