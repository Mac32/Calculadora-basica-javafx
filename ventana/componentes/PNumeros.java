package ventana.componentes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class PNumeros extends GridPane{

	public Button btnBorrar = new Button("C"),
				  btnParentesis = new Button("()"),
				  btnModulo = new Button("%"),
				  btnentre= new Button("/"),
				  btnpor = new Button("x"),
				  btnMenos = new Button("-"),
				  btnmas = new Button("+"),
				  btnMasMenos = new Button("+/-"),
				  btnPunto = new Button("."),
				  btnigual = new Button("="),
	
				  btn1 = new Button("1"),
				  btn2 = new Button("2"),
				  btn3 = new Button("3"),
				  btn4 = new Button("4"),
				  btn5 = new Button("5"),
				  btn6 = new Button("6"),
				  btn7 = new Button("7"),
				  btn8 = new Button("8"),
				  btn9 = new Button("9"),
				  btn0 = new Button("0");
	
	public Button[] botones = {btnBorrar, btnParentesis, btnModulo, btnentre, btn1, btn2, btn3, btnpor, btn4, btn5, btn6, btnMenos, btn7, btn8, btn9, btnmas, btnMasMenos, btn0, btnPunto, btnigual};
	
	public PNumeros(Stage stage){
		
		add(btnBorrar, 0,0);
		add(btnParentesis, 1,0);
		add(btnModulo, 2,0);
		add(btnentre, 3,0);
		add(btn1, 0,1);
		add(btn2, 1,1);
		add(btn3, 2,1);
		add(btnpor, 3,1);
		add(btn4, 0,2);
		add(btn5, 1,2);
		add(btn6, 2,2);
		add(btnMenos, 3,2);
		add(btn7, 0,3);
		add(btn8, 1,3);
		add(btn9, 2,3);
		add(btnmas, 3,3);
		add(btnMasMenos, 0,4);
		add(btn0, 1,4);
		add(btnPunto, 2,4);
		add(btnigual, 3,4);
		
		setId("panel");
		
		for(Button b: botones){
			b.setFocusTraversable(false);
			
			//enlace al tamaño de ventana para redimencional los elementos
			b.prefHeightProperty().bind(stage.heightProperty());
			b.prefWidthProperty().bind(stage.widthProperty());
			
			try{
				
				Integer.parseInt(b.getText());
				 b.setId("numero");
				
			}catch(NumberFormatException e){
				b.setId("operacion");
			}
			
			
		}
		
		
		setAlignment(Pos.CENTER);
		setHgap(3);
		setVgap(3);
//		setHgrow(Priority.ALWAYS);
		setPadding(new Insets(5, 5, 5, 5));
		
		
	}

}
