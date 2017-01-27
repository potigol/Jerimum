package jerimum

import java.awt.{ Graphics2D, RenderingHints, Font }

import scala.collection.SortedMap

object Desenho {
  val vazia = SortedMap[Int, List[Graphics2D => Unit]]()
  var camadas = vazia
  def todos = camadas.values.flatten

  private[this] val rh = new RenderingHints(
    RenderingHints.KEY_TEXT_ANTIALIASING,
    RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB)

  private[this] val font = new Font("Dialog", Font.BOLD, 16);

  def desenhe(g: Graphics2D) = {
    g match {
      case g: Graphics2D =>
        g.setFont(font)
        g.setRenderingHints(rh)
    }
    todos.foreach(f => f(g))
    camadas = vazia
  }

  def incluir(z: Int, funcao: Graphics2D => Unit) = {
    camadas += z -> (funcao :: camadas.getOrElse(z, Nil))
  }
}