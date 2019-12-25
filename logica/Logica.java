package logica;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ventana.Calculadora;

public class Logica {

	private String operador = "";
	private double valor = 0;
	private double valor2 = 0;

	public void MarcarNumeroTeclado (KeyEvent e, Calculadora calc){
		if(valor == 0 && valor2 == 0){
			calc.tfl.appendText(e.getText());
		}else{
			calc.tfl.setText(e.getText());
		}
	}

	public void MarcarNumeroBotones(ActionEvent e, Calculadora calc, Button boton){
		if(isNumeric(boton.getText())){
			calc.tfl.appendText(boton.getText());

		}else{
			AsignarOperador(e, calc, boton);
		}
	}

	
	public void AsignarOperadorSuma (Calculadora calc){
		operador = "+";
		AsignarValores(calc);
	}
	public void AsignarOperadorResta (Calculadora calc){
		operador = "-";
		AsignarValores(calc);
	}
	
	public void AsignarOperadorMultiplicar (Calculadora calc){
		operador = "x";
		AsignarValores(calc);
	}
	
	public void AsignarOperadorDividir (Calculadora calc){
		operador = "/";
		AsignarValores(calc);
	}
	
	public void AsignarOperadorModulo (Calculadora calc){
		operador = "%";
		AsignarValores(calc);
	}
	
	
	public void Limpiar(Calculadora calc){
		operador ="";
		valor = 0;
		valor2 = 0;
		calc.tfl.setText("");
	}
	
			
	public void AsignarOperador(ActionEvent e, Calculadora calc, Button boton){

		switch (boton.getText()) {
		case "+":
			operador = "+";
			valor = Double.parseDouble(calc.tfl.getText());
			calc.tfl.setText("");	
			valor2 = 0;

			break;
		case "-":
			operador = "-";
			valor = Double.parseDouble(calc.tfl.getText());
			calc.tfl.setText("");
			valor2 = 0;
			break;
		case "x":
			operador = "x";
			valor = Double.parseDouble(calc.tfl.getText());
			calc.tfl.setText("");
			valor2 = 0;
			break;
		case "/":
			operador = "/";
			valor = Double.parseDouble(calc.tfl.getText());
			calc.tfl.setText("");
			break;
			
		case "%":
			operador = "%";
			valor = Double.parseDouble(calc.tfl.getText());
			calc.tfl.setText("");
			valor2 = 0;
			break;
		case "C" :
			operador ="";
			valor = 0;
			valor2 = 0;
			calc.tfl.setText("");
			break;
		case "=":

			procesarOperacion(calc);
			break;

		}


	}
	
	public void BorrarNumero(Calculadora calculadora){
		if(valor == 0 && valor2 == 0){
			if(calculadora.tfl.getText().length() > 0){
				calculadora.tfl.setText(calculadora.tfl.getText().substring(0,calculadora.tfl.getLength()-1));
			}
		}
	}

	public void procesarOperacion(Calculadora calc){
		
		if(operador == "+"){
			if(valor2 == 0){
				valor2 = Double.parseDouble(calc.tfl.getText());
				valor = valor + valor2;
				calc.tfl.setText(String.valueOf(valor));
			}else{
				valor = valor + valor2;
				calc.tfl.setText(String.valueOf(valor));

			}
		}else if(operador == "-"){
			if(valor2 == 0){
				valor2 = Double.parseDouble(calc.tfl.getText());
				valor = valor - valor2;
				calc.tfl.setText(String.valueOf(valor));
			}else{
				valor = valor - valor2;
				calc.tfl.setText(String.valueOf(valor));

			}
		}else if(operador == "x"){
			
			if(valor2 == 0){
				valor2 = Double.parseDouble(calc.tfl.getText());
				valor = valor * valor2;
				calc.tfl.setText(String.valueOf(valor));
			}else{
				valor = valor * valor2;
				calc.tfl.setText(String.valueOf(valor));

			}
		}else if(operador == "/"){
			if(valor2 == 0){
				valor2 = Double.parseDouble(calc.tfl.getText());
				valor = valor / valor2;
				calc.tfl.setText(String.valueOf(valor));
			}else{
				valor = valor / valor2;
				calc.tfl.setText(String.valueOf(valor));
			}
		}else if(operador == "%"){
			if(valor2 == 0){
				valor2 = Double.parseDouble(calc.tfl.getText());
				valor = valor % valor2;
				calc.tfl.setText(String.valueOf(valor));
			}else{
				valor = valor % valor2;
				calc.tfl.setText(String.valueOf(valor));
			}
			
		}
	}

	public Boolean isNumeric(String cadena){
		try {

			Integer.parseInt(cadena);
			return true;

		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	private void AsignarValores (Calculadora calc){
		try{
		valor = Double.parseDouble(calc.tfl.getText());
		calc.tfl.setText("");
		valor2 = 0;
		}catch (NumberFormatException e) {
			
		}
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor2() {
		return valor2;
	}

	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}

}
