# Pergunta 1 - Validação de *Input*

Todas as imagens e outros ficheiros considerados relevantes para o entendimento complementar da resolução a todas as questões encontram-se listados na secção de [**Notas/Observações Finais**](#notasobservações-finais).

1. [**Pergunta 1.1**]()
   - Análise do programa `filetype.c`
   - Análise/Exploração de vulnerabilidades presentes

2. [**Pergunta 1.2**]()
   - Criação/desenvolvimento de um programa em Python
   - Validação do *input* consoante as regras de validação dadas na aula teórica

---

## Resolução da Pergunta 1

### Pergunta 1.1

Fazendo uma pequena análise do conteúdo/*source code* do programa `filetype.c` consegue-se deduzir que o mesmo trata de receber um nome de um ficheiro como argumento na linha de comandos, devolvendo como *output* o tipo de conteúdo que o ficheiro em causa possui.

<br/>

<p align="center">
    <img src="Images/Output Programa filetype.png" width=60%/>
</p>


<p>

#### 1. Deteção e Exploração das Vulnerabilidades

Tendo em conta as vulnerabilidades estudadas na aula teórica de "Validação de Input", pode-se referir as seguintes vulnerabilidades para o programa `filetype.c`:

- Ausência da verificação dos tamanhos dados como *input*;

- O uso da função `system()` torna-se perigoso, dado que não existe qualquer parte de código que valide a extensão do ficheiro que está a ser mandado como argumento na altura de executar o programa;

  <br/>

  **Note-se a seguinte sequência de execuções em modo terminal:**

  <br/>

  <p align = "center">
      <img src = "Images/Output Programa filetype V1.png" width = 60%/>
  </p>
<br/>
  

A criação do ficheiro `teste.txt; ps -a` permite demonstrar que não é feita a tal verificação do nome/extensão do ficheiro, acabando assim por devolver não só o resultado da aplicação do programa ao ficheiro `teste.txt` mas também o resultado da execução do programa `ps -a`, dado que o operador `;` é usado para a execução de vários comandos.

  **Isto demonstra o perigo aqui implícito, dado que se se pode fazer algo simples como a execução de um comando que de nada tem a ver com o propósito do programa em si, então pode existir outras "maldades" podem eventualmente funcionar.**

  

- O uso da função `system()` possibilita ainda a realização de *path traversal*. Neste caso apenas seria necessário usar `/ ` para executar esse processo e obter a diretoria através do *autocomplete*.

  <br/>

  <p align = "center">
      <img src = "Images/Output Programa filetype V2.png" width = 90%/>
  </p>

  <br/>

<p>

#### 2. Programa com permissões *setuid root*


Pensando-se agora num cenário onde o programa estudado anteriormente tivesse permissões *setuid root*. Fornecer estas permissões torna-se realmente perigoso, dado que permite a um *user* com poucas permissões padrão a possibilidade de executar comandos indesejáveis, comprometendo assim todo o sistema em termos de **Confidencialidade**, **Integridade** e **Disponibilidade**.

A execução de programas maliciosos, leitura/manipulação de ficheiros, etc seriam possibilidades perfeitamente exequível tendo-se estas permissões.

---

### Pergunta 1.2

<p>
---


## Notas/Observações Finais

- Imagem [**Output Programa filetype**]() que demonstra o *output* do programa `filetype.c`.
- Imagem [**Output Programa filetype V1**]() que demonstra o *output* do programa `filetype.c` com a exploração da primeira vulnerabilidade.
- Imagem [**Output Programa filetype V2**]() que demonstra o *output* do programa `filetype.c` com a exploração da segunda vulnerabilidade.