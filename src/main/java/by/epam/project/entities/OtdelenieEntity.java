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
}
