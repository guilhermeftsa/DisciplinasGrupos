package br.unifor.teste.disciplinasgrupos.testsAluno;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.unifor.teste.disciplinasgrupos.core.BaseTest;
import br.unifor.teste.disciplinasgrupos.page.DisciplinasPage;
import br.unifor.teste.disciplinasgrupos.page.GruposPage;
import br.unifor.teste.disciplinasgrupos.page.LoginPage;
import br.unifor.teste.disciplinasgrupos.page.SidebarPage;
import io.appium.java_client.MobileElement;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT993_RealizarBuscaComResultado_Grupos extends BaseTest {	
	String nomeBuscado;
	private MobileElement elemento;
	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinas = new DisciplinasPage();
	private GruposPage grupos = new GruposPage();
	
	@Test
	public void deveRealizarBuscaComResultado_Grupos_CT993(@Param(name = "matricula") String matricula, 
			 											   @Param(name = "senha") String senha){		
		login.fazerLogin(matricula, senha);
		esperar(1000);		
		sidebar.acessarDisciplinasEGrupos();
		disciplinas.acessarGrupos();
		elemento = grupos.obterUmGrupo();
		nomeBuscado = elemento.getText();
		grupos.realizarBuscaGrupos(nomeBuscado.substring(0, nomeBuscado.length()/2));
		Assert.assertTrue(disciplinas.checarBuscaComResultado(nomeBuscado));
	}
}
