package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.db.ConnectorDB;
import com.example.demo.model.Usuario;

public class UsuarioDAO {
    
    public Boolean addUser(Usuario user) {
        try {
            Statement st=ConnectorDB.getSt();
            System.out.println("LLEGUE ACA");
            Integer cantInsert=st.executeUpdate("INSERT INTO users (nombre, apellido, email, password, fechaNacimiento, pais,terminos) VALUES ('"+user.getNombre()+"', '"+user.getApellido()+"', '"+user.getEmail()+"', '"+user.getPassword()+"', '"+user.getFechaNacimiento()+"', '"+user.getPais()+"', "+user.getTerminos()+")");
            
            Boolean insertOk=(cantInsert==1);

            return insertOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Usuario> getUsers(){
        try {
            Statement st=ConnectorDB.getSt();
            ResultSet rs=st.executeQuery("Select * from users");
            List<Usuario> users=new ArrayList<Usuario>();
            while (rs.next()) {
                // orm: mapeo relacional objeto, lo hacen framework hibernate, jpa
                Usuario us = new Usuario(rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("password"),  rs.getString("fechaNacimiento"),rs.getString("pais"), rs.getBoolean("terminos"));
                users.add(us);
            }         
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean deleteUser(Usuario u) {
        try {
            Statement st=ConnectorDB.getSt();
            System.out.println("DELETE ANTES");
            
            Integer cantDel=st.executeUpdate("DELETE FROM users WHERE email = '"+u.getEmail()+"'");
            Boolean delOk=(cantDel==1);
            return delOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean updateUser(Usuario u) {
        try {
            Statement st=ConnectorDB.getSt();
            System.out.println(u.getEmail());
            Integer cantUpdate=st.executeUpdate("UPDATE users SET " +
                "nombre = '" + u.getNombre() + "', " +
                "apellido = '" + u.getApellido() + "', " +
                "email = '" + u.getEmail() + "', " +
                "password = '" + u.getPassword() + "', " +
                "fechaNacimiento = '" + u.getFechaNacimiento() + "', " + // Suponiendo que fechaNacimiento está en formato YYYY-MM-DD
                "pais = '" + u.getPais() + "', " +
                "terminos = " + u.getTerminos() + " " +
                "WHERE email = '" + u.getEmail() + "'");
           
            Boolean updateOk=(cantUpdate==1);
            System.out.println(cantUpdate);
            return updateOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
