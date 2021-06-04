package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobSeekerCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvDao;
import kodlamaio.hrms.entities.concretes.JobSeekerCv;

@Service
public class JobSeekerCvManager implements JobSeekerCvService{

public JobSeekerCvDao jobSeekerCvDao;
	
	@Autowired
	public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao) {
		super();
		this.jobSeekerCvDao=jobSeekerCvDao;
	}
	@Override
	public DataResult<List<JobSeekerCv>> getAllSortedGraduationDate() {
			Sort sort=Sort.by(Sort.Direction.DESC,"schoolGraduationYear");
			return new SuccessDataResult <List<JobSeekerCv>>(this.jobSeekerCvDao.findAll(sort),"Başarılı");
		
	}
	@Override
	public DataResult<List<JobSeekerCv>> getAllSortedExperienceDateYear() {
		Sort sort=Sort.by(Sort.Direction.DESC,"finishDateOfWork");
		return new SuccessDataResult <List<JobSeekerCv>>(this.jobSeekerCvDao.findAll(sort),"Başarılı");
	}
	
	@Override
	public DataResult<JobSeekerCv> getAll(int id) {
		return new SuccessDataResult<JobSeekerCv>
		(this.jobSeekerCvDao.findById(id).get(),"İş arayanlar listelendi");
	}

}
