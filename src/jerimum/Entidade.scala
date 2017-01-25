package jerimum

trait Entidade {
  var x: Double
  var y: Double
  val z: Int
  var largura: Double
  var altura: Double
  var vidas: Int = 3
  var ativo: Boolean = true
  var imagem: Imagem
  var atualize = () => {}

  def machucar(valor: Int): Unit = {
    vidas = vidas - valor
    if (vidas <= 0) {
      ativo = false
      morrer()
    }
  }

  def morrer(): Unit = {}

  var desenhe = () => {
    if (imagem != null)
      imagem.desenhe(x.toInt, y.toInt, z)
  }

  def def_desenhe(desenhe: => Unit): Unit = {
    this.desenhe = desenhe _
  }

  def def_atualize(atualize: => Unit): Unit = {
    this.atualize = atualize _
  }

}

trait Criatura extends Entidade {
  var deltaX = 0.0
  var deltaY = 0.0
  var velocidade = 10.0

  def mover() {
    x = x + deltaX
    y = y + deltaY
  }
}

case class Jogador(var imagem: Imagem, var x: Double, var y: Double,
                   val z: Int = 10) extends Criatura {
  var pontos = 0L
  var largura = 32.0
  var altura = 32.0

}