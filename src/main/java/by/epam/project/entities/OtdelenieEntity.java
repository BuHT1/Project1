package by.epam.project.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "otdelenie")
public class OtdelenieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "otdelenie", fetch = FetchType.EAGER)
    private Collection<SpecialityOtdelenieEntity> allSpecialityOtdelenie;
	
	@ManyToMany(mappedBy = "otdelenieEntities")
    private Collection<SpecialityEntity> specialityEntities;

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

	public Collection<SpecialityOtdelenieEntity> getAllSpecialityOtdelenie() {
		return allSpecialityOtdelenie;
	}

	public void setAllSpecialityOtdelenie(Collection<SpecialityOtdelenieEntity> allSpecialityOtdelenie) {
		this.allSpecialityOtdelenie = allSpecialityOtdelenie;
	}

	public Collection<SpecialityEntity> getSpecialityEntities() {
		return specialityEntities;
	}

	public void setSpecialityEntities(Collection<SpecialityEntity> specialityEntities) {
		this.specialityEntities = specialityEntities;
	}

	@Override
	public String toString() {
		return "OtdelenieEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
