# Pergunta 1 - *Buffer Overflow*

Todas as imagens e outros ficheiros considerados relevantes para o entendimento complementar da resolução a todas as questões encontram-se listados na secção de [**Notas/Observações Finais**](#notasobservações-finais).

1. [**Pergunta P1.1**](#) - ***Buffer Overflow* em várias linguagens**
   - Análise do programa `LOverflow2` em três linguagens distintas
   - Compreensão do comportamento do programa

2. [**Pergunta P1.2**](#) - ***Buffer Overflow***
   - Análise dos programas `RootExploit` e `0-simple` escritos em C
   - Deteção vulnerabilidade de *Buffer Overflow* existente
   - Exploração dessa vulnerabilidade

3. [**Pergunta P1.3**](#) - ***Read Overflow***
   - Análise do programa `ReadOverflow` escrito em C

4. [**Pergunta P1.4**](#) - ***Buffer Overflow***
   - Compilação e execução do programa `1-match` escrito em C
   - Conceitos *little-endian* e *big-endian*

5. [**Pergunta P1.5**](#) - ***Buffer Overflow* na *Heap***
   - Técnicas de programação defensiva para mitigar vulnerabilidades de *Buffer Overflow* na *Heap*

6. [**Pergunta P1.6**](#) - ***Buffer Overflow* na *Stack***
   - Técnicas de programação defensiva para mitigar vulnerabilidades de *Buffer Overflow* na *Stack*

---

## Resolução da Pergunta 1

### Pergunta P1.1 - ***Buffer Overflow* em várias linguagens**

Se analisarmos os ficheiros referentes ao `LOverflow2` para as três linguagens distintas, conseguimos detetar um conjunto de padrões e diferenças características das linguagens em si.

Apesar dessas diferenças, a ideia deste programa é universal  - armazenar num *buffer* tantos números quantos aqueles que são pedidos sob a forma de *input*. Apesar dessa ser a ideia teórica, constata-se que existem erros/problemas na execução deste programa que iremos detalhar a seguir.

Para as três linguagens, o problema central do programa `LOverflow2`  está na não verificação do primeiro inteiro que é pedido e depois inserido em modo *input*, que pela análise do código teria de ser igual ou inferior a 10.

**O que se vai ver de seguida é a idealização de certos cenários que podem representar vulnerabilidades do programa e de que forma cada um deles reage perante os mesmos.**

<p>

#### 1. Análise do programa`LOverflow2` em Java

| Cenário                                                      | Reação do Programa                                           | Justificação                                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Introdução de um inteiro muito elevado (*Overflow* de Inteiros) | O programa lança uma exceção `java.util.InputMismatchException` | No código consta que cada inteiro que é lido no *input* tem de ter entre [0-10] dígitos apenas |
| Introdução de quantidade de números ligeiramente superior a 10 | O programa lança uma exceção `java.lang.ArrayIndexOutOfBoundsException` | Impossibilidade de inserir além do índice 10 do *array* em si |
| Introdução de quantidade de números muito superior a 10      | O programa lança uma exceção `java.util.InputMismatchException` | Trata-se de um número muito superior a 10                    |
| Introdução de uma quantidade de números negativa             | O programa é terminado de imediato, não sendo pedido qualquer valor | Como o valor da variável `count` será negativo, não chega a entrar no ciclo que controla a inserção dos `count` números pedidos no *input* |

<p>

#### 2. Análise do programa`LOverflow2` em Python

| Cenário                                                      | Reação do Programa                                           | Justificação                                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Introdução de um inteiro muito elevado (*Overflow* de Inteiros) | O programa não apresenta qualquer reação oposta/defensiva    | Isto deve-se ao facto das operações em si estarem em Python puro. Uma vez que os números inteiros Python têm uma precisão arbitrária (não têm comprimento de *bytes* fixo) não existe a possibilidade de *Overflow* |
| Introdução de quantidade de números ligeiramente superior a 10 | O programa vai pedindo os números até atingir o erro `IndexError` | A descrição do erro detalha que o índice que se quer alcançar está fora do *range* permitindo, daí a impossibilidade de inserir além do índice 10 do *array* em si |
| Introdução de quantidade de números muito superior a 10      | O programa lança uma exceção `OverflowError`                 | A descrição do erro detalha que o *range* de resultados possui demasiados itens a serem verificados no ciclo *for* do código em si. Isto acontece porque a função `range()` vai devolver demasiados resultados possíveis, criando-se um *Overflow* |
| Introdução de uma quantidade de números negativa             | O programa é terminado de imediato, não sendo pedido qualquer valor | A função `range()` do Python pode lidar com *ranges* negativos mas estes devem estar bem definidos e fazerem sentido. Dado que no código o range vai de `0` a `count-1` termos um valor de `count` negativo acabaria por não funcionar |
| Invocação de funções no próprio *input*                      | O programa consegue lidar com estas invocações, dependendo o *output* da função usada | A expressão absorvida no *stdin* é interpretada pelo Python, permitindo então a invocação a estas funções |

<br/>

Para este programa Python, salienta-se essencialmente esta possibilidade de invocar funções como algo mais perigoso/preocupante. Para que se entenda de forma mais intuitiva esta invocação, criou-se uma mini definição no próprio código Python, que permite explorar a vulnerabilidade associada ao uso da função `input` existente no código original.

```python
def test():
    print("Secret")
    
tests=[None]*10
count = input("Quantos numeros? ")
for i in range (0,count-1):
    test = input ("Insira numero: ")
    tests[i]=test
```

<br/>

**Com este código pronto, executa-se novamente o programa e verifica-se o seguinte resultado:**

<p align = "center">
    <img src = "Images/LOverflow2PythonTest.png" width = 80% />
</p>


Entende-se assim a ideia de invocar funções que são depois executadas em modo *script* e de que forma se pode imprimir como resultado uma hipotética mensagem secreta sem sequer ser necessário alterar o restante código.

<p>

#### 3. Análise do programa `LOverflow2` em  C++

| Cenário                                                      | Reação do Programa                                           | Justificação                                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Introdução de um inteiro muito elevado (*Overflow* de Inteiros) | O programa imprime os restantes pedidos de números, não permitindo a sua introdução em termos de *input* | No código consta que cada inteiro que é lido no *input* tem de ter entre [0-10] dígitos apenas |
| Introdução de quantidade de números ligeiramente superiores a 10 | O programa gera mais pedidos de números do que o suposto     | Impossibilidade de inserir além do índice 10 do *array* em si |
| Introdução de quantidade de números muito superiores a 10    | O programa gera de forma repetida pedidos de números. Esta repetição acontece de forma infinita | Trata-se de um número muito superior a 10                    |
| Introdução de uma quantidade de números negativa             | O programa é terminado de imediato, não sendo pedido qualquer valor | Como o valor da variável `num_elems` será negativo, não chega a entrar no ciclo que controla a inserção dos `num_elems` números pedidos no *input* |

<br/>

**Estando feita toda esta triagem de resultados para os programas criados nas diferentes linguagens, surgem as seguintes conclusões:**

- Verifica-se que todas as linguagens concretizam os diferentes cenários que podem representar possíveis vulnerabilidades;
- Dado que são três linguagens distintas, o comportamento altera em alguns dos cenários;
- Apesar do comportamento ser diferente pelas várias linguagens, a justificação do porquê de estes erros acontecerem é semelhante entre os três programas;
- Nenhum dos programas faz uma verificação inicial da quantidade pedida pelo utilizador;
- Não há qualquer verificação em relação ao tipo de *input* recolhido.

---

### Pergunta P1.2  - *Buffer Overflow*

Para a resolução desta questão torna-se necessário estudar e compreender o algoritmo de cada programa, para que possam ser obtidas as respostas necessárias em termos de *exploit*. Relativamente ao ficheiro `RootExploit` pretende-se conseguir forçar permissões de root/admin mesmo sem usar a *password* adequada. No caso do ficheiro `0-simple` é suposto conseguir forçar a obtenção da mensagem "YOU WIN!!!".

**Pela análise rápida de ambos os programas, deteta-se desde logo o uso da função `gets`, que como o próprio compilador gcc indica, pode representar um grande perigo em termos de segurança de código. É precisamente através da compreensão do funcionamento da mesma que vamos conseguir fazer o *exploit* das vulnerabilidades seguintes.**

<br/>

#### 1. Análise do programa `RootExploit` em  C

Comece-se por enumerar o algoritmo pensado para este programa. Com isto feito, pode-se detetar a vulnerabilidade existente e definir a forma de explorá-la.

<br/>

**1.1. Algoritmo do programa:**

<br/>

- Cria duas variáveis de instância a ser usadas ao longo do programa

```C
int pass = 0;
char buff[4];
```

**A variável `pass` será usada para controlar o acesso root/admin do utilizador e a variável `buff` serve para armazenar a *password* dada pelo utilizador.**

<br/>

- Solicita a *password* de *root* ao utilizador e obtém/guarda a mesma pelo uso da função `gets`

```C
printf("\n Insira a password de root: \n");
gets(buff);
```

<br/>

- Compara essa *string password* com a string `csi1`, que corresponde à *password* válida para obter os privilégios

<br/>

- Caso a *password* seja válida, a variável `pass` assume o valor de 1

```C
if(strcmp(buff, "csi1")) printf ("\n Password errada \n");
else{
    printf ("\n Password correcta \n");
    pass = 1;
}
```

<br/>

- Caso `pass` tenha o valor de 1, são dadas as permissões de root/admin ao utilizador

```C
if(pass){
    /* Atribuir permissões de root/admin ao utilizador */
    printf ("\n Foram-lhe atribuidas permissões de root/admin \n");
}
```

<br/>

**1.2. Forma de explorar a vulnerabilidade do programa:**

Conforme dito anteriormente, o uso da função `gets` não deve ser considerado como uma solução válida, dado que esta função não trata de verificar o tamanho do *input* e de seguida comparar esse tamanho com aquele que foi alocado para a variável responsável por armazenar essa *string*. 

Uma vez que o *array* `buff` é declarado com caracteres de 4 *bytes*, entende-se que apenas podem ser introduzidos 3 caracteres, estando aqui representado todo o perigo. Acontece que se a escrita continuar o programa acaba por escrever para fora dos limites estabelecidos para o `buff`, o que permite que se altere o valor da variável `pass` que controla esta obtenção de privilégios.

<br/>

**Pense-se em termos de *stack* e a forma como os valores são colocados sobre a mesma:**

Apesar dos valores/variáveis serem colocados na *stack* desde os níveis mais altos até aos mais baixos, a escrita é feita no sentido contrário. Dessa forma, valida-se a *stack* apresentada abaixo, que mostra a variável `pass` acima do `buff`. 

<p align = "center">
    <img src = "Images/Stack1.png" width = 30% />
</p>

Com esta estrutura pensada, a escrita para lá dos 3 caracteres do *buffer* permitirão romper o espaço de memória reservado para `buff`, fazendo com que se suba na *stack* e se altere o valor de `pass`. Como o código o indica, caso este valor seja diferente de 0, a *password* é reconhecida como verdadeira e o utilizador obtém os privilégios pretendidos.

<br/>

**Veja-se essa ideia em prática:**

<p align = "center">
    <img src = "Images/RootExploit.png" width = 60%/> 
</p>
<p>

#### 2. Análise do programa `RootExploit` em  C

Comece-se por enumerar o algoritmo pensado para este programa. Com isto feito, pode-se detetar a vulnerabilidade existente e definir a forma de explorá-la.

<br/>

**2.1. Algoritmo do programa:**

<br/>

- Cria duas variáveis de instância a ser usadas ao longo do programa, inicializando uma delas a 0
```C
int control;
char buffer[64];

printf("You win this game if you can change variable control'\n");

control = 0;
```

<br/>

- Solicita a *password* de *root* ao utilizador e obtém/guarda a mesma pelo uso da função `gets`, tal como o programa anterior

```C
gets(buffer);
```

<br/>

- Caso `control` tenha um valor diferente de 0, é imprimida a tal mensagem "YOU WIN!!!"

```C
if(control != 0) printf("YOU WIN!!!\n");
else printf("Try again...\n");
```

<br/>

**2.2. Forma de explorar a vulnerabilidade do programa:**

O problema continua a ser o mesmo do programa anterior - uso da função `gets` e a possibilidade de ir além do espaço alocado para a variável do buffer.

<br/>

**Para este programa, a *stack* seria algo como:**

Seguindo o mesmo pensamento aplicado para o programa anterior, a ideia seria escrever para lá dos 64 bytes do *buffer*, conseguindo assim aceder à variável `control` e dessa forma chegar ao resultado pretendido. Contudo, verificou-se que esta alteração só é possível caso se dê um *input* de 77 caracteres, levantando a dúvida da possibilidade de existir uma outra variável/endereço entre o `buffer` e o `control`.

<p align = "center">
    <img src = "Images/Stack2.png" width = 30% />
</p>
<br/>

**Veja-se essa ideia em prática:**

<p align = "center">
    <img src = "Images/0-simple.png" width = 70%/> 
</p>

---

### Pergunta P1.3 - *Read Overflow*

Texto

---

### Pergunta P1.4

Texto

---

### Pergunta P1.5 - ***Buffer Overflow* na *Heap***

Texto

---

### Pergunta P1.6 - ***Buffer Overflow* na *Stack***

Texto

---

## Notas/Observações Finais

Não existem observações finais para este Trabalho Prático.
