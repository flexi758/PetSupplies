/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.petsupplies;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AKDENIS1
 */
@Stateless
@ManagedBean(name = "productBean")
@SessionScoped
public class ProductBean {

    private static final String _URL = "jdbc:mysql://localhost:3306/petsuppliesdb";
    private static final String _USER = "root";
    private static final String _PASSWORD = "root";

    public List<Product> getProductList() {
        List<Product> list = new ArrayList<Product>();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(_URL, _USER, _PASSWORD);
            String sql = "SELECT * FROM PRODUCT";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product prd = new Product();
                prd.setId(rs.getInt("id"));
                prd.setName(rs.getString("name"));
                prd.setPrice(rs.getBigDecimal("price"));
                prd.setDescription(rs.getString("description"));
                list.add(prd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
