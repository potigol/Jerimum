# Imagem

Permite carregar imagens de arquivos e exibir na tela.

## Atributo
<dl>
<dt><code>largura: Inteiro</code></dt>
  <dd>Largura da imagem</dd>
<dt><code>altura: Inteiro</code></dt>
  <dd>Altura da imagem</dd>
</dl>

## Métodos
<dl>
<dt><code>Imagem(caminho: Texto)</code></dt>
  <dd>Construtor<br>
  Exemplo: <code>img = Imagem("jogador.png")</code></dd>
<dt><code>desenhe(x, y: Real, z: Inteiro, angulo: Real = 0.0, scala_X, scala_Y: Real = 1.0)</code></dt>
  <dd>Desenha uma imagem na tela tendo (x, y) como ponto superior esquerdo.<br>
  Exemplo: <code>img.desenhe(20, 30, 1)</code></dd>
<dt><code>desenhe_centralizado(x, y: Real, z: Inteiro, angulo: Real = 0.0, scala_Y: Real = 1.0)</code></dt>
  <dd>Desenha uma imagem na tela tendo (x, y) como ponto central.<br>
  Exemplo: <code>img.desenhe_centralizado(20, 30, 1)</code></dd>
<dt><code>fatie(x, y: Inteiro): Lista[Imagem]</code></dt>
  <dd>Recorta uma imagem em imagens menores formando uma lista.<br>
  Exemplo: <code>imagens = Imagem("sprite.png").fatie(30, 30)</code></dd>
</dl>
