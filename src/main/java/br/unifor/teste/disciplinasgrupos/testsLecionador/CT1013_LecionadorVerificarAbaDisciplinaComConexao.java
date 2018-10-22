package br.unifor.teste.disciplinasgrupos.testsLecionador;

import java.util.List;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.unifor.teste.disciplinasgrupos.core.BaseTest;
import br.unifor.teste.disciplinasgrupos.page.AbaDisciplinaPage;
import br.unifor.teste.disciplinasgrupos.page.DisciplinasPage;
import br.unifor.teste.disciplinasgrupos.page.LoginPage;
import br.unifor.teste.disciplinasgrupos.page.SidebarPage;
import io.appium.java_client.MobileElement;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT1013_LecionadorVerificarAbaDisciplinaComConexao extends BaseTest {
	private List<MobileElement> disciplinas;
	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	private AbaDisciplinaPage disciplinaAba = new AbaDisciplinaPage();

	@Test
	public void deveVerificarLecionadorAbaDisciplinasComConexao_CT1013(@Param(name = "matricula") String matricula, 
				 													   @Param(name = "senha") String senha) {
		login.fazerLogin(matricula, senha);
		esperar(2000);
		sidebar.acessarDisciplinasEGrupos();
		esperar(1000);
		disciplinas = disciplinasPage.obterDisciplinas();
		for (MobileElement disciplina : disciplinas) {
			esperar(4000);
			disciplinasPage.acessarDetalheTurma(disciplina);
			esperar(2000);
			Assert.assertTrue(disciplinaAba.existeCampoInfoSala());
			Assert.assertTrue(disciplinaAba.existeCampoTurma());
			Assert.assertTrue(disciplinaAba.existeCampoInfoCreditos());
			Assert.assertTrue(disciplinaAba.existeCampoInfoHorario());
			Assert.assertTrue(disciplinaAba.existeCampoInfoSala());
			Assert.assertTrue(disciplinaAba.existeCampoNomeDisciplina());
			disciplinaAba.voltarTela();
			esperar(4000);
			disciplinasPage.Scroll(0.9, 0.8);
		}
	}
}
