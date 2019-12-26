package logica;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import ventana.Calculadora;

public class Logica {

	private String operador = "";
	private double valor = 0;
	private double valor2 = 0;

	public void MarcarNumeroTeclado (KeyEvent e, Calculadora calc){
		if(valor2 == 0){
			calc.tfl.appendText(e.getText());
		}else{
			calc.tfl.setText(e.getText());
		}
	}

	public void MarcarNumeroBotones(ActionEvent e, Calculadora calc, Button boton){

		if(isNumeric(boton.getText())){
			if(valor2 == 0 ){
				calc.tfl.appendText(boton.getText());
			}else{
				calc.tfl.setText(boton.getText());
			}

		}else{
			AsignarOperador(e, calc, boton);

		}
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
			AsignarValores(calc);
			break;
		case "-":
			operador = "-";
			AsignarValores(calc);
			break;
		case "x":
			operador = "x";
			AsignarValores(calc);
			break;
		case "/":
			operador = "/";
			AsignarValores(calc);
			break;

		case "%":
			operador = "%";
			AsignarValores(calc);
			break;
		case "C" :
			operador ="";
			valor = 0;
			valor2 = 0;
			calc.tfl.setText("");
			break;

		case "+/-":
			calc.tfl.setText(String.valueOf(Double.parseDouble(calc.tfl.getText()) * -1));
			break;
		case "=":

			procesarOperacion(calc);
			break;

		}
	}

	public void BorrarNumero(Calculadora calculadora){
		if(valor2 == 0){
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
				calc.tfl.setText(LimpiarDecimales(String.valueOf(valor)));
			}else{
				valor = valor + valor2;
				calc.tfl.setText(LimpiarDecimales(String.valueOf(valor)));

			}
		}else if(operador == "-"){
			if(valor2 == 0){
				valor2 = Double.parseDouble(calc.tfl.getText());
				valor = valor - valor2;
				calc.tfl.setText(LimpiarDecimales(String.valueOf(valor)));
			}else{
				valor = valor - valor2;
				calc.tfl.setText(LimpiarDecimales(String.valueOf(valor)));

			}
		}else if(operador == "x"){

			if(valor2 == 0){
				valor2 = Double.parseDouble(calc.tfl.getText());
				valor = valor * valor2;
				calc.tfl.setText(LimpiarDecimales(String.valueOf(valor)));
			}else{
				valor = valor * valor2;
				calc.tfl.setText(LimpiarDecimales(String.valueOf(valor)));

			}
		}else if(operador == "/"){
			if(valor2 == 0){
				valor2 = Double.parseDouble(calc.tfl.getText());
				valor = valor / valor2;
				calc.tfl.setText(LimpiarDecimales(String.valueOf(valor)));
			}else{
				valor = valor / valor2;
				calc.tfl.setText(LimpiarDecimales(String.valueOf(valor)));
			}
		}else if(operador == "%"){
			if(valor2 == 0){
				valor2 = Double.parseDouble(calc.tfl.getText());
				valor = valor % valor2;
				calc.tfl.setText(LimpiarDecimales(String.valueOf(valor)));
			}else{
				valor = valor % valor2;
				calc.tfl.setText(LimpiarDecimales(String.valueOf(valor)));
			}
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

	private String LimpiarDecimales (String cadena){
		if(cadena.indexOf(".0") == 1){
			return cadena.replace(".0", "");
		}else{
			return cadena;
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
