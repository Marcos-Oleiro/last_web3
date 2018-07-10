package ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TicketSellerAuthWS {
	
	
	@WebMethod
	public void oi () {
		System.out.println("oi");
	}

}
