/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

//import the classes needed.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import javafx.event.EventHandler;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author toledoalbert
 */
public class Design extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //make the stage without window.
        stage.initStyle(StageStyle.TRANSPARENT);
        
        
        //load the fxml file to import all the elements from fxml
        Parent root = FXMLLoader.load(getClass().getResource("Design1.fxml"));
        
        //
        //create axis objects for the barchart.
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        /*
        //initialize barchart object.
        BarChart<String, Number> chart = new BarChart<>(xAxis,yAxis);
        
        //set chart titles.
        chart.setTitle("Times for Algorithms");
        xAxis.setLabel("Algorithm");       
        yAxis.setLabel("Time (ms)");
        
        /*
        //create series object for chart.
        XYChart.Series<> series1 = new XYChart.Series<>();
        //////////////////////////////////
        
        //choiceboxes select the first element by default.
        selectEfficiency.getSelectionModel().selectFirst();
        selectEfficiency2.getSelectionModel().selectFirst();
        */
        //create scene object.
        Scene scene = new Scene(root);
        
        //set scene of the stage to the scene object.
        stage.setScene(scene);
        
        //show the stage.
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
        

    
}
