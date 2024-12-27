import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NameClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3999);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            int n=0;
            while(true){
                Scanner nam = new Scanner(System.in);
                String serverMessage = in.readLine();
                System.out.println("Server: " + serverMessage);
                System.out.print("You:");
                String name=nam.nextLine();

                out.println(name);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}