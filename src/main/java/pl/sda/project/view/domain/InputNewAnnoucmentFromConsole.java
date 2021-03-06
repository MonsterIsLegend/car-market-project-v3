package pl.sda.project.view.domain;

import pl.sda.project.domain.NewAnnoucment;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

public final class InputNewAnnoucmentFromConsole {
    private final Scanner scanner;

    public InputNewAnnoucmentFromConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public Optional<NewAnnoucment> inputNewAnnoucment() {
        scanner.nextLine();
        System.out.println("Wpisz Tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Wpisz zawartość: ");
        String inside = scanner.nextLine();
        System.out.println("Wpisz swoje imie: ");
        String author = scanner.nextLine();
        System.out.println("Wpisz producenta samochodu: ");
        String manufacture = scanner.nextLine();
        System.out.println("Wpisz model samochodu: ");
        String model= scanner.nextLine();
        System.out.println("Wpisz rok produkcji: ");
        int productionYear = scanner.nextInt();
        System.out.println("Wpisz cenę samochodu: ");
        BigDecimal price =  scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.println("Podaj typ ogłoszenia ( k dla kupie, s dla sprzedam: ");
        String check =  scanner.nextLine();
        String type = null;
        if(check.equals("k")){
            type = "kupie";
        }else if(check.equals("s")){
            type = "sprzedam";
        }else{
            type = "sprzedam";
        }
        return Optional.ofNullable(
                NewAnnoucment.builder()
                        .title(title)
                        .author(author)
                        .inside(inside)
                        .manufacture(manufacture)
                        .model(model)
                        .price(price)
                        .productionYear(productionYear)
                        .type(type)
                        .published(Timestamp.valueOf(LocalDateTime.now()))
                        .build());
    }
}