package entity;
import constants.Alphabet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class BruteForce {
     public static void doBruteForce( ) throws IOException {
         Scanner console = new Scanner(System.in);

         System.out.println("Введите адрес файла на расшифровку.");
         String in = console.nextLine();
         System.out.println("Введите адрес файла для записи.");
         String str = console.nextLine();
         String read = Files.readString(Path.of(in));
         StringBuilder strBuilder = new StringBuilder();
         char b;
         for (int i = 1; i <= 32; i++){
             for (int j = 0; j < read.length(); j++){

                 b = read.charAt(j);

                 if (Character.isLetter(b)){

                     b = (char) (read.charAt(j) - j);

                     if ((Character.isLowerCase(read.charAt(j)) && b > 'я')
                          || (Character.isUpperCase(read.charAt(j)) && b > 'Я'))
                         b = (char) (read.charAt(j) - (Alphabet.AlphabetA.length() + j));

                 }
                 strBuilder.append(b);
                 String cipher = strBuilder.toString();

                 try (PrintWriter out = new PrintWriter(str)){
                     out.print(cipher);
                 } catch (FileNotFoundException e){
                     throw new RuntimeException(e);
                 }
             }
         }
     }
}
