package com.cristianortega.portfolio.domain.mapper;

import com.cristianortega.portfolio.domain.dto.CertificateDTO;
import com.cristianortega.portfolio.persistence.entity.Certificate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = { CategoryMapper.class })
public interface CertificateMapper {

    CertificateMapper INSTANCE = Mappers.getMapper(CertificateMapper.class);
    @Mappings({
            @Mapping(source = "idCertificate", target = "id"),
            @Mapping(source = "entity", target = "entityName"),
            @Mapping(source = "smallImage", target = "imgUrl"),
            @Mapping(source = "bigImage", target = "pdfUrl")
    })
    CertificateDTO toCertificateDTO(Certificate certificate);
    List<CertificateDTO> toCertificatesDTO(List<Certificate> certificates);

    @InheritInverseConfiguration
    @Mapping(source = "category.id", target = "idCategory")
    Certificate toCertificate(CertificateDTO certificateDTO);



}
