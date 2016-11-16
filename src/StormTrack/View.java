package StormTrack;

import org.geotools.*;

import java.util.List;

/**
 * Created by Andrew Markley on 11/13/16.
 */
public class View {

    private boolean showPaths;
    private boolean showHeatMap;
    private List<String> heatMapData;
    private List<String> stormPathData;

    public View() {}

    //TODO: This method handles the generation of the UI.
    public void generateView() {}

    //TODO: This method handles the communication of initial/new heatmap data to the view component.
    public void updateHeatMap(List<String> data) {}

    //TODO: This method handles the communication of initial/new path data to the view component.
    public void updatePathData(List<String> data) {}

    public void showPaths(boolean b) {      showPaths = b; }
    public void showHeatMap(boolean b) {    showHeatMap = b; }
}
