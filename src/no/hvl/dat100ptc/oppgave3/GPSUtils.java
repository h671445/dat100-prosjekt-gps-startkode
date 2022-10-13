package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {
	
	public static double findMax(double[] da) {

		double max; 
		
		max = da[0]; 
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double latitudes[] = new double[gpspoints.length];
		
		for(int i = 0; i<gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double longitudes[] = new double[gpspoints.length];
		
		for(int i = 0; i<gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}

		return longitudes;


	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1 = gpspoint1.getLatitude(),
			   longitude1 = gpspoint1.getLongitude(),
			   latitude2 = gpspoint2.getLatitude(),
			   longitude2 = gpspoint2.getLongitude();
		Double latDistance = toRad(latitude2-latitude1);
		Double lonDistance = toRad(longitude2-longitude1);
		 Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
		 Math.cos(toRad(latitude1)) * Math.cos(toRad(latitude2)) * 
		 Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		 Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		 d = R * c;
		 return d;
		
		// TODO - START

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		double avstand = distance(gpspoint1, gpspoint2);
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		speed = avstand / secs;
		return speed*3.6;

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		int S = secs % 60;
		int H = secs / 60;
		int M = H % 60;
		H = H / 60;
		String s = Integer.toString(S);
		String m = Integer.toString(M);
		String h = Integer.toString(H);
		
		if (S < 10) {
			 s = "0" + Integer.toString(S);
		}
		if (M < 10) {
			 m = "0" + Integer.toString(M);
		}
		if (H < 10) {
			 h = "0" + Integer.toString(H);
		}
		
		timestr = "  " + h + TIMESEP + m + TIMESEP + s;
		
		return timestr;
		
		
	}
		
		
		
		

	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		
		double avrundet = Math.round(d*100.0)/100.0;
		String rundet = Double.toString(avrundet);
		str = "      " + rundet;
		return str;
		
		
	}
	 private static Double toRad(Double value) {
		 return value * Math.PI / 180;
}
}

