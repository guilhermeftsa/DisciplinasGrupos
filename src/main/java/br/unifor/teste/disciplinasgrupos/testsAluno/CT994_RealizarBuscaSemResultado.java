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
import br.unifor.teste.disciplinasgrupos.page.LoginPage;
import br.unifor.teste.disciplinasgrupos.page.SidebarPage;



@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT994_RealizarBuscaSemResultado extends BaseTest {

	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinas = new DisciplinasPage();
	
	@Test
	public void deveRealizarBuscaSemResultado_CT994(@Param(name = "matricula") String matricula, 
													@Param(name = "senha") String senha){
		login.fazerLogin(matricula, senha);
		esperar(1000);		
		sidebar.acessarDisciplinasEGrupos();
		disciplinas.realizarBuscaDisciplinas("tkrqkoqrikfdkaflh");
		Assert.assertTrue(disciplinas.checarBuscaVazia());
	}
}
