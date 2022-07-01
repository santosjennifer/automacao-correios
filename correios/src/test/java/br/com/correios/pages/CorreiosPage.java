package br.com.correios.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import org.openqa.selenium.By;

public class CorreiosPage extends DriverPage {

	private static final String URL = "https://www.correios.com.br/";

	public CorreiosPage() {
		super(null);
		this.browser.get(URL);
	}

	public void aceitarCookies() {
		this.browser.findElement(By.id("btnCookie")).click();
	}

	public void informarCEP(String CEP) {
		this.browser.findElement(By.xpath("//*[@id=\"relaxation\"]")).clear();
		this.browser.findElement(By.xpath("//*[@id=\"relaxation\"]")).sendKeys(CEP);
	}

	public void pesquisarCEP() {
		this.browser.findElement(By.xpath("	//*[@id=\"content\"]/div[2]/div/div[2]/div[2]/form/div[2]/button/i")).click();
	}

	public void navegarParaAbaProximaAba() {
		for (String winHandle : this.browser.getWindowHandles()) {
			this.browser.switchTo().window(winHandle);
		}
	}

	public String obterMensagemCEP() {
		return this.browser.findElement(By.id("mensagem-resultado")).getText();
	}

	public void voltarParaPaginaInicial() {
		this.browser.close();
		List<String> abas = new ArrayList<>(this.browser.getWindowHandles());
		this.browser.switchTo().window(abas.get(0));
	}

	public String obterEnderecoCEP() {
		return this.browser.findElement(By.cssSelector("#resultado-DNEC > tbody > tr")).getText();
	}

	public void informarCodigoRastreamento(String codigoRastreamento) {
		this.browser.findElement(By.id("objetos")).sendKeys(codigoRastreamento);
	}

	public void informarCodigoRastreamentoOutraPagina(String codigoRastreamentoOutraPagina) {
		this.browser.findElement(By.id("objeto")).sendKeys(codigoRastreamentoOutraPagina);
	}

	public void pesquisarCodigoRastreamento() {
		this.browser.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/form/div[2]/button")).click();
	}

	public void pesquisarCodigoRastreamentoOutraPagina() {
		this.browser.findElement(By.id("b-pesquisar")).click();
	}

	public String obterMensagemCodigoRastreamento() {		
		// return this.browser.findElement(By.xpath("//*[@id=\"alerta\"]/div[1]")).getText();
		return this.browser.findElement(By.xpath("/html/body/main/div[1]/form/div[2]/div[1]/div/div[4]")).getText();
	}

	public void espereCarregar() {
		this.browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
