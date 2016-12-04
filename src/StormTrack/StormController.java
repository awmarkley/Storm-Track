package StormTrack;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Andrew Markley on 11/13/16.
 */
public class StormController {

    private StormData data;
    private View view;

    public static void main( String[] args ) throws IOException {
        StormController stormControl = new StormController();

        stormControl.loadFiles("Info/");

        StormData sData = stormControl.getData();

        //Objects are stored by year + stormID
        Storm testStorm = sData.getStorm("194912090001");
        //Zero is the first storm track entry to get
        System.out.println(testStorm);
        testStorm.getHistory().forEach( System.out::println );
    }

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

    //TODO: Add all storm data from a file to the Storm object and then add that Storm to StormData.
    public void loadFiles( String f ) throws IOException {

        File folder = new File(f);
        File[] yearFiles = folder.listFiles();

        for ( File year : yearFiles ) {
            CSVReader reader = new CSVReader(new FileReader(year));
            List<String[]> input = reader.readAll();
            removeSpaces(input);

            //Organize storms by storm number
            Map<String,List<String[]>> storms = new HashMap();
            for ( String[] row : input ) {
                String stormName = row[0];

                if ( !storms.containsKey(stormName)) {
                    List<String[]> value = new ArrayList<>();
                    value.add(row);
                    storms.put(row[0], value);
                }
                else {
                    storms.get(row[0]).add(row);
                }
            }

            //Create a storm object for each key and add it to StormData object
            for ( String key : storms.keySet() ) {
                List<String[]> rows = storms.get(key);

                String stormID =  rows.get(0)[1] + "" + key;
                Storm storm = new Storm( stormID, rows);

                data.addStorm(stormID, storm);
            }
        }
    }

    private static void removeSpaces(List<String[]> data) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < 4; j++) {
                data.get(i)[j] = data.get(i)[j].replaceAll("\\s+", "");
            }
        }

    }

    //TODO: Design a format for input strings.
    public String loadString( String input ) { return null; }
    public StormData getData() { return data; }
}
