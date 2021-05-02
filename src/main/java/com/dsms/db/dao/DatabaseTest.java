/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsms.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

/**
 *
 * @author Mahaj
 */
public class DatabaseTest {

    public static void main(String[] args) throws SQLException {
        getAllGarments();

    }

    private static void getAllGarments() throws SQLException {
        DatabaseHandler databaseHandler = DatabaseHandler.getInstance();
        ResultSet result = databaseHandler.execQuery("select * from item_entity where item_category='GARMENTS'");
        String msg = "{0}\t{1}\t{2}";
        while (result.next()) {
            String o = MessageFormat.format(msg, result.getObject("id"), result.getObject("price"), result.getObject("name"));
            System.out.println(o);
        }
    }

}
