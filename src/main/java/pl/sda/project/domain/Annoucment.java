package pl.sda.project.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
public class Annoucment {
    private long id;
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
