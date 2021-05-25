package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Jardineria.ModelClass.cliente;
import Jardineria.PatronBuilder.BuilderCliente;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificarClientesController implements Initializable {

	
	CrearClientesController cliente2;
	


	
	
	
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

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText("El codigo del cliente no puede ser nulo.El resto de campos nulos se tendran en cuenta como que no se quieren cambiar.");

		alert.showAndWait();
		
	
	}
	
	
	
	
	
	public void Modificar() {
		

		
		String password;
		String email;
		String dni;
		String codigo_empleado_rep_ventas;
		double limite_credit;
		int telefono;
		String domicilio;
		String nombre_cliente ;
		
	
		
		
		int i = Integer.parseInt(CodigoCliente.getText());
		
		if(i<=0 || i>cliente2.clientesDao.getAll().size()) {
			
			System.out.println("No hay ningun  cliente con ese codigo");

			
		}else {
			
			for(int x=0; x<cliente2.clientesDao.getAll().size();x++) {			
				
				
				if(i== cliente2.clientesDao.getAll().get(x).getCodigo_cliente()) {
					int codigo_cliente = Integer.parseInt(CodigoCliente.getText())-1;
					
					
					 nombre_cliente = NombreCliente.getText();
					if(nombre_cliente=="") {
						
						nombre_cliente =cliente2.clientesDao.getAll().get(codigo_cliente).getNombre_cliente();

					}else {
						cliente2.clientesDao.getAll().get(codigo_cliente).setNombre_cliente(nombre_cliente);
						
					}
					
					 domicilio = Domicilio.getText();
					if(domicilio=="") {
						domicilio=cliente2.clientesDao.getAll().get(codigo_cliente).getDomicilio();

						
					}else {
						cliente2.clientesDao.getAll().get(codigo_cliente).setDomicilio(domicilio);

						
					}

					 String numCadena=Telefono.getText();

					if(numCadena=="") {
						telefono=cliente2.clientesDao.getAll().get(codigo_cliente).getTelefono();

					}else {
						
						 telefono = Integer.parseInt(Telefono.getText());


						
					}
					
					 String numCadena2;
					 numCadena2 = LimiteCredito.getText().replace(",", ".");
					
					if(numCadena2=="") {

						limite_credit = cliente2.clientesDao.getAll().get(codigo_cliente).getLimite_credit();

					}else {
						 limite_credit = Double.parseDouble(LimiteCredito.getText().replace(",", "."));


						
					}
					 codigo_empleado_rep_ventas = CodigoEmpleado.getText();
						

					if(codigo_empleado_rep_ventas=="") {
						
						codigo_empleado_rep_ventas =cliente2.clientesDao.getAll().get(codigo_cliente).getCodigo_empleado_rep_ventas();


					}else {
						
						cliente2.clientesDao.getAll().get(codigo_cliente).setCodigo_empleado_rep_ventas(codigo_empleado_rep_ventas);

					}

					
					 dni = DNI.getText();
					if(dni=="") {
						dni= cliente2.clientesDao.getAll().get(codigo_cliente).getDni();

					}else {
						
						cliente2.clientesDao.getAll().get(codigo_cliente).setDni(dni);

						
					}

					 email = Email.getText();
					if(email=="") {
						
						email= cliente2.clientesDao.getAll().get(codigo_cliente).getEmail();

					}else{
						
						cliente2.clientesDao.getAll().get(codigo_cliente).setEmail(email);

					}

					 password = Password.getText();
					if(password=="") {
						password= cliente2.clientesDao.getAll().get(codigo_cliente).getPassword();

					}else {
						
						cliente2.clientesDao.getAll().get(codigo_cliente).setPassword(password);

						
					}
					
				
					
					System.out.println("Cliente encontrado y modificado");
					cliente cliente =new BuilderCliente(codigo_cliente, nombre_cliente, domicilio, telefono,
					limite_credit, codigo_empleado_rep_ventas, dni, email, password).Buildeo();
				}
			 
		
			}
			
			
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
