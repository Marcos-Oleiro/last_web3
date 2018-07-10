package libs;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class LocalDateToStringAdapter extends XmlAdapter<String, LocalDate>{

	@Override
	public String marshal(LocalDate ld) throws Exception {
		// TODO Auto-generated method stub
		
		String new_string = ld.toString();
		return new_string;
	}

	@Override
	public LocalDate unmarshal(String str) throws Exception {
		// TODO Auto-generated method stub
		
		LocalDate new_ld = LocalDate.parse(str);
		return new_ld;
	}

}
