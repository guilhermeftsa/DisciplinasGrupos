package br.unifor.teste.disciplinasgrupos.page;


public class GruposDetalhesPage extends br.unifor.teste.disciplinasgrupos.core.BasePage {
	
	public boolean existeCampoNomeGrupo(){
		return existeElementoPorId("br.unifor.mobile:id/info_name_user_or_class");
	}
	
//	public boolean existeCampoNomeResponsavel(){
//	
//	}
	
	public void acessarAbaAulas(){
		clicarPorTexto("AULAS");
	}
}
