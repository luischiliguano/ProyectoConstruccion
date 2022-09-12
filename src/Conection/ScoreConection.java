/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conection;

import Persistence.Score;
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
public class ScoreConection {

    static Connection con;
    static Statement st;
    static ResultSet rst;
    static PreparedStatement pst;

    public void Mostrar(JTable tabla, String cadena) throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("N.");
        dtm.addColumn("Player ID");
        dtm.addColumn("Score Value");
        dtm.addColumn("Date");
        dtm.addColumn("Game");

        String consulta = "select * from SCORE where Player_ID like '" + cadena + "%'";
        con = Conection.conectar();
        st = Conection.getStatement();
        rst = Conection.getResultSet(consulta);

        String filas[] = new String[5];

        while (rst.next()) {
            filas[0] = rst.getString(3);
            filas[1] = rst.getString(4);
            filas[2] = rst.getString(1);
            filas[3] = rst.getString(5);
            filas[4] = rst.getString(2);

            dtm.addRow(filas);
        }
        tabla.setModel(dtm);
    }

    public boolean Insertar(Score score) throws SQLException {
         boolean r = false;
        String sql = "INSERT INTO SCORE (VALUE, GAME, PLAYER_ID, DATE_GAME)values (?,?,?,?)";
        try{
            con = Conection.conectar();
            st = Conection.getStatement();
            pst = Conection.getPreparedStatement(sql);
            pst.setInt(1, score.getValue());
            pst.setString(2, score.getGame());
            pst.setInt(3, score.getPlayerID());
            pst.setString(4, score.getDate());
            pst.executeUpdate();
        } finally{
          if(pst != null){
                Conection.Cerrar(pst);
            }
            if(con != null){
                Conection.Cerrar(con);
            }  
        }
        return r;
    }

    public Integer Modificar(Score score) throws SQLException {
        Integer r = null;
        try {
            String sql = "update SCORE set VALUE = ? where PLAYER_ID = ?";
            con = Conection.conectar();
            pst = Conection.getPreparedStatement(sql);
            pst.setInt(1, score.getValue());
            pst.setInt(2, score.getPlayerID());
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

    

}
