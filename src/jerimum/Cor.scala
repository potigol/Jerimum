package jerimum

import java.awt.Color

case class Cor(vermelho: Int, verde: Int, azul: Int) {
  def color = new Color(vermelho, verde, azul)
  def this(color: Color) = this(color.getRed, color.getGreen, color.getBlue)
}

object Cor {
  val AMARELO = new Cor(Color.yellow)
  val AZUL = new Cor(Color.blue)
  val BRANCO = new Cor(Color.white)
  val CIANO = new Cor(Color.cyan)
  val CINZA = new Cor(Color.gray)
  val CINZA_CLARO = new Cor(Color.lightGray)
  val CINZA_ESCURO = new Cor(Color.darkGray)
  val LARANJA = new Cor(Color.orange)
  val MAGENTA = new Cor(Color.magenta)
  val PRETO = new Cor(Color.black)
  val ROSA = new Cor(Color.pink)
  val VERDE = new Cor(Color.green)
  val VERMELHO = new Cor(Color.red)
}
