/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.web.service;

import com.zemogatest.web.dao.PortfolioDAO;
import com.zemogatest.web.entity.Portfolio;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

/**
 *
 * @author figue
 */
public class PortfolioRepositoryTest {
    
    public PortfolioRepositoryTest() {
    }
    
    PortfolioDAO portfolioDAO = mock(PortfolioDAO.class);
    
    PortfolioRepository repository = null;
    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        repository = new PortfolioRepository(portfolioDAO);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of findPortfolio method, of class PortfolioRepository.
     */
    @Test
    public void testFindPortfolio() throws Exception {
        when(portfolioDAO.find(ID_PORTFOLIO)).thenReturn(new Portfolio(ID_PORTFOLIO, 0));
        Portfolio portfolio = repository.findPortfolio(ID_PORTFOLIO);
        assertEquals(ID_PORTFOLIO, portfolio.getIdportfolio().longValue());
        verify(portfolioDAO).find(ID_PORTFOLIO);
    }

    /**
     * Test of createPortfolio method, of class PortfolioRepository.
     */
    @Test
    public void testCreatePortfolio() throws Exception {
        when(portfolioDAO.save(new Portfolio(NEW_ID_PORTFOLIO, 0))).thenReturn(new Portfolio(NEW_ID_PORTFOLIO, 0));
        Portfolio portfolio = repository.createPortfolio(new Portfolio(NEW_ID_PORTFOLIO, 0));
        assertEquals(NEW_ID_PORTFOLIO, portfolio.getIdportfolio().longValue());
        verify(portfolioDAO).save(portfolio);
    }
    private static final int NEW_ID_PORTFOLIO = 111222;
//
//    /**
//     * Test of updatePortfolio method, of class PortfolioRepository.
//     */
    @Test
    public void testUpdatePortfolio() throws Exception {
        when(portfolioDAO.update(new Portfolio(ID_PORTFOLIO, 1))).thenReturn(new Portfolio(ID_PORTFOLIO, 1));
        Portfolio portfolio = repository.updatePortfolio(new Portfolio(ID_PORTFOLIO, 1));
        assertEquals(1, portfolio.getIdPortafolio());
        verify(portfolioDAO).update(portfolio);
    }
//
//    /**
//     * Test of updateImage method, of class PortfolioRepository.
//     */
//    @org.junit.Test
//    public void testUpdateImage() throws Exception {
//
//    }
    private static final int ID_PORTFOLIO = 8888;
    
}
