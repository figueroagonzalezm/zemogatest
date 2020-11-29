/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.api.web;

import com.zemogatest.web.entity.Portfolio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author figue
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("portfolioPU");
        EntityManager em = emf.createEntityManager();
        Portfolio portfolio = em.find(Portfolio.class, 8888);
//    entityManager.getTransaction().begin();

//    entityManager.persist(new Employee());
//    entityManager.getTransaction().commit();
        //  entityManager.close();
        //  entityManagerFactory.close();        //Portfolio portfolio = em.find(Portfolio.class, 1);
        System.out.println("descripcion: " + portfolio.getDescription());
    }
    
}
