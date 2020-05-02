# Pergunta 1 - *Vulnerabilidade de Inteiros*

Todas as imagens e outros ficheiros considerados relevantes para o entendimento complementar da resolução a todas as questões encontram-se listados na secção de [**Notas/Observações Finais**](#notasobservações-finais).

1. [**Pergunta P1.1**](#pergunta-p11) - ***Overflow* numa matriz em C**
   - Mudança do código C
   - Compreensão do resultado do programa

2. [**Pergunta P1.2**](#pergunta-p12) - ***Underflow* em código C**
   - Mudança do código C
   - Compreensão do resultado do programa
   - Utilização de técnicas de programação defensiva para mitigação das vulnerabilidades

---

## Resolução da Pergunta 1

### Pergunta P1.1

O problema deste código vulnerável é a utilização do `typedef size_t` sem confirmação dos tamanhos do mesmo podendo causar *underflow/overflow* dos números.

Para tentar resolver o problema podemos mudar a função `main()` para:

```C
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

void vulneravel (char *matriz, size_t x, size_t y, char valor) {
    int i, j;
    matriz = (char *) malloc(x*y);

    printf("Teste para ver se chega aqui\n");
    
    for (i = 0; i < x; i++) {
            for (j = 0; j < y; j++) {
                    matriz[i*y+j] = valor;
            }
    }
}

int main() {
    
    char *mat;
    printf("Tamanho da matriz é: %zu\n", SIZE_MAX*SIZE_MAX);
    vulneravel(mat, SIZE_MAX, SIZE_MAX, '5');
    return 0;

}
```

Utilizando a *macro* definida no *header* `<stdint.h>` intitulada de `SIZE_MAX` podemos obter o valor máximo que um `size_t` pode tomar na máquina e compilador em questão, logo quando na função `vulneravel()` acontece o `malloc` fazendo $x*y \equiv SIZE\_MAX*SIZE\_MAX$, acontece um **overflow** e o resultado fica apenas 1. De seguida, vai-se preencher a matriz com endereçamentos e posições para lá dos limites, dado que as variáveis `x` e `y` são valores enormes e dessa forma o programa sofre um *Segmentation Fault*.

![ResultadoCMD](images/1.png)

---

### Pergunta P1.2

Texto

---

## Notas/Observações Finais

