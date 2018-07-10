package libs;

import java.time.LocalDate;

public class UtilDate {

	
	public boolean formatDate(String str) {
		
//		String data = "25/01/2016";   "yyyy-MM-dd"
		
		String[] pieces = str.split("/");
		
		if ( (pieces[0].length() != 4 ) || (pieces[1].length() != 2 ) || ( pieces[2].length() != 2 ) )
			return false;
		
		return true;
	}
	
	
	public boolean validDate (String str) {
		
		String[] pieces = str.split("/");
		
		LocalDate today = LocalDate.now();
//		System.out.println(today.getYear());
//		System.out.println(today.getMonthValue());
//		System.out.println(today.getDayOfMonth());
//		System.out.println("----");
//		System.out.println(pieces[0]);
//		System.out.println(pieces[1]);
//		System.out.println(pieces[2]);
//		System.out.println("----");
		
		if ( ( Integer.parseInt(pieces[1] ) < 0) ||  ( Integer.parseInt(pieces[1])  > 13 )  ||  ( Integer.parseInt(pieces[2]) < 0 )  || (Integer.parseInt(pieces[2]) > 31)  ) 
			return false;
		
		
		
		if (Integer.parseInt(pieces[0]) >= today.getYear()) {
		
			if (Integer.parseInt(pieces[0]) > today.getYear()) {
				
				if ( (Integer.parseInt(pieces[1]) == 2 )  && (Integer.parseInt(pieces[2]) > 29 ) ) {
					 return false;
				 }
				return true;
			}
			else {
				 if ( Integer.parseInt(pieces[1])  >= today.getMonthValue()){
					 
					 if (Integer.parseInt(pieces[1])  > today.getMonthValue()) {
						 if ( (Integer.parseInt(pieces[1]) == 2 )  && (Integer.parseInt(pieces[2]) > 29 ) ) {
							 return false;
						 }
						 return true;
					 }
					 else {
						 if ( (Integer.parseInt(pieces[1]) == 2 )  && (Integer.parseInt(pieces[2]) > 29 ) ) {
							 return false;
						 }
						 else {	
							 if ( Integer.parseInt(pieces[2])  < today.getDayOfMonth() ) {
								 return false;
							 }
							 return true;
						 }
					 }
				 }
				 return false;
			}
		}
		return false;
	}
	
	public LocalDate makeALocalDate (String str) {
		
		String[] pieces = str.split("/");
		LocalDate ld = LocalDate.of(Integer.parseInt(pieces[0]), Integer.parseInt(pieces[1]), Integer.parseInt(pieces[2]));
			
		
		
		
		return ld;
	}
}
