package kodlamaio.hrms.business.concretes;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.adapters.CloudinaryImageServiceAdapters;
import kodlamaio.hrms.adapters.abstracts.CloudinaryImageService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobSeekerCv;

@Service
public class ImageManager implements ImageService  {

	private ImageDao imageDao;
	private CloudinaryImageService imageService;
	
	@Autowired
	public ImageManager(ImageDao imageDao, CloudinaryImageServiceAdapters imageService) {
		this.imageDao = imageDao;
		this.imageService=imageService;
	}

	@Override
	public Result upload(int id, MultipartFile file) {
		@SuppressWarnings("unchecked")
		Map<String,String> hey=(Map<String,String>)this.imageService.upload(file).getData();
		
		JobSeekerCv jobSeeker=new JobSeekerCv();
		Image image =new Image();
		jobSeeker.setId(id);
		image.setJobSeekerCv(jobSeeker);
		
		 image.setUrl(hey.get("url"));
	
		this.imageDao.save(image);
		return new SuccessResult();
	}

}
