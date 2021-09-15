package br.com.correios.steps;

import br.com.correios.pageObjects.CorreiosPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class CorreiosTest {

	private CorreiosPage pesquisar;

	@Given("acessar site dos Correios")
	public void acessar_site_dos_correios() {
		this.pesquisar = new CorreiosPage();
		pesquisar.aceitarCookies();
	}

	@Given("informar um CEP invalido")
	public void informar_um_cep_invalido() {
		pesquisar.informarCEP("80700000");
	}

	@When("pesquisar o CEP")
	public void pesquisar_o_cep() {
		pesquisar.pesquisarCEP();
	}

	@Then("validar que CEP nao existe")
	public void validar_que_cep_nao_existe() throws InterruptedException {
		pesquisar.navegarParaAbaProximaAba();
		pesquisar.espereCarregarCampo();
		Assert.assertEquals("Não há dados a serem exibidos", pesquisar.obterMensagemCEP());
	}

	@Then("voltar tela inicial")
	public void voltar_tela_inicial() {
		pesquisar.voltarParaPaginaInicial();
	}

	@Given("informar um CEP valido")
	public void informar_um_cep_valido() {
		pesquisar.informarCEP("01013-001");
	}

	@Then("confirmar que CEP eh valido")
	public void confirmar_que_cep_eh_valido() throws InterruptedException {
		pesquisar.navegarParaAbaProximaAba();
		pesquisar.espereCarregarCampo();
		Assert.assertTrue(pesquisar.obterEnderecoCEP().contains("Rua Quinze de Novembro"));
		Assert.assertTrue(pesquisar.obterEnderecoCEP().contains("São Paulo/SP"));

		// Validar apenas o logradouro
		// Assert.assertEquals("Rua Quinze de Novembro - lado ímpar", pesquisar.obterEnderecoCEP());
	}

	@Given("informar codigo rastreamento invalido")
	public void informar_codigo_rastreamento_invalido() {
		pesquisar.informarCodigoRastreamento("SS987654321BR");
	}

	@When("pesquisar codigo rastreamento")
	public void pesquisar_codigo_rastreamento() {
		pesquisar.pesquisarCodigoRastreamento();
	}

	@Then("validar codigo rastreamento invalido")
	public void validar_codigo_rastreamento_invalido() throws InterruptedException {
		pesquisar.navegarParaAbaProximaAba();
		pesquisar.espereCarregarMensagem();
		Assert.assertEquals("Objeto não encontrado na base de dados dos Correios.",
				pesquisar.obterMensagemCodigoRastreamento());
	}

	@Then("fechar tela")
	public void fechar_tela() {
		pesquisar.fecharNavegador();
	}

}
