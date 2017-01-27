package jerimum
import java.util.Date

object Relogio {
  private[this] val inicio = new Date(1, 1, 2000).getTime;
  def agora: Double = new Date().getTime
  def milisegundos: Int = (System.currentTimeMillis() - inicio).toInt
}