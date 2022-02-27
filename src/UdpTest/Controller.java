package UdpTest;

import UdpTest.udp.Server;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static UdpTest.udp.Server.isStop;

public class Controller implements Initializable {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        server = new Server(serverMsg);
        server.setDaemon(true);
        server.start();

    }

    public void initHandler(){
        stage.setOnCloseRequest(event -> {
            server.interrupt();
        });
    }

    private Server server;

    @FXML
    private TextField sendAdr;

    @FXML
    private TextArea serverMsg;

    @FXML
    private TextArea clientMsg;

    @FXML
    public void sendHandler() {
        clientMsg.setText("Start Text");
    }

    @FXML
    public void clearText() {
        clientMsg.setText("");
        serverMsg.setText("");
    }

    @FXML
    public void stop() {
        if(!isStop()){
            server.stop();
        }
    }
}
