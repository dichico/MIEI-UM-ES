# Pergunta 2 - Secret Sharing/Splitting

Todas as imagens consideradas relevantes para o entendimento complementar da resolução a todas as questões encontram-se listadas na secção de [**Notas/Observações Finais**](#notasobservações-finais).

1. [**Experiência 2.1**](#experiência-11---comando-openssl) - **Execução comando OpenSSL `openssl rand -base64 1024` para gerar 1024 *bytes* pseudoaleatórios.**
    - Pequeno enquadramento teórico.    
---

## Resolução da Pergunta 2

### Experiência 2.1 e 2.2 - Ficheiro *genSharedSecret.php* e *reconstroiSecret.php*

  - Se executarmos este exemplo a limpo verificamos que é necessário fornecer o **segredo** em si e o **número de entidades** a partilhar;
  - Quando são fornecidos esses dois parâmetros, é dado um código binário para cada entidade em causa.
  - Ao tentar reconstruir o segredo com o código binário dado para essa entidade verificamos a necessidade de explicitar os códigos gerados anteriormente.
  - Caso os códigos tenham sido dados corretamente, o segredo é reconstruído com sucesso.
  - No caso de aplicarmos a duas entidades (por ex.), para reconstruir o segredo não basta o código de uma delas mas sim de ambas. O que acontece é que quando é dado apenas "parte" do código, o segredo não é apresentado na sua forma natural mas sim através de caractéres estranhos aos comuns dígitos e letras.

---

### Pergunta 2.1 - 

A. O programa Python anunciado baseia-se na divisão de um determinado segredo por um determinado grupo de entidades, sendo entregue a cada uma destas uma parte de um código que é depois essencial para reconstruir o segredo em si. Este processo torna-se semelhante ao que ficou visto na **Experiência 2.1** e **2.2**, estando neste caso a lidar com um algoritmo mais complexo e moldável ao pedido via terminal, através de um conjunto de parâmetros essenciais para o *output* deste programa.

Conforme indicado no enunciado, estamos agora a lidar com uma chave privada , dado que cada parte do segredo é devolvida num objeto JWT assinado sob forma de base 64.

**Para gerarmos a chave privada podemos recorrer ao seguinte comando:**
`openssl genrsa -aes128 -out privateKey.pem 1024`

**Com a *Private Key* pronta, podemos agora executar o programa, dividindo em oito partes, um *quorom* de 5 (tal como pedido), o *uid* de 0 e a chave em causa:**
`python createSharedSecret-app.py 8 5 0 privateKey.pem`

*Note-se que para existir a construção da Private Key incial é pedido uma passphrase ao utilizador. Esta passphrase é depois usada ao executar o ficheiro Python, juntamente com o segredo que se pretende dividir.*

Em termos de algoritmo existe a recorrência à função **createSharedSecretComponents** presente no módulo *shamirscret.py* do *package* **eVotUM** usado para a [Pergunta 1](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/TP1/P1%20-%20N%C3%BAmeros%20Aleat%C3%B3rios%20e%20Pseudoaleat%C3%B3rios).

Esta função divide o segredo nas n partes pedidas em modo *array*, gerando um *hash* através da função de *hash* criptográfica SHA256 para cada uma destas mesmas partes. Com isto feito, cria-se um ficheiro jwt com *array* para a totalidade das partes, devidamente assinado pela *Private Key* usada para todo o processo.

<br/>

B. Estando o segredo criado e os códigos devidamente distribuídos para todas as partes, surgem dois ficheiros que facilitam na recuperação/reconstrução do nosso segredo inicial. Estes diferem entre si em certos detalhes e é exatamente sobre ambos que se pretende estabelecer um termo de comparação.


---

## Notas/Observações Finais

- [Imagem **Experiência 1.1**](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/TP1/P1%20-%20N%C3%BAmeros%20Aleat%C3%B3rios%20e%20Pseudoaleat%C3%B3rios/Experi%C3%AAncia%201.1.PNG) permite observar o tipo de resposta por parte do comando e os tais *bytes* pseudoaleatórios que devolve.
