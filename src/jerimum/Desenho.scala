package jerimum

import java.awt.Graphics

import scala.collection.SortedMap
object Desenho {
  val vazia = SortedMap[Int, List[Graphics => Unit]]()
  var camadas = vazia
  // camadas += { 1 -> List((g: Graphics) => g.drawLine(30, 30, 60, 70)) }
  def todos = camadas.values.flatten

  def desenhe(g: Graphics) = {
    todos.foreach(f => f(g))
    camadas = vazia
  }

  def incluir(z: Int, funcao: Graphics => Unit) = {
    camadas += z -> (funcao :: camadas.getOrElse(z, Nil))
  }
}