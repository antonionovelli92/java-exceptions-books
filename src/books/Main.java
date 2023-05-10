package books;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di libri che vuoi inserire: ");
        int numLibri = scanner.nextInt();
        scanner.nextLine(); 

        Libro[] catalogo = new Libro[numLibri];

        for (int i = 0; i < numLibri; i++) {
            System.out.println("Dati libro " + (i + 1) + ":");

            System.out.print("Inserisci il titolo del libro: ");
            String titolo = scanner.nextLine();
            
            System.out.print("Inserisci il numero di pagine del libro: ");
            int numPagine = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Inserisci il nome dell'autore del libro: ");
            String autore = scanner.nextLine();


            System.out.print("Inserisci l'editore del libro: ");
            String editore = scanner.nextLine();

            try {
                catalogo[i] = new Libro(titolo, numPagine, autore, editore);
            } catch (IllegalArgumentException e) {
                System.out.println("Errore durante la creazione del libro: " + e.getMessage());
                i--; 
            }
        }

        scanner.close();
        
//        Create file

        try {
            FileWriter fileWriter = new FileWriter("catalogo.txt");
            for (int i = 0; i < catalogo.length; i++) {
                fileWriter.write(catalogo[i].toString() + "\n");
            }
            fileWriter.close();
            System.out.println("Dati salvati nel file catalogo.txt");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio dei dati nel file: " + e.getMessage());
        }

        try {
            Scanner fileScanner = new Scanner(new File("catalogo.txt"));
            System.out.println("Catalogo dal file:");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        }
    }
}

