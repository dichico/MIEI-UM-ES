# *Command Line Program* para teste das Operações do Serviço de Assinatura com Chave Móvel Digital

A aplicação Comando Linha (CLI) surge no sentido de permitir efetuar todos os testes das várias operações do serviço nacional SCMD (*Signature* CMD). Esta aplicação foi inicialmente desenvolvida na linguagem Pyhton, sendo este repositório reservado à sua implementação na linguagem Java, através de *Reverse Engineer* da aplicação original [CMD-SOAP](https://github.com/devisefutures/CMD-SOAP).

# Implementação/Estrutura do Programa

O programa encontra-se então implementado na linguagem Java, tendo-se feito uso do ***Software Project Management* Maven** que se baseia num  *Project Object Model (POM)* sob a forma de `xml`, onde se encontram listadas todas as dependências internas ao programa desenvolvido. 
Este ficheiro `xml` permite uma flexibilidade em termos de atualização das versões das várias bibliotecas e possíveis adições futuras, sendo apenas necessário fazer um *build* inicial para que as mesmas sejam automaticamente instaladas/integradas no projeto.

**Assim, esta diretoria encontra-se organizada da seguinte forma:**

- :open_file_folder: **Diretoria [src](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main)** que contém a diretoria **[java](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/java)** que possui toda a parte do código Java e ainda a diretoria **[resources](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/resources)** que possui todos os ficheiros extra ao programa
  - :open_file_folder: **Diretoria [java](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/java)**
    - :file_folder: **Diretoria [code](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/code)**
      - :memo: Ficheiro [CmdConfig.java](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/code/CmdConfig.java) que é usado para definir o *Application Id* fornecido pela AMA 
      - :memo: Ficheiro [CmdSoapMsg.java](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/code/CmdSoapMsg.java) que contém todas as funções que preparam e executam os vários comandos SOAP da Assinatura com Chave Móvel Digital
      - :memo: Ficheiro [TestCmdWsdl.java](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/code/TestCmdWsdl.java) que contém a *main* do programa que permite que os testes dos vários comandos sejam executados
    - :file_folder: **Diretoria [wsdlservice](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/wsdlservice)**
  - :open_file_folder: **Diretoria [resources](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/resources)**
    - :page_facing_up: **Ficheiro [ama.wsdl](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/CMD-SOAP/src/main/resources/ama.wsdl)** que define como descreve como todo o *Web Service* SOAP funciona 
    - :key: **Ficheiro(s) [XXXXXXXXX.pem](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/CMD-SOAP/src/main/resources/ama.wsdl)** que correspondem a todos os ficheiros PEM dos vários utilizadores do programa, usando-se como nome do ficheiro o seu *User Id*
- :bookmark_tabs: Ficheiro [pom.xml](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/CMD-SOAP/pom.xml) que consiste na *Bill of Materials* do *software* desenvolvido

**Para demonstrar todo o processo da utilização da aplicação, desde a parte inicial de *build* até à parte do *compile* do ficheiro Java com a *main*, recorre-se ao *Code Editor* IntelliJ IDEA**.

# Utilização da Aplicação de Testes

Para começar a utilizar o programa Java pela primeira vez, e tendo em conta que o mesmo está já implementado com o **Maven**, o primeiro passo consiste em abrir o projeto no IntelliJ IDEA, selecionado para isso apenas o ficheiro `pom.xml` e selecionar `Open as Project`. 

<br/>

<p align = "center">
   <img src = "https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/Run%20First%20Time%20Program.gif" alt = "Run First Time Program" width="80%"/>
</p>
<p align = "center"><b>Figura 1.</b> Demonstração de como fazer o <i>build</i> inicial do programa<br/></p>

<br/>

- Abrir o ficheiro `pom.xml` e clicar no ícone de ferramenta a verde na parte superior da janela.

  - Isto faz um *compile/build* inicial desse mesmo ficheiro `pom.xml`, que trata de criar toda a pasta **target** com as devidas Classes Java necessárias ao programa.
  - Todas as dependências definidas na *Bill of Materials* são corretamente instaladas e armazenadas na diretoria `.idea/libraries`.
- Navegar até à Diretoria [code](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/code), selecionado o Ficheiro [TestCmdWsdl.java](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/code/TestCmdWsdl.java).
- Com o ficheiro aberto, o próprio IntelliJ IDEA cria um ícone de play a verde que ao ser acionado permite fazer o *run* da Classse `main` nele descriminada.

<br/>

**Este conjunto de passos inicia o programa, espoletando a exibição do menu principal do mesmo:**

<p align = "center">
   <img src = "https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/Menu%20Command%20Line%20Program.png" alt = "Run First Time Program" width="80%"/>
</p>
<p align = "center"><b>Figura 2.</b>Menu Principal do *Command Line Program*<br/></p>  


## Exemplo da utilização Comando GetAll

# Notas
