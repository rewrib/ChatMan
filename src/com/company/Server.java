package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(5555);
            System.out.println("Server start!");

            Socket client = server.accept();

            //  In/out-streams

            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String s = null;

            while ((s = reader.readLine()) != null) {
                writer.write(s + System.lineSeparator());
                writer.flush();
                System.out.println("Empfangen vom Client: " + s);
            }

            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //
    }
}
