package br.unifor.teste.disciplinasgrupos.page;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public class SidebarPage extends br.unifor.teste.disciplinasgrupos.core.BasePage {
		
	public void abrirMenu(){
		clicar(MobileBy.AccessibilityId("Abrir menu"));
	}
	
	public void acessarDisciplinasAlterandoWifi(){
		abrirMenu();
		alterarWifi();
		clicarPorTexto("Disciplinas e Grupos");
	}
	
	public void acessarDisciplinasEGrupos(){
		abrirMenu();		
		clicarPorTexto("Disciplinas e Grupos");
	}
	
	public void acessarPerfil(){
		clicar(By.id("br.unifor.mobile:id/profile_container"));
	}
}
