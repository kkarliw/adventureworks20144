package org.example.java;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://relational.fel.cvut.cz:3306/AdventureWorks2014?useSSL=false&serverTimezone=UTC";
        String user = "guest";
        String password = "ctu-relational";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver MySQL cargado correctamente.");

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                System.out.println("✅ Conexión exitosa a la base AdventureWorks2014.");

                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("SHOW TABLES")) {
                    System.out.println(" 👁️ Tablas disponibles en AdventureWorks2014:");
                    while (rs.next()) {
                        System.out.println(" - " + rs.getString(1));
                    }
                }
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("DESCRIBE Customer")) {
                    System.out.println(" ⭕ Estructura de Customer:");
                    while (rs.next()) {
                        System.out.println(rs.getString("Field") + " - " + rs.getString("Type"));
                    }
                }
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("DESCRIBE Person")) {
                    System.out.println("🔵 Estructura de Person:");
                    while (rs.next()) {
                        System.out.println(rs.getString("Field") + " - " + rs.getString("Type"));
                    }
                }

                String sql1 = "SELECT BusinessEntityID, FirstName, LastName FROM Person WHERE LastName LIKE ? LIMIT 10";
                try (PreparedStatement ps = conn.prepareStatement(sql1)) {
                    ps.setString(1, "A%");
                    ResultSet rs = ps.executeQuery();
                    System.out.println("🅰️ Personas con apellido que empieza en 'A':");
                    while (rs.next()) {
                        System.out.println(rs.getInt("BusinessEntityID") + " - " +
                                rs.getString("FirstName") + " " + rs.getString("LastName"));
                    }
                }
                String sql2 = "SELECT BusinessEntityID, Rate FROM EmployeePayHistory WHERE Rate > ? LIMIT 10";
                try (PreparedStatement ps = conn.prepareStatement(sql2)) {
                    ps.setDouble(1, 40.0);
                    ResultSet rs = ps.executeQuery();
                    System.out.println("🅱️ Empleados con tarifa mayor a 40:");
                    while (rs.next()) {
                        System.out.println(rs.getInt("BusinessEntityID") + " - " + rs.getDouble("Rate"));
                    }
                }
                String sql3 = "SELECT CustomerID, AccountNumber FROM Customer LIMIT 10";
                try (PreparedStatement ps = conn.prepareStatement(sql3);
                     ResultSet rs = ps.executeQuery()) {
                    System.out.println("©️ Primeros 10 clientes:");
                    while (rs.next()) {
                        System.out.println(rs.getInt("CustomerID") + " - " + rs.getString("AccountNumber"));
                    }
                }
                String sql4 = "SELECT ProductID, Name, ListPrice FROM Product WHERE ListPrice > ? LIMIT 10";
                try (PreparedStatement ps = conn.prepareStatement(sql4)) {
                    ps.setDouble(1, 1000.0);
                    ResultSet rs = ps.executeQuery();
                    System.out.println("🪙 Productos con precio mayor a 1000:");
                    while (rs.next()) {
                        System.out.println(rs.getInt("ProductID") + " - " +
                                rs.getString("Name") + " - $" + rs.getDouble("ListPrice"));
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: no se encontró el driver.");
        } catch (SQLException e) {
            System.out.println("❌ Error en la conexión o consulta:");
            Logger.getLogger(JDBC1.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
