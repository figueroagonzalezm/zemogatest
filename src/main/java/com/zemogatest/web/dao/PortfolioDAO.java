/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.web.dao;

import com.zemogatest.web.entity.Portfolio;
import com.zemogatest.web.exception.PortfolioNotFoundException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PostRemove;

/**
 *
 * @author figue
 */
@Stateless
public class PortfolioDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("portfolioPU");

    
    public Portfolio find(Integer id){
        EntityManager em = emf.createEntityManager();
        try {
            Portfolio portfolio =  em.find(Portfolio.class, id);
            return portfolio;            
        } finally {
            em.close();
        }
    }
    
    public Portfolio save(Portfolio portfolio){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(portfolio);
            em.getTransaction().commit();
            return portfolio;
        } finally {
            em.close();
        }
    }
    
    public Portfolio update(Portfolio portfolio){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(portfolio);
            em.getTransaction().commit();
            return portfolio;
        } finally {
            em.close();
        }
    }
            
    @PostRemove
    private void closeAll() {
        //close entity manager factory
        emf.close();
    }    

}
