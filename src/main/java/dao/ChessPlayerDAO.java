package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ChessPlayer;

public class ChessPlayerDAO extends DAO {

        public ChessPlayerDAO() {
                super();
        }

        public ArrayList<ChessPlayer> getChessPlayerByRound(int idRound) {
                ArrayList<ChessPlayer> result = new ArrayList<>();
                String sql = "SELECT cp.*, cm.elo, cm.result " +
                                "FROM tblChessPlayer cp " +
                                "INNER JOIN tblChess_Match cm ON cp.id = cm.tblChessPlayerid " +
                                "WHERE cm.tblMatchId IN (SELECT id FROM tblMatch WHERE tblRoundid = ?) " +
                                "ORDER BY cm.elo DESC";
                try {
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
                                result.add(chessPlayer);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return result;
        }

        public boolean addChessPlayer(ChessPlayer player) {
                String sql = "INSERT INTO tblChessPlayer (name, dob, [national]) VALUES (?, ?, ?)";
                try {
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, player.getName());
                        ps.setDate(2, new java.sql.Date(player.getDob().getTime()));
                        ps.setString(3, player.getNational());
                        ps.executeUpdate();
                        return true;
                } catch (Exception e) {
                        System.err.println("Error adding player: " + e.getMessage());
                        e.printStackTrace();
                        return false;
                }
        }

        public boolean updateChessPlayer(ChessPlayer player) {
                String sql = "UPDATE tblChessPlayer SET name = ?, dob = ?, [national] = ? WHERE id = ?";
                try {
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, player.getName());
                        ps.setDate(2, new java.sql.Date(player.getDob().getTime()));
                        ps.setString(3, player.getNational());
                        ps.setInt(4, player.getId());
                        ps.executeUpdate();
                        return true;
                } catch (Exception e) {
                        System.err.println("Error updating player: " + e.getMessage());
                        e.printStackTrace();
                        return false;
                }
        }

        public boolean deleteChessPlayer(int id) {
                String sql = "DELETE FROM tblChessPlayer WHERE id = ?";
                try {
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, id);
                        ps.executeUpdate();
                        return true;
                } catch (Exception e) {
                        System.err.println("Error deleting player: " + e.getMessage());
                        e.printStackTrace();
                        return false;
                }
        }

        public ArrayList<ChessPlayer> searchChessPlayersByName(String keyword) {
                ArrayList<ChessPlayer> result = new ArrayList<>();
                String sql = "SELECT * FROM tblChessPlayer WHERE name LIKE ?";
                try {
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, "%" + keyword + "%");
                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                                ChessPlayer chessPlayer = new ChessPlayer();
                                chessPlayer.setId(rs.getInt("id"));
                                chessPlayer.setName(rs.getString("name"));
                                chessPlayer.setDob(rs.getDate("dob"));
                                chessPlayer.setNational(rs.getString("national"));
                                result.add(chessPlayer);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return result;
        }

        public ChessPlayer getChessPlayerById(int id) {
                ChessPlayer player = null;
                String sql = "SELECT * FROM tblChessPlayer WHERE id = ?";
                try {
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, id);
                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                                player = new ChessPlayer();
                                player.setId(rs.getInt("id"));
                                player.setName(rs.getString("name"));
                                player.setDob(rs.getDate("dob"));
                                player.setNational(rs.getString("national"));
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return player;
        }
}