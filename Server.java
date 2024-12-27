import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3999)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);


                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                int x=0;
                while(true){
                    Scanner nam = new Scanner(System.in);
                    System.out.print("You:");
                    String names = nam.nextLine();
                    out.println(names);
                    String clientResponse = in.readLine();
                    System.out.println("Client's: " + clientResponse);

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
