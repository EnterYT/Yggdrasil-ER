package net.enter.yggdrasil.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import net.enter.yggdrasil.importer.JarImportService;

import java.io.File;
import java.io.IOException;

public class LinkBoardController {

    public Pane dragPane;
    private final JarImportService jarImportService = new JarImportService();
    @FXML
    private Pane workspace;

    @FXML
    private VBox playerNode;

    private double mouseOffsetX;
    private double mouseOffsetY;

    @FXML
    private void initialize() {
        setupDrag();
    }

    @FXML
    private void handleImportJar() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import JAR");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Java archive (*.jar)", "*.jar"));

        Window owner = workspace.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(owner);
        if (selectedFile == null) {
            return;
        }

        try {
            int classCount = jarImportService.countClassEntries(selectedFile.toPath());
            String message = classCount == 0
                    ? "The archive is valid, but it contains no .class files."
                    : "Found " + classCount + " .class files in " + selectedFile.getName() + ".";
            showAlert(Alert.AlertType.INFORMATION, "JAR inspection complete", message);
        } catch (IOException exception) {
            showAlert(Alert.AlertType.ERROR, "Could not read JAR",
                    "The selected file could not be read as a JAR archive. "
                            + exception.getMessage());
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void setupDrag() {
        playerNode.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            mouseOffsetX = event.getX();
            mouseOffsetY = event.getY();
        });

        dragPane.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            double newX = playerNode.getLayoutX()
                    + event.getX()
                    - mouseOffsetX;

            double newY = playerNode.getLayoutY()
                    + event.getY()
                    - mouseOffsetY;

            playerNode.setLayoutX(newX);
            playerNode.setLayoutY(newY);
        });
    }
}
