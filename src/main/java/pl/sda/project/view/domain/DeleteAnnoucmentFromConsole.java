package pl.sda.project.view.domain;

import java.util.Scanner;

public class DeleteAnnoucmentFromConsole {
    private final Scanner scanner;

    public DeleteAnnoucmentFromConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public long deleteById(){
        System.out.println("Wprowadź ID ogłoszenia który chcesz usunąć");
        return scanner.nextLong();
    }


}
