<h1 align="center" style="font-weight: bold;">📦 Sistema de Blocos</h1>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
[![GitHub license](https://img.shields.io/github/license/Naereen/StrapDown.js.svg)](https://github.com/Naereen/StrapDown.js/blob/master/LICENSE)

<p align="center">
  <a href="#sobre">Sobre</a> • 
  <a href="#acesso">Instalação</a> • 
  <a href="#exercicio">Exercício</a> •
  <a href="#funcionalidades">Funcionalidades</a> •
  <a href="#licenca">Licença</a> •
</p>

<br>
<p align="center">
    <img src="./imgs/img_projeto.png" alt="Imagem do Projeto" width="600px">
</p>
<br>

<h2 id="sobre">📌 Sobre</h2>
<p>Um <ins>projeto da faculdade</ins> da matéria de física, no qual foi realizado um programa em <strong>Java</strong> que calcula um exercício de física. O exercício escolhido é um sistema com 3 blocos, no qual os blocos estão ligados por uma corda e roldanas, e calcula a aceleração, a tração e mostra um diagrama de corpos livres.</p>

<br>
<br>

<h2 id="acesso">🚀 Instalação</h2>
<h3>Requisitos</h3>
<p>É necessário ter o <ins>JDK 24</ins> instalado em sua máquina para poder rodar o projeto, <a href="https://download.oracle.com/java/24/latest/jdk-24_windows-x64_bin.exe">baixe aqui</a></p>
<h3>Execute o Programa</h3>
<p>Baixe o executável do programa <CODE>(.jar)</CODE> <a href="https://github.com/JoaoVitorDomingos/Sistema-de-Blocos/releases/tag/1.0.0">aqui</a>. E com dois cliques, execute-o.</p>


<br>
<br>

<h2 id="exercicio">Exercício</h2>
<p>Este é um famoso exercício de física para mostrar as leis de Newton, principalmente a segunda, no qual temos 3 blocos ligados por uma corda e roldanas, o bloco do meio está em cima de uma mesa e os outros dois pendurados, um na esquerda e outroa na direita.</p>
<p>Neste exercício, a massa da corda e das roldanas são desprezadas, e pede para calcular a tração da esquerda, porém é necessário, para este fim, calcular a aceleração, portanto, o programa é capaz de calcular a aceleração, a tração da esquerda e direita e analisa se a corda arrebenta, adicionando um valor máximo de tensão à corda.</p>
<p>O primeiro passo para resolver o problema é construir um diagrama de corpos livres, analisando as forças que atuam sobre os blocos, então, o programa também desenha um diagrama de corpos livres, mostrando a direção da aceleração, das trações e outras forças (adotado como positivo da esquerda para direita no eixo x e para cima no eixo y)</p>
<p>É possível também cortar uma das cordas, assim se tornando um sistema com 2 blocos, e o que teve sua corda cortada vira um exercício de queda livre, que não foi abordado, mas foi realizado seu desenho de forças.</p>

<br>
<br>

<h2 id="funcionalidades">💻 Funcionalidades</h2>
<p>Nesta sessão está as funcionalidades do projeto.</p>
<details>
  <summary><h3>Sumário</h3></summary>
  <ol>
  <li><a href="#interface">Interface Gráfica</a></li>
    <li><a href="#restricoes">Restrições de Entrada</a></li>
    <li><a href="#calculo">Cálculo do Exercício</a></li>
    <li><a href="#respostas">Exibição de Resposta</a></li>
    <li><a href="#diagrama">Diagrama de Corpos Livres</a></li>
    <li><a href="#reset">Reset de Dados</a></li>
  </ol>
</details>

<h3 id="interface">Interface Gráfica</h3>
<p>Há uma interface gráfica feita em Swing, no qual foi utilizado a ferramenta do NeatBeans.</p>
<p>Possui labels, inputs, radio buttons, botões, uma imagem, um TexteArea para mostrar as respostas e um JPanel para realizar o desenho do diagrama de corpos livres.</p>
<p>Não é possível diminuir nem aumentar o tamanho da janela para impedir que o layout se quebre, ou seja, também não é possível maximizar a janela.</p>

<br>
<br>

<h3 id="restricoes">Restrições de Entrada</h3>
<p>Há restriçoes para a entrada do usuário para que condiza com a realidade os cálculos.</p>
<p>Não é possível adicionar valores negativos ou não-numéricos para a massa e a tensão máxima da corda, até porque isso não existe. E tem um limite máximo de 200Kg para as massas e 500N para a tensão máxima da corda, a corda tem uma restrição mínima, onde diz que sua tensão deve ser no mínimo 10N</p>
<p>Também há uma verificação que analisa se todos os inputs estão preechidos. Caso uma das restrições sejam feridas, mostra um JOptionalPane que alerta sobre a restrição.</p>
<div display="flex" align="center">
  <img src="./imgs/avisos_restricoes/vazio.png" alt="JOptionalPane quando os inputs estão vazios." width="300px">
  <img src="./imgs/avisos_restricoes/negativo.png" alt="JOptionalPane quando há um valor de entrada de dado negativo ou não-numérico." width="350px">
  <img src="./imgs/avisos_restricoes/massa.png" alt="JOptionalPane quando há um valor de entrada de massa maior que o máximo." width="300px">
  <img src="./imgs/avisos_restricoes/tensao.png" alt="JOptionalPane quando há um valor de entrada inferior ao mínimo da tensão ou superior ao máximo" width="400px">
</div>

<br>
<br>

<h3 id="calculo">Cálculo do Exercício</h3>
<p>A partir da resolução do exercício, se acha uma formula geral para realizar as calculos para qualquer entrada de massa. A formula se altera quando uma das cordas é cortada.</p>
<p><strong>Calculo para o sistema com 3 Blocos:</strong></p>
<div display="flex" align="center">
    <img src="./imgs/formulas/aceleracao3.png" alt="Formula da aceleração com 3 blocos." width="200px">
    <img src="./imgs/formulas/tracaoEsq3.png" alt="Formula da tração da esquerda." width="300px">
    <img src="./imgs/formulas/tracaoDir3.png" alt="Formula da tração da direita." width="300px">
</div>
<p><strong>Legenda:</strong></p>
<ul>
  <li>a: Aceleração
  <li>Ma: Massa do Bloco A.
  <li>Mb: Massa do Bloco B.
  <li>Mc: Massa do Bloco C.
  <li>g: Aceleração da Gravidade.
  <li>Te: Tração da Esquerda.
  <li>Td: Tração da Direita.
</ul>

<br>
<p><strong>Calculo para o sistema com 2 Blocos:</strong></p>
<p>Obs: Dependendo de qual corda é cortada, o valor da aceleração e da tração podem assumir valores negativos, pois estaram contra o eixo positivo.</p>
<div display="flex" align="center">
    <img src="./imgs/formulas/aceleracao2.png" alt="Formula da aceleração com 2 blocos." width="200px">
    <img src="./imgs/formulas/tracao2.png" alt="Formula da tração com 2 blocos." width="300px">
</div>
<p><strong>Legenda:</strong></p>
<ul>
  <li>a: Aceleração
  <li>Mm: Massa do Bloco que esta em cima da Mesa.
  <li>Mp: Massa do Bloco Pendurado.
  <li>T: Tração.
  <li>g: Aceleração da Gravidade.
</ul>


<br>
<br>

<h3 id="respostas">Exibição de Resposta</h3>
<p>Ao realizar os cálculos, é exibido as resposta no <CODE>JText Area</CODE>, é mostrado o valor da aceleração, da tração da esquerda, da direita e se a corda arrebenta.</p>
<p align="center"><img src="./imgs/respostas.png" alt="Imagem da exibição das respostas." width="350px"></p>


<br>
<br>


<h3 id="diagrama">Diagrama de Corpos Livres</h3>
<p>Foi utilizado a biblioteca <CODE>Graphics</CODE> e <CODE>Graphics2D</CODE> para realizar os desenhos do diagrama de corpos livres.</p>
<p>Há uma classe apenas para esta finalidade, que herda <CODE>JPanel</CODE>, e possui metodos para realizar o desenho.</p>
<p align="center"><img src="./imgs/diagrama.png" alt="Exemplo do Diagrama de Corpos Livres." width="350px"></p>


<br>
<br>


<h3 id="reset">Reset de Dados</h3>
<p>Há um botão para limpar todos os valores de entradas do usuário.</p>
<p>Os inputs de massas são limpados, o input da tensão máxima da corda recebe o valor 100, o radio button volta para o padrão, que é não</p>
<p>A área de resposta é limpa e o diagrama de corpos livres também.</p>


<br>
<br>


<h2 id="licenca">📃 Licença</h2>
Veja a lincença do projeto: <a href="https://github.com/JoaoVitorDomingos/Sistema-de-Blocos?tab=MIT-1-ov-file">MIT License</a>
<br>
<br>
