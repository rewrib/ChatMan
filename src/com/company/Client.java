package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

        try {
            Socket client = new Socket("localhost", 5555);
            System.out.println("Client start!");

            //  In/out-streams

            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            System.out.print("Eingabe: ");
            String textToServer = eingabe.nextLine();

            //Send stuff to server
            writer.write(textToServer + System.lineSeparator());
            writer.flush();

            String s = null;

            //receive stuff from Server
            while ((s = reader.readLine()) != null) {
                System.out.println("Empfangen vom Server: " + s);
            }

            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
