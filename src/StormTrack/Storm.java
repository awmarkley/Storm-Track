package StormTrack;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrew Markley on 11/13/16.
 */
public class Storm {
    private List<DatePosition> list;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String stormID;

    public Storm(String stormID, List<String[]> stormTracks) {
        list = new ArrayList<>();
        this.stormID = stormID;

        //Populate list of DatePosition with contents of array
        stormTracks.forEach( row ->
            list.add( new DatePosition( convertDate(row[1]), row[2], row[3])));

        startDate = list.get(0).getDate();
        endDate = list.get( list.size()-1 ).getDate();
    }


    protected static LocalDateTime convertDate(String s) {
        //Formatted with YYYYMMDDHH
        return LocalDateTime.parse(s, DateTimeFormatter.ofPattern("uuuuMMddHH"));
    }


    public List<DatePosition> getHistory() { return list; }
    public Iterator<DatePosition> getIterator() { return list.iterator(); }
    public LocalDateTime getStartDate() { return startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public String getStormID() { return stormID; }

    public String toString() {
        return stormID + " : From " + startDate + " to " + endDate;
    }
}
