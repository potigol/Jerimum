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

### Métodos ###

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

## Imagem ##

Permite carregar imagens de arquivos e exibir na tela.

### Atributos ###
<dl>
<dt><code>largura: Inteiro</code></dt>
  <dd>Largura da imagem</dd>
<dt><code>altura: Inteiro</code></dt>
  <dd>Altura da imagem</dd>
</dl>

### Métodos do Tipo###
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

## Teclado ##

Verifica se alguma tecla está pressionada.

### Atributos###

<dl>
<dt><code>TECLA_A, TECLA_B, TECLA_C, TECLA_D, TECLA_E, TECLA_F, TECLA_G, TECLA_H, TECLA_I, TECLA_J, TECLA_K, TECLA_L, TECLA_M,
 TECLA_N, TECLA_O, TECLA_P, TECLA_Q, TECLA_R, TECLA_S, TECLA_T, TECLA_U, TECLA_V, TECLA_W, TECLA_X, TECLA_Y, TECLA_Z
 TECLA_0, TECLA_1, TECLA_2, TECLA_3, TECLA_4, TECLA_5, TECLA_6, TECLA_7, TECLA_8, TECLA_9
 TECLA_ESPAÇO, TECLA_ENTER, TECLA_PARA_CIMA, TECLA_PARA_BAIXO, TECLA_PARA_ESQUERDA, TECLA_PARA_DIREITA: Lógico</code></dt>
  <dd>Indica se uma tecla específica foi pressionada.<br>
  Exemplo: <code>se Teclado.TECLA_PARA_DIREITA então x := x + 1 fim</code></dd>
</dl>

## Mouse ##

Verifica se algum botão do mouse está pressionado.

### Atributos do Tipo ###
<dl>
<dt><code>BOTÃO_ESQUERDO: Lógico</code></dt>
  <dd>Indica se o botão esquerdo do mouse está pressionado.<br>
  Exemplo: <code>se Mouse.BOTÃO_ESQUERDO então x := x - 1 fim</code></dd>
<dt><code>BOTÃO_DIREITO: Lógico</code></dt>
  <dd>Indica se o botão direito do mouse está pressionado.<br>
  Exemplo: <code>se Mouse.BOTÃO_DIREITO então x := x + 1 fim</code></dd>
<dt><code>x: Inteiro</code></dt>
  <dd>A posição do mouse no eixo X.<br>
  Exemplo: <code>pos_x := Mouse.x</code></dd> 
<dt><code>y: Inteiro</code></dt>
  <dd> posição do mouse no eixo Y.<br>
  Exemplo: <code>pos_y := Mouse.y</code></dd>
</dl>

## Fonte ##

Usado para escrever textos na tela

### Atributos ###
<dl>
<dt><code>tamanho: Inteiro</code></dt>
  <dd>Tamanho da letra<br>
  Exemplo: <code>a = fonte.tamanho</code></dd>
</dl>

### Métodos ###
<dl>
<dt><code>Fonte(tamanho: Inteiro)</code></dt>
  <dd>Construtor: Cria uma nova fonte passando o tamanho.<br>
  Exemplo: <code>f = Fonte(16)</code></dd>
<dt><code>desenhe(texto: Texto, x, y: Real, z: Inteiro)</code></dt>
  <dd>Escreve um texto na tela na posição (x, y), camada z.<br>
  Exemplo: <code>fonte.desenhe("Texto", 100, 120, 3)</code></dd>
<dt><code>desenhe_centralizado(texto: Texto, x, y: Real, z: Inteiro)</code></dt>
  <dd>Escreve um texto na tela centralizado no ponto (x, y), camada z.<br>
  Exemplo: <code>fonte.desenhe_centralizado("Texto", 100, 120, 3)</code></dd>
</dl>

## Cor ##

### Atributos ###
<dl>
<dt><code>AMARELO, AZUL, BRANCO, CIANO, CINZA, CINZA_CLARO, CINZA_ESCURO, LARANJA, MAGENTA, PRETO, ROSA, VERDE, VERMELHO: Cor</code></dt>
  <dd>Cores predefinidas.<br>
  Exemplo: <code>fonte.desenhe("Texto", 10, 20, Cor.AMARELO)</code></dd>
</dl>

### Métodos ###
<dl>
<dt><code>Cor(vermelho, verde, azul: Inteiro)</code></dt>
  <dd>Construtor: Cria uma nova cor passando os componentes vermelho, verde e azul.<br>
  Exemplo: <code>cor = Cor(10, 120, 240)</code></dd>
</dl>


## Relógio ##

### Atributos do Tipo ###
<dl>
<dt><code>agora: Real</code></dt>
  <dd>Horário no momento.<br>
  Exemplo: <code>hora = Relógio.agora</code></dd>
<dt><code>milisegundos: Inteiro</code></dt>
  <dd>Quantidade de milisegundos desde o dia 1/1/2000.<br>
  Exemplo: <code>ms = Relógio.milisegundos</code></dd>
</dl>
