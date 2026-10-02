package com.mayraponce.eventos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mayraponce.eventos.config.conexionMySQLDatabase;


public class Main {
    public static void main(String[] args) {
        try (Connection conn = conexionMySQLDatabase.getConnection()) {
            if (conn != null) {
                System.out.println("✅ Conexión establecida correctamente.");

                // Ejemplo: ejecutar una consulta
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT NOW() AS fecha_actual");

                while (rs.next()) {
                    System.out.println("La base de datos respondió: " +
                            rs.getString("fecha_actual"));
                }
            } else {
                System.out.println("❌ No se pudo establecer la conexión.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}