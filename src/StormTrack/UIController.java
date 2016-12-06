package StormTrack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.geotools.map.MapContent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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
    private Canvas canvas;// Value injected by FXMLLoader

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

        ArrayList years = new ArrayList(stormC.getYears());
        years.add(0,"All years");

        ArrayList storms = new ArrayList(stormC.getStormIDs());
        final ObservableList masterStormIDList = FXCollections.observableArrayList(storms);
        FXCollections.sort(masterStormIDList);

        //Set up the initial map canvas
        MapCanvas map = new MapCanvas(1024, 768);
        canvas = (Canvas) map.getCanvas();

        //Populate the years in pulldown menu from the StormData set.

        choicebox.getItems().addAll(FXCollections.observableArrayList(years));
        choicebox.getSelectionModel().selectFirst();
        choicebox.getSelectionModel().selectedIndexProperty()
                .addListener((ov, value, newValue) -> {
                    listView.getItems().clear();

                    if ( newValue.intValue() == 0 )
                        listView.getItems().addAll(masterStormIDList);
                    else {
                        int listValue = (int) years.get(newValue.intValue());
                        ArrayList currentStorms = (ArrayList) storms.stream().filter(
                                line -> ((String) line).substring(0,4).equals(listValue + "") )
                                .collect(Collectors.toList());
                        ObservableList current = FXCollections.observableArrayList(currentStorms);
                        FXCollections.sort(current);
                        listView.getItems().addAll(current);
                    }
                });

        //Populate the storms in the listView from the StormData set.
        listView.getItems().addAll(masterStormIDList);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

}
