package exemplo
import jerimum._
import scala.util.Random
import br.edu.ifrn.potigol.Potigolutil._
import br.edu.ifrn.potigol.Matematica._

object CataEstrela extends App {

  case class Jogador(var x: Real, var y: Real) {
    val imagem = Imagem("Nave.png")
    var placar = 0
    var vel_x, vel_y = 0.0
    var angulo = 0.0

    def desenhe() = {
      imagem.desenhe_centralizado(x, y, 3, angulo)
    }

    def girar_direita() = {
      angulo = angulo + 5.0
    }

    def girar_esquerda() = {
      angulo = angulo - 5.0
    }

    def acelerar() = {
      vel_x = vel_x + Jogo.projeção_X(angulo, 0.5)
      vel_y = vel_y + Jogo.projeção_Y(angulo, 0.5)
    }

    def mover() = {
      x = x + vel_x
      y = y + vel_y
      x = (jogo.largura + x) % jogo.largura
      y = (jogo.altura + y) % jogo.altura
      vel_x = vel_x * 0.95
      vel_y = vel_y * 0.95
    }

    def catar_estrelas(estrelas: Lista[Estrela]) = {
      val catado = estrelas.selecione {
        estrela => Jogo.distância(x, y, estrela.x, estrela.y) >= 35
      }
      val n = estrelas.size - catado.size
      placar = placar + n * 10
      catado
    }
  }

  case class Estrela() {
    val x = aleatório(jogo.largura)
    val y = aleatório(jogo.altura)
    val cor = Cor(aleatório(216) + 40, aleatório(216) + 40, aleatório(216) + 40)
    val imagens = Imagem.fatie("Estrela.png", 25, 25)
    val i = aleatório(imagens.tamanho)

    def desenhe() = {
      val imagem = imagens((Relogio.milisegundos / 100 + i) % imagens.tamanho)
      imagem.desenhe_centralizado(x, y, 1, 0)
    }
  }

  val imagem_fundo = Imagem("Space.png")
  val nave = Jogador(jogo.largura / 2, jogo.altura / 2)
  var tempo = 0.0
  var estrelas = Lista(0, Estrela())
  var estado = "INICIO"
  val fonte = Fonte(16)

  def atualize() = {
    estado match {
      case "INICIO"  => atualize_inicio
      case "JOGANDO" => atualize_jogando
      case _         => atualize_fim
    }
  }

  def desenhe() = {
    imagem_fundo.desenhe(0, 0, 0)
    estado match {
      case "INICIO"  => desenhe_inicio
      case "JOGANDO" => desenhe_jogando
      case "FIM" | _ => desenhe_fim
    }
  }

  // Estado Inicio
  def atualize_inicio() = {
    if (Teclado.TECLA_I) estado = "JOGANDO"
  }

  def desenhe_inicio() = {
    val msg = "PRESSIONE [ I ] PARA COMEÇAR"
    fonte.desenhe_centralizado(msg, jogo.largura / 2, jogo.altura / 2, 3, Cor.AMARELO)
  }

  // Estado Jogando
  def atualize_jogando() = {
    // eventos
    if (Teclado.TECLA_PARA_DIREITA) nave.girar_direita
    if (Teclado.TECLA_PARA_ESQUERDA) nave.girar_esquerda
    if (Teclado.TECLA_PARA_CIMA) nave.acelerar
    // inserir novas estrelas estrelas se necessario
    if (aleatório(100) < 4 && estrelas.tamanho < 25) {
      estrelas = Estrela() :: estrelas
    }

    estrelas = nave.catar_estrelas(estrelas) // catar estrelas
    nave.mover // atualizar a posicao do jogador
    tempo = tempo + 1.0 / 60.0 // incrementar o tempo
    if (tempo.inteiro >= 30) {
      estado = "FIM" // terminar o jogo depois de 30 segundos
    }
  }

  def desenhe_jogando() = {
    nave.desenhe
    for (estrela <- estrelas) {
      estrela.desenhe
    }
    fonte.desenhe(s"Placar: ${nave.placar}", 10, 20, 3, Cor.AMARELO)
    fonte.desenhe(s"Tempo: ${tempo.toInt}s", 10, 40, 3, Cor.AMARELO)
  }

  // Estado: fim do jogo
  def desenhe_fim() = {
    val msg = s"FIM DE JOGO, VOCÊ FEZ ${nave.placar} PONTOS"
    fonte.desenhe_centralizado(msg, jogo.largura / 2, jogo.altura / 2, 3, Cor.AMARELO)
  }

  def atualize_fim() = {}

  jogo.iniciar("Cata Estrelas", 640, 480, atualize, desenhe)
}
