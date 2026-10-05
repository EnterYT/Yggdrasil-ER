package net.enter.yggdrasil;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LinkBoardController {

    public Pane dragPane;
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
