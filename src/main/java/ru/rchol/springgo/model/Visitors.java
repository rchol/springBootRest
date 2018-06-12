package ru.rchol.springgo.model;

import javax.persistence.*;


@Entity
@Table(name="visitors")
public class Visitors {
    private Long id;
    private String name;

    public Visitors(){

    }


    public Visitors (Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Visitors (String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

