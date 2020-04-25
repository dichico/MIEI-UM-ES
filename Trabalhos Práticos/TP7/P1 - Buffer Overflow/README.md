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

#### Análise do programa Java

| Cenário                                                      | Reação do Programa                                           | Justificação                                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Introdução de um inteiro muito elevado (*Overflow* de Inteiros) | O programa lança uma exceção `java.util.InputMismatchException` | No código consta que cada inteiro que é lido no *input* tem de ter entre [0-10] dígitos apenas |
| Introdução de quantidade de números superior a 10            | O programa lança uma exceção `java.lang.ArrayIndexOutOfBoundsException` | Impossibilidade de inserir além do índice 10 do *array* em si |
| Introdução de quantidade de números muito superior a 10      | O programa lança uma exceção `java.util.InputMismatchException` | Trata-se de um número muito superior a 10                    |
| Introdução de uma quantidade de números negativa             | O programa é terminado de imediato                           | Como o valor da variável `count` será negativo, não chega a entrar no ciclo que controla a inserção dos `n` números pedidos no *input* |

<p>

#### Análise do programa Python

Em termos de linguagem Python o comportamento do programa é ligeiramente diferente. Esta situação é perfeitamente normal, uma vez que cada linguagem lida com os erros/problemas de uma forma diferente.

<br/>

| Cenário                                                      | Reação do Programa                                           | Justificação                                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Introdução de um inteiro muito elevado (*Overflow* de Inteiros) | O programa não apresenta qualquer reação oposta/defensiva    | Isto deve-se ao facto das operações em si estarem em Python puro. Uma vez que os números inteiros Python têm uma precisão arbitrária (não têm comprimento de *bytes* fixo) não existe a possibilidade de *Overflow* |
| Introdução de quantidade de números elevada                  | O programa lança uma exceção `OverflowError`                 | A descrição do erro detalha que o *range* de resultados possui demasiados itens a serem verificados no ciclo *for* do código em si |
| Introdução de uma quantidade de números negativa             | O programa é terminado de imediato                           | A função `range()` do Python pode lidar com *ranges* negativos mas estes devem estar bem definidos e fazerem sentido. Dado que no código o range vai de `0` a `count-1` termos um valor de `count` negativo acabaria por não funcionar |
| Invocação de funções no próprio *input*                      | O programa consegue lidar com estas invocações, dependendo o *output* da função usada | No caso do código fornecido,                                 |

<br/>

<p>

#### Análise do programa C++

---

### Pergunta P1.2  - *Buffer Overflow*

Texto

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
