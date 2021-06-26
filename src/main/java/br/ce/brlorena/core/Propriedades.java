package br.ce.brlorena.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = false;
		
	public static Browsers browser = Browsers.CHROME;
	
	//Define que a conta criada ao final tera um tempo diferente da nova conta criada
	public static String NOME_CONTA_ALTERADA = "Conta Alterada" + System.nanoTime(); 
	
	//Definir quais browser desejamos exec.
	public enum Browsers {
		CHROME,
		FIREFOX
	}
}
