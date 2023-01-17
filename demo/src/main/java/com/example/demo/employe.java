package com.example.demo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employe")
public class employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;
    @Column(name = "ename")
    private String ename;

    public Long getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
