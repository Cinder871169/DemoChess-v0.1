/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ChessPlayer;
/**
 *
 * @author user
 */
public class ChessPlayerDAO extends DAO{

    public ChessPlayerDAO() {
        super();
    }
    public ArrayList<ChessPlayer> getChessPlayerByRound(int idRound) {
        ArrayList<ChessPlayer> result = new ArrayList<>();
        //String sql = "SELECT * FROM tblChessPlayer WHERE id IN (SELECT tblChessPlayerid FROM tblChess_Match WHERE tblMatchId IN (SELECT id FROM tblMatch WHERE tblRoundid = ?))";
        String sql = "SELECT cp.*, cm.elo, cm.result " +
             "FROM tblChessPlayer cp " +
             "INNER JOIN tblChess_Match cm ON cp.id = cm.tblChessPlayerid " +
             "WHERE cm.tblMatchId IN (SELECT id FROM tblMatch WHERE tblRoundid = ?) " +
             "ORDER BY cm.elo DESC";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idRound);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ChessPlayer chessPlayer = new ChessPlayer();
                chessPlayer.setId(rs.getInt("id"));
                chessPlayer.setName(rs.getString("name"));
                chessPlayer.setDob(rs.getDate("dob"));
                chessPlayer.setNational(rs.getString("national"));
                chessPlayer.setTotalPoint(rs.getFloat("elo"));
                chessPlayer.setResult(rs.getString("result"));
                result.add(chessPlayer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
