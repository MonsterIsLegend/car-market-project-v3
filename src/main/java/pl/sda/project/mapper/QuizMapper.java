package pl.sda.project.mapper;

import pl.sda.project.domain.NewQuiz;
import pl.sda.project.domain.Quiz;
import pl.sda.project.domain.QuizForUser;
import pl.sda.project.entity.QuizEntity;

import java.util.ArrayList;
import java.util.List;

public enum QuizMapper {
    INSTANCE;

    public QuizEntity toEntity(NewQuiz newQuiz){
        String[] options = newQuiz.getOptions();
        return QuizEntity.builder()
                .question(newQuiz.getQuestion())
                .option1(options[0])
                .option2(options[1])
                .option3(options[2])
                .option4(options[3])
                .answer(newQuiz.getAnswer())
                .build();
    }

    public Quiz toDomain(QuizEntity entity){
        List<String> options = new ArrayList<>();
        if(entity.getOption1() != null){
            options.add(entity.getOption1());
        }
        if(entity.getOption2() != null){
            options.add(entity.getOption2());
        }
        if(entity.getOption3() != null){
            options.add(entity.getOption3());
        }
        if(entity.getOption4() != null){
            options.add(entity.getOption4());
        }
        return Quiz.builder()
                .id(entity.getId())
                .question(entity.getQuestion())
                .options(options.toArray(new String[4]))
                .answer(entity.getAnswer())
                .build();
    }
    public QuizForUser toFront(QuizEntity quizEntity){
        Quiz quiz = toDomain(quizEntity);
        return QuizForUser.builder()
                .id(quiz.getId())
                .question(quiz.getQuestion())
                .options(quiz.getOptions())
                .build();
    }
}
