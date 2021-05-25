package pl.sda.project.view.domain;

import pl.sda.project.domain.QuizForUser;
import pl.sda.project.domain.UserAnswer;

import java.util.Optional;
import java.util.Scanner;

public final class FillQuizByUserFromConsole{
    private final Scanner scanner;
    private final QuizForUser quizForUser;

    public FillQuizByUserFromConsole(Scanner scanner, QuizForUser quizForUser) {
        this.scanner = scanner;
        this.quizForUser = quizForUser;
    }
    public Optional<UserAnswer> fillQuiz(){
        System.out.println("Pytanie: \n" + quizForUser.getQuestion());
        int count = 1;
        for(String option: quizForUser.getOptions()){
            System.out.println(count++ + ". " + option);
        }
        System.out.println("Wpisz numer odpowiedzi:");
        if(scanner.hasNextInt()){
            int option = scanner.nextInt() - 1;
            if (option >=0 && option < quizForUser.getOptions().length) {
                return Optional.of(
                        UserAnswer.builder()
                        .quizId(quizForUser.getId())
                        .answer(quizForUser.getOptions()[option])
                        .build());
            }
        }
        return Optional.empty();
    }
}
