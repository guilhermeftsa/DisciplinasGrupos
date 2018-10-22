package br.unifor.teste.disciplinasgrupos.page;

import static br.unifor.teste.disciplinasgrupos.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class AbaDisciplinaPage extends br.unifor.teste.disciplinasgrupos.core.BasePage {

	public boolean existeCampoProfessor(){
		boolean retorno = false;
		retorno = existeElementoPorId("br.unifor.mobile:id/info_name_user_or_class");
		return retorno;
	}
	
	public boolean existeCampoTurma(){
		return existeElementoPorId("br.unifor.mobile:id/info_name_user_or_class");
	}
	
	public boolean existeCampoNomeDisciplina(){
		boolean retorno = false;
		MobileElement elemento = getDriver().findElement(By.className("android.widget.TextView"));	
		System.out.println(elemento.getText());
		if(elemento != null){
			retorno = true;
		}
		return retorno;
//		MobileElement elemento = DriverFactory.getDriver().findElement(By.className("android.widget.TextView"));
//		System.out.println(elemento.getText());	
	}
	
	public boolean existeCampoInfoSala(){
		return existeElementoPorId("br.unifor.mobile:id/info_sala");
	}
	
	public boolean existeCampoInfoCodigo(){
		return existeElementoPorId("br.unifor.mobile:id/info_codigo");
	}
	
	public boolean existeCampoInfoCreditos(){
		return existeElementoPorId("br.unifor.mobile:id/info_codigo");
	}
	
	public boolean existeCampoInfoHorario(){
		return existeElementoPorId("br.unifor.mobile:id/info_horario");
	}
	
	public boolean existeCampoNota1(){
		return existeElementoPorId("br.unifor.mobile:id/av1");
	}
	
	public boolean existeCampoNota2(){
		return existeElementoPorId("br.unifor.mobile:id/av2");
	}
	
	public boolean existeCampoNota3(){
		return existeElementoPorId("br.unifor.mobile:id/av3");
	}
	
	public boolean existeCampoFrequencia(){
		return existeElementoPorId("br.unifor.mobile:id/presenca");
	}
	
	public boolean existeCampoFaltas(){
		return existeElementoPorId("br.unifor.mobile:id/faltas");
	}
	
	
	
}
