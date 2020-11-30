/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.api.web.helper;

import com.zemogatest.web.model.TweetInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author figue
 */
@Singleton
public class TweetsHelper {

    private TwitterFactory tf;

    public List<TweetInfo> getUsrTimeline() {
        List<TweetInfo> tweetInfoList = new ArrayList<>();
        try {
            Twitter twitter = tf.getInstance();
            ResponseList<Status> results = twitter.getUserTimeline();

            for (Status tweet : results) {
                TweetInfo tweetInfo = new TweetInfo();
                tweetInfo.setId(tweet.getId());
                tweetInfo.setCreatedAt(tweet.getCreatedAt());
                tweetInfo.setPostedBy(tweet.getUser().getName());
                
                tweetInfo.setImgUrl(tweet.getUser().get400x400ProfileImageURL());
                tweetInfo.setText(tweet.getText());
                tweetInfoList.add(tweetInfo);
                
            }
        } catch (TwitterException ex) {
            Logger.getLogger(TweetsHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tweetInfoList;
    }
    
    @PostConstruct
    private void setupTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("KRy7l0v8wex3w8Sy5zThai3Ea")
                .setOAuthConsumerSecret("X2eBm0Y21kYEuR74W3Frqc2JVIizOj8Q1EVGatDsEVVEJo0ucu")
                .setOAuthAccessToken("1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja")
                .setOAuthAccessTokenSecret("tmJKqM4ORfQW6CH7wIVV8uKNpmSEmeFAP8lYwGb19uYjj");

        tf = new TwitterFactory(cb.build());
    }    
}
