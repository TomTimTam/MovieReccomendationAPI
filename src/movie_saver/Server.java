package movie_saver;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

public class Server {
    static final String BASE_URI = "http://localhost:9999/SocialQuoter/";

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create();
            server.start();
            System.out.println("Press Enter to stop the server. ");
            System.in.read();
            server.stop(0);
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }

}
