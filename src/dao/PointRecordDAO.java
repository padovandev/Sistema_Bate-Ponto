package dao;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class PointRecordDAO {
    public void registerEntry(int user_id) throws Exception {
        Connection conn = ConnectionFactory.getConnection();

        String sql = "INSERT INTO registers (usuario_id, data, hora_entrada) VALUES (?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, user_id);
        stmt.setDate(2, Date.valueOf(LocalDate.now()));
        stmt.setTime(2, Time.valueOf(LocalTime.now()));

        stmt.execute();
        stmt.close();
        conn.close();
    }

    public void registerExit(int user_id) throws Exception {
        Connection conn = ConnectionFactory.getConnection();

        String sql = "UPDATE registers SET entry_hour = ? WHERE user_id = ? AND date_work = ? ";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setTime(1, Time.valueOf(LocalTime.now()));
        stmt.setInt(2, user_id);
        stmt.setDate(3, Date.valueOf(LocalDate.now()));

        stmt.execute();
        stmt.close();
        conn.close();

    }

}
