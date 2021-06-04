package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import kodlamaio.hrms.entities.dtos.JobSeekerCvInProgrammingLanguages;
import kodlamaio.hrms.entities.dtos.JobSeekerCvInForeignLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@Table(name="job_seeker_cv")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerCvInForeignLanguages","jobSeekerCvInProgrammingLanguages","images"})
public class JobSeekerCv {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@Column(name="id")
	//private int jobSeekerId;
	
	@Column(name="school_name")
	@NotBlank
	@NotNull
	private String schoolName;
	
	@Column(name="school_department")
	private String schoolDepartment;
	
	@Column(name="school_graduation_year")
	private short schoolGraduationYear;
	
	@Column(name="business_name")
	private String businessName;
	
	@Column(name="position_at_work")
	private String positionAtWork;
	
	@Column(name="start_date_of_work")
	private LocalDate startDateOfWork;
	
	@Column(name="finish_date_of_work")
	private LocalDate finishDateOfWork;
	
	@Column(name="github_address")
	private String githubAddress;
	
	@Column(name="linkedin_address")
	private String linkedinAddress;
	
	@Column(name="cover_letter")
	@NotBlank
	@NotNull
	private String coverLetter;
	
	@OneToOne()
	@JoinColumn(name="id")
	private JobSeeker jobSeeker;
	
	@OneToMany(mappedBy="jobSeekerCv")
	private List<JobSeekerCvInForeignLanguage> jobSeekerCvInForeignLanguages;
	
	@OneToMany(mappedBy="jobSeekerCv")
	private List<JobSeekerCvInProgrammingLanguages> jobSeekerCvInProgrammingLanguages;
	
	@OneToMany(mappedBy="jobSeekerCv")
	private List<Image> images;
}
