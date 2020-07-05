# *Command Line Program* para teste das Operações do Serviço de Assinatura com Chave Móvel Digital

A aplicação Comando Linha (CLI) surge no sentido de permitir efetuar todos os testes das várias operações do serviço nacional SCMD (*Signature* CMD). Esta aplicação foi inicialmente desenvolvida na linguagem Pyhton, sendo este repositório reservado à sua implementação na linguagem Java, através de *Reverse Engineer* da aplicação original [CMD-SOAP](https://github.com/devisefutures/CMD-SOAP).

# Implementação do Programa e Respetivos Ficheiros

O programa encontra-se então implementado na linguagem Java, tendo-se feito uso do ***Software Project Management* Maven** que se baseia num  *Project Object Model (POM)* sob a forma de xml, onde se encontram listadas todas as dependências internas ao programa desenvolvido. 
Este ficheiro xml permite uma flexibilidade em termos de atualização das versões das várias bibliotecas e possíveis adições futuras, sendo apenas necessário fazer um *build* inicial para que as mesmas sejam automaticamente instaladas/integradas no projeto.

**Assim, esta diretoria encontra-se organizada da seguinte forma:**

- :open_file_folder: **Diretoria [src](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main)** que contém a diretoria **[java](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/java)** que possui 
  - :open_file_folder: **Diretoria [java](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/java)**
    - :file_folder: Diretoria [code](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/code)
      - :page_facing_up: Ficheiro [CmdConfig.java](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/code/CmdConfig.java)
      - :page_facing_up: Ficheiro [CmdSoapMsg.java](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/code/CmdSoapMsg.java)
      - :page_facing_up: Ficheiro [TestCmdWsdl.java](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/code/TestCmdWsdl.java) 
    - :file_folder: Diretoria [wsdlservice](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/java/wsdlservice)
  - :open_file_folder: Diretoria [resources](https://github.com/uminho-miei-engseg-19-20/Grupo5/tree/master/Projetos/Projeto%203/CMD-SOAP/src/main/resources)
- :bookmark_tabs: Ficheiro [pom.xml](https://github.com/uminho-miei-engseg-19-20/Grupo5/blob/master/Projetos/Projeto%203/CMD-SOAP/pom.xml)

**Para demonstrar todo o processo da utilização da aplicação, desde a parte inicial de *build* até à parte do *compile* do ficheiro Java com a *main*, recorre-se ao *Code Editor* IntelliJ IDEA**.

# Utilização da Aplicação de Testes

## Exemplo da utilização Comando GetAll

# Notas
