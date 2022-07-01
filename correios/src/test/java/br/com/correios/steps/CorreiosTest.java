package br.com.correios.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import br.com.correios.pages.CorreiosPage;

public class CorreiosTest {

	private CorreiosPage pesquisar;

	@Given("no site Correios informar CEP invalido")
	public void no_site_correios_informar_cep_invalido() {
		this.pesquisar = new CorreiosPage();
		pesquisar.aceitarCookies();
		pesquisar.informarCEP("80700000");
	}

	@When("pesquisar o CEP")
	public void pesquisar_o_cep() {
		pesquisar.scrollPage();
		pesquisar.pesquisarCEP();
	}

	@Then("validar que CEP nao existe")
	public void validar_que_cep_nao_existe() throws InterruptedException {
		pesquisar.navegarParaAbaProximaAba();
		pesquisar.espereCarregar();
		Assert.assertEquals("Não há dados a serem exibidos", pesquisar.obterMensagemCEP());

		pesquisar.voltarParaPaginaInicial();
		pesquisar.closeBrowser();
	}

	@Given("no site Correios informar CEP valido")
	public void no_site_correios_informar_cep_valido() {
		this.pesquisar = new CorreiosPage();
		pesquisar.aceitarCookies();
		pesquisar.informarCEP("01013001");
	}

	@Then("confirmar que CEP eh valido")
	public void confirmar_que_cep_eh_valido() {
		pesquisar.navegarParaAbaProximaAba();
		pesquisar.espereCarregar();
		Assert.assertTrue(pesquisar.obterEnderecoCEP().contains("Rua Quinze de Novembro"));
		Assert.assertTrue(pesquisar.obterEnderecoCEP().contains("São Paulo/SP"));

		pesquisar.voltarParaPaginaInicial();
		pesquisar.closeBrowser();
	}

	@Given("no site Correios informar codigo rastreamento invalido")
	public void no_site_correios_informar_codigo_rastreamento_invalido() {
		this.pesquisar = new CorreiosPage();
		pesquisar.aceitarCookies();
		pesquisar.informarCodigoRastreamento("8888888888888888888");
	}

	@When("pesquisar codigo rastreamento")
	public void pesquisar_codigo_rastreamento() {
		pesquisar.pesquisarCodigoRastreamento();
	}

	@Then("validar codigo rastreamento invalido")
	public void validar_codigo_rastreamento_invalido() {
		pesquisar.navegarParaAbaProximaAba();
		pesquisar.espereCarregar();
		pesquisar.informarCodigoRastreamentoOutraPagina("G");
		pesquisar.pesquisarCodigoRastreamentoOutraPagina();

		Assert.assertEquals("Código de objeto, CPF ou CNPJ informado não está válido",
				pesquisar.obterMensagemCodigoRastreamento());

		pesquisar.closeBrowser();
	}

}
