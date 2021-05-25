package pl.sda.project.view.domain;

import java.util.Scanner;

public class PrintQuizFoundById {
    private final Scanner scanner;


    public PrintQuizFoundById(Scanner scanner) {
        this.scanner = scanner;
    }

    public long findQuizById(){
        System.out.println("Podaj ID quizu: ");
        return scanner.nextLong();
    }




}
