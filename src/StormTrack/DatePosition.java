package StormTrack;

import java.time.LocalDateTime;

/**
 * Created by Andrew Markley on 11/13/16.
 */
class DatePosition implements Comparable<DatePosition>{
    private LocalDateTime date;
    private boolean latNorth;
    private double latitude;
    private boolean longEast;
    private double longitude;

    public DatePosition(LocalDateTime date, String latCoord, String longCoord ) {
        this.date = date;
        latitude = Double.parseDouble(latCoord.substring(0,2));
        longitude = Double.parseDouble(longCoord.substring(0,2));

        //Check for whether Latitude is North or South, throw an exception if it is neither
        //N or S.
        char direction = latCoord.charAt(3);

        if ( direction == 'N' || direction =='n' )
            latNorth = true;
        else if ( direction != 'S' && direction != 's' )
            throw new IllegalArgumentException("Latitude must be either N or S");

        //Check for whether Longitude is East or West, throw an exception if it is neither
        //E or W.
        direction = longCoord.charAt(3);
        if ( direction == 'E' || direction == 'e' )
            longEast = true;
        else if ( direction != 'W' && direction != 'w' )
            throw new IllegalArgumentException("Longitude must be either E or W");
    }

    public LocalDateTime getDate() { return date; }
    public boolean isLatNorth() { return latNorth; }
    public boolean isLongEast() { return longEast; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    @Override
    public int compareTo(DatePosition o) {
        return this.getDate().compareTo(o.getDate());
    }
}
