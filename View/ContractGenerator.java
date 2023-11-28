package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;


public class ContractGenerator extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Contract Generator");
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		grid.setStyle("-fx-background-color: #333333;");
		
		Label partyALabel= new Label("Party A Name:");
		partyALabel.setTextFill(Color.WHITE);
		grid.add(partyALabel, 0, 0);
		
		TextField partyANameField = new TextField();
		grid.add(partyANameField, 1, 0);
		
		Label partyBLabel = new Label("Party B Name:");
		partyBLabel.setTextFill(Color.WHITE);
		grid.add(partyBLabel, 0, 1);
		
		TextField partyBNameField = new TextField();
		grid.add(partyBNameField, 1, 1);
		
		Label contractAmountLabel = new Label("Contract Amount:");
		contractAmountLabel.setTextFill(Color.WHITE);
		grid.add(contractAmountLabel, 0, 2);
		
		TextField contractAmountField = new TextField();
		grid.add(contractAmountField, 1, 2);
		
		Label contractTermLabel = new Label("Contract Terms:");
		contractTermLabel.setTextFill(Color.WHITE);
		grid.add(contractTermLabel, 0, 3);
		
		TextField contractTermsArea = new TextField();
		grid.add(contractTermsArea, 1, 3);
		
		CheckBox partyASignCheckbox = new CheckBox("Party A Sign");
		partyASignCheckbox.setTextFill(Color.WHITE);
		grid.add(partyASignCheckbox, 0, 4);
		CheckBox partyBSignCheckbox = new CheckBox("Party B Sign");
		partyBSignCheckbox.setTextFill(Color.WHITE);
		grid.add(partyBSignCheckbox, 1, 4);
		
		Button generateButton = new Button("Generate Contract");
		grid.add(generateButton, 1, 5);
		
		TextArea generatedContractArea = new TextArea();
		grid.add(generatedContractArea,0, 6, 2, 1);
		
		generateButton.setOnAction(event -> {
			String partyAName = partyANameField.getText();
			String partyBName = partyBNameField.getText();
			String contractAmount = contractAmountField.getText();
			String contractTerms = contractTermsArea.getText();
			
			String partyASignature = partyASignCheckbox.isSelected()? "\n\nParty A Signature:_________" : "";
			String partyBSignature = partyBSignCheckbox.isSelected()? "\nParty B Signature: _________" : "";
			
			String contractTemplate = String.format(
					"Contract\n\nParty A: %s\nParty B: %s\nAmount: %s\nTerms:\n%s%s%s", partyAName, partyBName, contractAmount, contractTerms, partyASignature, partyBSignature);
			
			generatedContractArea.setText(contractTemplate);
			});
		
		Scene scene = new Scene(grid, 600, 500);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}
