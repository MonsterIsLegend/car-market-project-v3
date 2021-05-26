package pl.sda.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.sda.project.domain.AnnoucmentForUser;
import pl.sda.project.entity.AnnoucmentEntity;

import java.util.List;


@Repository
public interface AnnoucmentRepository extends JpaRepository<AnnoucmentEntity, Long> {
//    @Query("SELECT max(a.id) FROM annoucment a")
//    long maxId();

    @Query("select a from AnnoucmentEntity a order by  a.manufacture asc ")
    List<AnnoucmentEntity> sortedByManufacture();

    @Query("select a from AnnoucmentEntity a order by a.productionYear asc ")
    List<AnnoucmentEntity> sortedByYear();

    @Query("select a from AnnoucmentEntity a order by a.title desc ")
    List<AnnoucmentEntity> sortedByTitleDesc();


}
