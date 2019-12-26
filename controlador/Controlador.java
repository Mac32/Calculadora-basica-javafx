package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import logica.Logica;
import ventana.Calculadora;

public class Controlador {

	Calculadora calculadora;
	Logica logica;
	EventHandler<KeyEvent> EventosTeclado;
	EventHandler<ActionEvent> EventosBotones;

	public Controlador(Calculadora calculadora, Logica logica){

		this.logica = logica;
		this.calculadora = calculadora;

		Manejadores();
		AgregadoManejadores();
	}

	private void AgregadoManejadores() {
		calculadora.s.addEventFilter(KeyEvent.KEY_RELEASED, EventosTeclado);
		for(Button b: calculadora.p.botones){
			b.addEventHandler(ActionEvent.ACTION, EventosBotones);
		}
	}

	private void Manejadores(){

		//Eventos de teclado
		EventosTeclado = new EventHandler<KeyEvent> (){
			
			KeyCodeCombination dividir = new KeyCodeCombination(KeyCode.DIGIT7, KeyCombination.SHIFT_DOWN);
			KeyCodeCombination multiplicar = new KeyCodeCombination(KeyCode.PLUS, KeyCombination.SHIFT_DOWN);
			KeyCodeCombination modulo = new KeyCodeCombination(KeyCode.DIGIT5, KeyCombination.SHIFT_DOWN);
			
			public void handle(KeyEvent e) {
				if(e.getCode() == KeyCode.PLUS){calculadora.p.btnmas.fire();}
				
				if(e.getCode() == KeyCode.MINUS){calculadora.p.btnMenos.fire();} 
				
				if(e.getCode() == KeyCode.ENTER){logica.procesarOperacion(calculadora);}
				
				if(e.getCode() == KeyCode.BACK_SPACE){logica.BorrarNumero(calculadora);}
				
				if(e.getCode() == KeyCode.DELETE){logica.Limpiar(calculadora);}
				
				if(e.getCode() == KeyCode.PERIOD){calculadora.p.btnPunto.fire();}
				
				if(dividir.match(e)){
					calculadora.p.btnentre.fire();
				}else if(multiplicar.match(e)){
					calculadora.p.btnpor.fire();
				}else if(modulo.match(e)){
					calculadora.p.btnModulo.fire();
				}else if(logica.isNumeric(e.getText())){
					logica.MarcarNumeroTeclado(e, calculadora);
				}
				
					

			}

		};
		
		//Eventos de botones
		EventosBotones = new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e){
				logica.MarcarNumeroBotones(e, calculadora, (Button) e.getSource());
				
			}
		};
		
	}

}
