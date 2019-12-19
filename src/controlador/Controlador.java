package controlador;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import logica.Logica;
import ventana.Calculadora;

public class Controlador {

	Calculadora calculadora;
	Logica logica;

	public Controlador(Calculadora calculadora, Logica logica){

		this.logica = logica;
		this.calculadora = calculadora;

		eventosCalculadora();

	}


	private void eventosCalculadora (){


		calculadora.tfl.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {logica.MarcarNumeroTeclado(event, calculadora);}

		});



		calculadora.tfl.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {

			}


		});
		
		for(Button b: calculadora.p.botones){
			b.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					logica.MarcarNumeroBotones(arg0, calculadora, b);
					
				}
			});
		}

	}
}
