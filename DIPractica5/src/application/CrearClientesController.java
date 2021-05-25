package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Jardineria.ModelClass.cliente;
import Jardineria.ModelClassDao.Dao;
import Jardineria.ModelClassDao.clienteDao;
import Jardineria.PatronBuilder.BuilderCliente;
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

public class CrearClientesController implements Initializable {

	public static Dao<cliente> clientesDao = new clienteDao();
	 
	
	@FXML
	private TextField CodigoCliente;
	
	@FXML
	private TextField NombreCliente;
	
	@FXML
	private TextField Domicilio;
	
	@FXML
	private TextField Telefono;
	
	@FXML
	private TextField LimiteCredito;
	
	@FXML
	private TextField CodigoEmpleado;
	
	@FXML
	private TextField DNI;
	
	@FXML
	private TextField Email;
	
	@FXML
	private TextField Password;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
	
	public void crear() {
		
		int codigo_cliente = Integer.parseInt(CodigoCliente.getText());
		String nombre_cliente = NombreCliente.getText();
		String domicilio = Domicilio.getText();
		int telefono = Integer.parseInt(Telefono.getText());

		double limite_credit = Double.parseDouble(LimiteCredito.getText().replace(",", "."));

		String codigo_empleado_rep_ventas = CodigoEmpleado.getText();
		String dni = DNI.getText();
		String email = Email.getText();
		String password = Password.getText();

		try {
			clientesDao.save(new BuilderCliente(codigo_cliente, nombre_cliente, domicilio, telefono,
					limite_credit, codigo_empleado_rep_ventas, dni, email, password).Buildeo());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
	
		
		
	}
	
public void vaciar() {
	

	CodigoEmpleado.setText("");
	LimiteCredito.setText("");
	Password.setText("");
	Telefono.setText("");
	DNI.setText("");
	Email.setText("");
	Domicilio.setText("");
	NombreCliente.setText("");
	CodigoCliente.setText("");
	
	}
		
	


}
