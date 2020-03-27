# Pergunta 1 - RGPD (Regulamento Geral de Proteção de Dados)

Todas as imagens e outros ficheiros considerados relevantes para o entendimento complementar da resolução a todas as questões encontram-se listados na secção de [**Notas/Observações Finais**](#notasobservações-finais).

1. [**Experiência 1.1**](#) - **Regulamento (UE) 2016/679 (RGPD)**
    - Análise do Artigo 32.º - Segurança do tratamento
    - Escrita de pequeno texto que reflete a forma como este artigo pode influir no desenvolvimento de *software*
2. [**Pergunta P1.1**](#) - ***Recommendations on shaping technology according to GDPR provisions - Exploring the notion of data protection by default***
	- Análise da Secção 3 - *Data protection by default in practice*
	- Pequeno resumo da mesma
3. [**Experiência 1.3**](#) - ***Guidelines on Data Protection Impact Assessment (DPIA) and determining whether processing is “likely to result in a high risk” for the purposes of Regulation 2016/679***
	- Nove critérios a ser considerados na avaliação do risco do processamento de dados pessoais
	- Projeto hipotético que envolva a utilização de dados pessoais
	  - Explicação do projeto
	  - Processamento dos dados pessoais
	  - Critérios que satisfaz
	  - Template DPIA
4. [**Experiência 1.4**](#) - **Ferramenta usada para o *Data Protection Impact Assessment* (DPIA)**
	- Utilização da ferramenta no projeto hipotético pensado anteriormente
5. [**Pergunta P1.2**](#) - ***Handbook on Security of Personal Data Processing***
    - Análise do caso de uso *Marketing/advertising*
    - Passos metodológicos seguidos até à avaliação do risco
    - Medidas propostas para diminuir/mitigar determinados riscos

---

## Resolução da Pergunta 1

### Experiência 1.1 - Regulamento (UE) 2016/679 (RGPD)

O artigo escolhido para esta pequena análise foi o Artigo 32.º, cujo tema assenta sobre a **Segurança do tratamento**. De modo a compreender melhor toda esta secção e aproveitando já para contextualizar com o tema primordial em si, atentente-se no significado do RGPD.

> *The **General Data Protection Regulation** (EU) [2016/679](https://eur-lex.europa.eu/eli/reg/2016/679/oj) (**GDPR**) is a [regulation](https://en.wikipedia.org/wiki/Regulation_(European_Union)) in [EU law](https://en.wikipedia.org/wiki/EU_law) on [data protection](https://en.wikipedia.org/wiki/Data_protection) and privacy in the [European Union](https://en.wikipedia.org/wiki/European_Union) (EU) and the [European Economic Area](https://en.wikipedia.org/wiki/European_Economic_Area) (EEA). It also addresses the transfer of [personal data](https://en.wikipedia.org/wiki/Personal_data) outside the EU and EEA areas. The GDPR aims primarily to give control to individuals over their personal data and to simplify the regulatory environment for [international business](https://en.wikipedia.org/wiki/International_business) by unifying the regulation within the EU.*

Assim se entende que este regulamento visa proteger os dados pessoais dentro da comunidade europeia, surgindo assim como objetivo de garantir uma segurança mais eficaz aos cidadãos em si.

<br/>

**Atente-se nas seguintes considerações iniciais que são importantes ter em conta para a reflexão que vai ser feita para este artigo:**

- **Consideração N.º 74** 

  > Deverá ser consagrada a responsabilidade do responsável por qualquer tratamento de dados pessoais realizado por este ou por sua conta. Em especial, o responsável deverá ficar obrigado a executar as medidas que forem adequadas e eficazes (...)

  Isto significa que o responsável pelos dados está responsável por executar as medidas de segurança que forem necessárias.

- **Consideração N.º 75**

  >O risco para os direitos e liberdades das pessoas singulares, cuja probabilidade e gravidade podem ser variáveis, poderá resultar de operações de tratamento de dados pessoais suscetíveis de causar danos físicos, materiais ou imateriais (...)

  Fala-se do risco que surge no uso dos dados pessoais de indivíduos, que variam consoante determinados fatores.

- **Consideração N.º 76**

  > A probabilidade e a gravidade dos riscos para os direitos e liberades do titular dos dados deverá ser determinada por referência à natureza, âmbito, contexto e finalidades do tratamento de dados.

  Fala-se da avaliação da gravidade e probabilidade dos riscos para os direitos do titular de dados, referindo-se que devem ser determinadas através de um conjunto de parâmetros de modo a se concluir o nível de segurança das operações a ter no tratamento dos dados.

<br/>

Estas considerações inicias trazem noções necessárias para este Artigo N.º 32. O mesmo começa por deixar claro que devido à globalização e consequente evolução tecnológica por parte das diversas técnicas acaba por ser preciso estabelecer um controlo mais pesado em relação à natureza dos dados pessoais, o seu armanezamento, tratamento e respetivo acesso.

**Assim, define as medidas técnicas e organizativas adequadas para assegurar um nível de segurança apropriado ao risco:**

- Pseudonimização e cifragem dos dados pessoais;
- Capacidade de assegurar a confidencialidade, integridade, disponibilidade e resiliência dos sistemas e serviços de tratamento;
- Capacidade de restabelecer a disponbilidade e o acesso aos dados pessoais atempadamente, caso existam incidentes físicos ou até mesmo técnicos;
- Existência de um processo para testar, apreciar e consequentemente avaliar regularmente a eficácia das medidas técnicas e organizativas de modo a garantir a segurança do tratamento.

<br/>Se pensarmos nestas medidas em termos práticos e tentarmos "encaixá-las" no processo de desenvolvimento dum *software* entendemos ainda mais a sua importância e de que forma podem atuar/influenciar de forma positiva nestes tipos de desenvolvimentos, e vice-versa. A tabela abaixo permite obter uma noção basilar acerca destas duas relações.



| RGPD -> Software                                             | Software -> RGPD                                             |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| A ideia é que se tenha uma atenção reforçada ao nível dos dados pessoais ao longo de todo o processo de desenvolvimento de *software*. <br />Isso deve ser feito usando-se técnicas que garantam a segurança dos dados, ao mesmo tempo que se avaliam essas mesmas técnicas, deixando assim clara a certeza de que o sistema está integrado num plano de técnicas perfeitamente seguras. | O *software* pode ajudar a estabelecer um encontro entre o RGPD, ao mesmo tempo que traz benefícios para o negócio. Através do *software* podemos realizar um conjunto de processos obrigatórios ao regulamento, evitando intervenções manuais com custos superiores.<br />Dessa forma, simplifica na execução de determinadas medidas que são impostas, como o acesso aos dados, o seu rastreamento e ainda as suas respetivas limitações. |

---

### Pergunta 1.1 - *Recommendations on shaping technology according to GDPR provisions - Exploring the notion of data protection by default*

Perante os critérios de escolha defenidos para os vários grupos, cabe-nos analisar a Secção 3 do documentos em causa, de seu título *Data protection by default in practice*.

Esta secção apresenta como objetivo a apresentação de apresentar práticas recomendadas para definir estes dos padrões existentes para a proteção de dados. Deixa-se claro que estes exemplos visam apenas demonstrar como a proteção de dados por padrão pode ser aplicada em termos práticos e quais os desafios inerentes a esta implementação.

<br/>

**Atente-se nestes critérios detalhados nas tabelas criadas para o efeito:** 



- **Critério N.º 1: *Minimum amount of personal data***, Quantidade mínima de dados pessoais

| Prática                                                      | Descrição da Prática                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| "***The less data, the better***", Quanto menos data, melhor. | Recolher apenas os dados que sejam considerados estritamente necessários. <br />**Exemplo:** Formulários online. Neste caso pode-se minimizar a quantidade de dados pessoais que são recolhidos do utilizador. |
| "***Granular collection of data on the basis of necessity***", Coleta granular dos dados baseada na necessidade. | Garantir que a recolha de dados seja feita de forma granular. Isto significa que se deve evitar a recolha de dados de uma vez só. A ideia é ir recolhendo os dados consoante a necessidade gradual dos serviços prestados.<br />**Exemplo:** Pagamentos online antecipados. Neste caso não há a necessidade de pedir ao utilizador uma quantidade de dados tão grande à partida. |
| "***Use of privacy enhancing technologies***", Uso de tecnologias que melhorem a privacidade. | Fala-se do uso de técnicas criptográficas, de pseudonimização ou anonimização perante cada caso, no sentido de melhorar a segurança e a privacidade dos dados.<br />**Exemplo:** Gerir maiores de idade para compras de bebidas alcoólicas. Em vez de se retirar o ano de nascimento, implementar um mecanismo/técnica que verifica se a condição de "maior de idade" é cumprida. Assim, em vez de retirarmos a data de nascimento, retiramos o resultado dessa verificação. |
| "***Different minimum per purpose***", Diferentes mínimos para cada propósito. | Definir o minímo de dados perante cada situação.<br />**Exemplo:** O acesso ao microfone não deve ser obrigatório em todo o tipo de aplicações. |



---

### Experiência 1.3 - *Guidelines on Data Protection Impact Assessment (DPIA) and determining whether processing is “likely to result in a high risk” for the purposes of Regulation 2016/679*

Texto.

---

### Experiência 1.4 - Ferramenta usada para o *Data Protection Impact Assessment* (DPIA)

Texto.

---

### Pergunta P1.2 - *Handbook on Security of Personal Data Processing*

Texto.

---

## Notas/Observações Finais