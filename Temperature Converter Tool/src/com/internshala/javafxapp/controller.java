package com.internshala.javafxapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class controller implements Initializable{

	@FXML
	public Label welcomeLabel;
    @FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField userInput;

	@FXML
	public Button convertButton;

	private static final String C_To_F = "Celsius To Fahrenheit";
	private static final String F_To_C = "Fahrenheit To Celsius";

	private boolean isC_To_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(C_To_F);
		choiceBox.getItems().add(F_To_C);

		choiceBox.setValue(C_To_F);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

			if (newValue.equals(C_To_F)) {// If user has selected "Celsius to Fahrenheit"
				isC_To_F = true;
			}else{           //If user has selected "Fahrenheit to Celsius"
				isC_To_F = false;
			}

		});

		convertButton.setOnAction(event -> {
			convert();
		});

	}

	private void convert() {
		String input = userInput.getText(); // 23.4  ==> "23.4"

		float enteredTemperature = 0.0f;
		try {
			enteredTemperature = Float.parseFloat(input);
		} catch (Exception exception) {
			warnUser();
			return;
			// no code executed...
		}

		float newTemperature = 0.0f;
		if (isC_To_F) {
			newTemperature = (enteredTemperature * 9 / 5) + 32;
		}else {
			newTemperature = (enteredTemperature - 32) * 5 / 9;
		}

		display(newTemperature);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter a valid temperature");
		alert.show();
	}

	private void display(float newTemperature) {

		String unit = isC_To_F? " F" : " C";

		System.out.println("The new temperature is: " + newTemperature + unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temperature is: " + newTemperature + unit);
		alert.show();
	}
}
