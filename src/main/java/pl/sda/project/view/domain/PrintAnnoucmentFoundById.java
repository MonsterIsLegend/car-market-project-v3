package pl.sda.project.view.domain;

import java.util.Scanner;

public class PrintAnnoucmentFoundById {
    private final Scanner scanner;


    public PrintAnnoucmentFoundById(Scanner scanner) {
        this.scanner = scanner;
    }

    public long findAnnoucmentById(){
        System.out.println("Podaj ID ogłoszenia: ");
        return scanner.nextLong();
    }




}
