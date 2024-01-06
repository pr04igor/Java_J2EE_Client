package org.example;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        ConnectInputMessage connectWithServer;
        try {
            connectWithServer = new ConnectInputMessage();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        Thread tConnectInputMessage = new Thread(connectWithServer);
        tConnectInputMessage.start();

        RecieveMessageFromServer recieveMessage = new RecieveMessageFromServer(connectWithServer.getInputStreamServer());
        Thread tRecieveMessage = new Thread(recieveMessage);
        tRecieveMessage.start();
    }
}