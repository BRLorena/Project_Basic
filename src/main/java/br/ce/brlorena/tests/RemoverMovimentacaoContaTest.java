package br.ce.brlorena.tests;

import static br.ce.brlorena.core.Propriedades.NOME_CONTA_ALTERADA;

import org.junit.Assert;
import org.junit.Test;

import br.ce.brlorena.core.BaseTest;
import br.ce.brlorena.pages.ContasPage;
import br.ce.brlorena.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.AcessarTelaListarConta();
		
		contasPage.clicarExcluirConta(NOME_CONTA_ALTERADA);
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.getErrorMessage());
	}
}
