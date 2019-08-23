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
import javax.persistence.Table;

@Entity
@Table(name = "groupss")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "students_groups",
            joinColumns = @JoinColumn(name = "groupss_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Collection<StudentEntity> studentsEntities;

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

    public Collection<StudentEntity> getStudentsEntities() {
        return studentsEntities;
    }

    public void setStudentsEntities(Collection<StudentEntity> studentsEntities) {
        this.studentsEntities = studentsEntities;
    }
}
