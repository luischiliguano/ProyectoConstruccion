/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conection;

import Persistence.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class PlayerConection {

    static Connection con;
    static Statement st;
    static ResultSet rst;
    static PreparedStatement pst;

    public void Mostrar(JTable tabla, String cadena) throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nick");
        dtm.addColumn("ID");

        String consulta = "select * from PLAYER where PLAYER_ID like '" + cadena + "%'";
        con = Conection.conectar();
        st = Conection.getStatement();
        rst = Conection.getResultSet(consulta);

        String filas[] = new String[2];

        while (rst.next()) {
            filas[0] = rst.getString(1);
            filas[1] = rst.getString(2);

            dtm.addRow(filas);
        }
        tabla.setModel(dtm);
    }

    public boolean Insertar(Player player) throws SQLException {
        boolean r = false;
        String sql = "INSERT INTO PLAYER (NICK,PASSWORD)values (?,?)";
        try {
            con = Conection.conectar();
            st = Conection.getStatement();
            pst = Conection.getPreparedStatement(sql);
            pst.setString(1, player.getNick());
            pst.setString(2, player.getPassword());
            pst.executeUpdate();

        } finally {
            if (pst != null) {
                Conection.Cerrar(pst);
            }
            if (con != null) {
                Conection.Cerrar(con);
            }
        }
        return r;
    }

    public String ObtenerPassword(String nick) {
        String password = "";
        String sql = "SELECT PASSWORD FROM PLAYER WHERE NICK = '" + nick + "'";
        try {
            rst = Conection.getResultSet(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            while (rst.next()) {
                password = rst.getString("PASSWORD");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return password;
    }

    public String ObtenerNick(String nick) {
        String nickName = "";
        String sql = "SELECT NICK FROM PLAYER WHERE NICK = '" + nick + "'";
        try {
            rst = Conection.getResultSet(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            while (rst.next()) {
                nickName = rst.getString("NICK");
                //System.out.print("xdd");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        System.out.print(nickName);
        return nickName;

    }

    public Integer ModificarCurrentActive1(Player player) throws SQLException {
        Integer r = null;
        try {
            String sql = "update PLAYER set CURRENT_ACTIVE = ? where NICK = ?";
            con = Conection.conectar();
            pst = Conection.getPreparedStatement(sql);
            pst.setInt(1, 1); //current Active = 1
            pst.setString(2, player.getNick());
            r = pst.executeUpdate();

            if (r >= 1) {
                JOptionPane.showMessageDialog(null, "Modificado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR!", "ATENCIÓN!", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            if (pst != null) {
                Conection.Cerrar(pst);
            }
            if (con != null) {
                Conection.Cerrar(con);
            }
        }
        return r;
    }

    public Integer ModificarCurrentActive0(String nick) throws SQLException {
        Integer r = null;
        try {
            String sql = "update PLAYER set CURRENT_ACTIVE = ? where NICK = ?";
            con = Conection.conectar();
            pst = Conection.getPreparedStatement(sql);
            pst.setInt(1, 0); //current Active = 0
            pst.setString(2, nick);
            r = pst.executeUpdate();

            if (r >= 1) {
                JOptionPane.showMessageDialog(null, "Modificado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR!", "ATENCIÓN!", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            if (pst != null) {
                Conection.Cerrar(pst);
            }
            if (con != null) {
                Conection.Cerrar(con);
            }
        }
        return r;
    }

    public String ObtenerNickCurrentActive(int currentActive) {
        String nickName = "";
        String sql = "SELECT NICK FROM PLAYER WHERE CURRENT_ACTIVE = '" + currentActive + "'";
        try {
            rst = Conection.getResultSet(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            while (rst.next()) {
                nickName = rst.getString("NICK");
                //System.out.print("xdd");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        System.out.print(nickName);
        return nickName;

    }

    public int ObtenerID(String nickName) {
        int id = 0;
        String sql = "SELECT PLAYER_ID FROM PLAYER WHERE NICK = '" + nickName + "'";
        try {
            rst = Conection.getResultSet(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            while (rst.next()) {
                id = rst.getInt("PLAYER_ID");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        System.out.print(id);

        return id;
    }
}
