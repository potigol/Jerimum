package jerimum

import java.awt.{ Canvas, Dimension }

import br.edu.ifrn.potigol.Potigolutil.{ Inteiro, Texto }
import javax.swing.JFrame

class Tela(titulo: Texto, largura: Inteiro, altura: Inteiro) {
  private[this] val dim = new Dimension(largura, altura)
  val canvas = new Canvas() {
    setPreferredSize(dim)
    setMaximumSize(dim)
    setMinimumSize(dim)
    setFocusable(false)
  }
  val frame = new JFrame(titulo) {
    setIconImage(Imagem("potigol.png").buffer)
    setSize(dim)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setResizable(false)
    setLocationRelativeTo(null)
    setVisible(true)
    add(canvas)
    pack()
  }
}
