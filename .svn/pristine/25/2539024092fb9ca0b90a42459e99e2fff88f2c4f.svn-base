package br.unifor.teste.disciplinasgrupos.page;

import org.openqa.selenium.By;

public class LoginPage extends br.unifor.teste.disciplinasgrupos.core.BasePage {
	public void setMatricula(String matricula){
		escreverBy(By.xpath("//*[@text = 'Matrícula']//android.widget.EditText"), matricula);
	}
	
	public void setSenha(String senha){
		escreverBy(By.xpath("//*[@text = 'Senha']//android.widget.EditText"), senha);
	}
	
	public void clicarEntrar(){
		clicarPorTexto("ACESSAR");
	}
	
	public void fazerLogin(String matricula, String senha){
		setMatricula(matricula);
		setSenha(senha);
		clicarEntrar();
	}
}
//android.widget.EditText