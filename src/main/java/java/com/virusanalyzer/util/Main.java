package java.com.virusanalyzer.util;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        primaryStage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/java/com/virusanalyzer/views/main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1035, 859);
        primaryStage.setTitle("Virus Analyzer");
        primaryStage.setScene(scene);
    }
}
