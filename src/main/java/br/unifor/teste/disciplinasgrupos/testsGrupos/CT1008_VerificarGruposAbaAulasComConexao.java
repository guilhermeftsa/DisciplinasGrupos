package br.unifor.teste.disciplinasgrupos.testsGrupos;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.unifor.teste.disciplinasgrupos.core.BaseTest;
import br.unifor.teste.disciplinasgrupos.page.AbaAulasPage;
import br.unifor.teste.disciplinasgrupos.page.DisciplinasPage;
import br.unifor.teste.disciplinasgrupos.page.GruposDetalhesPage;
import br.unifor.teste.disciplinasgrupos.page.GruposPage;
import br.unifor.teste.disciplinasgrupos.page.LoginPage;
import br.unifor.teste.disciplinasgrupos.page.SidebarPage;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT1008_VerificarGruposAbaAulasComConexao extends BaseTest {

	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	private GruposPage grupos = new GruposPage();
	private GruposDetalhesPage GruposDetalhes = new GruposDetalhesPage();
	private AbaAulasPage aulasAba = new AbaAulasPage();
	
	@Test
	public void deveVerificarGrupoAbaAulasComConexao_CT1008(@Param(name = "matricula") String matricula,
															@Param(name = "senha") String senha){
		login.fazerLogin(matricula, senha);
		esperar(2000);		
		sidebar.acessarDisciplinasEGrupos();
		esperar(1000);
		disciplinasPage.acessarGrupos();
		grupos.acessarDetalheGrupoUnico();
		
		GruposDetalhes.acessarAbaAulas();
		Assert.assertTrue(aulasAba.existeAulas());
	}
}
