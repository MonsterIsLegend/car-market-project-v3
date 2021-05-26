package pl.sda.project.service;

import org.springframework.stereotype.Service;
import pl.sda.project.domain.AnnoucmentForUser;
import pl.sda.project.domain.NewAnnoucment;
import pl.sda.project.mapper.AnnoucmentMapper;
import pl.sda.project.repository.AnnoucmentRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnnoucmentServiceJpa implements AnnoucmentService {

    private final AnnoucmentRepository annoucmentRepository;

    public AnnoucmentServiceJpa(AnnoucmentRepository annoucmentRepository) {
        this.annoucmentRepository = annoucmentRepository;
    }


    @Override
    public void addAnnoucment(NewAnnoucment newAnnoucment) {
    annoucmentRepository.save(AnnoucmentMapper.INSTANCE.toEntity(newAnnoucment));
    }


    @Override
    public Optional<AnnoucmentForUser> findByID(Long id) {
        return annoucmentRepository.findById(id).map(AnnoucmentMapper.INSTANCE::toFront);
    }

    @Override
    public List<AnnoucmentForUser> findByManufacture(String manufactureToFind) {
        return annoucmentRepository.findAll().stream().filter(manuf -> manuf.getManufacture().equals(manufactureToFind)).map(AnnoucmentMapper.INSTANCE::toFront).collect(Collectors.toList());
    }

    @Override
    public List<AnnoucmentForUser> showAllAnnoucments() {
        return annoucmentRepository.findAll().stream().map(AnnoucmentMapper.INSTANCE::toFront).collect(Collectors.toList());
    }


    @Override
    public List<AnnoucmentForUser> showSortedByManufacture() {
      return annoucmentRepository.sortedByManufacture();
    }

    @Override
    public List<AnnoucmentForUser> showSortedByYear() {
        return annoucmentRepository.sortedByYear();
    }

    @Override
    public List<AnnoucmentForUser> showSortedAnnoucmentsByTitleDesc() {
        return annoucmentRepository.sortedByTitleDesc();

    }

    @Override
    public void deleteById(Long id) {
        annoucmentRepository.deleteById(id);
    }
}
