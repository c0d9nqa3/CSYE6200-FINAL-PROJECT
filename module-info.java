module Final_Project_Maven {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.sql;
	requires itextpdf;
	
	opens View to javafx.graphics, javafx.fxml;
}
