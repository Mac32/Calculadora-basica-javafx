package main;

import controlador.Controlador;
import javafx.application.Application;
import javafx.stage.Stage;
import logica.Logica;
import ventana.Calculadora;

public class Main extends Application{
	
	public void start(Stage stage){
		Calculadora calc = new Calculadora(stage);
		Logica logica = new Logica();
		Controlador c = new Controlador(calc, logica);
		
	}
	
	public static void main(String[] args){
		launch(args);

	}

}
