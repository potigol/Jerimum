package jerimum

import br.edu.ifrn.potigol.Potigolutil.{ Inteiro, Real, Texto }
import java.awt.Font

object Fonte {

}

case class Fonte(tamanho: Inteiro) {
  private[this] val font = new Font("Dialog", Font.BOLD, tamanho);

  def desenhe_centralizado(msg: Texto, x: Real, y: Real, z: Inteiro, c: Cor) = {
    Desenho.incluir(z, g => {
      g.setColor(c.color)
      g.setFont(font)
      val largura = g.getFontMetrics.stringWidth(msg)
      val altura = g.getFontMetrics.getHeight
      g.drawString(msg, x.toInt - largura / 2, y.toInt - altura / 2)
    })

  }

  def desenhe(msg: Texto, x: Real, y: Real, z: Inteiro, c: Cor) = {
    Desenho.incluir(z, g => {
      g.setColor(c.color)
      g.setFont(font)
      g.drawString(msg, x.toInt, y.toInt)
    })
  }
}