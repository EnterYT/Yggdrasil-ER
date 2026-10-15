package net.enter.yggdrasil.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LinkBoardApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                LinkBoardApplication.class.getResource("/net/enter/yggdrasil/LinkBoardView.fxml"));
        primaryStage.setMinWidth(640);
        primaryStage.setMinHeight(480);
        Scene scene = new Scene(fxmlLoader.load(), primaryStage.getMinWidth(), primaryStage.getMinHeight());
        primaryStage.setTitle("LinkBoard");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
