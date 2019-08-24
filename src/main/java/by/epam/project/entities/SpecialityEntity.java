package by.epam.project.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "speciality")

public class SpecialityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "faculty_id")
    private FacultyEntity faculty;

    @OneToMany(mappedBy = "speciality", fetch = FetchType.LAZY)
    private Collection<SpecialityOtdelenieEntity> tenants;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "speciality_otdelenie",
            joinColumns = @JoinColumn(name = "speciality_id"),
            inverseJoinColumns = @JoinColumn(name = "otdelenie_id")
    )
    private Collection<OtdelenieEntity> otdelenieEntities;

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

    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }

    public Collection<SpecialityOtdelenieEntity> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<SpecialityOtdelenieEntity> tenants) {
        this.tenants = tenants;
    }

    public Collection<OtdelenieEntity> getOtdelenieEntities() {
        return otdelenieEntities;
    }

    public void setOtdelenieEntities(Collection<OtdelenieEntity> otdelenieEntities) {
        this.otdelenieEntities = otdelenieEntities;
    }
}
