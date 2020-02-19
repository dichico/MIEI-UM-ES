# Trabalho Prático 1 - Aula 17/02/2020

Add Small Description.



---

## Resolução do Guião
<p>

### 1\. Números Aleatórios/Pseudoaleatórios

<p>

#### Pergunta P1.1

O comando `openssl rand -base64 1024` pedido para teste na Experiência 1.1 é claro de se compreender.

Segundo a documentação oficial do **OpenSSL**,

> The **rand** command outputs *num* pseudo-random bytes after seeding the random number generator once.

O que faz sentido, dado que o *output* produzido por este comando consiste precisamente num conjunto de 1024 *bytes* pseudoaleatórios.

<p>

**Tomando este comando como base, pretende-se agora ir mais longe, no sentido de combinar dois comandos que permitirão gerar diferentes conjuntos de *bytes* também eles pseudoaleatórios, apresentando-os sobre a forma da base64.** 

Note-se que o tempo de execução destes comandos é uma estimativa dada pelo próprio *Debian*, fazendo-se uso do comando `time`.

|               Lista de Comandos               | Tempo de Execução | Resultados/Observações |
| :-------------------------------------------: | :---------------: | :--------------------: |
|   **Comando 1** - 32 *bytes*, `/dev/random`   |     ≡ 0.004s      |                        |
|   **Comando 2** - 64 *bytes*, `/dev/random`   |     ≡ 0.012s      |                        |
|  **Comando 3** - 1024 *bytes*, `/dev/random`  |       ≡ 0.        |                        |
| **Comando 4** - 1024 *bytes*, `/dev/unrandom` |       ≡ 0.        |                        |



---

## Observações Finais

Add Final Observations.