package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Event;

public class EventDAO {

	
	DataSource ds;
	Connection c;
	
	
	public EventDAO() {
		try {
			ds = (DataSource) new InitialContext().lookup("jdbc/ticket_resource");
			c = ds.getConnection();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Event> getEventByPlace (String place) throws SQLException{
		List<Event> l = null;
		if (this.c != null) {
			l = new ArrayList<Event>();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM events WHERE place = ?");
			ps.setString(1, place);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Event e = new Event();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEventDate(rs.getTimestamp("event_date").toLocalDateTime().toLocalDate());
				e.setPlace(rs.getString("place"));
				e.setId(rs.getInt("id_owner"));
				if (rs.getTimestamp("sale_beginning") != null)
					e.setSalesBeg(rs.getTimestamp("sale_beginning").toLocalDateTime().toLocalDate());
				if (rs.getTimestamp("sale_ending") != null)
					e.setSalesEnd(rs.getTimestamp("sale_ending").toLocalDateTime().toLocalDate());
				l.add(e);			
			}
			rs.close();
			ps.close();
			c.close();
		}
		
		return l;
		
	}
	public List<Event> getEventByEvent(String event) throws SQLException{
		List<Event> l = null;
		if (this.c != null) {
			l = new ArrayList<Event>();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM events WHERE name = ?");
			ps.setString(1, event);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Event e = new Event();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEventDate(rs.getTimestamp("event_date").toLocalDateTime().toLocalDate());
				e.setPlace(rs.getString("place"));
				e.setId(rs.getInt("id_owner"));
				if (rs.getTimestamp("sale_beginning") != null)
					e.setSalesBeg(rs.getTimestamp("sale_beginning").toLocalDateTime().toLocalDate());
				if (rs.getTimestamp("sale_ending") != null)
					e.setSalesEnd(rs.getTimestamp("sale_ending").toLocalDateTime().toLocalDate());
				l.add(e);			
			}
			rs.close();
			ps.close();
			c.close();
		}
		return l;
		
	}
	public List<Event> getEventByDate (LocalDate event_date) throws SQLException{
		List<Event> l = null;
		if (this.c != null) {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM events WHERE event_date = ?");
			ps.setTimestamp(1,Timestamp.valueOf(event_date.atStartOfDay()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Event e = new Event();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEventDate(rs.getTimestamp("event_date").toLocalDateTime().toLocalDate()); 
				e.setPlace(rs.getString("place"));
				e.setId(rs.getInt("id_owner"));
				if (rs.getTimestamp("sale_beginning") != null)
					e.setSalesBeg(rs.getTimestamp("sale_beginning").toLocalDateTime().toLocalDate());
				if (rs.getTimestamp("sale_ending") != null)
					e.setSalesEnd(rs.getTimestamp("sale_ending").toLocalDateTime().toLocalDate());
				l.add(e);			
			}
			rs.close();
			ps.close();
			c.close();
		}
		return l;
		
	}
	
	public List<Event> getEventByDateName (LocalDate event_date, String name) throws SQLException{
		List<Event> l = null;
		if (this.c != null) {
			l = new ArrayList<Event>();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM events WHERE event_date = ? AND name = ?");
			ps.setTimestamp(1, Timestamp.valueOf(event_date.atStartOfDay()));			
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Event e = new Event();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEventDate(rs.getTimestamp("event_date").toLocalDateTime().toLocalDate());
				e.setPlace(rs.getString("place"));
				e.setId(rs.getInt("id_owner"));
				if (rs.getTimestamp("sale_beginning") != null)
					e.setSalesBeg(rs.getTimestamp("sale_beginning").toLocalDateTime().toLocalDate());
				if (rs.getTimestamp("sale_ending") != null)
					e.setSalesEnd(rs.getTimestamp("sale_ending").toLocalDateTime().toLocalDate());
				l.add(e);			
			}
			rs.close();
			ps.close();
			c.close();
		}
		return l;
		
	}
	
	public List<Event> getEventByDatePlace (LocalDate event_date, String place) throws SQLException{
		List<Event> l = null;
		if (this.c != null) {
			l = new ArrayList<Event>();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM events WHERE event_date = ? AND place = ?");
			ps.setTimestamp(1,Timestamp.valueOf(event_date.atStartOfDay()));
			ps.setString(2, place);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Event e = new Event();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEventDate(rs.getTimestamp("event_date").toLocalDateTime().toLocalDate());
				e.setPlace(rs.getString("place"));
				e.setId(rs.getInt("id_owner"));
				if (rs.getTimestamp("sale_beginning") != null)
					e.setSalesBeg(rs.getTimestamp("sale_beginning").toLocalDateTime().toLocalDate());
				if (rs.getTimestamp("sale_ending") != null)
					e.setSalesEnd(rs.getTimestamp("sale_ending").toLocalDateTime().toLocalDate());
				l.add(e);			
			}
			rs.close();
			ps.close();
			c.close();
		}
		return l;
		
	}
	
	public List<Event> getEventByPlaceName(String place, String name) throws SQLException{
		List<Event> l = null;
		if (this.c != null) {
			l = new ArrayList<Event>();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM events WHERE place = ? AND name = ?");
			ps.setString(1, place);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Event e = new Event();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEventDate(rs.getTimestamp("event_date").toLocalDateTime().toLocalDate());
				e.setPlace(rs.getString("place"));
				e.setId(rs.getInt("id_owner"));
				if (rs.getTimestamp("sale_beginning") != null)
					e.setSalesBeg(rs.getTimestamp("sale_beginning").toLocalDateTime().toLocalDate());
				if (rs.getTimestamp("sale_ending") != null)
					e.setSalesEnd(rs.getTimestamp("sale_ending").toLocalDateTime().toLocalDate());
				l.add(e);			
			}
			rs.close();
			ps.close();
			c.close();
		}
		return l;
		
	}
	
	public List<Event> getEventByPlaceNameDate(String place, String name, LocalDate event_date) throws SQLException{
		List<Event> l = null;
		if (this.c != null) {
			l = new ArrayList<Event>();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM events WHERE place = ? AND name = ? AND event_date = ? ");
			ps.setString(1, place);
			ps.setString(2, name);
			ps.setTimestamp(3,Timestamp.valueOf(event_date.atStartOfDay()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Event e = new Event();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEventDate(rs.getTimestamp("event_date").toLocalDateTime().toLocalDate());
				e.setPlace(rs.getString("place"));
				e.setId(rs.getInt("id_owner"));
				if (rs.getTimestamp("sale_beginning") != null)
					e.setSalesBeg(rs.getTimestamp("sale_beginning").toLocalDateTime().toLocalDate());
				if (rs.getTimestamp("sale_ending") != null)
					e.setSalesEnd(rs.getTimestamp("sale_ending").toLocalDateTime().toLocalDate());
				l.add(e);			
			}
			rs.close();
			ps.close();
			c.close();
		}
		return l;
		
	}
	
	public List<Event> getAllEvents() throws SQLException{
		List<Event> l = null;
		if (this.c != null) {
			l = new ArrayList<Event>();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM events");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Event e = new Event();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEventDate(rs.getTimestamp("event_date").toLocalDateTime().toLocalDate());
				e.setPlace(rs.getString("place"));
				e.setId(rs.getInt("id_owner"));
//				System.out.println("teste: " + rs.getTimestamp("sale_beginning"));
				if (rs.getTimestamp("sale_beginning") != null)
					e.setSalesBeg(rs.getTimestamp("sale_beginning").toLocalDateTime().toLocalDate());
				if (rs.getTimestamp("sale_ending") != null)
					e.setSalesEnd(rs.getTimestamp("sale_ending").toLocalDateTime().toLocalDate());
				l.add(e);			
			}
			rs.close();
			ps.close();
			c.close();
		}
		return l;
	}
	
	public Event getEventById(int id) throws SQLException{
		Event e = new Event();
		if (this.c != null) {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM events where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
		
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEventDate(rs.getTimestamp("event_date").toLocalDateTime().toLocalDate()); 
				e.setPlace(rs.getString("place"));
				e.setId(rs.getInt("id_owner"));
				if (rs.getTimestamp("sale_beginning") != null)
					e.setSalesBeg(rs.getTimestamp("sale_beginning").toLocalDateTime().toLocalDate());
				if (rs.getTimestamp("sale_ending") != null)
					e.setSalesEnd(rs.getTimestamp("sale_ending").toLocalDateTime().toLocalDate());
				
			}
			rs.close();
			ps.close();
			c.close();
		}
		return e;
	}

//	public boolean addEvent (Event e) throws SQLException {
	public boolean addEvent (String name, LocalDate event_date, String place, Integer number_seats, Integer id_owner, 
			LocalDateTime sales_beg,LocalDateTime sales_end) throws SQLException {	
		if ( this.c != null) {
			PreparedStatement ps = c.prepareStatement("INSERT INTO events (name,event_date,place,id_owner,sale_beginning,sale_ending) VALUES (?,?,?,?,?,?)");
//			ps.setString(1, e.getName());
//			ps.setTimestamp(2,Timestamp.valueOf(e.getEventDate()));
//			ps.setString(3, e.getPlace());
//			ps.setInt(4, e.getOwner().getId());
//			ps.setTimestamp(5,Timestamp.valueOf(e.getSalesBeg()));
//			ps.setTimestamp(6,Timestamp.valueOf(e.getSalesEnd()));
			
			ps.setString(1, name);
		
			
			ps.setTimestamp(2,Timestamp.valueOf(event_date.atStartOfDay()));
			ps.setString(3, place);
			ps.setInt(4, id_owner);
			if (sales_beg != null) {
				ps.setTimestamp(5,Timestamp.valueOf(sales_beg));
			}
			else {
				ps.setTimestamp(5,null);
			}
			if (sales_beg != null) {
				ps.setTimestamp(6,Timestamp.valueOf(sales_end));
			}
			else {
				ps.setTimestamp(6,null);
			}
			int i = ps.executeUpdate();
			
			if (i == 0) return true;
		}
		
		return false;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
