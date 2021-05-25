package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Jardineria.ModelClass.cliente;
import Jardineria.ModelClassDao.Dao;
import Jardineria.ModelClassDao.clienteDao;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainController implements Initializable {
	


	@FXML
	private MenuItem ModificarCliente;

	@FXML
	private MenuItem CrearClientes;

	@FXML
	private MenuItem BorrarClientes;

	@FXML
	private Button BotonClientes;

	@FXML
	private Button BotonPedidos;

	
	
	public void CloseWindows() throws IOException {

		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/Login.fxml"));

		Parent root = loader.load();

		LoginController controller = loader.getController();

		Scene scene = new Scene(root);
		Stage stage = new Stage();
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
		
		

		// Stage myStage = (Stage) this.textPassword.getScene().getWindow();

		// myStage.close();
		
		
		

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	

	}

	public void Modificar() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/ModificarClientes.fxml"));

		Parent root = loader.load();

		ModificarClientesController controller = loader.getController();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		stage.setScene(scene);
		stage.show();

		stage.setOnCloseRequest(e -> {
			try {
				controller.CloseWindows();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
			
		
		Stage myStage = (Stage) this.BotonClientes.getScene().getWindow();

		myStage.close();

	}

	public void crear() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/CrearClientes.fxml"));

		Parent root = loader.load();

		CrearClientesController controller = loader.getController();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
		
		
		stage.setOnCloseRequest(e -> {
			try {
				controller.CloseWindows();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		Stage myStage = (Stage) this.BotonClientes.getScene().getWindow();

		myStage.close();

	}

	public void borrar() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/BorrarClientes.fxml"));

		Parent root = loader.load();

		BorrarClientesController controller = loader.getController();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
		
		
		stage.setOnCloseRequest(e -> {
			try {
				controller.CloseWindows();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		Stage myStage = (Stage) this.BotonClientes.getScene().getWindow();

		myStage.close();

	}
	
	public void Clientes() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/Clientes.fxml"));

		Parent root = loader.load();

		ClientesController controller = loader.getController();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
		
		
	
		stage.setOnCloseRequest(e -> {
			try {
				controller.CloseWindows();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		

		Stage myStage = (Stage) this.BotonClientes.getScene().getWindow();

		myStage.close();

	}
	
	public void Pedidos() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/Pedidos.fxml"));

		Parent root = loader.load();

		PedidosController controller = loader.getController();

		Scene scene = new Scene(root);
		Stage stage = new Stage();

		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
		
		
	
		stage.setOnCloseRequest(e -> {
			try {
				controller.CloseWindows();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		

		Stage myStage = (Stage) this.BotonClientes.getScene().getWindow();

		myStage.close();

	}

}
