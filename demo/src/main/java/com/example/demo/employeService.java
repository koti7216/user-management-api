package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class employeService {
    @Autowired
    employeRepository employeRepo;


    public void post(employe emplo){

        employeRepo.save(emplo);

    }

    public List<employe> get() {
        return employeRepo.findAll();
    }

    public employe update(Long id, Updateemp EN) {
        employe emploi=null;
        try {
            emploi = employeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
            emploi.setEname(EN.getEname());
            employeRepo.save(emploi);
        } catch (Exception e) {
            System.out.println(e);
            throw new EntityNotFoundException("record not found");
        }
        return emploi;
    }

    public void delete(Long id) {
        try {
            employeRepo.deleteById(id);
        }
        catch(Exception e){
            System.out.println(e);
            throw new EntityNotFoundException("bad request");
        }
    }

    public employe getembyId(Long id) {
        employe em=null;
        try{
        em=employeRepo.findById(id).orElseThrow(EntityNotFoundException::new);}
        catch(Exception e){
            System.out.println(e);
            throw new EntityNotFoundException("no record for id :"+id);
        }
        return em;
    }

    public List<employe> getbyename(String ename) {
        return employeRepo.findByEname(ename);
    }
}


