package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Event;
import model.Seat;

public class SeatDAO {

	
	DataSource ds;
	Connection c;
	
	
	public SeatDAO() {
		try {
			ds = (DataSource) new InitialContext().lookup("jdbc/ticket_resource");
			c = ds.getConnection();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Seat> getSeatByEvent(Integer event) throws SQLException{	
		List<Seat> l = null;		

		if (this.c != null) {
			l = new ArrayList<Seat>();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM seats WHERE id_event = ? AND status = 'free'");
			ps.setInt(1, event);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Seat seat = new Seat();
				seat.setNumber(rs.getInt("seat_number"));
				seat.setPrice(rs.getBigDecimal("price"));
				seat.setStatus(rs.getString("status"));
				l.add(seat);
			}
			rs.close();
			ps.close();
			c.close();
		}
		return l;
	}
	
	public void addPriceSeat(int id_event, int seat_number, BigDecimal price) throws SQLException {
		
		if (this.c != null) {
			PreparedStatement ps = c.prepareStatement("UPDATE seats set price = ? WHERE id_event = ? AND seat_number = ?");
			ps.setBigDecimal(1, price);
			ps.setInt(2, id_event);
			ps.setInt(3, seat_number);
			int i = ps.executeUpdate();
		}
	}
}




































