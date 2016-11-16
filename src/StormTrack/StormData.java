package StormTrack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrew Markley on 11/13/16.
 */
public class StormData {

    private Map<String,Storm> map;

    public StormData() {
        map = new HashMap<>();
    }

    public void addStorm(String name, Storm storm) {
        if ( !map.containsKey(name) )
            map.put(name,storm);
        //TODO: How to handle storms with the same name? Is this even an issue?
        else
            throw new UnsupportedOperationException("Cannot add two storms with the same name.");
    }

    public Storm getStorm(String name) { return map.get(name); }

    //TODO: Need to decide on return type for heat map generation.
    public Object getPaths(List<Storm> storms) { return null; }

    //TODO: Need to decide on return type for heat map generation.
    //TODO: Need arguments for heat map generation - perhaps Lat/Long coordinates?
    public Object getHeatMap() { return null; }


}
