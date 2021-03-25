# Fonte

Usado para escrever textos na tela

## Atributos
<dl>
<dt><code>tamanho: Inteiro</code></dt>
  <dd>Tamanho da letra<br>
  Exemplo: <code>a = fonte.tamanho</code></dd>
</dl>

## Métodos
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
