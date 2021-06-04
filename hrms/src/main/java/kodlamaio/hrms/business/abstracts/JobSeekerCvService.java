package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobSeekerCv;

public interface JobSeekerCvService {
	
	DataResult<JobSeekerCv> getAll(int id);
	DataResult<List<JobSeekerCv>> getAllSortedGraduationDate();//sıralama
	DataResult<List<JobSeekerCv>> getAllSortedExperienceDateYear();
}
