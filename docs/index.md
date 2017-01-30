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

## Teclado ##

### Atributos do Tipo###

<dl>
<dt><code>TECLA_A, TECLA_B, TECLA_C, TECLA_D, TECLA_E, TECLA_F, TECLA_G, TECLA_H, TECLA_I, TECLA_J, TECLA_K, TECLA_L, TECLA_M,
 TECLA_N, TECLA_O, TECLA_P, TECLA_Q, TECLA_R, TECLA_S, TECLA_T, TECLA_U, TECLA_V, TECLA_W, TECLA_X, TECLA_Y, TECLA_Z
 TECLA_0, TECLA_1, TECLA_2, TECLA_3, TECLA_4, TECLA_5, TECLA_6, TECLA_7, TECLA_8, TECLA_9
 TECLA_ESPAÇO, TECLA_ENTER, TECLA_PARA_CIMA, TECLA_PARA_BAIXO, TECLA_PARA_ESQUERDA, TECLA_PARA_DIREITA: Lógico</code></dt>
  <dd>Indica se uma tecla específica foi pressionada.</dd>
  </dl>

## Mouse ##

### Atributos do Tipo ###

<dt><code>BOTÃO_ESQUERDO: Lógico</code></dt>
  <dd>Indica se o botão esquerdo do mouse está pressionado.</dd>
<dt><code>BOTÃO_DIREITO: Lógico</code></dt>
  <dd>Indica se o botão direito do mouse está pressionado.</dd>
<dt><code>x: Inteiro</code></dt>
  <dd>A posição do mouse no eixo X.</dd>
<dt><code>y: Inteiro</code></dt>
  <dd> posição do mouse no exio Y.</dd>
