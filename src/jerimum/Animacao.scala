package jerimum

case class Animacao(velocidade: Int, imagens: Seq[Imagem]) {
  private[this] val inicio = System.currentTimeMillis()
  private[this] val tamanho = imagens.length

  def imagem(): Imagem = {
    val indice = ((System.currentTimeMillis() - inicio) / velocidade % tamanho).toInt
    imagens(indice)
  }
}