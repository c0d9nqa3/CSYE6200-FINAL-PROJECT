package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        VBox leftSidebar = new VBox(10);
        leftSidebar.setPadding(new Insets(10));
        leftSidebar.setStyle("-fx-background-color: #2A5058; -fx-border-color: black; -fx-border-width: 1;");
        leftSidebar.setPrefWidth(200); // Left side
        
        
        // button
        String buttonStyle = "-fx-border-color: white; -fx-border-width: 1; -fx-border-insets: 5; "
                             + "-fx-border-style: solid; -fx-background-color: #2A5058; -fx-text-fill: white;";

        // side button
        Button btnProfile = new Button("Profile");
        btnProfile.setStyle(buttonStyle);
        btnProfile.setPrefWidth(Double.MAX_VALUE); 
        Button btnMessage = new Button("Message");
        btnMessage.setStyle(buttonStyle);
        btnMessage.setPrefWidth(Double.MAX_VALUE);
        Button btnChangePassword = new Button("Change Password");
        btnChangePassword.setStyle(buttonStyle);
        btnChangePassword.setPrefWidth(Double.MAX_VALUE);
        
        leftSidebar.getChildren().addAll(btnProfile, btnMessage, btnChangePassword);

        // top bar
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(20, 12, 20, 12));
        topBar.setStyle("-fx-background-color: #336699;"); // color
        Text projectNameTopBar = new Text("ACE Project");
        projectNameTopBar.setFont(new Font("Arial", 24));
        projectNameTopBar.setFill(javafx.scene.paint.Color.WHITE);
        topBar.getChildren().add(projectNameTopBar);
        topBar.setAlignment(Pos.CENTER_LEFT); 
        
        // main info
        GridPane centerGrid = new GridPane();
        centerGrid.setAlignment(Pos.CENTER);
        centerGrid.setHgap(10);
        centerGrid.setVgap(10);
        centerGrid.setPadding(new Insets(20, 150, 20, 150)); 

        // text
        centerGrid.add(new Label("Company name:"), 0, 0);
        centerGrid.add(new TextField(), 1, 0);
        centerGrid.add(new Label("Address:"), 0, 1);
        centerGrid.add(new TextField(), 1, 1);
        centerGrid.add(new Label("TEL:"), 0, 2);
        centerGrid.add(new TextField(), 1, 2);
        centerGrid.add(new Label("Email:"), 0, 3);
        centerGrid.add(new TextField(), 1, 3);
        centerGrid.add(new Label("More INFO:"), 0, 4);
        centerGrid.add(new TextArea(), 1, 4); 

        // Right button
        Button applyButton = new Button("Apply");
        applyButton.setFont(new Font("Arial", 14)); 
        HBox applyButtonBox = new HBox(applyButton);
        applyButtonBox.setAlignment(Pos.BOTTOM_RIGHT); 
        applyButtonBox.setPadding(new Insets(10));

      
        borderPane.setTop(topBar);
        borderPane.setLeft(leftSidebar);
        borderPane.setCenter(centerGrid);
        borderPane.setBottom(applyButtonBox);

      
        Scene scene = new Scene(borderPane, 1280, 720); 
        primaryStage.setTitle("Profile");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true); 
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



