package jerimum

import java.awt.Graphics2D
import java.awt.image.BufferedImage

import scala.util.{ Failure, Success, Try }

import br.edu.ifrn.potigol.Potigolutil.{ Inteiro, Lista, Real, Texto }
import javax.imageio.ImageIO
import java.io.File

object Imagem {
  private[this] val vazia = new Imagem(new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB))

  private[this] val imagens = collection.mutable.Map[String, Imagem]()
  private val listas = collection.mutable.Map[String, List[Imagem]]()

  def apply(caminho: Texto): Imagem = {
    imagens.get(caminho).getOrElse {
      Try {
        ImageIO.read(new File(caminho))
      } map (new Imagem(_, caminho)) match {
        case Success(img) =>
          imagens(caminho) = img
          img
        case Failure(x) => println(x); vazia
      }
    }
  }

  def fatie(caminho: Texto, x: Inteiro, y: Inteiro): Lista[Imagem] = {
    val id = s"$caminho $x $y"
    val l = listas.getOrElse(id, {
      val img = Imagem(caminho).buffer
      val lista = for (
        j <- 0 until img.getHeight by y if (j + y <= img.getHeight);
        i <- 0 until img.getWidth by x if (i + x <= img.getWidth)
      ) yield {
        new Imagem(img.getSubimage(i, j, x, y))
      }
      listas(id) = lista.toList
      listas(id)
    })
    Lista(l)
  }
}

class Imagem(val buffer: BufferedImage, val caminho: String = "") {
  def largura = buffer.getWidth
  def altura = buffer.getHeight

  def fatie(x: Inteiro, y: Inteiro): Lista[Imagem] = {
    val id = s"$caminho $x $y"
    val l = Imagem.listas.getOrElse(id, {
      val img = buffer
      val lista = for (
        j <- 0 until img.getHeight by y if (j + y <= img.getHeight);
        i <- 0 until img.getWidth by x if (i + x <= img.getWidth)
      ) yield {
        new Imagem(img.getSubimage(i, j, x, y))
      }
      Imagem.listas(id) = lista.toList
      Imagem.listas(id)
    })
    Lista(l)
  }

  private[this] def girar(g: Graphics2D, angulo: Double, x: Double, y: Double, scalaX: Double, scalaY: Double)(desenho: => Unit): Unit = {
    val old = g.getTransform()
    if (angulo != 0.0) g.rotate(Math.toRadians(angulo), x + buffer.getWidth / 2, y + buffer.getHeight / 2)
    desenho
    g.setTransform(old)
  }

  def desenhe(x: Real, y: Real, z: Inteiro, angulo: Real = 0.0, scalaX: Double = 1.0, scalaY: Double = 1.0): Unit = {
    Desenho.incluir(z, g => {
      girar(g, angulo, x, y, scalaX, scalaY) {
        val largura = (buffer.getWidth * scalaX).toInt
        val altura = (buffer.getHeight * scalaY).toInt
        val deltaX = if (largura < 0) -largura else 0
        val deltaY = if (altura < 0) -altura else 0
        g.drawImage(buffer, x.toInt + deltaX, y.toInt + deltaY, largura, altura, null)
      }
    })
  }

  def desenhe_centralizado(x: Real, y: Real, z: Inteiro, angulo: Real = 0.0, scalaX: Double = 1.0, scalaY: Double = 1.0) = {
    desenhe(x - buffer.getWidth / 2, y - buffer.getHeight / 2, z, angulo, scalaX, scalaY)
  }
}