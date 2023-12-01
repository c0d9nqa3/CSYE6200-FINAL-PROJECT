package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ContractGenerator extends Application {

    private Stage primaryStage;
    private Stage previewStage;
    private TextField contractorNameTextField;
    private TextField contractNameTextField;
    private String contractorName;
    private String contractName;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Contract Generator");

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(5);
        root.setStyle("-fx-background-color: #111;");

        Label contractorNameLabel = new Label("Contractor's Name:");
        contractorNameLabel.setTextFill(Color.WHITE);
        root.getChildren().add(contractorNameLabel);

        contractorNameTextField = new TextField();
        root.getChildren().add(contractorNameTextField);
        contractorNameTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");

        Label contractNameLabel = new Label("Contract Name:");
        contractNameLabel.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel);

        contractNameTextField = new TextField();
        root.getChildren().add(contractNameTextField);
        contractNameTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        Button generatePreviewButton = new Button("Generate Preview");
        generatePreviewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                contractorName = contractorNameTextField.getText();
                contractName = contractNameTextField.getText();

                previewStage = new Stage();
                previewStage.setTitle("Contract Preview");
                previewStage.setScene(createPreviewScene());
                previewStage.show();

                previewStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        contractorNameTextField.setText(contractorName);
                        contractNameTextField.setText(contractName);
                    }
                });
            }
        });
        root.getChildren().add(generatePreviewButton);

        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Scene createPreviewScene() {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(5);
        root.setStyle("-fx-background-color: #111;");

        Label contractorNameLabel = new Label("Contractor's Name:");
        contractorNameLabel.setTextFill(Color.WHITE);
        root.getChildren().add(contractorNameLabel);

        Label contractorNameValueLabel = new Label(contractorName);
        root.getChildren().add(contractorNameValueLabel);

        Label contractNameLabel = new Label("Contract Name:");
        contractNameLabel.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel);

        Label contractNameValueLabel = new Label(contractName);
        root.getChildren().add(contractNameValueLabel);

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                previewStage.close();
            }
        });
        root.getChildren().add(cancelButton);

        Button generateAndSaveButton = new Button("Generate and Save");
        generateAndSaveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Implement the logic to generate and save the contract
                previewStage.close();
            }
        });
        root.getChildren().add(generateAndSaveButton);

        return new Scene(root, 600, 500);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
