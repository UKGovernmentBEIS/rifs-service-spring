package uk.gov.rifs.business.repository;


import uk.gov.rifs.business.entity.OpportunityDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpportunityRepository extends JpaRepository<OpportunityDB,Long>{
}
