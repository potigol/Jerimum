package jerimum

import java.awt.image.BufferedImage

import scala.util.{ Failure, Success, Try }

import javax.imageio.ImageIO

object Imagem {
  val vazia = new Imagem(new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB))

  val imagens = collection.mutable.Map[String, Imagem]()
  val listas = collection.mutable.Map[String, Seq[Imagem]]()

  def apply(caminho: String): Imagem = {
    imagens.get(caminho).getOrElse {
      Try(ImageIO.read(Imagem.getClass.getResource(caminho))).map(new Imagem(_)) match {
        case Success(img) =>
          imagens(caminho) = img
          img
        case Failure(x) => println(x); vazia
      }
    }
  }

  def fatie(caminho: String, x: Int, y: Int): Seq[Imagem] = {
    val id = s"caminho $x $y"
    listas.getOrElse(id, {
      val img = Imagem(caminho).buffer
      val lista = for (
        j <- 0 until img.getHeight by y;
        i <- 0 until img.getWidth by x
      ) yield {
        new Imagem(img.getSubimage(i, j, x, y))
      }
      listas(id) = lista
      lista
    })
  }
}

class Imagem(val buffer: BufferedImage) {
  def desenhe(x: Double, y: Double, z: Int) = {
    Desenho.incluir(z, g => {
      g.drawImage(buffer, x.toInt, y.toInt, null)
    })
  }
}