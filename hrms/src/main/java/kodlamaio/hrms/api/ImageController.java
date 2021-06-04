package kodlamaio.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.business.abstracts.ImageService;

@RestController
@RequestMapping(value="/api/image")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
    	super();
        this.imageService = imageService;
    }

    @PostMapping(value="/add")
    public ResponseEntity<?> add(@RequestParam(value="id") int id ,@RequestParam(value="file") MultipartFile file) {
        return ResponseEntity.ok(this.imageService.upload(id,file));
    }

}
