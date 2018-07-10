package ws;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



import dao.EventDAO;
import dao.SeatDAO;
import exception.DateException;
import exception.InvalidIDException;
import libs.LocalDateToStringAdapter;
import libs.UtilDate;
import model.Event;
import model.Seat;

@WebService
public class TicketSellerWS {
	
	
	// métodos não autenticados
	
	
	@WebMethod(operationName = "listEvents")
	@WebResult(name = "event_list")
	public List<Event> listEvents(@WebParam(name ="event_name")String event, @WebParam(name = "event_date_str") String event_date_str, 
													@WebParam(name = "place")String place) throws SQLException,DateException{

		LocalDate event_date ;
		
//		event = event.trim();
		event_date_str = event_date_str.trim();
//		place = place.trim();
//		System.out.println("string : " + event_date_str);
//		System.out.println(event.equals(""));
//		System.out.println(event_date_str.length());
//		System.out.println(event_date_str.isEmpty());
//		System.out.println(event_date_str == null);
		
		if (event.equals("")) event = null;
		if (place.equals("")) place= null;
		
		if (!event_date_str.equals("") ) {
			if ( !(new UtilDate().formatDate(event_date_str)) || !(new UtilDate().validDate(event_date_str)) ) {
				System.out.println("entrou no if da exception");
				throw new DateException();
			}
			System.out.println("entrou no if da teste de null");
			event_date = new UtilDate().makeALocalDate(event_date_str);
		}else {
			event_date = null;
		}
		System.out.println("nome : " + event);
		System.out.println("data : " + event_date);
		System.out.println("lugar : " + place);
		System.out.println();
		
		EventDAO eDAO = new EventDAO();
		if ( (event == null) && (event_date == null) && (place == null)  ) {
			return eDAO.getAllEvents();
		}
		if ( (event != null) && (event_date != null) && (place != null)  ) {
			return eDAO.getEventByPlaceNameDate(place, event, event_date);			
		}
//		 -----------------
		if ( (event == null) && (event_date != null) && (place!= null) ) {
			return eDAO.getEventByDatePlace(event_date, place);			
		}
		if ( (event_date == null && (event != null) && (place!= null)) ) {
			return eDAO.getEventByPlaceName(place, event);			
		}
		if ( (place== null) && (event_date != null) && (event != null) ) {
			return eDAO.getEventByDateName(event_date, event);			
		}
//		-----------
		if ( (event == null) && (event_date == null) )
			return eDAO.getEventByPlace(place);
		
		if ( (event == null) && (place == null) ) {
		
			System.out.println("aaqui!");
			return eDAO.getEventByDate(event_date);
		}
		
		if ( (event_date == null) && (place == null) )
			return eDAO.getEventByEvent(event);
		
		
		return null;
		
	}
	
	
	@WebMethod(operationName = "seat_list")
	@WebResult(name  =  "listSeats")
	public List<Seat> listSeats (@WebParam (name = "event_id")  @XmlElement(required  = true) Integer id_event) throws InvalidIDException, SQLException{
		
		if (id_event < 1) {
			throw new InvalidIDException();
		}		

		SeatDAO sDAO = new SeatDAO();		 		
		return sDAO.getSeatByEvent(id_event);
	}
	
	
	
	// métodos autenticados
	
	
	
	

	
	

}
