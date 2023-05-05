package com.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Manager {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.load(Manager.class.getResourceAsStream("/db.properties"));

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            con = DriverManager.getConnection(props.getProperty("db.url"),props.getProperty("db.username"),props.getProperty("db.password"));
            st = con.createStatement();
            rs = st.executeQuery("select name,role,country,amount,team from player");
            while (rs.next()){
                String name = rs.getString("name");
                String role = rs.getString("role");
                String country = rs.getString("country");
                double amount = rs.getDouble("amount");
                String team = rs.getString("team");
                System.out.println(name+","+role+","+country+","+amount+","+team);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(rs!=null){
                    rs.close();
                    if(st!=null){
                        st.close();
                        if(con!=null){
                            con.close();
                        }
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
