package application;

import javafx.beans.binding.StringExpression;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalcController {
	
	public double num1;
	public double num2;
	public String operation;
	public double memory = 0;
	@FXML
	Label CurrentNumberLbl;	
	
	
	@FXML
	private void clearEntryButtonPressed() {
		clearLabel();
	}
	@FXML
	public void clearLabel() {
		CurrentNumberLbl.setText("0");
	}
	@FXML
	private void digitButtonPressed(ActionEvent event) {
		Button b = (Button) event.getSource();
		//store button value into String digit;
		String digit = b.getText();
		// if a decimal already exists do not add another decimal
		if (CurrentNumberLbl.getText().contains(".") == false || b.getText().equals(".") == false) {			
		//if label value is 0 replace with new digit
			if (CurrentNumberLbl.getText().equals("0")) {
				//and button value is decimal
				if (b.getText().equals("."))
					CurrentNumberLbl.setText("0.");
				else
				CurrentNumberLbl.setText(digit);
			}
			//concat the value of button to the label
			else {
			String newLbl = CurrentNumberLbl.getText() + digit;
			CurrentNumberLbl.setText(newLbl);
			}
		}
		
	}

	@FXML
	public void operationButtonPressed(ActionEvent event) {
		Button b = (Button) event.getSource();
		//store current label as num1
		num1 = Double.parseDouble(CurrentNumberLbl.getText());
		//clear label
		clearLabel();
		//set operation based on button value
		operation = b.getText();
		
	}
	@FXML
	private void equalsButtonPressed() {
		calculate();
	}
	@FXML
	public void calculate() {
		num2 = Double.parseDouble(CurrentNumberLbl.getText());
		double answer = num2;
		if (operation.equals("+"))
			answer = num1 + num2;
		else if (operation.equals("-"))
			answer = num1 - num2;
		else if (operation.equals("*"))
			answer = num1 * num2;
		else if (operation.equals("/"))
			answer = num1 / num2;
		num1 = answer;
		CurrentNumberLbl.setText(Double.toString(answer));
	}
	@FXML
	private void clearButtonPressed() {
		num1 = 0;
		operation = "";
		num2 = 0;
		clearLabel();
	}
	
	@FXML
	private void posNegButtonPressed() {
		double numNeg = Double.parseDouble(CurrentNumberLbl.getText());
		numNeg *= -1;
		CurrentNumberLbl.setText(Double.toString(numNeg));
	}
	
	@FXML
	private void memoryClearButtonPressed() {
		memory = 0;
		clearLabel();
	}
	
	@FXML
	private void memoryAddButtonPressed() {
		memory += Double.parseDouble(CurrentNumberLbl.getText());
		CurrentNumberLbl.setText(Double.toString(memory));
	}
	
	@FXML
	private void memoryRecallButtonPressed() {
		CurrentNumberLbl.setText(Double.toString(memory));
	}
}
