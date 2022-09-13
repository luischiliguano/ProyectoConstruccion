/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Conection {

    static Connection cn;
    static Statement st;

    public static Connection conectar() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
            cn = DriverManager.getConnection(url, "lchiliguano", "lchiliguano");
            st = cn.createStatement();
            return cn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO FUE POSIBLE CONECTARSE \n " + e);
            return null;
        }
    }

    public static Statement getStatement() throws SQLException {
        Statement st = null;
        st = conectar().createStatement();
        return st;
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        PreparedStatement ps = conectar().prepareStatement(sql);
        return ps;
    }

    public static ResultSet getResultSet(String sql) throws SQLException {
        ResultSet rs = null;
        rs = getStatement().executeQuery(sql);
        return rs;
    }

    public static void Cerrar(Connection cn) throws SQLException {
        cn.close();
    }

    public static void Cerrar(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void Cerrar(ResultSet rs) throws SQLException {
        rs.close();
    }
}
