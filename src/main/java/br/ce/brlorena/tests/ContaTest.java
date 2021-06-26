package br.ce.brlorena.tests;

import static br.ce.brlorena.core.Propriedades.NOME_CONTA_ALTERADA;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.brlorena.core.BaseTest;
import br.ce.brlorena.pages.ContasPage;
import br.ce.brlorena.pages.MenuPage;


// Definir a ordem de forma alfabetica
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1_InserirConta() {
		menuPage.AcessarTelaInserirConta();
		
		contasPage.setNome("Conta do Teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.getSucessMessage());
	}
	
	@Test
	public void test2_AlterarConta() {
		menuPage.AcessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do Teste");
		contasPage.setNome(NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.getSucessMessage());
		
	}
	
	@Test
	public void test3_InserirContaMesmoNome() {
		menuPage.AcessarTelaInserirConta();
		
		contasPage.setNome(NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.getErrorMessage());
	}
	
}
