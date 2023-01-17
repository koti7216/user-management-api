package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface employeRepository extends JpaRepository<employe, Long> {

    List<employe> findByEname(String ename);
}
