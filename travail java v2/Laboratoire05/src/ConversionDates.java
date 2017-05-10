import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversionDates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(formeLongue("2017-04-03"));
		
		//Nous pouvons l'appeler car il est static.
	}
	
	public static String formeLongue(String dateISO){
		SimpleDateFormat form = new SimpleDateFormat("'Le' dd MMMM yyyy");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		
		try {
			dt = df.parse(dateISO);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return form.format(dt);
	}

}
