package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		gpspoints = new GPSPoint[n];

		
	}

	public GPSPoint[] getGPSPoints() { 
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// TODO - START
		if (antall < gpspoints.length && !inserted) {
			gpspoints[antall] = gpspoint;
			inserted = true;
			antall++;
		}
		// TODO - SLUTT
		return inserted;
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
		
		
		int timeint = GPSDataConverter.toSeconds(time);
		
		GPSPoint punkt = new GPSPoint(timeint, Double.parseDouble(latitude), Double.parseDouble(longitude),
				Double.parseDouble(elevation));
		
		return insertGPS(punkt);
		}
		
		
	

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		for(int i = 0; i<antall; i++) {
			System.out.print(gpspoints[i].toString());
		}
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
