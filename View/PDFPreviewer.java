package View;

import com.dansoftware.pdfdisplayer.JSLogListener;
import com.dansoftware.pdfdisplayer.PDFDisplayer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class PDFPreviewer extends Application {
    private boolean visible;
    private static String contractName;
    public PDFPreviewer(String contractName) {
        this.contractName = contractName;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
        PDFDisplayer displayer = new PDFDisplayer();
        displayer.loadPDF(new File("Contract/"+contractName+".pdf"));
        displayer.setSecondaryToolbarToggleVisibility(visible);
        displayer.setVisibilityOf("sidebarToggle", false);

        Button hideShowBtn = new Button("Hide/Show");
        hideShowBtn.setOnAction(event -> {
            displayer.setSecondaryToolbarToggleVisibility(visible = !visible);
        });

        Button generateAndSaveBtn = new Button("Generate and Save");
        generateAndSaveBtn.setOnAction(event -> {
            // Implement the logic to generate and save the PDF
        });

        Button cancelBtn = new Button("Cancel");
        cancelBtn.setOnAction(event -> {
            // Implement the logic to cancel
        });

        HBox buttonsBox = new HBox(10, generateAndSaveBtn, cancelBtn);
        buttonsBox.setStyle("-fx-padding: 10; -fx-alignment: CENTER;");

        JSLogListener.setOutputStream(System.err);

        BorderPane root = new BorderPane();
        root.setCenter(displayer.toNode());
        root.setBottom(buttonsBox);
        root.setTop(hideShowBtn);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(contractName);
    }
}
