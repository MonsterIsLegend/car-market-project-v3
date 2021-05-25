package pl.sda.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.project.controller.QuizController;
import pl.sda.project.service.AnnoucmentService;

@SpringBootApplication
public class CarMarketDemoApplication implements CommandLineRunner {

    private final QuizController controller;

    public CarMarketDemoApplication(AnnoucmentService annoucmentService) {
        controller = new QuizController(annoucmentService);
    }

    public static void main(String[] args) {
        SpringApplication.run(CarMarketDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        controller.start();
    }
}
