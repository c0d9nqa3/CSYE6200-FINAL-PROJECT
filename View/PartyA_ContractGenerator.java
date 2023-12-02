package View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pdfOperates.PDFGenerate;
public class PartyA_ContractGenerator extends Application {

    private Stage primaryStage;
    private Stage previewStage;
    private TextField effectivedateTextField;
    private TextField PAnameTextField;
    private TextField PBTextField;
    private TextField constuctionAddTextField;
    private TextField serviceTextField;
    private TextField ddlTextField;
    private TextField invoicefTextField;
    private TextField totalamountTextField;
    private TextField nameofContractorTextField;
    private TextField nameofClientTextField;
    private TextField contractnameTextField;
    //private TextField contractnameTextField;
    private TextField signatureTextField;
    
    private String contractorName;
    private String contractName;
    private BorderPane borderPane;
    private DatePicker effectiveDatePicker;
    Spinner<Integer> invoicefSpinner = new Spinner<>();
    
    
    @Override
    public void start(Stage primaryStage) {
    	this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Contract Generator");
    	borderPane = new BorderPane();

        // Left sidebar with buttons
        VBox leftSidebar = createLeftSidebar();

        // Top bar
        HBox topBar = createTopBar();

        // Set initial view, for example, the home page
        borderPane.setCenter(createContractGenerate());

        borderPane.setTop(topBar);
        borderPane.setLeft(leftSidebar);

        Scene scene = new Scene(borderPane, 1280, 780);
        
        // Set the background color
        scene.getRoot().setStyle("-fx-background-color: #333333;");
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private VBox createLeftSidebar() {
        VBox leftSidebar = new VBox(10);
        leftSidebar.setPadding(new Insets(10));
        leftSidebar.setStyle("-fx-background-color: #2A5058; -fx-border-color: black; -fx-border-width: 1;");
        leftSidebar.setPrefWidth(200); // Left side bar width

        // Button style
        String buttonStyle = "-fx-border-color: white; -fx-border-width: 1; -fx-border-insets: 5; "
                + "-fx-border-style: solid; -fx-background-color: #2A5058; -fx-text-fill: white;";

        Button btnHome = createStyledButton("Home", buttonStyle);
        //btnHome.setOnAction(e -> borderPane.setCenter(createHomePage()));
        
        Button btnContracts = createStyledButton("Contracts", buttonStyle);
        Button btnProfile = createStyledButton("Profile", buttonStyle);
        //btnProfile.setOnAction(e -> borderPane.setCenter(createProfilePage()));

        Button btnMessage = createStyledButton("Message", buttonStyle);
        //btnMessage.setOnAction(e -> borderPane.setCenter(createMessagePage()));

        Button btnChangePassword = createStyledButton("Change Password", buttonStyle);
        //btnChangePassword.setOnAction(e -> borderPane.setCenter(createChangePasswordPage()));

        leftSidebar.getChildren().addAll(btnHome, btnContracts,btnProfile, btnMessage, btnChangePassword);
        return leftSidebar;
    }

    private HBox createTopBar() {
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(20, 12, 20, 12));
        topBar.setStyle("-fx-background-color: #336699;");
        Text projectNameTopBar = new Text("ACE Project");
        projectNameTopBar.setFont(new Font("Arial", 24));
        projectNameTopBar.setFill(javafx.scene.paint.Color.WHITE);
        topBar.getChildren().add(projectNameTopBar);
        topBar.setAlignment(Pos.CENTER_LEFT);
        return topBar;
    }

    private Button createStyledButton(String text, String style) {
        Button button = new Button(text);
        button.setStyle(style);
        button.setPrefWidth(Double.MAX_VALUE);
        button.setOnMouseEntered(e -> button.setStyle(style + "; -fx-background-color: #3A7078;"));
        button.setOnMouseExited(e -> button.setStyle(style));
        button.setOnMousePressed(e -> button.setStyle(style + "; -fx-background-color: #1A3038;"));
        button.setOnMouseReleased(e -> button.setStyle(style + "; -fx-background-color: #3A7078;"));
        return button;
    }
    
    
    private VBox createContractGenerate() {
    	VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(5);
        root.setStyle("-fx-background-color: #111;");

        Label contractorNameLabel = new Label("Effective Date:");
        contractorNameLabel.setTextFill(Color.WHITE);
        root.getChildren().add(contractorNameLabel);
        
        effectiveDatePicker = new DatePicker();
      
        effectiveDatePicker.setValue(LocalDate.now());
        root.getChildren().add(effectiveDatePicker);
        effectiveDatePicker.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");

        Label contractNameLabel = new Label("PartyA Company Name:");
        contractNameLabel.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel);

        PAnameTextField = new TextField();
        root.getChildren().add(PAnameTextField);
        PAnameTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        Label contractNameLabel0 = new Label("PartyB Company Name:");
        contractNameLabel0.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel0);

        PBTextField = new TextField();
        root.getChildren().add(PBTextField);
        PBTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        Label contractNameLabel1 = new Label("Constuction Address:");
        contractNameLabel1.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel1);

        constuctionAddTextField = new TextField();
        root.getChildren().add(constuctionAddTextField);
        constuctionAddTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        Label contractNameLabel2 = new Label("Services:");
        contractNameLabel2.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel2);

        serviceTextField = new TextField();
        root.getChildren().add(serviceTextField);
        serviceTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        Label contractNameLabel3 = new Label("Deadline:");
        contractNameLabel3.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel3);

        ddlTextField = new TextField();
        root.getChildren().add(ddlTextField);
        ddlTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        Label contractNameLabel4 = new Label("Invoice Provide frequency(week):");
        contractNameLabel4.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel4);

        invoicefSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE));
        root.getChildren().add(invoicefSpinner);
        //invoicefTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        
        
        Label contractNameLabel5 = new Label("Total amount:");
        contractNameLabel5.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel5);

        totalamountTextField = new TextField();
        root.getChildren().add(totalamountTextField);
        totalamountTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        Label contractNameLabel6 = new Label("Name of contractor:");
        contractNameLabel6.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel6);

        nameofContractorTextField = new TextField();
        root.getChildren().add(nameofContractorTextField);
        nameofContractorTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        Label contractNameLabel7 = new Label("Name of CLinets:");
        contractNameLabel7.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel7);

        nameofClientTextField = new TextField();
        root.getChildren().add(nameofClientTextField);
        nameofClientTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        Label contractNameLabel8 = new Label("Contract name:");
        contractNameLabel8.setTextFill(Color.WHITE);
        root.getChildren().add(contractNameLabel8);

        contractnameTextField = new TextField();
        root.getChildren().add(contractnameTextField);
        contractnameTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        Label contractNameLabel9 = new Label("Signature:");
        contractNameLabel9.setTextFill(Color.RED);
        root.getChildren().add(contractNameLabel9);

        signatureTextField = new TextField();
        root.getChildren().add(signatureTextField);
        signatureTextField.setStyle("-fx-text-fill: #fff; -fx-background-color: #444;");
        
        
        Button generatePreviewButton = new Button("Generate Preview");
        root.getChildren().add(generatePreviewButton);
        generatePreviewButton.setOnAction(e->{
        	String effectiveDate = effectiveDatePicker.getValue().toString();
            String paName = PAnameTextField.getText();
            String pbName = PBTextField.getText();
            String constructionAddress = constuctionAddTextField.getText();
            String services = serviceTextField.getText();
            String deadline = ddlTextField.getText();
            String invoiceFrequency = invoicefSpinner.getValue().toString(); 
            String totalAmount = totalamountTextField.getText();
            String contractorName = nameofContractorTextField.getText();
            String clientName = nameofClientTextField.getText();
            String contractName = contractnameTextField.getText();
            String signature = signatureTextField.getText();

            
            if (isValidInput(effectiveDate, paName, pbName, constructionAddress, services,
                    deadline, invoiceFrequency, totalAmount, contractorName, clientName,
                    contractName, signature)) {
               
                PDFGenerate pdfgenerate = new PDFGenerate();
                try {
					pdfgenerate.generatePDFFile(effectiveDate, paName, pbName, constructionAddress,
					        services, deadline, invoiceFrequency, totalAmount, contractorName,
					        clientName, contractName, signature);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                openPDFPreviewer(contractName);
            } else {
                
            	 displayEmptyFieldAlert();
            }
        	
        });
        return root;
    }
    
    
 
    private boolean isValidInput(String... values) {
        return Arrays.stream(values)
                .noneMatch(String::isEmpty);
    }
    private void displayEmptyFieldAlert() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Empty Fields");
        alert.setHeaderText(null);
        alert.setContentText("Please fill in all fields.");

        alert.showAndWait();
    }
    
    private void openPDFPreviewer(String contractName) {
        PDFPreviewer pdfPreviewer = new PDFPreviewer(contractName);
        Stage pdfStage = new Stage();
        try {
            pdfPreviewer.start(pdfStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}