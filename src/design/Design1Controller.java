/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import java.util.StringTokenizer;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;
import javafx.event.EventType;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.input.*;

/**
 *
 * @author Albert Toledo
 */


public class Design1Controller implements Initializable {
    
    //FXML Elements control variables.
    @FXML private TextField tfSequence;
    @FXML private Button button;
    @FXML private Label sum;
    @FXML private Label efficiency;
    @FXML private Label subSequence;
    //@FXML private ProgressBar pBar;
    @FXML private BarChart chart;
    @FXML private XYChart.Series series1;
    @FXML private Label time;
    @FXML private Label seqSize;
    @FXML private Slider sliderSize;
    @FXML private Label randomSize;
    @FXML private ToggleButton manual;
    @FXML private ToggleButton random;
    @FXML private AnchorPane manualPane;
    @FXML private AnchorPane randomPane;
    @FXML private AnchorPane welcomePane;
    @FXML private AnchorPane results;
    @FXML private ToggleGroup menuGroup;
    @FXML private ChoiceBox selectEfficiency;
    @FXML private ChoiceBox selectEfficiency2;
    @FXML private ImageView close;
    @FXML private HBox menu;
    
    //instance variables to store values in.
    int randomN;    //size of the randomly generated sequence.
    
    
    
    @FXML private void handleButtonAction(ActionEvent event) {
        //Input from the textfield.
        String fullSequence;
        
        //Assign the value of sequence from textfield to the variable.
        fullSequence = tfSequence.getText();
        
        //get the algorithm by efficiency chosen.
        String algorithm = selectEfficiency.getValue().toString();
        
        //Create String Tokenizer object to seperate the sequence into numbers.
        StringTokenizer sToken = new StringTokenizer(fullSequence, ",", false);
        
        //Count the number of tokens.
        int numToken = sToken.countTokens();
        
        //Create an integet array to hold the numbers in the sequence.
        int[] sequenceArray = new int[numToken];
        
        //initialize counter variable.
        int count = 0;
        
        //Tokenize the string and insert components into an integer array.
        while (sToken.hasMoreTokens()) 
        {
         //set index count of the array to the next token of the sequence
         //converted to integer from string.
         sequenceArray[count] = Integer.parseInt(sToken.nextToken());
         //increment the counter by 1 everytime.
         count++;
        }
        
        //create a sequence object with the array.
        Sequence seq = new Sequence(sequenceArray);
        
        //find the subsequence using the cubic method and create Sequence object with it.
        //start the timer
        long startTime = 0;
        long totalTime = 0;
        long start2 = 0;
        long total2 = 0;
        long start3 = 0;
        long total3 = 0;
        
        //create sequence object to store the subsequence
        Sequence sub = null;
        
        //check each possible algorithm chosen and call appropriate method.
        switch (algorithm){
            case "N": {
                
                //keep track of time.
                startTime = System.currentTimeMillis( );
                totalTime = 0;
                
                //calculate
                sub = seq.maxSubSumLinear();
                
                //get the time difference.
                totalTime = System.currentTimeMillis( ) - startTime;
                series1.getData().add(new XYChart.Data("N", totalTime));
                
            } break;
                
            case "N Square": { 
                //keep track of time.
                startTime = System.currentTimeMillis( );
                totalTime = 0;
                
                //calculate
                sub = seq.maxSubSumQuadratic();
                
                //get the time difference.
                totalTime = System.currentTimeMillis( ) - startTime;
                series1.getData().add(new XYChart.Data("N Square", totalTime));
                
            } break;
            
            case "N Cube": {
                
                //keep track of time.
                startTime = System.currentTimeMillis( );
                totalTime = 0;
                
                //calculate
                sub = seq.maxSubSumCubic();
                
                //get the time difference.
                totalTime = System.currentTimeMillis( ) - startTime;
                series1.getData().add(new XYChart.Data("N Cube", totalTime));
                
            } break;
                
            case "Compare All": {
                
                //keep track of time.
                startTime = System.currentTimeMillis( );
                totalTime = 0;
                
                //calculate
                sub = seq.maxSubSumLinear();
                
                //get the time difference.
                totalTime = System.currentTimeMillis( ) - startTime;
                series1.getData().add(new XYChart.Data("N", totalTime));
                
                //keep track of time for n square.
                start2 = System.currentTimeMillis( );
                total2 = 0;
                
                //calculate
                sub = seq.maxSubSumQuadratic();
                
                //get the time difference.
                total2 = System.currentTimeMillis( ) - start2;
                series1.getData().add(new XYChart.Data("N Square", total2));
                
                //keep track of time for n cube.
                start3 = System.currentTimeMillis( );
                total3 = 0;
                
                //calculate
                sub = seq.maxSubSumQuadratic();
                
                //get the time difference.
                total3 = System.currentTimeMillis( ) - start3;
                series1.getData().add(new XYChart.Data("N Cube", total3));
                
            } break;
            
        }
      
        
        //set the sum to the max sum getting it from the object with getSum method.
        sum.setText(Integer.toString(sub.getSum()));
        
        //set N to the size of the input sequence
        seqSize.setText(Integer.toString(seq.getSize()));
        
        //set the subsequence text getting it from the object with getsequencestring method.
        subSequence.setText(sub.getSequenceString());
        
        //set the time to the time label.
        time.setText(String.valueOf(totalTime)+ " ms");
        
        //set the efficiency to the results
        efficiency.setText(algorithm);
        
        //show results
        results.setVisible(true);
        
        //set values to the chart.
        chart.getData().addAll(series1);

    }
    
    
    @FXML private void handleRandomButtonAction(ActionEvent event) {
        
        //create a sequence object with the array.
        int[] a = new int[1];
        Sequence seq = new Sequence(randomN);
        
        //get the algorithm by efficiency chosen.
        String algorithm = selectEfficiency2.getValue().toString();
        
        //find the subsequence using the cubic method and create Sequence object with it.
        //start the timer
        long startTime = 0;
        long totalTime = 0;
        long start2 = 0;
        long total2 = 0;
        long start3 = 0;
        long total3 = 0;
        
        //create sequence object to store the subsequence
        Sequence sub = null;
        
        //check each possible algorithm chosen and call appropriate method.
       /* switch (algorithm){
            case "N": sub = seq.maxSubSumLinear();
            case "N Square": sub = seq.maxSubSumQuadratic();
            case "N Cube": sub = seq.maxSubSumCubic();
                
        }
        
        //get the time difference.
        totalTime = System.currentTimeMillis( ) - startTime;
        
        //set the sum to the max sum getting it from the object with getSum method.
        sum.setText(Integer.toString(sub.getSum()));
        
        //set the subsequence text getting it from the object with getsequencestring method.
        subSequence.setText(sub.getSequenceString());
        
        //set the time to the time label.
        time.setText(String.valueOf(totalTime)+ " ms");
        
        //set N to the size of the input sequence
        seqSize.setText(Integer.toString(seq.getSize()));
        
        //set the efficiency to the results
        efficiency.setText(algorithm);
        
        //show the results
        results.setVisible(true); */
        
        //craph test
        
        
        
        
        //check each possible algorithm chosen and call appropriate method.
        switch (algorithm){
            case "N": {
                
                //keep track of time.
                startTime = System.currentTimeMillis( );
                totalTime = 0;
                
                //calculate
                sub = seq.maxSubSumLinear();
                
                //get the time difference.
                totalTime = System.currentTimeMillis( ) - startTime;
                series1.getData().add(new XYChart.Data("N", totalTime));
                
            } break;
                
            case "N Square": { 
                //keep track of time.
                startTime = System.currentTimeMillis( );
                totalTime = 0;
                
                //calculate
                sub = seq.maxSubSumQuadratic();
                
                //get the time difference.
                totalTime = System.currentTimeMillis( ) - startTime;
                series1.getData().add(new XYChart.Data("N Square", totalTime));
                
            } break;
            
            case "N Cube": {
                
                //keep track of time.
                startTime = System.currentTimeMillis( );
                totalTime = 0;
                
                //calculate
                sub = seq.maxSubSumCubic();
                
                //get the time difference.
                totalTime = System.currentTimeMillis( ) - startTime;
                series1.getData().add(new XYChart.Data("N Cube", totalTime));
                
            } break;
                
            case "Compare All": {
                
                //keep track of time.
                startTime = System.currentTimeMillis( );
                totalTime = 0;
                
                //calculate
                sub = seq.maxSubSumLinear();
                
                //get the time difference.
                totalTime = System.currentTimeMillis( ) - startTime;
                series1.getData().add(new XYChart.Data("N", totalTime));
                
                //keep track of time for n square.
                start2 = System.currentTimeMillis( );
                total2 = 0;
                
                //calculate
                sub = seq.maxSubSumQuadratic();
                
                //get the time difference.
                total2 = System.currentTimeMillis( ) - start2;
                series1.getData().add(new XYChart.Data("N Square", total2));
                
                //keep track of time for n cube.
                start3 = System.currentTimeMillis( );
                total3 = 0;
                
                //calculate
                sub = seq.maxSubSumQuadratic();
                
                //get the time difference.
                total3 = System.currentTimeMillis( ) - start3;
                series1.getData().add(new XYChart.Data("N Cube", total3));
                
            } break;
            
        }
      
        
        //set the sum to the max sum getting it from the object with getSum method.
        sum.setText(Integer.toString(sub.getSum()));
        
        //set N to the size of the input sequence
        seqSize.setText(Integer.toString(seq.getSize()));
        
        //set the subsequence text getting it from the object with getsequencestring method.
        subSequence.setText(sub.getSequenceString());
        
        //set the time to the time label.
        time.setText(String.valueOf(totalTime)+ " ms");
        
        //set the efficiency to the results
        efficiency.setText(algorithm);
        
        //show results
        results.setVisible(true);
        
        //set values to the chart.
        chart.getData().addAll(series1);
    }
    
    
    //change to the manual view.
    @FXML private void goManual(ActionEvent event){
            
            welcomePane.setVisible(false);
            manualPane.setVisible(true);
            randomPane.setVisible(false);  
            results.setVisible(false);
            menu.setVisible(true);
        
    }
    
    //change to the random view
    @FXML private void goRandom(ActionEvent event){
            
            welcomePane.setVisible(false);
            randomPane.setVisible(true);
            manualPane.setVisible(false); 
            results.setVisible(false);
            menu.setVisible(true);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        welcomePane.setVisible(true);
        randomPane.setVisible(false);
        manualPane.setVisible(false); 
        results.setVisible(false);
        menu.setVisible(false);
        
        //create axis objects for the barchart.
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        
        //initialize barchart object.
        chart = new BarChart<>(xAxis,yAxis);
        
        //set chart titles.
        chart.setTitle("Times for Algorithms");
        xAxis.setLabel("Algorithm");       
        yAxis.setLabel("Time (ms)");
        
        //create series object for chart.
        series1 = new XYChart.Series<>();
        //////////////////////////////////
        
        //choiceboxes select the first element by default.
        selectEfficiency.getSelectionModel().selectFirst();
        selectEfficiency2.getSelectionModel().selectFirst();
        
        //set the close function to the close button(image)
        close.setOnMouseClicked(new EventHandler<MouseEvent>() {
        
        //handle mouse click on the close button(image) with exiting the system.
        @Override
        public void handle(MouseEvent arg0) {
              System.exit(0);
                        }
         });
        
        //set N value equal to the slider value.
        sliderSize.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    randomN = new_val.intValue();
                    randomSize.setText(Integer.toString(randomN));
            }
        });//end slider equals N.
        
        
    }    
}


