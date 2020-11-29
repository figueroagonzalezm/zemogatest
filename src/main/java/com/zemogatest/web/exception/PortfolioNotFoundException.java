/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.web.exception;

/**
 *
 * @author figue
 */
public class PortfolioNotFoundException extends RuntimeException {

    public PortfolioNotFoundException() {
    }
    
    public PortfolioNotFoundException(String message) {
        super(message);
    }    
}
