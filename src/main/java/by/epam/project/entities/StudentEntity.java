package by.epam.project.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="score")
	private Double score;
	
	@ManyToMany(mappedBy = "studentsEntities")
    private Collection<GroupEntity> groupsEntities;

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

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Collection<GroupEntity> getGroupsEntities() {
		return groupsEntities;
	}

	public void setGroupsEntities(Collection<GroupEntity> groupsEntities) {
		this.groupsEntities = groupsEntities;
	}
}
