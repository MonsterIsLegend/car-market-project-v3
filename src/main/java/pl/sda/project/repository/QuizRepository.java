package pl.sda.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.project.entity.QuizEntity;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
    @Query("SELECT max(a.id) FROM Annoucment a")
    long maxId();
}
