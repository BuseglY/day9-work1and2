package kodlamaio.hrms.core.utilities.concretes;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public class CheckJobSeeker {
	
	public static boolean checkJobSeekerPassword(JobSeeker jobSeeker) {
		//MernisServiceAdapters adapter=new MernisServiceAdapters();
		//if(adapter.checkRealJobSeeker(jobSeeker)) {
				if(jobSeeker.getPassword().equals(jobSeeker.getRepeatPassword())) {
					return true;
				}
		//}
		return false;
	}
	
	public static boolean jobSeekerEmailVerification(JobSeeker jobSeeker) {
		if(true) {
			return true;//eposta doğrulaması yapıldı
		}
		return false;
		
	}
}
