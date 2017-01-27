package jerimum

import java.awt.Graphics2D

object Fonte {

}

case class Fonte() {
  def desenhe_centralizado(msg: String, x: Double, y: Double, z: Int, c: Cor) = {
    Desenho.incluir(z, g => {
      g.setColor(c.color)
      val largura = g.getFontMetrics.stringWidth(msg)
      val altura = g.getFontMetrics.getHeight
      g.drawString(msg, x.toInt - largura / 2, y.toInt - altura / 2)
    })

  }

  def desenhe(msg: String, x: Double, y: Double, z: Int, c: Cor) = {
    Desenho.incluir(z, g => {
      g.setColor(c.color)
      g.drawString(msg, x.toInt, y.toInt)
    })
  }
}