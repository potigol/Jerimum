package jerimum

import br.edu.ifrn.potigol.Potigolutil._

case class Som(arquivo: Texto) {
  def toque: Unit = ()
}

case class Musica(arquivo: Texto) {
  def toque(loop: Lógico = falso): Unit = {
    //    Musica._musica = this
  }
  def tocando: Lógico = falso
  def pare: Unit = ()
  def pause: Unit = ()
  def pausado: Lógico = falso
}

object Musica {
  private var _musica: Option[Musica] = None
  def musica_atual: Option[Musica] = _musica
  def música_atual = musica_atual
}
