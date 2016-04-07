package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class MainController implements Initializable {

	@FXML
	private TextArea inputText;
	@FXML
	private TextField shift;
	@FXML
	private TextArea vinInputText;
	@FXML
	private TextField vKey;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void caeserEncrypt(ActionEvent event){
	    encrypt(true);
	}
	
	public void caeserDecrypt(ActionEvent event){		
	    encrypt(false);
		
	}
	
    public void vigenereEncrypt(ActionEvent event){
	    vinEncrypt(true);
	}
	
	public void vigenereDecrypt(ActionEvent event){	
	    vinEncrypt(false);
	}
	
	private void encrypt(Boolean isEncrypt){
		
		String shiftText = shift.getText();
		if(!allDigits()) {
			 Alerts.shiftAlert();
			 return;
        }
		int shift = Integer.parseInt(shiftText); 
		if(shift<1 || shift>26){
			 Alerts.shiftAlert();
			 return;
		}
		
	    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String result = "";
		String text = inputText.getText().toUpperCase();
		
		if(!isEncrypt){
		     alpha = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
		}
		  for (int i=0; i<text.length(); i++) {
		        int pos = alpha.indexOf(text.charAt(i));
		        int newPos = (pos + shift) % alpha.length();

		        if (pos == -1) {
		            result += text.charAt(i);
		        } else {
		            result += alpha.charAt(newPos);
		        }
		    }
        
		inputText.setText(result);	
	}
	
	private void vinEncrypt(Boolean isEncrypt){
	
		String key = vKey.getText().toUpperCase();
		if(!allLetters() || key.length()>=10) {
			 Alerts.keyAlert();
			 return;
       }
		
	    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String result = "";
		String text = vinInputText.getText().toUpperCase();
		String keyAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		if(!isEncrypt){
		    alpha = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
		}
		
		 for (int i=0; i<text.length(); i++) {
		        int pos = alpha.indexOf(text.charAt(i));
		        int newPos = (pos + keyAlpha.indexOf(key.charAt(i % key.length()))) % alpha.length();

		        if (pos == -1) {
		            result += text.charAt(i);
		        } else {
		            result += alpha.charAt(newPos);
		        }
		    }
		vinInputText.setText(result);	
	}
	
	private boolean allDigits(){
		String shiftText = shift.getText();
		for(int i=0; i<shiftText.length(); i++){
			if(Character.isDigit(shiftText.charAt(i))==false){
				return false;
			}
		}
		return true;
	}
	
	private boolean allLetters(){
		String key = vKey.getText();
		for(int i=0; i<key.length(); i++){
			if(Character.isLetter(key.charAt(i))==false){
				return false;
			}
		}
		return true;
	}
}
