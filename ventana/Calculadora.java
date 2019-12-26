package ventana;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ventana.componentes.PNumeros;

public class Calculadora {

	public PNumeros p;
	public Scene s;
	BorderPane borderPane;
	HBox hb;
	public TextField tfl;
	
	public Calculadora (Stage stage){
		
		//Se cambia el titulo del stage
		stage.setTitle("Calculadora");
		
		tfl = new TextField();
		tfl.setPrefSize(250, 154.79);
		tfl.setId("tfl");
		tfl.setEditable(false);
		tfl.setAlignment(Pos.CENTER_RIGHT);
		
		
		hb = new HBox();
		hb.setId("panel");
		HBox.setHgrow(tfl, Priority.ALWAYS);
		
		hb.getChildren().add(tfl);
		
		p = new PNumeros(stage);
		
		borderPane = new BorderPane();
		borderPane.setCenter(p);
		borderPane.setTop(tfl);
		
		s = new Scene(borderPane);
		
		s.getStylesheets().add(Calculadora.class.getResource("style.css").toExternalForm()); 
		stage.setScene(s);
		stage.setMinHeight(404.51);
		stage.setMinWidth(250);
		stage.setResizable(false);
		stage.show();
		
	}

}
