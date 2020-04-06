# Pergunta 1 - *Common Weakness Enumeration* (CWE)

Todas as imagens e outros ficheiros considerados relevantes para o entendimento complementar da resolução a todas as questões encontram-se listados na secção de [**Notas/Observações Finais**](#notasobservações-finais).

1. [**Pergunta 1.1**](#) - ***Common Weakness Enumeration* (CWE)**
   
    - Análise das três primeiras *Weakness* do *ranking* do CWE
    - Análise da *Weakness* N.º 9 do *ranking* do CWE
    
2. [**Pergunta P1.2**](#) - ***Source Lines Of Code* (SLOC)**
   - Análise do número de linhas de código de um pacote/plataforma de *software*
    - Estimativa de número de *bugs* a partir desse número de linhas de código
    - Possíveis Vulnerabilidades

---

## Resolução da Pergunta 1

### Pergunta 1.1 - ***Common Weakness Enumeration* (CWE)**

Usando como base o **The CWE Top 25** de 2019 https://cwe.mitre.org/top25/, somos capazes de responder às seguinte perguntas práticas.

<br/>

#### Alínea I. Características das três primeiras *Weakness* do *ranking*

| ID da *Weakness*                                             | Descrição                                                    | Plataformas Aplicáveis                                       | Consequências mais comuns                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **ID** [**CWE-119**](https://cwe.mitre.org/data/definitions/119.html) | ***Improper Restriction of Operations within the Bounds of a Memory Buffer***<br />Weakness* presente quando estamos a lidar com um *buffer* presente numa aplicação e conseguimos ler/escrever num espaço de memória para além do que foi alocado a esse *buffer*. | **Linguagens de Programação**: Mais dominante em linguagens de baixo nível - C, C++ e *Assembly*. <br />**Tecnologias**: Não Aplicáveis. | Execução de código ou comandos não autorizados; Leitura de memória, bem como informação sensível; Alterar o fluxo de controlo; Colocar o sistema indisponível. |
| **ID** [**CWE-79**](https://cwe.mitre.org/data/definitions/79.html) | ***Improper Neutralization of Input During Web Page Generation ('Cross-site Scripting')***<br />*Weakness* presente quando uma  *web app* não neutraliza ou neutraliza de forma incorreta o *input* dado pelo utilizador. <br />Como o *ouput* destas páginas é veiculado a outros utilizador, tornam-se vulneráveis a esta fraqueza. | **Linguagens de Programação:** Indeterminadas.<br />**Tecnologias:** Todas as tecnologias *web* podem estar vulneráveis a este tipo de ataques. | Obtenção de informação armazenada nos *cookies*; Execução de código ou comandos não autorizados; Envio de pedidos fingindo ser a vítima. |
| **ID** [**CWE-20**](https://cwe.mitre.org/data/definitions/20.html) | ***Improper Input Validation***<br />*Weakness* presente quando uma *web app* não valida o *input* vindo do utilizador, podendo afetar o fluxo de controlo ou o fluxo de dados do programa em si.<br />**Apesar de similar à anterior em termos de descrição, esta *weakness* interfere nos servidores onde o *software* se encontra alojado, enquanto que a anterior pode chegar a afetar diretamente os dispositivos dos clientes do *software*.** | **Linguagens de Programação:** Indeterminadas.<br />**Tecnologias:** Não Aplicáveis. | *Denial of Service*; Leitura de memória, bem como ficheiros ou pastas; Execução de código ou comandos não autorizados. |

<br/>

#### Alínea II. Características da *Weakness* N.º 9 do *ranking*

| ID da *Weakness*                                             | Descrição                                                    | Plataformas Aplicáveis                                       | Consequências mais comuns                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **ID** [**CWE-190**](https://cwe.mitre.org/data/definitions/190.html) | ***Integer Overflow or Wraparound***<br />Cálculo que pode originar um excesso de número inteiro ou envolvente.<br />Este *overflow* acontece quando um valor inteiro é incrementado para um valor demasiado grande para ser armazenado. <br />Quando isto acontece, esse valor pode "estourar" e virar um número muito pequeno e até mesmo negativo. | **Linguagens de Programação:** Indeterminadas.<br />**Tecnologias:** Não Aplicáveis. | *Denial of Service*; Modificação da memória; Execução de código ou comandos não autorizados. |

<br/>

**Veja-se um exemplo demonstrativo de como esta *Weakness* pode ocorrer:**

```c
img_t table_ptr; / * struct contendo dados img, 10kB cada * /
int num_imgs;
...
num_imgs = get_num_imgs ();
table_ptr = (img_t *) malloc (sizeof (img_t) * num_imgs);
...
```

Pela análise do código conseguimos perceber que se quer criar/alocar uma tabela de tamanho ```num_imgs```. 

Tendo em conta que esse ```num_imgs``` vai crescendo, o cálculo que determina o tamanho da lista terá também de ser feito calculado. O que acontece é pode chegar a um momento em que esse cálculo acabe por "estourar", resultando numa lista muito pequena a ser alocada.
Se o código C que vier a seguir a estes cálculos operar assumindo um determinado número de imagens, este cálculo errado poderá produzir muitos tipos de *out-of-bounds problems*.

<br/>

**Veja-se outro exemplo demonstrativo:**

```c
bytes int curtos = 0;
char buf [SOMEBIGNUM];

while (bytesRec < MAXGET) {
bytesRec + = getFromInput (buf + bytesRec);
}
```

Neste caso, o valor de ```bytesRec``` pode também ele "estourar", criando um valor continuamente menor que ```MAXGET```, levando a que exista um comportamento de *loop* indefinido.

<br/>

**Este tipos de *overflows* são muito comuns no contexto da linguagem C, estando eles associados à insuficiência de memória por parte destas variáveis.**

---

### Pergunta P1.2 - ***Source Lines Of Code* (SLOC)**

A ideia desta pergunta passa por analisar os dados fornecidos relativamente ao número de linhas de código de um determinado pacote/plataforma de *software*, de modo a estabelecer uma estimativa do número de *bugs* dos mesmos e possíveis vulnerabilidades.

<br/>

#### Alínea I. Estimativa número de *bugs*

Estima-se que qualquer pacote de de *software* tem uma média de 5 a 50 bugs por cada 1.000 linhas de código fonte (1.000 *Source Lines Of Code*) , alguns dos quais dados como vulnerabilidades.

<br/>

**Para estes valores existe um limite inferior que está associado a *softwares* mais normais e um limite superior associado a *softwares* desenvolvidos através de métodos mais rigorosos:**

- **Limite Inferior:** 50 *bugs* por cada 1.000 linhas de código fonte;
- **Limite Superior:** 5 *bugs* por casa 1.000 linhas de código fonte.

Isso deixa desde logo a ideia de que esta estimativa varia muito de acordo com o nível de testes de um *software* e até mesmo a linguagem de programação associada ao mesmo. Tendo-se isto definido, é possível estabelecer uma regra de três simples e determinar os valores para estes limites.

 <br/>

| Pacote/Plataforma de *software*      | ≅ Linhas de Código | Limite Inferior | Limite Superior |
| ------------------------------------ | ------------------ | --------------- | --------------- |
| Facebook                             | 62 milhões         | 310 000         | 3 100 000       |
| *Software* de automóveis             | 100 milhões        | 500 000         | 5 000 000       |
| Linux 3.1                            | 15 milhões         | 75 000          | 750 000         |
| Todos os serviços Internet da Google | 2 biliões          | 10 000 000      | 100 000 000     |

<br/>

#### Alínea II. Possíveis Vulnerabilidades

Sabe-se que o número de *bugs* e o número de vulnerabilidades estão internamente ligados. Basta pensar em grandes aplicações, com maior número de linhas de código fonte, para perceber que estão mais suscetíveis a apresentar um maior número de *bugs*, pelo simples facto de serem aplicações mais complexas em termos de desenvolvimento.

<br/>No entanto, não é possível estabelecer uma ligação direta entre todos estes valores, pelo simples facto de que não existe uma estimativa em termos de vulnerabilidades que possa ser determinada a partir do número de linhas de código fonte e/ou número de *bugs*.

---

### Pergunta P1.3



---

### Pergunta P1.4

As vulnerabilidades de **dia-zero** são vulnerabilidades que não têm um *patch* para corrigir disponível, fazendo com que seja uma falha de segurança para qualquer *hacker* explorar e atacar, dado que toda a gente usando esse produto afetado está exposto dada a falta de correção da vulnerabilidade.

De forma análoga, uma vulnerabilidade que não seja **day-zero** é uma falha que foi encontrada pela comunidade e/ou pelo fabricante, mas já corrigida através dum *patch*. De qualquer forma, não deixa de ser uma vulnerabilidade dado que apenas aqueles que tenham o produto atualizado para a versão mais recente é que estão protegidos de possíveis *exploits* advindos dessa vulnerabilidade.

O caso mais infame e recente foi a vulnerabilidade **HeartBleed** que afetou a biblioteca de segurança *open source* **OpenSSL**. Quando esta vulnerabilidade **dia-zero** no dia 1 de Abril de 2014, estimou-se que 17%, ou meio milhão de servidores Web que estavam certificados como seguros, estavam na verdade vulneráveis a *exploits* relacionados com esta vulnerabilidade, até ter existido o *patch* que demorou 7 dias a ser efetuado.

---

## Notas/Observações Finais

Escrever Notas.