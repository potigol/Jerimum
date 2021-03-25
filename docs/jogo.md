# Jogo


## Atributos
<dl>
<dt><code>largura: Inteiro</code></dt>
  <dd>Largura da janela do jogo (em pixels)<br>
    Exemplo: <code>x = jogo.largura</code>
  </dd>

<dt><code>altura: Inteiro</code></dt>
  <dd>Altura da janela do jogo (em pixels)<br>
    Exemplo: <code>y = jogo.largura</code></dd>
  
<dt><code>título: Texto</code></dt>
  <dd>Texto que aparece na barra de título da janela<br>
    Exemplo: <code>s = jogo.título</code>
    </dd>

<dt><code>fps: Inteiro</code></dt>
  <dd>Taxa de atualização do jogo em quadros por segundo<br>
    Exemplo: <code>a = jogo.fps</code></dd>
</dl>

## Métodos

<dl>
<dt><code>iniciar(titulo: Texto, largura: Inteiro, altura: Inteiro, atualize, desenhe, fps: Inteiro = 60)</code></dt>
  <dd>Iniciar o jogo.<br>
  Exemplo: <code>jogo.iniciar("Título", 640, 480, atualize, desenhe)</code></dd>
  
<dt><code>distância(x1, y1, x2, y2: Real): Real</code></dt>
  <dd>Distância entre dois pontos (x1,y1) e (x2,y2).<br>
  Exemplo: <code>Jogo.distância(10, 10, 20, 30)</code></dd>
  
<dt><code>projeção_X(angulo: Real, módulo: Real): Real</code></dt>
  <dd>Projeção do vetor dado pelo módulo e ângulo no eixo x.<br>
  Exemplo: <code>dx = Jogo.projeção_X(30, 5)</code></dd>

<dt><code>projeção_Y(angulo: Real, módulo: Real): Real</code></dt>
  <dd>Projeção do vetor dado pelo módulo e ângulo no eixo y.<br>
  Exemplo: <code>dy = Jogo.projeção_Y(30, 5)</code></dd>

</dl>
