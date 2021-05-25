package pl.sda.project.service;

import org.springframework.stereotype.Service;
import pl.sda.project.domain.NewQuiz;
import pl.sda.project.domain.QuizForUser;
import pl.sda.project.domain.UserAnswer;
import pl.sda.project.mapper.QuizMapper;
import pl.sda.project.repository.QuizRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AnnoucmentServiceJpa implements AnnoucmentService {
    private static final Random RANDOM = new Random();

    private final QuizRepository quizRepository;

    public AnnoucmentServiceJpa(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public void addQuiz(NewQuiz newQuiz) {
        quizRepository.save(QuizMapper.INSTANCE.toEntity(newQuiz));
    }

    @Override
    public Optional<QuizForUser> findById(long id) {
        return quizRepository.findById(id).map(QuizMapper.INSTANCE::toFront);
    }

    @Override
    public List<QuizForUser> findAll() {
        return quizRepository.findAll().stream().map(QuizMapper.INSTANCE::toFront).collect(Collectors.toList());
    }

    @Override
    public Optional<QuizForUser> findRandom() {
        long count = quizRepository.count();
        return quizRepository.findAll()
                .stream()
                .map(QuizMapper.INSTANCE::toFront)
                .min((a, b) -> RANDOM.nextInt(2) - 1);
    }

    @Override
    public boolean isValidAnswer(UserAnswer userAnswer) {
        return quizRepository.findById(userAnswer.getQuizId())
                .map(QuizMapper.INSTANCE::toDomain)
                .filter(quiz -> quiz.isValidUserAnswer(userAnswer))
                .isPresent();
    }
}
