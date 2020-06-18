package com.prova.segbim.dao;

import java.util.List;
import java.util.Optional;

import com.prova.segbim.entidade.Time;


public interface Dao<acao> {


	Optional<acao> get(long id); 
    
    List<acao> getAll(); 
     
    void save(acao t); 
     
    void update(acao t, String[] params); 
    
    void update(acao t, Integer[] params); 
    
    void remove(acao t);

	
}