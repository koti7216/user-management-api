package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/1st")
public class DemoController {
    @Autowired
    employeService serv;

    @PostMapping("/2nd")
    public void epost(@RequestBody employe emp) {
        serv.post(emp);
    }
   @GetMapping("/3rd")
    public List<employe> eget(){
        return serv.get();
   }

   @PutMapping ("/4th/{id}")
    public employe eupdate(@PathVariable Long id,@RequestBody Updateemp updateemp) {
        try{
            return serv.update(id,updateemp);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "record Not Found", e);
        }
   }

   @DeleteMapping("/5th/{id}")
    public void edelete(@PathVariable Long id) {
        try{
        serv.delete(id);}
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"bad request",e);
        }
   }
   @GetMapping("/6th/{id}")
   public employe egetbyId(@PathVariable Long id){

        return serv.getembyId(id);}

    @GetMapping("7th/{ename}")
    public List<employe> egetEname(@PathVariable String ename){
        return serv.getbyename(ename);
    }


    }

