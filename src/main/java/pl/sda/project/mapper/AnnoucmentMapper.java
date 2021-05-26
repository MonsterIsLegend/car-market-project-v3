package pl.sda.project.mapper;

import pl.sda.project.domain.Annoucment;
import pl.sda.project.domain.AnnoucmentForUser;
import pl.sda.project.domain.NewAnnoucment;

import pl.sda.project.entity.AnnoucmentEntity;


import java.sql.Timestamp;
import java.time.LocalDateTime;

public enum AnnoucmentMapper {
    INSTANCE;

    public AnnoucmentEntity toEntity(NewAnnoucment newAnnoucment){

        return AnnoucmentEntity.builder()
                .author(newAnnoucment.getAuthor())
                .title(newAnnoucment.getTitle())
                .inside(newAnnoucment.getInside())
                .manufacture(newAnnoucment.getManufacture())
                .model(newAnnoucment.getModel())
                .productionYear(newAnnoucment.getProductionYear())
                .published(Timestamp.valueOf(LocalDateTime.now()))
                .price(newAnnoucment.getPrice())
                .build();
    }

    public Annoucment toDomain(AnnoucmentEntity entity){
        return Annoucment.builder()
                .id(entity.getId())
                .author(entity.getAuthor())
                .inside(entity.getInside())
                .title(entity.getTitle())
                .manufacture(entity.getManufacture())
                .model(entity.getModel())
                .price(entity.getPrice())
                .productionYear(entity.getProductionYear())
                .published(entity.getPublished())
                .build();
    }

    public AnnoucmentForUser toFront(AnnoucmentEntity annoucmentEntity){
        Annoucment annoucment = toDomain(annoucmentEntity);
        return AnnoucmentForUser.builder()
                .id(annoucment.getId())
                .author(annoucment.getAuthor())
                .inside(annoucment.getInside())
                .manufacture(annoucment.getManufacture())
                .model(annoucment.getModel())
                .price(annoucment.getPrice())
                .productionYear(annoucment.getProductionYear())
                .title(annoucment.getTitle())
                .build();
    }
}
