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

		if(isNumeric(e.getText())){
			calc.tfl.appendText(e.getText());
		}else if(e.getCode() == KeyCode.BACK_SPACE){
			try{
				calc.tfl.setText(calc.tfl.getText().substring(0,calc.tfl.getLength()-1));
			}catch(StringIndexOutOfBoundsException e2){

			}

		}
	}

	public void MarcarNumeroBotones(ActionEvent e, Calculadora calc, Button boton){
		if(isNumeric(boton.getText())){
			calc.tfl.appendText(boton.getText());

		}else{
			AsignarOperador(e, calc, boton);
		}
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

}
