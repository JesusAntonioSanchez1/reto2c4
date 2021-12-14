/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.repository;


import co.sergioarboleda.retos.entity.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Desarrollo
 */
public interface CloneCrudRepository extends MongoRepository<Clone, Integer>{
    
    public Optional<Clone> findById(String id);
    
    public List<Clone> findByPrice(Integer precio);
    
    public List<Clone> findByDescriptionContains(String dc);
    
    
    
}
