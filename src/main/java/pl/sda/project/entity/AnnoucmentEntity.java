package pl.sda.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "annoucments")
public class AnnoucmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String author;

    @Column()
    private String title;

    @Column
    private String inside;

    @Column(nullable = false)
    private String manufacture;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int productionYear;

    @Column(nullable = false)
    private BigDecimal price;

    @CreationTimestamp
    private Timestamp published;

}
