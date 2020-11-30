/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.web.service;

//import com.zemogatest.portfolio.entity.Portfolio;
import com.zemogatest.web.dao.PortfolioDAO;
import com.zemogatest.web.exception.PortfolioNotFoundException;
import com.zemogatest.web.entity.Portfolio;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PostRemove;

/**
 *
 * @author figue
 */
@Stateless
public class PortfolioRepository {

    @Inject
    PortfolioDAO portfolioDAO;

    public PortfolioRepository() {
    }

    public PortfolioRepository(PortfolioDAO portfolioDAO) {
        this.portfolioDAO = portfolioDAO;
    }
    
    public Portfolio findPortfolio(Integer id){
        Portfolio portfolio = portfolioDAO.find(id);
        if(portfolio == null)
            throw new PortfolioNotFoundException();        
        return portfolio;
    }
    
    public Portfolio createPortfolio(Portfolio portfolio){
        return portfolioDAO.save(portfolio);
    }
    
    public Portfolio updatePortfolio(Portfolio portfolio){
        return portfolioDAO.update(portfolio);
    }
    public void updateImage(Portfolio entity) {
        Portfolio portfolio = portfolioDAO.find(entity.getIdportfolio());
        if(portfolio == null)
            throw new PortfolioNotFoundException();
        portfolio.setImageUrl(entity.getImageUrl());
        portfolioDAO.update(portfolio);
    }
            



}
