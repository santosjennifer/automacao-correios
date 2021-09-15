Feature: Pesquisar CEP e codigo de rastreamento no site dos Correios

  Scenario: Pesquisar CEP e codigo de rastreamento no site dos Correios
    Given acessar site dos Correios
    And informar um CEP invalido
    When pesquisar o CEP
    Then validar que CEP nao existe
    And voltar tela inicial 
    Given informar um CEP valido 
    When pesquisar o CEP 
    Then confirmar que CEP eh valido
    And voltar tela inicial 
    Given informar codigo rastreamento invalido
    When pesquisar codigo rastreamento 
    Then validar codigo rastreamento invalido
    And fechar tela


