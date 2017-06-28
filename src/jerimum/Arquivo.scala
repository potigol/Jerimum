package jerimum

import br.edu.ifrn.potigol.Potigolutil._
import scala.io.Source

object Arquivo {
  def leia(caminho: Texto): Lista[Texto] = {
    Lista(Source.fromFile(caminho).getLines().toList)
  }
}