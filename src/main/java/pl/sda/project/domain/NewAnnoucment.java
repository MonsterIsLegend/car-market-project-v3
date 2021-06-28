package pl.sda.project.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
public class NewAnnoucment {
    private String author;
    private String title;
    private String inside;
    private String manufacture;
    private String model;
    private int productionYear;
    private BigDecimal price;
    private String type;
    private Timestamp published;

}
