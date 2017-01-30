# Biblioteca Jerimum #

Para usar a biblioteca Jerimum comece o programa com a instrução `use "jerimum"`

````python
use "jerimum"

atualize()
  # Código para atualizar o jogo
fim

desenhe()
  # código para desenhar o jogo
fim

jogo.iniciar("Título", 640, 480, atualize, desenhe, 60)
````

## Jogo ##


### Atributos ###
<dl>
<dt><code>largura: Inteiro = 640</code></dt>
  <dd>Largura da janela do jogo (em pixels)</dd>

<dt><code>altura: Inteiro = 480</code></dt>
  <dd>Altura da janela do jogo (em pixels)</dd>
  
<dt><code>titulo: Texto</code></dt>
  <dd>Texto que aparece na barra de título da janela</dd>

<dt><code>fps: Inteiro = 60</code></dt>
  <dd>Taxa de atualização do jogo em quadros por segundo</dd>
</dl>

### Métodos ###

<dl>
<dt><code>iniciar(titulo: Texto, largura: Inteiro = 640, altura: Inteiro = 480, atualize, desenhe, fps: Inteiro = 60)</code></dt>
  <dd>Iniciar o jogo.</dd>
  
<dt><code>distância(x1, y1, x2, y2: Real): Real</code></dt>
  <dd>Distância entre dois pontos (x1,y1) e (x2,y2).</dd>
  
<dt><code>projeção_X(angulo: Real, módulo: Real): Real</code></dt>
  <dd>Projeção do vetor dado pelo módulo e ângulo no eixo x.</dd>

<dt><code>projeção_Y(angulo: Real, módulo: Real): Real</code></dt>
  <dd>Projeção do vetor dado pelo módulo e ângulo no eixo y.</dd>

</dl>
