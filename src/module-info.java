module CRUDProfessorDisciplinaMySQLJFX11v1 {
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	requires java.sql;

	opens application to javafx.graphics, javafx.fxml;
	opens application.controller to javafx.graphics, javafx.fxml;
}
