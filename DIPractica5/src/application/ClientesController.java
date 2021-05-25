package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Jardineria.ModelClass.cliente;
import Jardineria.ModelClassDao.Dao;
import Jardineria.ModelClassDao.clienteDao;


public class ClientesController implements Initializable  {
	
	
	
	
	//public static Dao<cliente> clientesDao = new clienteDao();

	CrearClientesController cliente2;

	
	@FXML
	private TableView<cliente> tablaClientes;
	@FXML
	private TableColumn<?, ?> CodigoCliente;
	
	@FXML
	private TableColumn<?, ?> NombreCliente;
	
	@FXML
	private TableColumn<?, ?> tableTelefono;
	
	@FXML
	private TableColumn<?, ?> tableDNI;
	
	
	
	private ObservableList<cliente> clientes;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		

		
		clientes = FXCollections.observableArrayList();
		
		for(int x=0; x<cliente2.clientesDao.getAll().size();x++) {
			
			//cliente cliente = clientesDao.get(x).get();
	
			cliente cliente =  cliente2.clientesDao.getAll().get(x);


			this.clientes.add(cliente);
		
	
		}
		
		

		this.CodigoCliente.setCellValueFactory((new PropertyValueFactory("codigo_cliente")));
		this.NombreCliente.setCellValueFactory((new PropertyValueFactory("nombre_cliente")));
		this.tableDNI.setCellValueFactory((new PropertyValueFactory("dni")));
		this.tableTelefono.setCellValueFactory((new PropertyValueFactory("telefono")));
		
		
		tablaClientes.setItems(clientes);

		
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


	
	
	
	
	
	
}
