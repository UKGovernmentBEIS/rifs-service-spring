package uk.gov.rifs.business.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uk.gov.rifs.business.entity.SectionDB;

public interface SectionRepository extends JpaRepository<SectionDB,Long>{
}
