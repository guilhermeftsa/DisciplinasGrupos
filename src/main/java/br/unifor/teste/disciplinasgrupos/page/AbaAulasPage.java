package br.unifor.teste.disciplinasgrupos.page;

import org.openqa.selenium.By;

public class AbaAulasPage extends br.unifor.teste.disciplinasgrupos.core.BasePage {

	public boolean existeMensagemErroAulas(){
		return existeElementoPorTexto("Sem conexão com a internet");
	}
	
	public boolean existeBotaoTenteNovamente(){
		return existeElementoPorTexto("TENTAR NOVAMENTE");
	}
	
	public boolean existeAulas(){
		return existeElementoBy(By.className("android.webkit.WebView"));
	}
	
	public boolean isAbaSemAulas(){
		SwipeLeft();
		return existeElementoPorTexto("N�o existe aula publicada");
	}
}
