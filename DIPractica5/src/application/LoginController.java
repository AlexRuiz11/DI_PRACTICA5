package application;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginController  implements Initializable {
	
	
	
	@FXML
	private TextField textUser;
	
	@FXML
	private TextField textPassword;
	
	@FXML
	private PasswordField PasswordOculto;
	
	
	@FXML
	private CheckBox CheckPassword;
	
	@FXML
	private Hyperlink hyperlink;
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		this.togglevisiblePassword(null);
		
	}
	@FXML
	public void VerificarLogin(ActionEvent event) throws IOException {
		
		
		if(textUser.getText().equals("admin") &&  textPassword.getText().equals("admin")||(textUser.getText().equals("admin") &&  PasswordOculto.getText().equals("admin"))) {
			
			System.out.println("Login correcto");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/Main.fxml"));
			
			Parent root = loader.load();
			
			
			MainController controller = loader.getController();
			
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			stage.setScene(scene);
			
			stage.show();
			
			
			stage.setOnCloseRequest(e -> {
				try {
					
					

					 Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "¿De verdad quieres cerrar esta aplicación?", ButtonType.YES, ButtonType.NO);
					    ButtonType result = alert.showAndWait().orElse(ButtonType.YES);
					    
					    if (ButtonType.NO.equals(result)) {
						      // no choice or no clicked -> don't close
						    	e.consume();
						    }else {
						    	 Platform.exit();
						         System.exit(0);
								controller.CloseWindows();

						    	
						    }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
				
					
			
			
			Stage myStage = (Stage) this.textPassword.getScene().getWindow();
					
			
			myStage.close();
		
		}
		

	 
	

	}
	
	@FXML
	public void togglevisiblePassword(ActionEvent event) {
	    if (CheckPassword.isSelected()) {
	    	textPassword.setText(PasswordOculto.getText());
	        textPassword.setVisible(true);
	        PasswordOculto.setVisible(false);
	        return;
	    }
	    PasswordOculto.setText(textPassword.getText());
	    PasswordOculto.setVisible(true);
	    textPassword.setVisible(false);
	}
	
	
	
	public void recuperarPassword(ActionEvent event) {
	   
		System.out.println("Heyyyy");
		Stage stage = new Stage();
		
		WebView web = new WebView();
    	web.getEngine().load("http://www.google.com/");
    	Scene scene = new Scene(web);
    	stage.setScene(scene);
    	stage.show();
		
	}
	
	

}
