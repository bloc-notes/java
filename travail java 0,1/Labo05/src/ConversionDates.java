
public class ConversionDates
	{

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				//formeLongue("2016-03-14");
				System.out.println(formeLongue("2016-03-14")); // Nous pouvons appeller directement la methode formeLongue car celle-ci est static.
			}
		
		public static String formeLongue(String dateISO)
		{
			String strDateLongue = "";
			String strAnnee = dateISO.substring(0,4);
			String strMois = dateISO.substring(5,7);
			String strJour = dateISO.substring(8);
			
			String strMoisLettre = "";
			
			switch (strMois)
				{
				case "01":
					strMoisLettre = "Janvier";
					break;
				case "02":
					strMoisLettre = "Février";
					break;
				case "03":
					strMoisLettre = "Mars";
					break;
				case "04":
					strMoisLettre = "Avril";
					break;
				case "05":
					strMoisLettre = "Mai";
					break;
				case "06":
					strMoisLettre = "Juin";
					break;
				case "07":
					strMoisLettre = "Juillet";
					break;
				case "08":
					strMoisLettre = "Août";
					break;
				case "09":
					strMoisLettre = "Septembre";
					break;
				case "10":
					strMoisLettre = "Octobre";
					break;
				case "11":
					strMoisLettre = "Novembre";
					break;
				case "12":
					strMoisLettre = "Décembre";
					break;
				}
			
		    //System.out.println("Date format AAAA-MM-JJ:\n" + dateISO + "\n\nDate format JJ MMMM AAAA:\n" + "Le " + strJour + " " + strMoisLettre + " " + strAnnee);
		    
		    strDateLongue = "Date format AAAA-MM-JJ:\n" + dateISO + "\n\nDate format JJ MMMM AAAA:\n" + "Le " + strJour + " " + strMoisLettre + " " + strAnnee;
			return strDateLongue;
		}

	}
