package jerimum
import java.util.Date

import br.edu.ifrn.potigol.Potigolutil.{ Inteiro, Real }

object Relogio {
  private[this] val inicio = new Date().getTime;
  def agora: Real = new Date().getTime
  def milisegundos: Inteiro = (System.currentTimeMillis() - inicio).toInt
}
