package br.ce.brlorena.suites;

import static br.ce.brlorena.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.brlorena.pages.LoginPage;
import br.ce.brlorena.tests.ContaTest;
import br.ce.brlorena.tests.MovimentacaoTest;
import br.ce.brlorena.tests.RemoverMovimentacaoContaTest;
import br.ce.brlorena.tests.ResumoTest;
import br.ce.brlorena.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})

public class SuiteGeral {

	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void initialize() {
		
		page.acessarTelaInicial();
		page.setEmail("traderlorena25@gmail.com");
		page.setPassword("99531865");
		page.entrar();
		
	}
	
	@AfterClass
	public static void finaliza() {
		killDriver();
	}
}
