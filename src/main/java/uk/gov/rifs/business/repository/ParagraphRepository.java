package uk.gov.rifs.business.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uk.gov.rifs.business.entity.ParagraphDB;

public interface ParagraphRepository extends JpaRepository<ParagraphDB,Long>{
}
