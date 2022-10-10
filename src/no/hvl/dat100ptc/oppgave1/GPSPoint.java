package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	// TODO - objektvariable
	private int time;
	private double latitude;
	private double longitude;
	private double elevation;

	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		// TODO - konstruktør
		this.time = time;
		this.latitude = latitude;
		this.latitude = longitude;
		this.elevation = elevation;
		// Fjern linjene med throw new etterhvert som metodene implementeres
		// throw new UnsupportedOperationException(TODO.construtor("GPSPoint"));

	}

	// TODO - get/set metoder
	public int getTime() {
		
		//throw new UnsupportedOperationException(TODO.method());
		return time;
	}

	public void setTime(int time) {
		this.time = time;		
		//throw new UnsupportedOperationException(TODO.method());

	}

	public double getLatitude() {
		return latitude;
		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
		//throw new UnsupportedOperationException(TODO.method());
		
	}

	public double getLongitude() {
		return longitude;
		// throw new UnsupportedOperationException(TODO.method());
		
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
		// throw new UnsupportedOperationException(TODO.method());
		
	}

	public double getElevation() {
		return elevation;
		// throw new UnsupportedOperationException(TODO.method());
		
	}

	public void setElevation(double elevation) {
		this.elevation = elevation;
		// throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public String toString() {
		
		
		
		// TODO - start
		return Integer.toString(time) + " (" + Double.toString(latitude) + "," + Double.toString(longitude)
		+ ") " + Double.toString(elevation);
		
		
		
	}
}
