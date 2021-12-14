/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.controller;

import co.sergioarboleda.retos.entity.Clone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.sergioarboleda.retos.service.CloneService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/clone")
public class CloneController {
    
    @Autowired
    private CloneService cloneService;
    
    @GetMapping("/all")
    public List<Clone> getUsers(){
        return cloneService.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone){
        return cloneService.save(clone);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update (@RequestBody Clone clone){
        return cloneService.update(clone);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer delete(@PathVariable("id") Integer id){
       return cloneService.deleteById(id);
    }
    
    @GetMapping("/{id}")
    public Clone getUser(@PathVariable("id") Integer id){
        return cloneService.getUserById(id);
    }
    
     @GetMapping("/price/{precio}")
    public List<Clone> getCloneByPrice(@PathVariable("precio") Integer precio){
        return cloneService.getCloneByPrice(precio);
    }
    
    @GetMapping("/description/{dc}")
    public List<Clone> getCloneByDescription(@PathVariable("dc") String dc){
        return cloneService.getCloneByDescription(dc);
    }
    
    
    
}
