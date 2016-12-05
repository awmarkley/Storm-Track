package StormTrack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.data.JFileDataStoreChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UIController extends VBox{
    private MapContent map;
    private GraphicsContext gc;


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="heatmap"
    private Button heatmap = new Button(); // Value injected by FXMLLoader

    @FXML // fx:id="stormtrack"
    private Button stormtrack = new Button(); // Value injected by FXMLLoader

    @FXML // fx:id="latitude"
    private TextField latitude = new TextField(); // Value injected by FXMLLoader

    @FXML // fx:id="longitude"
    private TextField longitude = new TextField(); // Value injected by FXMLLoader

    @FXML // fx:id="choicebox"
    private ChoiceBox<?> choicebox = new ChoiceBox<>(); // Value injected by FXMLLoader

    @FXML // fx:id="go"
    private Button go = new Button(); // Value injected by FXMLLoader

    @FXML // fx:id="listView"
    private ListView<?> listView = new ListView<>(); // Value injected by FXMLLoader

    @FXML // fx:id="info"
    private TextArea info = new TextArea(); // Value injected by FXMLLoader

    @FXML // fx:id="canvas"
    private Canvas canvas = new Canvas(); // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert heatmap != null : "fx:id=\"heatmap\" was not injected: check your FXML file 'Window.fxml'.";
        assert stormtrack != null : "fx:id=\"stormtrack\" was not injected: check your FXML file 'Window.fxml'.";
        assert latitude != null : "fx:id=\"latitude\" was not injected: check your FXML file 'Window.fxml'.";
        assert longitude != null : "fx:id=\"longitude\" was not injected: check your FXML file 'Window.fxml'.";
        assert choicebox != null : "fx:id=\"choicebox\" was not injected: check your FXML file 'Window.fxml'.";
        assert go != null : "fx:id=\"go\" was not injected: check your FXML file 'Window.fxml'.";
        assert listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'Window.fxml'.";
        assert info != null : "fx:id=\"info\" was not injected: check your FXML file 'Window.fxml'.";
        assert canvas != null : "fx:id=\"canvas\" was not injected: check your FXML file 'Window.fxml'.";

        StormController stormC = new StormController();

        //Populate the years in pulldown menu from the StormData set.
        ArrayList years = new ArrayList(stormC.getYears());
        years.add(0,"All years");
        choicebox.getItems().addAll(FXCollections.observableArrayList(years));

        //Populate the storms in the listView from the StormData set.
        ArrayList storms = new ArrayList(stormC.getStormIDs());

        ObservableList stormIDList = FXCollections.observableArrayList(storms);
        FXCollections.sort(stormIDList);
        listView.getItems().addAll(stormIDList);
    }

    private void initMap() {
        try {
            File file = JFileDataStoreChooser.showOpenFile("shp", null);
            FileDataStore store = FileDataStoreFinder
                    .getDataStore(this.getClass().getClassLoader().getResource("countries.shp"));
            SimpleFeatureSource featureSource = store.getFeatureSource();
            map = new MapContent();
            Style style = SLD.createSimpleStyle(featureSource.getSchema());
            FeatureLayer layer = new FeatureLayer(featureSource, style);
            map.addLayer(layer);
            map.getViewport().setScreenArea(
                    new Rectangle((int) canvas.getWidth(), (int) canvas.getHeight()));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
