/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.service;

import co.sergioarboleda.retos.entity.Clone;
import co.sergioarboleda.retos.repository.CloneRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloneService {
    
    @Autowired
    private CloneRepository cloneRepository;
    
    public List<Clone> getAll(){
        return cloneRepository.getAll();
    }
  
    public Optional<Clone> getUser(int id){
        return cloneRepository.getUserById(id);
    }
    
     public Clone save(Clone clone){
        if(clone.getBrand() == null || clone.getProcesor()==null || clone.getOs()==null
                || clone.getDescription()==null || clone.getMemory()==null || clone.getHardDrive()==null
                || clone.getPhotography()==null){
            return clone;
        }else{
               Optional<Clone> existUser2 = cloneRepository.getUserById(clone.getId());
                    if(existUser2.isEmpty()){
                        return cloneRepository.save(clone);
                    }else{
                        return clone;
                    }
             
            }
        }
     
     
     public Clone update(Clone clone){
        if(clone.getId()!=null){
            Optional<Clone> cloneExist = cloneRepository.getUserById(clone.getId());
            if(cloneExist.isPresent()){
                if(clone.getBrand()!=null){
                    cloneExist.get().setBrand(clone.getBrand());
                }
                if(clone.getProcesor()!=null){
                    cloneExist.get().setProcesor(clone.getProcesor());
                }
                if(clone.getOs()!=null){
                    cloneExist.get().setOs(clone.getOs());
                }
                if(clone.getDescription()!=null){
                    cloneExist.get().setDescription(clone.getDescription());
                }
                if(clone.getMemory()!=null){
                    cloneExist.get().setMemory(clone.getMemory());
                }
                if(clone.getHardDrive()!=null){
                    cloneExist.get().setHardDrive(clone.getHardDrive());
                }
                if(clone.getPhotography()!=null){
                    cloneExist.get().setPhotography(clone.getPhotography());
                }
                
                 if(clone.getQuantity()!=0){
                    cloneExist.get().setQuantity(clone.getQuantity());
                }
                 
                 if(clone.getPrice()!=0){
                    cloneExist.get().setPrice(clone.getPrice());
                }
                return cloneRepository.save(cloneExist.get());
            }else{
                return clone;
            }
        }else{
            return clone;
        }
    }
     
     
     
     
     public Integer deleteById(Integer id){
        Optional<Clone> clone = cloneRepository.getUserById(id);
        if(clone.isPresent()){
            cloneRepository.deleteById(id);
            return null;
        }else{
            return id;
        }
    }
     
     public Clone getUserById(Integer id){
        /*Optional<User> usuario = repository.getUserById(id);
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            return  new User;
        }*/
        return cloneRepository.getUserById(id).orElse(new Clone());
    }
     
      public List<Clone> getCloneByPrice(Integer precio){
        return cloneRepository.getCloneByPrice(precio);
    }
      
      public List<Clone> getCloneByDescription(String dc){
        return cloneRepository.getCloneByDescription(dc);
    }
   
}
