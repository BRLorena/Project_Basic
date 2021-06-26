package br.ce.brlorena.tests;

import static br.ce.brlorena.core.Propriedades.NOME_CONTA_ALTERADA;

import org.junit.Assert;
import org.junit.Test;

import br.ce.brlorena.core.BaseTest;
import br.ce.brlorena.pages.HomePage;
import br.ce.brlorena.pages.MenuPage;

public class SaldoTest extends BaseTest {

	HomePage page = new HomePage();
	MenuPage menuPage = new MenuPage();
	
	@Test 
	public void testSaldoConta() {
		
		menuPage.acessarTelaPrincipal();
		
		Assert.assertEquals("500.00", page.obterSaldoConta(NOME_CONTA_ALTERADA));
	}
	
}
