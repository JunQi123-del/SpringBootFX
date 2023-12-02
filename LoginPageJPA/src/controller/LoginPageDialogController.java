package controller;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.LoginModel;

public class LoginPageDialogController {
	
	@FXML
	private TextField id;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button button;
	
	@FXML
	private void initialize() {
		initButton();
	}
	
	private void initButton() {
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("Login");
				EntityManager entityManager = factory.createEntityManager();
			
				LoginModel login = new LoginModel();
				login.setLoginID(id.getText());
				login.setPassword(password.getText());
				
				entityManager.getTransaction().begin();
				entityManager.persist(login);
				entityManager.getTransaction().commit();

				
				entityManager.close();


				factory.close();
				
				Stage stage = (Stage) button.getScene().getWindow();
				stage.close();
				
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
