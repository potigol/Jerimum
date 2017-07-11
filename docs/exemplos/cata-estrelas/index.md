# Cata Estrelas

## Estrutura básica

````python
use "jerimum"

atualize()
  # Código para atualizar o jogo
fim

desenhe()
  # Código para desenhar o jogo
fim

jogo.iniciar("Título", 640, 480, atualize, desenhe)
````
[código fonte](v1.poti)

## Imagem

````python
fundo = Imagem("Space.png")
nave_imagem = Imagem("nave.png")

desenhe()
  fundo.desenhe(0, 0, 0)
  nave_imagem.desenhe(300, 200, 2)
fim
````
[código fonte](v3.poti)

## Movimento

````scala
var nave_x = 300

atualize()
  se Teclado.TECLA_PARA_DIREITA então
    nave_x := nave_x + 10
  fim
  se Teclado.TECLA_PARA_ESQUERDA então
    nave_x := nave_x - 10
  fim
fim

desenhe()
  nave_imagem.desenhe(nave_x, 200, 2)
fim
````
[código fonte](v4.poti)

## Limitando os movimentos

````scala
var nave_x = jogo.largura / 2

atualize()
  se Teclado.TECLA_PARA_DIREITA então
    nave_x := nave_x + 10
    se nave_x > jogo.largura - 40 então
      nave_x := jogo.largura - 40
    fim
  fim
  se Teclado.TECLA_PARA_ESQUERDA então
    nave_x := nave_x - 10
    se nave_x < 10 então nave_x := 10 fim
  fim
fim
````
[código fonte](v5.poti)

## Definindo Tipos

````scala
tipo Jogador
  var x, y: Real
  imagem = Imagem("nave.png")

  desenhe()
    imagem.desenhe_centralizado(x, y, 2)
  fim

  mover_direita()
    x := x + 10
    se x > jogo.largura - 20 então
      x := jogo.largura - 20
    fim
  fim

  mover_esquerda()
    x := x - 10
    se x < 20 então
      x := 20
    fim
  fim
fim

nave = Jogador(jogo.largura / 2, jogo.altura / 2)

atualize()
  se Teclado.TECLA_PARA_DIREITA então
    nave.mover_direita
  fim
  se Teclado.TECLA_PARA_ESQUERDA então
    nave.mover_esquerda
  fim
fim

desenhe()
  nave.desenhe
fim
````
[código fonte](v7.poti)

## Listas

````scala
tipo Estrela
  x = aleatório(jogo.largura)
  y = aleatório(jogo.altura)
  imagens = Imagem("Estrela.png").fatie(25, 25)

  desenhe()
    img = imagens[1]
    img.desenhe_centralizado(x, y, 1, 0)
  fim
fim

tipo Jogador
  cate_estrelas(estrelas: Lista[Estrela])
    estrelas.selecione(estrela => Jogo.distância(x, y, estrela.x, estrela.y) > 35)
  fim
fim

var estrelas = Lista(25, Estrela())

atualize()
  estrelas := nave.cate_estrelas(estrelas)
  se estrelas.tamanho < 25 e aleatório(100) < 4 então
    estrelas := Estrela() :: estrelas
  fim
fim

desenhe()
  para estrela em estrelas faça
    estrela.desenhe
  fim
fim
````
[código fonte](v9.poti)

## Girando imagens

````scala
tipo Jogador
  var ângulo, vel_x, vel_y := 0.0

  desenhe()
    imagem.desenhe_centralizado(x, y, 2, ângulo)
  fim

  girar_direita()
    ângulo := ângulo + 5
  fim

  girar_esquerda()
    ângulo := ângulo - 5
  fim

  acelerar()
    vel_x := vel_x + Jogo.projeção_X(ângulo, 0.5)
    vel_y := vel_y + Jogo.projeção_Y(ângulo, 0.5)
  fim

  mover()
    x := (x + vel_x + 640) mod 640
    y := (y + vel_y + 480) mod 480
    vel_x := vel_x * 0.95
    vel_y := vel_y * 0.95
  fim
fim

atualize()
  se Teclado.TECLA_PARA_DIREITA então
    nave.girar_direita
  fim
  se Teclado.TECLA_PARA_ESQUERDA então
    nave.girar_esquerda
  fim
  se Teclado.TECLA_PARA_CIMA então
    nave.acelerar
  fim
  nave.mover
fim
````
[código fonte](v10.poti)

## Animação

````scala
tipo Estrela
  imagens = Imagem.fatie("Estrela.png", 25, 25)

  desenhe()
    n = (Relógio.milisegundos div 100) mod imagens.tamanho + 1
    img = imagens[n]
    img.desenhe_centralizado(x, y, 1, 0)
  fim
fim
````
[código fonte](v11.poti)

## Escrevendo na tela o placar

````scala
tipo Jogador
  var placar := 0

  cate_estrelas(estrelas: Lista[Estrela])
    n = estrelas.tamanho
    estrelas_catadas = estrelas.selecione(
      estrela => Jogo.distância(x, y, estrela.x, estrela.y) > 35
    )
    placar := placar + (n - estrelas_catadas.tamanho) * 10
    estrelas_catadas
  fim
fim

fonte = Fonte(16)

atualize()
  estrelas := nave.cate_estrelas(estrelas)
fim

desenhe()
  fonte.desenhe("Placar: {nave.placar}", 10, 20, 3, Cor.AMARELO)
fim
````
[código fonte](v12.poti)

## Separando o jogo em arquivos

### Arquivo `principal.poti`
````scala
use "jerimum"
use "jogador.poti"
use "estrela.poti"

fundo = Imagem("Space.png")
nave = Jogador(jogo.largura / 2, jogo.altura / 2)
var estrelas = Lista(0, Estrela())
fonte = Fonte(16)

atualize()
  estrelas := nave.cate_estrelas(estrelas)
  se estrelas.tamanho < 25 e aleatório(100) < 4 então
    estrelas := Estrela() :: estrelas
  fim
  se Teclado.TECLA_PARA_DIREITA então
    nave.girar_direita
  fim
  se Teclado.TECLA_PARA_ESQUERDA então
    nave.girar_esquerda
  fim
  se Teclado.TECLA_PARA_CIMA então
    nave.acelerar
  fim
  nave.mover
fim

desenhe()
  fundo.desenhe(0, 0, 0)
  nave.desenhe
  para estrela em estrelas faça
    estrela.desenhe
  fim
  fonte.desenhe("Placar: {nave.placar}", 10, 20, 3, Cor.AMARELO)
fim

jogo.iniciar("Cata Estrelas", 640, 480, atualize, desenhe)
````
[código fonte](v13.poti)

### Arquivo `jogador.poti`
````scala
tipo Jogador
  ...
fim
````
[jogador.poti](jogador.poti)

### Arquivo `estrela.poti`
````scala
tipo Estrela
  ...
fim
````
[estrela.poti](estrela.poti)

## Fases

````scala
INICIO, JOGANDO, FIM = 1, 2, 3
var estado := INICIO

atualize()
  escolha estado
    caso INICIO  => atualize_inicio
    caso JOGANDO => atualize_jogando
    caso FIM     => atualize_fim
  fim
fim

desenhe()
  fundo.desenhe(0, 0, 0)
  escolha estado
    caso INICIO  => desenhe_inicio
    caso JOGANDO => desenhe_jogando
    caso FIM     => desenhe_fim
  fim
fim

# Estado Inicio
atualize_inicio()
  se Teclado.TECLA_I então
    estado := JOGANDO
  fim
fim

desenhe_inicio()
  msg = "PRESSIONE [I] PARA COMECAR"
  a = jogo.largura / 2
  b = jogo.altura / 2
  fonte.desenhe_centralizado(msg, a, b, 3, Cor.AMARELO)
fim

# Estado Jogando
atualize_jogando()
  estrelas := nave.cate_estrelas(estrelas)
  se estrelas.tamanho < 25 e aleatório(100) < 4 então
    estrelas := Estrela() :: estrelas
  fim
  se Teclado.TECLA_PARA_DIREITA então
    nave.girar_direita
  fim
  se Teclado.TECLA_PARA_ESQUERDA então
    nave.girar_esquerda
  fim
  se Teclado.TECLA_PARA_CIMA então
    nave.acelerar
  fim
  nave.mover
  tempo := tempo + 1.0 / 60.0
  se tempo >= 30.0 então
    estado := FIM
  fim
fim

desenhe_jogando()
  nave.desenhe
  para estrela em estrelas faça
    estrela.desenhe
  fim
  fonte.desenhe("Placar: {nave.placar}", 10, 20, 3, Cor.AMARELO)
  fonte.desenhe("Tempo: {tempo.inteiro}s", 10, 40, 3, Cor.AMARELO)
fim

#estado fim
atualize_fim()
  se Teclado.TECLA_R então
    estrelas := Lista(0, Estrela())
    tempo := 0.0
    estado := JOGANDO
    jogador.placar := 0
  fim
fim

desenhe_fim()
  msg = "FIM DE JOGO, VOCE FEZ {nave.placar} PONTOS"
  msg2 = "PRESSIONE [R] PARA RECOMECAR"
  a = jogo.largura / 2
  b = jogo.altura / 2
  fonte.desenhe_centralizado(msg, a, b, 3, Cor.AMARELO)
  fonte.desenhe_centralizado(msg2, a, b + 20, 3, Cor.AMARELO)
fim
````
[código fonte](v14.poti)

## Dois jogadores

````scala
nave1, nave2 = Jogador(jogo.largura / 2, jogo.altura / 2)

# Estado Jogando
atualize_jogando()
  estrelas := nave1.cate_estrelas(estrelas)
  estrelas := nave2.cate_estrelas(estrelas)
  # jogador 1
  se Teclado.TECLA_PARA_DIREITA então
    nave1.girar_direita
  fim
  se Teclado.TECLA_PARA_ESQUERDA então
    nave1.girar_esquerda
  fim
  se Teclado.TECLA_PARA_CIMA então
    nave1.acelerar
  fim

  #jogador 2
  se Teclado.TECLA_W então
    nave2.acelerar
  fim
  se Teclado.TECLA_A então
    nave2.girar_esquerda
  fim
  se Teclado.TECLA_D então
    nave2.girar_direita
  fim

  nave1.mover
  nave2.mover
fim

desenhe_jogando()
  nave1.desenhe
  nave2.desenhe
  fonte.desenhe("Placar 1: {nave1.placar}", 10, 20, 3, Cor.AMARELO)
  fonte.desenhe("Tempo: {tempo.inteiro}s", 10, 40, 3, Cor.AMARELO)
  fonte.desenhe("Placar 2: {nave2.placar}", 10, 60, 3, Cor.AMARELO)
fim

desenhe_fim()
  msg = "FIM DE JOGO, JOGADOR FEZ {nave1.placar} PONTOS"
  msg1 = "FIM DE JOGO, JOGADOR FEZ {nave2.placar} PONTOS"
  msg2 = "PRESSIONE [R] PARA RECOMECAR"
  a = jogo.largura / 2
  b = jogo.altura / 2
  fonte.desenhe_centralizado(msg, a, b, 3, Cor.AMARELO)
  fonte.desenhe_centralizado(msg1, a, b + 20, 3, Cor.AMARELO)
  fonte.desenhe_centralizado(msg2, a, b + 40, 3, Cor.AMARELO)
fim
````
[código fonte](v15.poti)
