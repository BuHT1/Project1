package by.epam.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;

@Entity
@Table(name = "speciality_otdelenie", uniqueConstraints = @UniqueConstraint(
        columnNames = {
                "speciality_id",
                "otdelenie_id"
        },
        name = "speciality_otdelenie_unique_constraint"))
public class SpecialityOtdelenieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "speciality_id")
    private SpecialityEntity speciality;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "otdelenie_id")
    private OtdelenieEntity otdelenie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpecialityEntity getSpeciality() {
        return speciality;
    }

    public void setSpeciality(SpecialityEntity speciality) {
        this.speciality = speciality;
    }

    public OtdelenieEntity getOtdelenie() {
        return otdelenie;
    }

    public void setOtdelenie(OtdelenieEntity otdelenie) {
        this.otdelenie = otdelenie;
    }
}
