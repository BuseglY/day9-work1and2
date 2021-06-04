package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao  extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where isActive=:isActive and employer.companyName=:companyName")
	List<JobAdvertisement> getByCompanyNameAndIsActive(String companyName,boolean isActive);
	

}
