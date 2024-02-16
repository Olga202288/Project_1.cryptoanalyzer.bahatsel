package entity;


import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Encryptition {
       public static void doEncryptition () throws IOException {
        Scanner console = new Scanner (System.in);
        System.out.println("Введите адрес файла на шифровку.");
        String in = console.nextLine();
        System.out.println("Введите адрес файла для записи.");
        String address = console.nextLine();
        System.out.println("Введите ключ для шифрования");
        int key = console.nextInt();
        key = key % 32;

        String read = Files.readString(Path.of(in));
        StringBuilder strBuilder =  new StringBuilder();
        char der;
        for (int i = 0; i < read.length(); i++){
             der = read.charAt(i);

             if (Character.isLetter(der)){
                 der = (char) (read.charAt(i) + key);

                 if ((Character.isLowerCase(read.charAt(i)) && der > 'я')
                      || (Character.isUpperCase(read.charAt(i)) && der > 'Я'))
                     der = (char)(read.charAt(i) + key);
             }
             strBuilder.append(der);
             String cipher = strBuilder.toString();

             try (PrintWriter out = new PrintWriter(address)) {
                 out.print(cipher);
             }
        }
    }
}
