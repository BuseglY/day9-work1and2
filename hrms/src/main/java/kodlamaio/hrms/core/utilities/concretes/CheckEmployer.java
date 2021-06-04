package kodlamaio.hrms.core.utilities.concretes;

import kodlamaio.hrms.entities.concretes.Employer;

public class CheckEmployer{
	
	public static boolean checkPassword(Employer employer) {
		//if(employer.getPassword().equals(employer.getRepeatPassword())) {
			return true;
		//}
		//return false;
	}
	
	public static boolean checkEmployerEmailVerification(Employer employer) {
		if(true) {//eposta doğrulaması yapıldı
			if(true) {//HRMS peresonelinin(bizim) onayımız gerçekleştirildi 
				return true;
			}
		}
		return false;
	}

}
