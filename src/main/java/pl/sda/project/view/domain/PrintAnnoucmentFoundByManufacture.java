package pl.sda.project.view.domain;

import java.util.Scanner;

public class PrintAnnoucmentFoundByManufacture {
    private final Scanner scanner;

    public PrintAnnoucmentFoundByManufacture(Scanner scanner) {
        this.scanner = scanner;
    }

    public String findByManufacture(){
        System.out.println("Podaj producenta którego chcesz wyszukać");
        return scanner.nextLine();
    }

}
