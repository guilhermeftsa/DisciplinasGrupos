package br.unifor.teste.disciplinasgrupos.testsLecionador;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.unifor.teste.disciplinasgrupos.core.BaseTest;
import br.unifor.teste.disciplinasgrupos.page.AbaFrequenciaPage;
import br.unifor.teste.disciplinasgrupos.page.AbasPage;
import br.unifor.teste.disciplinasgrupos.page.DisciplinasPage;
import br.unifor.teste.disciplinasgrupos.page.LoginPage;
import br.unifor.teste.disciplinasgrupos.page.SidebarPage;



@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosTestesDisciplinasEGrupos.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class CT1011_LecionadorVerificarAbaFrequenciaSemConexao extends BaseTest {
	
	private LoginPage login = new LoginPage();
	private SidebarPage sidebar = new SidebarPage();
	private DisciplinasPage disciplinasPage = new DisciplinasPage();
	private AbasPage abas = new AbasPage();
	private AbaFrequenciaPage frequenciaAba = new AbaFrequenciaPage();

	@Test
	public void deveVerificarLecionadorAbaFrequenciaSemConexao_CT1011(@Param(name = "matricula") String matricula, 
			   														  @Param(name = "senha") String senha){
		login.fazerLogin(matricula, senha);
		esperar(2000);		
		sidebar.acessarDisciplinasEGrupos();
		esperar(4000);
		sidebar.alterarWifi();
		disciplinasPage.acessarDetalheDisciplinaUnica();
		
		abas.acessarAbaFrequencia();
		Assert.assertTrue(frequenciaAba.obterMensagemSemInternet());
		Assert.assertTrue(frequenciaAba.obterMensagemSemFrequencia());
	}
	
	@After
	public void finaliza(){
		sidebar.alterarWifi();
	}
}
