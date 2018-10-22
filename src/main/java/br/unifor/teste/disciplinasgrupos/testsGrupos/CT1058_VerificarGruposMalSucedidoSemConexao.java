package br.unifor.teste.disciplinasgrupos.testsGrupos;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.unifor.teste.disciplinasgrupos.core.BaseTest;
import br.unifor.teste.disciplinasgrupos.page.DisciplinasPage;
import br.unifor.teste.disciplinasgrupos.page.GruposPage;
import br.unifor.teste.disciplinasgrupos.page.LoginPage;
import br.unifor.teste.disciplinasgrupos.page.SidebarPage;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT1058_VerificarGruposMalSucedidoSemConexao extends BaseTest {

	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	private GruposPage grupos = new GruposPage();
	
	@Test
	public void deveVerificarGruposMalSucedidoSemConexao_CT1058(@Param(name = "matricula") String matricula,
																@Param(name = "senha") String senha){		
		login.fazerLogin(matricula, senha);
		esperar(1000);		
		sidebar.acessarDisciplinasAlterandoWifi();
		disciplinasPage.acessarGrupos();
		
		Assert.assertTrue(grupos.obterMensagemSemInternet());
		Assert.assertTrue(grupos.obterMensagemSemGrupos());
	}
	
	@After
	public void finalizar(){
		sidebar.alterarWifi();
	}
}
