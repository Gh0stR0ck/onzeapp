package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    private boolean next;

    public static void main(String[] args ) throws SQLException {
        Database db = new Database("capgemini-academy.ck17qz3qdemp.eu-west-1.rds.amazonaws.com", "hotel5", "capgemini", "hotel5");
        db.open();
        ResultSet resultSet;

        resultSet = db.query("SELECT * FROM customers WHERE `name`='Sinterklaas';");
        while(resultSet.next()) {
            System.out.println("Sinterklaar woont op " + resultSet.getString("country") + resultSet.getString("city") + " in de straat " + resultSet.getString("address") );
        }

        resultSet = db.query("SELECT count(id) FROM customers;");
        while(resultSet.next()) {
            System.out.println( "Aantal klanten = " + resultSet.getInt("count(id)"));
        }

        resultSet = db.query("SELECT count(id) FROM customers WHERE `country`='Nepal';");
        while(resultSet.next()) {
            System.out.println( "Aantal klanten in Nepal = " + resultSet.getInt("count(id)"));
        }

        resultSet = db.query("SELECT count(id) FROM customers WHERE `country`='Sint Maarten';");
        while(resultSet.next()) {
            System.out.println( "Aantal klanten in Sint Maarten = " + resultSet.getInt("count(id)"));
        }


        for(int i = 0; i < 4; i++){

            char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int j = 0; j < 20; j++) {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            String output = sb.toString();
            db.queryExecute("INSERT INTO customers (`name`, `address`, `postal_code`,`city`,`country`) VALUES ('" + output + "', 'Reykjavikplein 1,', '3543 KA','Utrecht','Nederland');");
        }



        /* resultSet = db.query("SELECT * FROM customers;"); */

        /*while(resultSet.next()) {
            System.out.print(resultSet.getInt("id") + " ");
            System.out.print(resultSet.getString("name") + " ");
            System.out.print(resultSet.getString("address") + " ");
            System.out.print(resultSet.getString("postal_code") + " ");
            System.out.println(resultSet.getString("city") + " ");
        }*/

        resultSet.close();

        db.close();


        //SpringApplication.run(App.class, args);
    }
}

