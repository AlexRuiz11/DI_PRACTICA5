package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Jardineria.ModelClass.cliente;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BorrarClientesController  implements Initializable{

	
	CrearClientesController cliente2;
	
	
	
	@FXML
	private TextField CodigoCliente;
	
	
	
	 
	
	public void CloseWindows() throws IOException {

		
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
		

		// Stage myStage = (Stage) this.textPassword.getScene().getWindow();

		// myStage.close();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void borrar() {
	int i = Integer.parseInt(CodigoCliente.getText());
	int contrador=0;
		
	for(int x=0; x<cliente2.clientesDao.getAll().size();x++) {			
			//cliente cliente = clientesDao.get(x).get();
	
			


			if(i== cliente2.clientesDao.getAll().get(x).getCodigo_cliente()) {
				
				System.out.println("Cliente encontrado y borrado");
				cliente2.clientesDao.delete(cliente2.clientesDao.getAll().get(x));
				contrador++;
			}
		 
	
		}
	if(contrador==0) {
		System.out.println("No hay ningun  cliente con ese codigo");
	}
	
	
	
	}
}
