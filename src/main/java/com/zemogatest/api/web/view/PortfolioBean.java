/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.api.web.view;

import com.zemogatest.api.web.helper.TweetsHelper;
import com.zemogatest.web.entity.Portfolio;
import com.zemogatest.web.service.PortfolioRepository;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author figue
 */
@Named
@Dependent
public class PortfolioBean {

    private Portfolio portfolio;
    
    @Inject
    TweetsHelper tweets;
    
    @Inject
    PortfolioRepository repository;
    
    @PostConstruct
    private void initializeData(){
        portfolio = repository.find(8888);
    }
    
    public PortfolioBean() {
        
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
    
    
}
