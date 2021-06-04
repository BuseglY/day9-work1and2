package kodlamaio.hrms.adapters.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface CloudinaryImageService {

	DataResult<Map> upload(MultipartFile file);
}
