package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.Result;

public interface ImageService {
	Result upload (int id,MultipartFile file);
	 
}
