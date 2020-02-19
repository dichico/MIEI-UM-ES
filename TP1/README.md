# Trabalho Prático 1 - Aula 17/02/2020

Add Small Description.

---

## Resolução do Guião

### 1\. Números Aleatórios/Pseudoaleatórios

<p>

#### 	1.1\. Pergunta P1.1

O comando `openssl rand -base64 1024` pedido para teste na Experiência 1.1 é claro de se compreender.

Segundo a documentação oficial do **OpenSSL**,

> The **rand** command outputs *num* pseudo-random bytes after seeding the random number generator once.

O que faz sentido, dado que o *output* produzido por este comando consiste precisamente num conjunto de 1024 *bytes* pseudoaleatórios.

Tomando este comando como base, pretende-se agora ir mais longe, no sentido de combinar dois comandos que permitirão gerar diferentes conjuntos de *bytes* também eles pseudoaleatórios, apresentando-os sobre a forma da base64. 

<br/>

**Dessa forma, torna-se necessário compreender a diferença entre os *special files* do *Linux* cujo propósito é gerar números pseudoaleatórios.**

- `/dev/random`- devolve *bytes* aleatórios estimados pelo *pool* de entropia existente, bloqueando a operação de leitura quando a entropia disponível é inferior à solicitada/necessária para a geração em causa;
- `/dev/unrandom`- contrariamente ao anterior, caso não exista entropia suficiente/necessária, reusa o *pool* de forma a produzir os bits pseudoaleatórios em causa. 

Dado que o *special file* `/dev/unrandom` nunca interrompe a operação de leitura, é possível que os valores dados no *output* estejam vulneráveis a ataques criptográficos.

| Comando/Tipologia                             | Tempo de Execução | Resultados/Observações                                       |
| :-------------------------------------------- | :---------------: | :----------------------------------------------------------- |
| **Comando 1** - 32 *bytes*, `/dev/random`     |     ≡ 0.004s      | Devolução do resultado imediata. Número de *bytes* baixo.    |
| **Comando 2** - 64 *bytes*, `/dev/random`     |     ≡ 0.012s      | Devolução do resultado imediata. Tempo de Execução superior ao **Comando 1**. |
| **Comando 3** - 1024 *bytes*, `/dev/random`   |   ≡ 10m30.232s    | Número de *bytes* mais elevado logo maior Tempo de Execução. |
| **Comando 4** - 1024 *bytes*, `/dev/unrandom` |     ≡ 0.004s      | Apesar do número de *bytes* ser igual ao **Comando 3**, resultado imediato. |

*Note-se que o tempo de execução destes comandos é uma estimativa dada pelo próprio Debian, fazendo-se uso do comando `time`.*

<br/>

**Com os resultados em mão e com a breve explicação que foi feita para a diferença do `random`e do `unrandom`, torna-se intuitivo compreender os tempos de execução obtidos pelos quatro comandos.**

- O Tempo de Execução aumenta à medida que aumentamos também o número de *bytes* a serem gerados, dado que é preciso mais entropia para se gerarem mais *bytes*.
  - Isto fica percetível pelo **Comando 1** e pelo **Comando 2**. Ambos usam o `random`, mas diferem no tempo que demoram a ser executados.
- O uso do *special file* `/dev/random` ou `/dev/unrandom` é determinante no Tempo de Execução.
  - O **Comando 3** e o **Comando 4** solicitam a mesma quantidade de *bytes*, mas a diferença de tempo é muito grande. Isso acontece porque o **Comando 4** faz uso do `unrandom`, o que leva a que quando a entropia não é suficiente, exista uma espécie de implementação de PRNG próprio através de uma *seed* (que é o que OpenSSL acaba por fazer), acelarando todo o processo em si.

<p>
#### 	1.2\. Pergunta P2.1

Conforme anunciado, o haveged é um *daemon* de entropia totalmente adaptado através do algoritmo HAVEGE, criado com o objetivo de corrigir/colmatar problemas em que existe uma baixa entropia no *special file* em si. A sua ideia base passa por fornecer um RNG simples de usar que possibilite essa medida através da criação da entropia necessária para se excutar o comando/operações em causa.

<p>

Igualmente à **Pergunta P1.1**,  será feita uma análise basilar acerca dos comandos, estudando-se agora apenas o **Comando 3** e o **Comando 4**.

| Comando/Tipologia                             | Tempo de Execução | Resultados/Observações                                     |
| :-------------------------------------------- | :---------------: | :--------------------------------------------------------- |
| **Comando 3** - 1024 *bytes*, `/dev/random`   |     ≡ 0.004s      | Tempo de Execução muito inferior ao da **Pergunta P1.1**.  |
| **Comando 4** - 1024 *bytes*, `/dev/unrandom` |     ≡ 0.004s      | Tempo de Execução mantém-se igual ao da **Pergunta P1.1**. |

<p>

- Ambos os comandos executam em tempos aproximadamente iguais. 
- Relativamente à **Pergunta P1.1**, nota-se uma diferença significativa em relação ao **Comando 3**. 

  - Isto deve-se ao facto de que quando o `/dev/random` é executado, passa a existir desta vez a entropia essencial/necessária para que se produzam os 1024 *bytes* pedidos. 
  - Essa entropia é então calculada pelo haveged. 

---

## Observações Finais

Add Final Observations.