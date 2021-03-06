## Automação de testes no site dos Correios. Pesquisa de CEP e Código de rastreamento.

***Para criação dos testes foi utilizado o Eclipse IDE, projeto com estrutura Maven***

***Utilizado Java, Cucumber e Selenium WebDriver.***

## A estrutura do pacote de test é dividida em: 

* ***Page***: Page objects das páginas

* ***Runner***: Runner para rodar o Cucumber

* ***Steps***: Passos dos testes

## A estrutura do pacote de resources é dividida em: 

* ***Features***: Arquivo feature com os cenários de testes utilizando Cucumber.
 
## Tecnologia

- Java 8
- Java JDK 11
- Maven - Apache Maven 3.8.2
- Eclipse IDE - 2021-06 (4.20.0)
- Selenium - 3.141
- Cucumber - Puglin para Eclipse	v1.0.0.202107150747

**Observação:** O _ChromeDriver.exe_ disponibilizado na pasta _drivers_ é compatível com a Versão 103.0.5060.53 do navegador Chrome.

## Executando os Testes

Para executar todos os testes rode o comando ```mvn test```
