package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Login";
	static final String DATABASE_USERNAME = "root";
	static final String DATABASE_PASSWORD = "GerJun7/5";
	
	@FXML
	private TextField id;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button button;
	
	// use initialize with FXML annotation to use the nodes defined inside of the fxml file,\
	// if use the constructor of controller, it will not take the reference from fxml.
	
	@FXML
	private void initialize() {
		initBtnAction();
	}
	
	
	
	
	private void initBtnAction() {
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					//getting connection to database
					Connection myConn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
					
					//2. get a statement 
					Statement myStmt = myConn.createStatement();
					
					//3. Execute SQL query
					String sql = "insert into UserLogin "+"(ID, Password) "+" values ('"+
					id.getText()+"', '"+password.getText()+"')";
					
					myStmt.executeUpdate(sql);
					
					//close the window
					Stage stage = (Stage) button.getScene().getWindow();
					stage.close();
					
					
					
					System.out.println("Insertion Complete");
					
					}catch(Exception e) {
						e.printStackTrace();
					}
			}
		});
	}

	

}
