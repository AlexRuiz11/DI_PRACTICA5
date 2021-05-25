package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Jardineria.ModelClass.cliente;
import Jardineria.ModelClass.pedido;
import Jardineria.ModelClassDao.Dao;
import Jardineria.ModelClassDao.pedidosDao;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class PedidosController implements Initializable{
	
	
	
	
	public static Dao<pedido> pedidosDao = new pedidosDao();
	private ObservableList<pedido> pedidos;


	@FXML
	private TableView<pedido> tablaPedidos;
	@FXML
	private TableColumn<?, ?> CodigoCliente;
	
	@FXML
	private TableColumn<?, ?> 	CodigoPedido;
	
	
	@FXML
	private TableColumn<?, ?> 	tableEStado;
	
	@FXML
	private TableColumn<?, ?> 	tableComent;
	
	
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
		pedidos = FXCollections.observableArrayList();
		
		for(int x=0; x<pedidosDao.getAll().size();x++) {
			
			//cliente cliente = clientesDao.get(x).get();
	
			pedido pedido =  pedidosDao.getAll().get(x);


			this.pedidos.add(pedido);
		
	
		}
		this.CodigoCliente.setCellValueFactory((new PropertyValueFactory("codigo_pedido_cliente")));
		this.CodigoPedido.setCellValueFactory((new PropertyValueFactory("codigo_pedido")));
		this.tableEStado.setCellValueFactory((new PropertyValueFactory("estado")));
		this.tableComent.setCellValueFactory((new PropertyValueFactory("comentarios")));
		
		
		tablaPedidos.setItems(pedidos);
		
		
	}


}
