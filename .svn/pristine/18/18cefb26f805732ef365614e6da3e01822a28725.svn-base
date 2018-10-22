package br.unifor.teste.disciplinasgrupos.testsAluno;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.unifor.teste.disciplinasgrupos.page.AbaAulasPage;
import br.unifor.teste.disciplinasgrupos.page.AbasPage;
import br.unifor.teste.disciplinasgrupos.page.DisciplinasPage;
import br.unifor.teste.disciplinasgrupos.page.LoginPage;
import br.unifor.teste.disciplinasgrupos.page.SidebarPage;



@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT1000_AlunoVerificarAbaAulasComConexao extends br.unifor.teste.disciplinasgrupos.core.BaseTest {
	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	private AbasPage abas = new AbasPage();
	private AbaAulasPage aulasAba = new AbaAulasPage();

	// Automatiza o CT 1000 - Tentar acessar a aba Aulas,
	// Nos detalhes da disciplina selecionada
	@Test
	public void deveVerificarAlunoAbaAulaComConexao_CT1000(@Param(name = "matricula") String matricula,
														   @Param(name = "senha") String senha) {
		login.fazerLogin(matricula, senha);
		esperar(2000);
		sidebar.acessarDisciplinasEGrupos();
		esperar(1000);
		disciplinasPage.acessarDetalheDisciplinaUnica();
		abas.acessarAbaAulas();
		Assert.assertTrue(aulasAba.existeAulas());
	}
}
