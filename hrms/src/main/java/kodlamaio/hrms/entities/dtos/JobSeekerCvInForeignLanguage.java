package kodlamaio.hrms.entities.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import kodlamaio.hrms.entities.concretes.JobSeekerCv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seeker_foreign_languages")
@Entity
public class JobSeekerCvInForeignLanguage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="foreign_languages")
	@NotBlank
	@NotNull
	private String foreignLanguage;
	
	@Column(name="language_level")
	private String languageLevel;
	
	@ManyToOne()
	@JoinColumn(name="id",insertable=false, updatable=false)
	private JobSeekerCv jobSeekerCv;
	

}
