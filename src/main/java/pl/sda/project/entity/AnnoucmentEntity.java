package pl.sda.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    @Column(nullable = false, unique = true, length = 200)
    private String title;

    @Column
    private String inside;

    @Column(nullable = false)
    private String manufacture;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Long productionYear;

    @Column(nullable = false)
    private double price;

    @CreationTimestamp
    private Timestamp published;

    @PrePersist
    private void setDefaultTimeStamp(){
        published = Timestamp.valueOf(LocalDateTime.now());
    }
}
