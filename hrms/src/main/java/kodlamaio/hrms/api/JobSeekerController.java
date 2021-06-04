package kodlamaio.hrms.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCvService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.JobSeekerCv;

@RestController
@RequestMapping("/api/jobSeeker")
public class JobSeekerController {
	
	private JobSeekerService jobSeekerService; 
	private JobSeekerCvService jobSeekerCvService;
	
	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService,JobSeekerCvService jobSeekerCvService) {
		super();
		this.jobSeekerService=jobSeekerService;
		this.jobSeekerCvService=jobSeekerCvService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getall(){
		return this.jobSeekerService.getAll();
	}
	
	@GetMapping("/getallCv")
	public DataResult<JobSeekerCv> getallCv(@RequestParam int id){
		return this.jobSeekerCvService.getAll(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.add(jobSeeker);
	}
	
	@GetMapping("/getAllDescGraduationYear")
	public DataResult<List<JobSeekerCv>> getAllSortedGraduationDate() {
		return this.jobSeekerCvService.getAllSortedGraduationDate();
	}
	
	@GetMapping("/getAllDescExperienceDateYear")
	public DataResult<List<JobSeekerCv>> getAllSortedExperienceDateYear() {
		return this.jobSeekerCvService.getAllSortedExperienceDateYear();
	}
	

}
