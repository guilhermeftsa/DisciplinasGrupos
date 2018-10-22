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
public class CT1056_VerificarDisciplinasSemConexao extends BaseTest {
	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	
	// Automatiza o CT 990 - Tentar acessar a aba de disciplinas sem internet
	// e sem dados salvos no banco local
	
	@Test
	public void deveVerificarDisciplinasSemConexao_CT1056(@Param(name = "matricula") String matricula,
														  @Param(name = "senha") String senha) {	
		login.fazerLogin(matricula, senha);
		esperar(1000);
		sidebar.acessarDisciplinasAlterandoWifi();
		
		Assert.assertTrue(disciplinasPage.obterMensagemSemInternet());
		Assert.assertTrue(disciplinasPage.verificarSemDisciplina());
		sidebar.alterarWifi();
	}
	
}
