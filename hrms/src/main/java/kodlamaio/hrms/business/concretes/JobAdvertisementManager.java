package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(),"İş ilanları listelendi");
	}
	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.ASC,"publicationDate");//publicationDate e göre a dan z ye sıralar.
		List<JobAdvertisement> jobs=jobAdvertisementDao.findAll();
		for (JobAdvertisement jobList : jobs) {
			if(jobList.isActive()==true) {
				return new SuccessDataResult <List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),"Başarılı");
			}
			
		}return new ErrorDataResult<List<JobAdvertisement>>("Aktif olan iş ilanı bulunmamaktadır");
	}
	@Override
	public DataResult<List<JobAdvertisement>> getByCompanyNameAndIsActive(String companyName,boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByCompanyNameAndIsActive(companyName,isActive),"Firmaya göre aktif iş ilanları listelendi");
	}

}
