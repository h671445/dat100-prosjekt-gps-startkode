package no.hvl.dat100ptc.oppgave2;

import java.lang.invoke.StringConcatException;
import java.lang.invoke.StringConcatFactory;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {
		
	

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // posisjon for start av tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
	        // timer
			char time1 = timestr.charAt(11);
			char time2 = timestr.charAt(12);
		    StringBuilder sb = new StringBuilder();
		    sb.append(time1);
		    sb.append(time2);
		    hr = Integer.parseInt(sb.toString());
		   
		    
		    //minutter
		    char min1 = timestr.charAt(14);
			char min2 = timestr.charAt(15);
		    StringBuilder minutter = new StringBuilder();
		    minutter.append(min1);
		    minutter.append(min2);
		    min = Integer.parseInt(minutter.toString());
		    
		    //sekunder
		    char sek1 = timestr.charAt(17);
			char sek2 = timestr.charAt(18);
		    StringBuilder sekunder = new StringBuilder();
		    sekunder.append(sek1);
		    sekunder.append(sek2);
		    sec = Integer.parseInt(sekunder.toString());
		    
		    secs = (hr*60*60) + (min*60) + sec;
		    return secs;
		
		

		
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {
		
		//throw new UnsupportedOperationException(TODO.method());
		GPSPoint gpspoint = new GPSPoint(toSeconds(timeStr), Double.parseDouble(latitudeStr),
				Double.parseDouble(longitudeStr), Double.parseDouble(elevationStr));
		// OPPGAVE - SLUTT ;
		return gpspoint;
	    
	
	
}
}
