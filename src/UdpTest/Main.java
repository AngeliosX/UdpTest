package UdpTest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/main.fxml"));
            Pane root = loader.load();
            Controller controller = loader.getController();
            controller.setStage(primaryStage);
            controller.initHandler();
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/resources/style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Udp Chat");
            primaryStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
