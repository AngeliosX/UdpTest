package UdpTest.udp;

import javafx.scene.control.TextArea;

public class Server extends Thread {
    private final TextArea serverMsg;
    public static boolean stop;

    public Server(TextArea serverMsg) {
        this.serverMsg = serverMsg;
    }

    public static boolean isStop() {
        return stop;
    }

    @Override
    public void run() {
        for (int i = 0; !isInterrupted() && i < 20; i++) {
           serverMsg.appendText(i + "\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
