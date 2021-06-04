package kodlamaio.hrms.adapters;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapters {

	
	public boolean checkRealJobSeeker(JobSeeker jobSeeker) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		boolean sonuc;
		try {
			sonuc=client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentificationNumber()), 
			jobSeeker.getFirstName().toUpperCase(), jobSeeker.getLastName().toUpperCase(),
			jobSeeker.getYearOfBirth());	
			return sonuc;
		}
	       catch(Exception e)
	       {
	    	   return false;
	       }
	}

}
