/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.api.web.api;

import com.zemogatest.web.entity.Portfolio;
import javax.ws.rs.PathParam;

/**
 *
 * @author figue
 */

public interface IPortfolioAPI {


    public Portfolio create(Portfolio entity);


    public void edit(@PathParam(value = "id") Integer id, Portfolio entity);



    public Portfolio find(@PathParam(value = "id") Integer id);
    
}
