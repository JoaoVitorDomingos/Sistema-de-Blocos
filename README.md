<h1 align="center" style="font-weight: bold;">📦 Sistema de Blocos</h1>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
[![GitHub license](https://img.shields.io/github/license/Naereen/StrapDown.js.svg)](https://github.com/Naereen/StrapDown.js/blob/master/LICENSE)

<p align="center">
  <a href="#sobre">Sobre</a> • 
  <a href="#acesso">Instalação</a> • 
  <a href="#funcionalidades">Funcionalidades</a> •
  <a href="#licenca">Licença</a> •
</p>

<br>
<p align="center">
    <img src="./imgs/img_projeto.png" alt="Imagem do Projeto" width="600px">
</p>
<br>

<h2 id="sobre">📌 Sobre</h2>
<p>Um <ins>projeto da faculdade</ins> da matéria de física, no qual foi realizado um programa em <strong>Java</strong> que calcula um exercício de física. O exercício escolhido é um sistema com 3 blocos, no qual os blocos estão ligados por uma corda e calcula a aceleração, a tração e mostra um diagrama de corpos livres.</p>

<br>
<br>

<h2 id="acesso">🚀 Instalação</h2>
<h3>Requisitos</h3>
<p>É necessário ter o <ins>JDK 24</ins> instalado em sua máquina para poder rodar o projeto, <a href="https://download.oracle.com/java/24/latest/jdk-24_windows-x64_bin.exe">baixe aqui</a></p>
<h3>Execute o Programa</h3>
<p>Baixe o executável do programa <CODE>(.jar)</CODE> <a href="https://github.com/JoaoVitorDomingos/Sistema-de-Blocos/releases/tag/1.0.0">aqui</a>. E com dois cliques, execute-o.</p>


<br>
<br>

<h2 id="funcionalidades">💻 Funcionalidades</h2>
<p>Nesta sessão esta as funcionalidades do projeto.</p>
<details>
  <summary><h3>Sumário</h3></summary>
  <ol>
  <li><a href="#interface">Interface Gráfica</a></li>
    <li><a href="#restricoes">Restrições de Entrada</a></li>
    <li><a href="#calculo">Cálculo do Exercício</a></li>
    <li><a href="#">Exibição de Resposta</a></li>
    <li><a href="#">Diagrama de Corpos Livres</a></li>
    <li><a href="#">Reset de Dados</a></li>
  </ol>
</details>

<h3 id="#interface">Interface Gráfica</h3>
<p>Há uma interface gráfica feita em Swing, no qual foi utilizado a ferramenta do NeatBeans.</p>
<p>Possui labels, inputs, radio buttons, botões, uma imagem, um TexteArea para mostrar as respostas e um JPanel para realizar o desenho do diagrama de corpos livres.</p>
<p>Não é possível diminuir nem aumentar o tamanho da janela para impedir que o layout se quebre, ou seja, também não é possível maximizar a janela.</p>

<br>
<br>

<h3 id="#restricoes">Restrições de Entrada</h3>
<p>Há restriçoes para a entrada do usuário para que condiza com a realidade os cálculos.</p>
<p>Não é possível adicionar valores negativos para a massa e a tensão máxima da corda, até porque isso não existe. E tem um limite máximo de 200Kg para as massas e 500N para a tensão máxima da corda, a corda tem uma restrição mínima, onde diz que sua tensão deve ser no mínimo 10N</p>
<p>Também há uma verificação que analisa se todos os inputs estão preechidos. Caso uma das restrições sejam feridas, mostra um JOptionalPane que alerta sobre a restrição.</p>

<br>
<br>

<h3 id="#calculo">Cálculo do Exercício</h3>
<p>A partir da resolução do exercício, se acha uma formula geral para realizar as calculos para qualquer entrada de massa. A formula se altera quando uma das cordas é cortada.</p>

<br>
<br>


<h2 id="licenca">📃 Licença</h2>
Veja a lincença do projeto: <a href="https://github.com/JoaoVitorDomingos/Sistema-de-Blocos?tab=MIT-1-ov-file">MIT License</a>
<br>
<br>
