package main;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {

	public static void shiftAlert(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText("Shift can only contain numbers between 1 & 26!");
		alert.showAndWait();
	}
	
	public static void keyAlert(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText("Key can only contain letters! (Max length 10)");
		alert.showAndWait();
	}
	
}
