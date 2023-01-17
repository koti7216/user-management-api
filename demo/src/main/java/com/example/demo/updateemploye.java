package com.example.demo;

import lombok.Data;

@Data
public class updateemploye {
    private String ename;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEname() {
        return ename;
    }
}
