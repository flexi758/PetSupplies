/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.petsupplies;

import javax.ejb.Stateless;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AKDENIS1
 */
@Stateless
@ManagedBean(name = "productBean")
@SessionScoped
public class ProductBean {
@PersistenceContext
private EntityManager em;

    public List<Product> getProductList() {
        List list = em.createNamedQuery("Product.findAll").getResultList();
        return list;
        }
}
