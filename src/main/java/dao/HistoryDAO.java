package dao;

import java.util.ArrayList;
import model.Chess_Match;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HistoryDAO extends DAO {

    public HistoryDAO() {
        super();
    }

    public ArrayList<Chess_Match> getHistory(int idChessPlayer) {
        ArrayList<Chess_Match> result = new ArrayList<>();
        String sql = "SELECT cm.*, m.tblRoundid "
                + "FROM tblChess_Match cm "
                + "INNER JOIN tblMatch m ON cm.tblMatchId = m.id "
                + "WHERE cm.tblChessPlayerid = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idChessPlayer);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Chess_Match chessMatch = new Chess_Match();
                chessMatch.setResult(rs.getString("result"));
                chessMatch.setTblMatchId(rs.getInt("tblRoundid"));
                chessMatch.setOpponentName(rs.getString("opponentName"));
                chessMatch.setEloGain(rs.getFloat("eloGain"));
                result.add(chessMatch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
