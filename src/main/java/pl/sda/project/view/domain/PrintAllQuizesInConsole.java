package pl.sda.project.view.domain;

import pl.sda.project.domain.QuizForUser;

import java.util.List;

public class PrintAllQuizesInConsole {

    private List<QuizForUser> allQuizes;

    public PrintAllQuizesInConsole(List<QuizForUser> allQuizes) {
        this.allQuizes = allQuizes;
    }

    public void printAllQuizes(){
        allQuizes.forEach(System.out::println);
    }
}
