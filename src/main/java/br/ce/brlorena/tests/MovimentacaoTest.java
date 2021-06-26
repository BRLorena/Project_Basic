package br.ce.brlorena.tests;

import static br.ce.brlorena.core.Propriedades.NOME_CONTA_ALTERADA;
import static br.ce.brlorena.utils.DataUtils.obterDateFormated;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.brlorena.core.BaseTest;
import br.ce.brlorena.pages.MenuPage;
import br.ce.brlorena.pages.MovimentacaoPage;
import br.ce.brlorena.utils.DataUtils;


//Definir a ordem de forma alfabetica
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest{

	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.AcessarTelaLInserirMovimentacao();
		
		movPage.setDataMovimentacao(obterDateFormated(new Date()));
		movPage.setDataPagamento(obterDateFormated(new Date()));
		movPage.setDescricao("Movimenta�ao do teste");
		movPage.setInteressado("Everybody");
		movPage.setValor("500");
		movPage.setConta(NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.getSucessMessage());
	}
	
	@Test
	public void test2_CamposObrigatorios() {
		menuPage.AcessarTelaLInserirMovimentacao();
		
		movPage.salvar();
		List<String> erros = movPage.obtainError();
	//	Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0)); //Busca erro pelo index, muito fraco
	//	Assert.assertFalse(erros.contains("Data da Movimenta��o � obrigat�rio")); // Busca o erro que contem o valor x.
		
		//Pega uma cole��o de textos e verifica se est�o na lista de erros   
		Assert.assertFalse(erros.containsAll(Arrays.asList( 
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Interessado � obrigat�rio",
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero"))); 
		Assert.assertEquals(1, erros.size()); //Check se vieram os erros
	}
	
	@Test
	public void test3_MovimentacaoFutura() {
		
		menuPage.AcessarTelaLInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDateWithDifferentDays(5);
		
		movPage.setDataMovimentacao(obterDateFormated(dataFutura));
		movPage.setDataPagamento(obterDateFormated(dataFutura));
		movPage.setDescricao("Movimenta�ao do teste");
		movPage.setInteressado("Everybody");
		movPage.setValor("500");
		movPage.setConta(NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		
		
		List<String> erros = movPage.obtainError();
		Assert.assertFalse(
				erros.contains("Data de Movimenta��o deve ser menor ou igual � data atual")); 
		Assert.assertEquals(1, erros.size());
	}
	
}
