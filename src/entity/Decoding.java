package entity;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.*;

public class Decoding {
    public static  void doDecoding () throws IOException{
        Scanner console = new Scanner(System.in);
        System.out.println("Введите адрес файла на расшифровку.");
        String in = console.nextLine();
        System.out.println("Введите адрес файла для записи.");
        String address = console.nextLine();
        System.out.println("Введите ключ для шифрования.");

        int key =console.nextInt();
        key = key % 32;

        String s = Files.readString(Path.of(in));
        StringBuilder strBuilder = new StringBuilder();
        char dec;
        for (int i = 0; i < s.length(); i++){
            dec = s.charAt(i);

            if (Character.isLetter(dec)){
                dec = (char) (s.charAt(i) - key);
                if ((Character.isLowerCase(s.charAt(i)) && dec > 'я')
                     ||(Character.isUpperCase(s.charAt(i)) && dec > 'Я'))

                    dec = (char) (s.charAt(i) - key);
            }
            strBuilder.append(dec);
            String cipher = strBuilder.toString();

            try (PrintWriter out = new PrintWriter(address)){
                out.print(cipher);
            } catch (FileNotFoundException e){
                throw  new RuntimeException(e);
            }
        }
    }
    public static  void doDecoding (int j) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите адрес файла на расшифровку.");
        String in = console.nextLine();
        System.out.println("Введите адрес файла для записи.");
        String line = console.nextLine();
        String string = Files.readString(Path.of(in));
        StringBuilder strBuilder = new StringBuilder();
        char dec;
        for (int i = 0; i < string.length(); i++){
            dec = string.charAt(i);
            if (Character.isLetter(dec)){
                dec = (char) (string.charAt(i) - j);
                 if ((Character.isLowerCase(string.charAt(i)) && dec > 'я')
                    || (Character.isUpperCase(string.charAt(i)) && dec > 'Я'))
                    dec = (char) (string.charAt(i)- j);
            }
            strBuilder.append(dec);
            String cipherText = strBuilder.toString();

            try (PrintWriter out = new PrintWriter(line)){
                out.print(cipherText);
            } catch (FileNotFoundException e){
                throw new RuntimeException(e);
            }
        }
    }
}
