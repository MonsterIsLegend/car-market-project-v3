package pl.sda.project.view.domain;

import pl.sda.project.domain.NewQuiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public final class InputNewQuizFromConsole{
    private final Scanner scanner;

    public InputNewQuizFromConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public Optional<NewQuiz> inputNewQuiz() {
        System.out.println("Wpisz pytanie: ");
        String question = scanner.nextLine();
        System.out.println("Wpisz opcje w osobnych wierszach:");
        int count = 1;
        List<String> options = new ArrayList<>();
        do {
            System.out.print(count++ + " : ");
            String option = scanner.nextLine();
            options.add(option);
            System.out.println("");
        } while (options.size() < 4);
        System.out.println("Wpisz numer opcji, która jest poprawną odpowiedzią: ");
        int valid = -1;
        if (scanner.hasNextInt()) {
            valid = scanner.nextInt();
            scanner.nextLine();
        }
        if (valid > 0 && valid <= options.size()) {
            return Optional.of(
                    NewQuiz.builder()
                            .answer(options.get(valid - 1))
                            .question(question)
                            .options(options.toArray(new String[0]))
                            .build());
        }
        return Optional.empty();
    }
}
