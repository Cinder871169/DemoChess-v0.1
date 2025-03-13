package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Round;

public class RoundDAO extends DAO {

    public RoundDAO() {
        super();
    }

    public ArrayList<Round> getRound() {
        ArrayList<Round> result = new ArrayList<>();
        String sql = "SELECT * FROM tblRound";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Round rd = new Round();
                rd.setId(rs.getInt("id"));
                rd.setNameRound(rs.getString("nameRound"));
                rd.setDateTime(rs.getDate("time"));
                rd.setNumberOfMatch(rs.getInt("numberOfMatchs"));
                rd.setTblTournamentId(rs.getInt("tblTournamentid"));
                result.add(rd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
