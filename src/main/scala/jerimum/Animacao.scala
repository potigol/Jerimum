package jerimum

import br.edu.ifrn.potigol.Potigolutil.{ Inteiro, Lista }

case class Animacao(velocidade: Inteiro, imagens: Lista[Imagem]) {
  private[this] val inicio = System.currentTimeMillis()
  private[this] val tamanho = imagens.length

  def imagem(): Imagem = {
    val indice = ((System.currentTimeMillis() - inicio) / velocidade % tamanho).toInt
    imagens(indice)
  }
}