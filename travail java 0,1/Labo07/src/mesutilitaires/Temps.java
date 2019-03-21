package mesutilitaires;

import java.text.DecimalFormat;

public class Temps
	{
		private int intHeure;
		private int intMinute;
		private int intSeconde;

		public Temps()
			{
				setTemps(0, 0, 0);
			}

		public void setTemps(int h, int m, int s)
			{
				// TODO Auto-generated method stub

				intHeure = (h >= 0 && h < 24) ? h : 0;

				intMinute = (m >= 0 && m < 60) ? m : 0;

				intSeconde = (s >= 0 && s < 60) ? s : 0;
			}

		public String formatUniversel()
			{
				DecimalFormat dec = new DecimalFormat("00");

				return dec.format(intHeure) + ":" + dec.format(intMinute) + ":" + dec.format(intSeconde);
			}

		public String toString()
			{
				DecimalFormat dec = new DecimalFormat("00");
				String strStandard = null;

				if (intHeure <= 12 && intHeure > 0)
					{
						strStandard = intHeure + ":" + dec.format(intMinute) + ":" + dec.format(intSeconde) + " AM";
					} else if (intHeure > 12)
					{
						strStandard = (intHeure - 12) + ":" + dec.format(intMinute) + ":" + dec.format(intSeconde)
								+ " PM";
					} else if (intHeure == 0)
					{
						strStandard = (intHeure + 12) + ":" + dec.format(intMinute) + ":" + dec.format(intSeconde)
								+ " PM";
					}

				return strStandard;
			}

		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				Temps t = new Temps();
				t.setTemps(8, 0, 0);

				System.out.println(t.toString());
				System.out.println(t.formatUniversel());
			}
	}
