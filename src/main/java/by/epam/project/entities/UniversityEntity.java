package by.epam.project.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "university")
public class UniversityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name="name")
	private String name;

	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
	private Collection<FacultyEntity> faculties;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<FacultyEntity> getFaculties() {
		return faculties;
	}

	public void setFaculties(Collection<FacultyEntity> faculties) {
		this.faculties = faculties;
	}
}
