package controller;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.LoginModel;

public class LoginPageDialogController {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Login");
	EntityManager entityManager = factory.createEntityManager();
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField password;
	
	@FXML
	private Button button;
	
	@FXML
	private Label toSignUp;
	
	@FXML
	private void initialize() {
		initValue();
		initButton();
		initListener();
	}
	
	private void initListener() {
//		button.addEventHandler(MouseEvent.MOUSE_CLICKED, null);
		id.textProperty().addListener(textChangeListener());
	}
	
	private ChangeListener<String> textChangeListener(){
		return new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println("The string size is: "+newValue.length());
			}
		};
	}
	
	private EventHandler<ActionEvent> mouseClickEventHandler(){
		return new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	
	private void initValue() {
		
		LoginModel login = entityManager.find(LoginModel.class, "Hellos");
//		id.setText(login.getLoginID());
//		password.setText(login.getPassword());
		
	}
	
	private void initButton() {
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
			
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
