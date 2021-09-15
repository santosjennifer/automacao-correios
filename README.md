## Objetivo

Fazer automação do cenário de teste abaixo:

1. Entre no site dos correios;
2. Procure pelo CEP 80700000;
3. Confirmar que o CEP não existe;
4. Voltar a tela inicial;
5. Procure pelo CEP 01013-001
6. Confirmar que o resultado seja em “Rua Quinze de Novembro, São Paulo/SP”
7. Voltar a tela inicial;
8. Procurar no rastreamento de código o número “SS987654321BR”
9. Confirmar que o código não está correto;
10. Fechar o browser;

### Para criação dos testes foi utilizado o Eclipse IDE, projeto com estrutura Maven.
### Utilizado Cucumber e Selenium WebDriver com PageObjects.

## A estrutura do pacote de test é dividida em: 

* ***pageObjects***: Page Objects da página

* ***Runner***: Runner para rodar o Cucumber

* ***Steps***: passo a passo dos testes

## A estrutura do pacote de resources é dividida em: 

* ***Features***: Arquivo feature com passo a passo utilizando Cucumber.
 
## Recursos utilizados

- Java 8
- Java JDK 11
- Maven - Apache Maven 3.8.2
- Eclipse IDE - 2021-06 (4.20.0)
- Selenium - 3.141
- Cucumber - Puglin para Eclipse	v1.0.0.202107150747

**Observação:** O _ChromeDriver.exe_ disponibilizado na pasta _drivers_ é compatível com a Versão 93.0.4577.63 do navegador Chrome.
