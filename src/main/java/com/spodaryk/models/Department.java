package com.spodaryk.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "head_of_department_id")
    private int headOfDepartmentId;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "department_lector",
            joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "lector_id", referencedColumnName = "id", nullable = false))
    private List<Lector> lectors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeadOfDepartmentId() {
        return headOfDepartmentId;
    }

    public void setHeadOfDepartmentId(int headOfDepartmentId) {
        this.headOfDepartmentId = headOfDepartmentId;
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headOfDepartmentId=" + headOfDepartmentId +
                ", lectors=" + lectors +
                '}';
    }
}
