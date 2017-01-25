package jerimum

import java.awt.{ Canvas, Dimension }
import java.awt.image.BufferedImage

import javax.swing.JFrame

class Tela(titulo: String, largura: Int, altura: Int) {
  private[this] val dim = new Dimension(largura, altura)
  val canvas = new Canvas() {
    setPreferredSize(dim)
    setMaximumSize(dim)
    setMinimumSize(dim)
    setFocusable(false)
  }
  val frame = new JFrame(titulo) {
    val img = new BufferedImage(128, 128, BufferedImage.TYPE_INT_RGB)
    setIconImage(img)
    setSize(dim)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setResizable(false)
    setLocationRelativeTo(null)
    setVisible(true)
    add(canvas)
    pack()
  }
}