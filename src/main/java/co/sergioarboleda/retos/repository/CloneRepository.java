/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.repository;

import co.sergioarboleda.retos.entity.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CloneRepository {
    
    @Autowired
    private CloneCrudRepository cloneCrudRepository;
    
    //Get ALl
    public List<Clone> getAll(){
        return (List<Clone>) cloneCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Clone> getUserById(Integer id){
        return cloneCrudRepository.findById(id);
    }
    
     public Clone save(Clone clone){
        return cloneCrudRepository.save(clone);
    }
     
     public void delete (Integer id){
        cloneCrudRepository.deleteById(id);
    }

    public void deleteById (Integer id){
        cloneCrudRepository.deleteById(id);
    }
    
    public Optional <Clone> getUserById(int id){
        return cloneCrudRepository.findById(id);
    }
    
     public List<Clone> getCloneByPrice(Integer precio){
        return  cloneCrudRepository.findByPrice(precio);
    }
     
     public List<Clone> getCloneByDescription(String dc){
        return  cloneCrudRepository.findByDescriptionContains(dc);
    }
    
    
}
