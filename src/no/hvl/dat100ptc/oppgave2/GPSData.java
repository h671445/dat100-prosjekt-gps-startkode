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
		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			inserted = true;
		}
		// TODO - SLUTT
		return inserted;
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint = new GPSPoint(Integer.parseInt(time), Double.parseDouble(latitude),
				Double.parseDouble(longitude), Double.parseDouble(elevation));
		for(int i = 0; i<gpspoints.length; i++) {
			if (gpspoints[i] == null) {
				gpspoints[i] = gpspoint;
				
			}
		}
		
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
		// System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
