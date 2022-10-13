package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		double ystep = MAPYSIZE / (Math.abs(maxlat - minlat));
		
		return ystep;
	}

	public void showRouteMap(int ybase) {
		
		int i = 0;
		double[] latitudes = GPSUtils.getLatitudes(gpspoints);
		double[] longitudes = GPSUtils.getLongitudes(gpspoints);
		int x = 0;
		int y = 0;
		
		
		while (i < gpspoints.length -1) {
			y += (int)Math.round((latitudes[i] - latitudes[i+1])* ystep());
			x += (int)Math.round((longitudes[i] - longitudes[i+1]) * xstep());
			if (i == gpspoints.length -2) {
				setColor(0, 0, 255);
			}else {
				setColor(0, 255, 0);
			}
		    
			fillCircle(50 + (x*-1) , -ybase + 1050 + y , 4);
			
			i++;
		}
		    
	
		} 
	
	

	public void showStatistics() {

		int TEXTDISTANCE = 20;
		
		
		int totaltime = gpscomputer.totalTime();
		double totaldist = gpscomputer.totalDistance();
		double totalelev = gpscomputer.totalElevation();
		double maxspeed = gpscomputer.maxSpeed();
		double avgspeed = gpscomputer.averageSpeed();
		double energy = gpscomputer.totalKcal(80);
		totaldist = totaldist / 1000;
		
		
		
		
		String time = (" Total time : " + GPSUtils.formatTime(totaltime));
		String distance = (" Total Distance : " + GPSUtils.formatDouble(totaldist) + " km");
		String Elevation = (" Total Elevation : " + GPSUtils.formatDouble(totalelev) + " m");
		String maxsped = (" Max Speed : " + GPSUtils.formatDouble(maxspeed) + " km/h");
		String averageSpd = (" Average Speed : " + GPSUtils.formatDouble(avgspeed) + " km/h");
		String enrgy = (" Energy : " + GPSUtils.formatDouble(energy) + " kcal");
		
		
		setColor(0,0,0);
		setFont("Courier",12);
	    drawString(time, 0, 20);
	    drawString(distance, 0, 35);
	    drawString(Elevation, 0, 50);
	    drawString(maxsped, 0, 65);
	    drawString(averageSpd, 0, 80);
	    drawString(enrgy, 0, 95);
	    
	    
		
		
	}

}
