package br.com.eduardo.springcrud.services;


import br.com.eduardo.springcrud.model.Game;
import br.com.eduardo.springcrud.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class GameServiceV2 {

    @Autowired
    private GameRepository repository;

    // version 2 //
    @Autowired
    private EntityManager em;
    // version 2 //

    public Game save(Game person){
        // Version 2 //
        person.setRegisterdate(new Date());
        // --------- //
        return repository.save(person);
    }

    public Game findById(long id) throws Exception{
        return repository.findById(id).orElseThrow( () -> new Exception("Not Found!"));
    }

    public List<Game> findALL(){
        return  repository.findAll();
    }

    public Game update(Game person) throws Exception {
        Game p = repository.findById(person.getId()).orElseThrow( () -> new Exception("Not found"));
        p.setname(person.getname());
        p.setdeveloper(person.getdeveloper());
        p.setyear(person.getyear());
        //version 2//
        p.setplatform(person.getplatform());
        //---------//
        return repository.save(p);
    }

    public void delete(long id) throws Exception {
        Game p = repository.findById(id).orElseThrow( () -> new Exception("Not Found"));
        repository.delete(p);
    }

    // Version 2 //
    public List<Game> listByName(String name){
     String hql = "from Game where name like :name order by name";
        Query query = em.createQuery(hql);
        query.setParameter("name", name + "%");
        List<Game>game = query.getResultList();
        return game;
    }
    // -------- //

}
