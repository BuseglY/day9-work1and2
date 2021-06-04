package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.concretes.CheckEmployer;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"İş verenler listelendi");
	}

	@Override
	public Result add(Employer employer) {
		//if(employer.getCompanyName()!=null && employer.getEmail()!=null && employer.getPassword()!=null && employer.getRepeatPassword()!=null && employer.getPhoneNumber()!=null && employer.getWebsite()!=null)
		//{
			boolean control=checkTheEmail(employer);
		if(control) {
			boolean check=CheckEmployer.checkPassword(employer);
			if(check) {
				boolean checkEmailAndConfirmation=CheckEmployer.checkEmployerEmailVerification(employer);
				if(checkEmailAndConfirmation) {
					employerDao.save(employer);
					return new SuccessResult("İş veren kayıt edildi");
				}
				return new ErrorResult("E posta doğrulamanız yapılmamış veya personel onay vermemiştir.İşlem başarısız.");
			}
			return new ErrorResult("Şifreniz ile şifre tekrarınız aynı değildir.İşlem başarısız.");
		}
		return new ErrorResult("Bu e posta ile daha önceden kayıt gerçekleştirilmiştir.İşlem başarısız.");
		//}
		//return new ErrorResult("Tüm alanlar zorunludur");
	}
	private boolean checkTheEmail(Employer employer) {
		List<Employer> employers=employerDao.findAll();
		for (Employer employerList : employers) {
			if(employerList.getEmail().equals(employer.getEmail())) {
				return false;
			}
		}
		return true;
	}

}
