package pl.sda.project.controller;

import pl.sda.project.domain.AnnoucmentForUser;
import pl.sda.project.service.AnnoucmentService;
import pl.sda.project.view.core.ConsoleLooper;
import pl.sda.project.view.core.ConsoleView;
import pl.sda.project.view.core.Menu;
import pl.sda.project.view.core.MenuItem;
import pl.sda.project.view.domain.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MarketController {
    private final ConsoleLooper looper;
    private final ConsoleView view;
    private final Scanner input = new Scanner(System.in);

    public MarketController(AnnoucmentService annoucmentService) {
        Menu menu = new Menu();
        view = new ConsoleView(menu, System.in);
        looper = new ConsoleLooper(view);

        menu.addMenuItem(new MenuItem(
                "Dodaj nowe ogłoszenie",
                () -> new InputNewAnnoucmentFromConsole(input).inputNewAnnoucment().ifPresent(annoucmentService::addAnnoucment)
        ));


        menu.addMenuItem(new MenuItem("Wyświetl wszystkie ogłoszenia",
                () -> {
                    PrintAllAnnoucmentsInConsole printAllAnnoucmentsInConsole = new PrintAllAnnoucmentsInConsole(annoucmentService.showAllAnnoucments());
                    printAllAnnoucmentsInConsole.printAllAnnoucments();
                }
        ));
        menu.addMenuItem(new MenuItem("Wyswietl ogłoszenie o podanym ID",
                () -> {
                    PrintAnnoucmentFoundById ask = new PrintAnnoucmentFoundById(input);
                    long id = ask.findAnnoucmentById();
                    annoucmentService.findByID(id).ifPresent(annoucment ->
                            new PrintAllAnnoucmentsInConsole(List.of(annoucment)).printAllAnnoucments());
                }
        ));
        menu.addMenuItem(new MenuItem("Wyswietl ogłoszenie podanego producenta",
                () -> {
                    PrintAnnoucmentFoundByManufacture man1 = new PrintAnnoucmentFoundByManufacture(input);
                    String manufacture = man1.findByManufacture();
                    List<AnnoucmentForUser> byManufacture = annoucmentService.findByManufacture(manufacture);
                    byManufacture.forEach(System.out::println);

                }
        ));

        menu.addMenuItem(new MenuItem("Posortuj według producentów",
                () -> {
                    PrintAllAnnoucmentsInConsole printAllAnnoucmentsInConsole = new PrintAllAnnoucmentsInConsole(annoucmentService.showSortedByManufacture());
                    printAllAnnoucmentsInConsole.printAllAnnoucments();
                }
        ));
        menu.addMenuItem(new MenuItem("Posortuj według roku produkcji",
                () -> {
                    PrintAllAnnoucmentsInConsole printAllAnnoucmentsInConsole = new PrintAllAnnoucmentsInConsole(annoucmentService.showSortedByYear());
                    printAllAnnoucmentsInConsole.printAllAnnoucments();
                }
        ));
        menu.addMenuItem(new MenuItem("Posortuj według tytułu malejąco",
                () -> {
                    PrintAllAnnoucmentsInConsole printAllAnnoucmentsInConsole = new PrintAllAnnoucmentsInConsole(annoucmentService.showSortedAnnoucmentsByTitleDesc());
                    printAllAnnoucmentsInConsole.printAllAnnoucments();
                }
        ));

        menu.addMenuItem(new MenuItem(
                "Usuń artykuł",
                () -> {
                    DeleteAnnoucmentFromConsole del = new DeleteAnnoucmentFromConsole(input);
                    long idOfDeleting = del.deleteById();
                    annoucmentService.deleteById(idOfDeleting);
                }
        ));
        menu.addMenuItem(new MenuItem(
                "Koniec",
                Menu.DEFAULT_QUIT
        ));
    }

    public void start() {
        looper.runLoop();
    }
}
