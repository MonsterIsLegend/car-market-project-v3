package pl.sda.project.service;


import pl.sda.project.domain.Annoucment;
import pl.sda.project.domain.AnnoucmentForUser;
import pl.sda.project.domain.NewAnnoucment;

import java.util.List;
import java.util.Optional;

public interface AnnoucmentService {


    void addAnnoucment(NewAnnoucment newAnnoucment);
    List<AnnoucmentForUser> showAllAnnoucments();
    List<AnnoucmentForUser> showSortedByManufacture();
    List<AnnoucmentForUser> showSortedByYear();
    List<AnnoucmentForUser> showSortedAnnoucmentsByTitleDesc();
    List<AnnoucmentForUser> findByManufacture(String manufacture);
    Optional<AnnoucmentForUser> findByID(Long id);
    void deleteById(Long id);
}
