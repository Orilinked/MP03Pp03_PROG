package com.example.mp03pp03_prog;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
    private String url;

    public SQL() {
        url = "jdbc:sqlite:nevera.db";
    }

    private void guardar_dades(String nom, Float preu, String descripcio, Date data_caducitat){
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "INSERT INTO productes (nom, preu, descripcio,data_caducitat) VALUES ("+nom+","+preu+","+descripcio+","+data_caducitat+")";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void Crear_Taules(){
        try{
            Connection coon = DriverManager.getConnection(url);
            String sql = "CREATE TABLE productes (\n" +
                    "    nom TEXT(20),\n" +
                    "    preu FLOAT(20),\n" +
                    "    descripcio TEXT(20),\n" +
                    "    data_caducitat DATE(20),\n" +
                    ");";
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

}
