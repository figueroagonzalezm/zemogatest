/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.web.view;

import com.zemogatest.api.web.helper.TweetsHelper;
import com.zemogatest.web.entity.Portfolio;
import com.zemogatest.web.model.TweetInfo;
import com.zemogatest.web.service.PortfolioRepository;
import java.util.List;
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

    private static final int USER_PORTFOLIO_ID = 8888;
    private Portfolio portfolio;
    private List<TweetInfo> tweetInfoList;
    
    @Inject
    TweetsHelper tweets;
    
    @Inject
    PortfolioRepository repository;
    
    @PostConstruct
    private void initializeData(){
        portfolio = repository.findPortfolio(USER_PORTFOLIO_ID);
        tweetInfoList = tweets.getUsrTimeline();
    }
    
    public PortfolioBean() {
        
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public List<TweetInfo> getTweetInfoList() {
        return tweetInfoList;
    }

    public void setTweetInfoList(List<TweetInfo> tweetInfoList) {
        this.tweetInfoList = tweetInfoList;
    }
    
    
}
