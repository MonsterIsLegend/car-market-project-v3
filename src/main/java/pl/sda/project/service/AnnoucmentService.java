package pl.sda.project.service;

import
import pl.sda.project.domain.Annoucment;

import java.util.List;
import java.util.Optional;

public interface AnnoucmentService {
    void addAnnoucment(Annoucment entity);
    List<Annoucment> showAllAnnoucments();
    List<Annoucment> showSortedByManufacture(String manufacture);
    List<Annoucment> showSortedByYear(Long year);
    List<Annoucment> showSortedAnnoucmentsByTitleDesc(String title);
    Optional<Annoucment> findByManufacture(String manufacture);
    Optional<Annoucment> findByID(Long id);
    void deleteById(Long id);
}
