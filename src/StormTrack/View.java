package StormTrack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View extends Application {

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

    public static void main(String[] args) throws Exception {

        launch(args);

    }


    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane page = (BorderPane) FXMLLoader.load(getClass()
                    .getClassLoader().getResource("Window.fxml"));

            MapCanvas canvas = new MapCanvas(1024, 768);
            page.setCenter( canvas.getCanvas() );
            Scene scene = new Scene(page);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Storm Track v0.9");

            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
