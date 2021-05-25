package pl.sda.project.controller;

import pl.sda.project.service.AnnoucmentService;
import pl.sda.project.view.core.ConsoleLooper;
import pl.sda.project.view.core.ConsoleView;
import pl.sda.project.view.core.Menu;
import pl.sda.project.view.core.MenuItem;
import pl.sda.project.view.domain.FillQuizByUserFromConsole;
import pl.sda.project.view.domain.InputNewQuizFromConsole;
import pl.sda.project.view.domain.PrintAllQuizesInConsole;
import pl.sda.project.view.domain.PrintQuizFoundById;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class QuizController {
    private final ConsoleLooper looper;
    private final ConsoleView view;
    private final Scanner input = new Scanner(System.in);

    public QuizController(AnnoucmentService annoucmentService) {
        Menu menu = new Menu();
        view = new ConsoleView(menu, System.in);
        looper = new ConsoleLooper(view);

        menu.addMenuItem(new MenuItem(
                "Dodaj nowy quiz",
                () -> new InputNewQuizFromConsole(input).inputNewQuiz().ifPresent(annoucmentService::addQuiz)
        ));

        menu.addMenuItem(new MenuItem(
                "Wypełnij losowy quiz",
                () -> annoucmentService.findRandom().ifPresent(quiz -> {
                    Optional<UserAnswer> userAnswer = new FillQuizByUserFromConsole(input, quiz).fillQuiz();
                    userAnswer.ifPresent(answer -> {
                        if (annoucmentService.isValidAnswer(answer)) {
                            view.printMessage("Brawo! Poprawna odpowiedź!");
                        } else {
                            view.printMessage("Ups! To nie jest poprawna odpowiedź!");
                        }

                    });
                })
        ));

        menu.addMenuItem(new MenuItem("Wyświetl wszystkie quizy",
                () -> {
                    PrintAllQuizesInConsole printAllQuizesInConsole = new PrintAllQuizesInConsole(annoucmentService.findAll());
                    printAllQuizesInConsole.printAllQuizes();
                }
        ));
        menu.addMenuItem(new MenuItem("Wyswietl quiz o podanym ID",
                () -> {
            PrintQuizFoundById ask = new PrintQuizFoundById(input);
            long id = ask.findQuizById();
            annoucmentService.findById(id).ifPresent(quiz ->
                    new PrintAllQuizesInConsole(List.of(quiz)).printAllQuizes());
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
