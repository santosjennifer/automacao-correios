Feature: Pesquisar CEP e codigo de rastreamento no site dos Correios

  Scenario: Pesquisar CEP invalido no site dos Correios
    Given no site Correios informar CEP invalido
    When pesquisar o CEP
    Then validar que CEP nao existe
    
  Scenario: Pesquisar CEP valido no site dos Correios
    Given no site Correios informar CEP valido
    When pesquisar o CEP 
    Then confirmar que CEP eh valido
    
  Scenario: Pesquisar codigo rastreamento invalido no site dos Correios
    Given no site Correios informar codigo rastreamento invalido
    When pesquisar codigo rastreamento 
    Then validar codigo rastreamento invalido