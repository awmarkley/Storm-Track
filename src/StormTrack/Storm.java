package StormTrack;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrew Markley on 11/13/16.
 */
public class Storm {
    private String name;
    private List<DatePosition> list;

    public Storm(String name) {
        name = this.name;
        list = new ArrayList<>();
    }

    public void addHistory(LocalDateTime ldt, String latitude, String longitude ) {
        list.add( new DatePosition(ldt, latitude, longitude));
        Collections.sort(list);
    }

    public String getName() { return name; }
    public List<DatePosition> getHistory() { return list; }
    public Iterator<DatePosition> getIterator() { return list.iterator(); }
}
