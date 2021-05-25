module DIPractica5 {
	requires javafx.controls;
	requires java.sql;
	requires junit;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.web;
	requires javafx.base;
	 

	
	opens application to javafx.graphics, javafx.fxml;
	opens Jardineria.ModelClass to javafx.base;

}
