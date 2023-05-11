package com.example.mp03pp03_prog;
import java.sql.*;

public class SQL {
    private String url;

    public SQL() {
        url = "jdbc:sqlite:nevera.db";
    }

    public void guardar_dades(String nom, Float preu, String descripcio, Date data_caducitat){
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "INSERT INTO productes (nom, preu, descripcio,data_caducitat) VALUES (?,?,?,?)";
            // Crear un objeto PreparedStatement y establecer los valores de los parámetros
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nom);
            pstmt.setFloat(2, preu);
            pstmt.setString(3,descripcio);
            pstmt.setDate(4,data_caducitat);
            // Ejecutar la sentencia SQL
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected");
            // Cerrar la conexión y el objeto PreparedStatement
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Crear_Taules(){
        try{
            Connection coon = DriverManager.getConnection(url);
            String sql = "CREATE TABLE productes (\n" +
                    "    nom TEXT(20),\n" +
                    "    preu FLOAT(20),\n" +
                    "    descripcio TEXT(20),\n" +
                    "    data_caducitat DATE(20),\n" +
                    ");";
            PreparedStatement pstmt = coon.prepareStatement(sql);
            int rowsAffected = pstmt.executeUpdate();

        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public void buscar_productes(String nom){
        try {
            Connection coon = DriverManager.getConnection(url);
            String sql = "SELECT * FROM productes WHERE NOM =?;";
            PreparedStatement pstmt = coon.prepareStatement(sql);
            pstmt.setString(1, nom);
            // Ejecutar la sentencia SQL
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected");
            // Cerrar la conexión y el objeto PreparedStatement
            pstmt.close();
            coon.close();
            if (rowsAffected == 1){

            }else {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
