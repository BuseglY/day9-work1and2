package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.concretes.CheckJobSeeker;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	public JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao=jobSeekerDao;
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>
		(this.jobSeekerDao.findAll(),"İş arayanlar listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName()!=null && jobSeeker.getLastName()!=null && jobSeeker.getEmail()!=null && jobSeeker.getPassword()!=null && jobSeeker.getRepeatPassword()!=null && jobSeeker.getIdentificationNumber()!=null && jobSeeker.getYearOfBirth()>0)
		{
			boolean control=checkTheTerms(jobSeeker);
			if (control) {
				boolean result=CheckJobSeeker.checkJobSeekerPassword(jobSeeker);
				if (result) {
					boolean emailVerification=CheckJobSeeker.jobSeekerEmailVerification(jobSeeker);
					if(emailVerification) {
						jobSeekerDao.save(jobSeeker);
						return new SuccessResult("İş arayan kaydınız yapılmıştır.");
					}
					return new ErrorResult(jobSeeker.getEmail()+" hesabınıza gönderdiğimiz e postayı doğrulamadınız. Kayıt geçersiz.");
				}
				return new ErrorResult("Girdiğiniz bilgiler doğru değildir.İşlem başarısız.");
			}
			return new ErrorResult("Bu e mail ile veya tc kimlik  numarası ile daha önceden kayıt yapılmıştır. İşlem başarısız.");
		}
		return new ErrorResult("Lütfen boş alan bırakmayınız!");
	}
	
	private boolean checkTheTerms(JobSeeker jobSeeker) {
		List<JobSeeker> jobSeekers=jobSeekerDao.findAll();
		for (JobSeeker jobSeekerList : jobSeekers) {
			if(jobSeekerList.getEmail().equals(jobSeeker.getEmail())) {
				return false;
			}
			if(jobSeekerList.getIdentificationNumber().equals(jobSeeker.getIdentificationNumber())) {
				return false;
			}
		}
		return true;
	}
	
}
