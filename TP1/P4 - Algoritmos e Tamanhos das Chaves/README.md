# Pergunta 4 - Algoritmos e Tamanhos das Chaves

Todas as imagens consideradas relevantes para o entendimento complementar da resolução a todas as questões encontram-se listadas na secção de [**Notas/Observações Finais**](#notasobservações-finais).

1. [**Pergunta P4.1**]() - **Execução comando OpenSSL `openssl rand -base64 1024` para gerar 1024 *bytes* pseudoaleatórios.**
    - Pequeno enquadramento teórico.
    
---

## Resolução da Pergunta 4

### Pergunta P4.1 - 

Tendo em conta o site disponibilizado e o número de grupo, somos redirecionados para a página https://webgate.ec.europa.eu/tl-browser/#/tl/IT/45/.

Nesta página existem alguns separadores. Selecionando o separador "*Qualified certificate for eletronic signature*" encontram-se apenas dois certificados. Dado que se pretende considerar apenas o último certificado emitido, escolhe-se então o certificado com validade maior. Este certificado é emitido pela EC [Lottomatica Holding S.r.l.](https://webgate.ec.europa.eu/tl-browser/#/tl/IT/45) e tem de nome [C=IT, O=Lottomatica Holding S.r.l., OID.2.5.4.97=VATIT-02611940038, CN=Lottomatica EU Qualified Certificates CA](https://webgate.ec.europa.eu/tl-browser/#/tl/IT/45/2)

**Seguindo-se as instruções fornecidas na Nota 2, eis a informação dada para este Certificado:**

1. Escolha do Certificado e Criação do mesmo em modo txt.

