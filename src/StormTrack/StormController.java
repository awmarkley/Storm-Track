package StormTrack;

import java.util.List;

/**
 * Created by Andrew Markley on 11/13/16.
 */
public class StormController {

    private StormData data;
    private View view;

    public StormController() {
        data = new StormData();
        view = new View();
    }

    //TODO: Use View object to visualize a map.
    public void generateMap() { return; }

    //TODO: Use StormData's heatMap method to generate a heatMap for View to display.
    public void heatMap() { return; }

    //TODO: Return the necessary information to the View object to display Storm paths.
    public void paths( List<Storm> storms) { return; }

    //TODO: Recursively load all folders and files in target directory.
    public void loadFolder( String folder ) { return; }

    //TODO: Add all storm data from a file to the Storm object and then add that Storm to StormData.
    public void loadFile( String file ) {

        /**
         * Each file corresponds to a storm, create a new storm for every file.
         */

        String name = "";
        Storm s = new Storm(name);

        /**
         * Add DatePosition for each line
         */

        data.addStorm(name, s);

        return;
    }

    //TODO: Design a format for input strings.
    public String loadString( String input ) { return null; }
}
