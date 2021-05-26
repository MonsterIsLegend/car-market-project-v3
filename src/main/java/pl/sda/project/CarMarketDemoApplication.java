package pl.sda.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.project.controller.MarketController;
import pl.sda.project.service.AnnoucmentService;
import pl.sda.project.service.AnnoucmentServiceJpa;

@SpringBootApplication
public class CarMarketDemoApplication implements CommandLineRunner {

    private final MarketController controller;

    public CarMarketDemoApplication(AnnoucmentService annoucmentService) {
        controller = new MarketController(annoucmentService);
    }

    public static void main(String[] args) {
        SpringApplication.run(CarMarketDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        controller.start();
    }
}
