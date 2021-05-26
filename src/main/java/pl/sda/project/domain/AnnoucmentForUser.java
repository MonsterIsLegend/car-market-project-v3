package pl.sda.project.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AnnoucmentForUser {
    private long id;
    private String author;
    private String title;
    private String inside;
    private String manufacture;
    private String model;
    private int productionYear;
    private BigDecimal price;
}
