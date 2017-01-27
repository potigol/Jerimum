package jerimum

import br.edu.ifrn.potigol.Potigolutil.{ Inteiro, Real, Texto }

object Fonte {

}

case class Fonte() {
  def desenhe_centralizado(msg: Texto, x: Real, y: Real, z: Inteiro, c: Cor) = {
    Desenho.incluir(z, g => {
      g.setColor(c.color)
      val largura = g.getFontMetrics.stringWidth(msg)
      val altura = g.getFontMetrics.getHeight
      g.drawString(msg, x.toInt - largura / 2, y.toInt - altura / 2)
    })

  }

  def desenhe(msg: Texto, x: Real, y: Real, z: Inteiro, c: Cor) = {
    Desenho.incluir(z, g => {
      g.setColor(c.color)
      g.drawString(msg, x.toInt, y.toInt)
    })
  }
}