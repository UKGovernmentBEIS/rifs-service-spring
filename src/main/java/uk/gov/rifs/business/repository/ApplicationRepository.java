package uk.gov.rifs.business.repository;


import uk.gov.rifs.business.entity.ApplicationDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<ApplicationDB,Long>{
}
