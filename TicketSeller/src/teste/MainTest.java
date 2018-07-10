package teste;

import java.time.LocalDate;

import libs.UtilDate;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(LocalDate.now());
		
		
		System.out.println(new UtilDate().validDate("2018/10/30"));
		System.out.println(new UtilDate().formatDate("2018/10/30"));
		

//		System.out.println(LocalDate.now().toString());
	}

}
