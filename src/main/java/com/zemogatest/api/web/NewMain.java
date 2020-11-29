/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.api.web;

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("KRy7l0v8wex3w8Sy5zThai3Ea")
                    .setOAuthConsumerSecret("X2eBm0Y21kYEuR74W3Frqc2JVIizOj8Q1EVGatDsEVVEJo0ucu")
                    .setOAuthAccessToken("1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja")
                    .setOAuthAccessTokenSecret("tmJKqM4ORfQW6CH7wIVV8uKNpmSEmeFAP8lYwGb19uYjj");
            
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            
            
            //ResponseList<Status> results = twitter.getUserTimeline();
            ResponseList<Status> results = twitter.getMentionsTimeline();
            
            for (Status result : results) {
                
                System.out.println(result.getUser().getName());
                System.out.println(result.getUser().getScreenName());
                System.out.println(result.getUser());
                System.out.println(result.getUser().get400x400ProfileImageURL());
                System.out.println(result.getCreatedAt());
                System.out.println(result.getText());
            }
//        try {
//
//            String current = new java.io.File(".").getCanonicalPath();
//            System.out.println("Current dir:" + current + "\\WEB-INF\\classes\\credentials.json");
//            String credentialsPath = current + "\\WEB-INF\\classes\\credentials.json";
//            
//            //TwitterClient twitterClient = new TwitterClient();
//
//            TwitterClient twitterClient = new TwitterClient(TwitterClient.OBJECT_MAPPER
//                    .readValue(new File(credentialsPath), TwitterCredentials.class));
//            
//            List<Tweet> tweets = twitterClient.getFavorites("1332895371668959235", 10);
//            
//            for (Tweet tweet : tweets) {
//                System.out.println(tweet.getCreatedAt());
//                System.out.println(tweet.getText());
//                System.out.println(tweet.getUser());
//                
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (TwitterException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
