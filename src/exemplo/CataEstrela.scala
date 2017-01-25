package exemplo

import jerimum.{ Entidade, Imagem, Jogador, Teclado, jogo }
import scala.util.Random

object CataEstrela extends App {

  val img2 = Imagem.fatie("/textures/sheet.png", 32, 32)
  val jogador = Jogador(Imagem("/textures/Nave.bmp"), 40, 40, 1)

  val fundo = Imagem("/textures/Space.png")

  var estrelas = List[(Int, Int)]()
  for (i <- 1 to 10) {
    estrelas ::= (Random.nextInt(620), Random.nextInt(460))
  }

  def atualize() = {
    if (Teclado.TECLA_PARA_DIREITA) jogador.x += 3
    if (Teclado.TECLA_PARA_ESQUERDA) jogador.x -= 3
    if (Teclado.TECLA_PARA_CIMA) jogador.y -= 3
    if (Teclado.TECLA_PARA_BAIXO) jogador.y += 3
  }

  def desenhe() = {
    fundo.desenhe(0, 0, 0)
    jogador.desenhe()
    for ((a, b) <- estrelas) {
      img2(4).desenhe(a, b, 2)
    }
  }

  jogo.iniciar("Cata Estrelas", 640, 480, atualize, desenhe)
}
