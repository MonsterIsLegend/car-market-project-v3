package pl.sda.project.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class Quiz {
    private long id;
    private String question;
    private String[] options;
    private String answer;
    private boolean accepted;

    public boolean isValidUserAnswer(UserAnswer userAnswer){
        if(userAnswer == null){
            return false;
        }
        if(userAnswer.getQuizId() != id){
            return false;
        }
        return Objects.equals(answer, userAnswer.getAnswer());
    }
    public boolean isValidUserAnswerWithException(UserAnswer userAnswer){
        if(userAnswer == null){
            throw new IllegalArgumentException("USER answer is null!");
        }
        if(userAnswer.getQuizId() != id){
            return false;
        }
        return Objects.equals(answer, userAnswer.getAnswer());
    }
}
