package Main;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class ValidateDate {
	
	public boolean validateDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    sdf.setLenient(false);
	    if(sdf.parse(date,new ParsePosition(0))!=null) {
	    	return true;
	    }
	    else {
	    	return false;
	    }		
	}
	
}
