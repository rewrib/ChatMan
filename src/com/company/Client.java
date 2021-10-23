package com.company;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try {
            Socket client = new Socket("localhost", 5555);
            System.out.println("Client start!");

            //  In/out-streams

            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            writer.write("Hallo Server!");
            writer.flush();

            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
