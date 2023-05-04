package edu.guilford;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CalPane extends GridPane {

    private TextField billField;
    private TextField tipField;
    private TextField totalField;
    private Button calculateButton;
    private ImageView imageview;
    private Calculate calculate;
    //private final List<Calculate> calculationList;


    // create constructor for the calPane
    public CalPane(Calculate calculate) {
        super();
        this.calculate = calculate;
        
        // instantiate text fields 
        billField = new TextField();
        tipField = new TextField();
        totalField = new TextField();
        calculateButton = new Button("Calculate");


        // add labels to the pane
        Label billLabel = new Label("Bill Amount:");
        add(billLabel, 1, 0);

        // add textfield to the pane
        billField = new TextField();
        billField.setPromptText("Enter bill amount");
        add(billField, 2, 0);
        //put user input into the get bill method
        

        // add labels to the pane
        Label tipLabel = new Label("Tip Percent:");
        add(tipLabel, 1, 2);
       

        tipField = new TextField();
        tipField.setPromptText("Enter tip percentage");
        
        add(tipField, 2, 2);

        // add labels to the pane
        Label totalLabel = new Label("Total Amount:");
        add(totalLabel, 1, 3);

        totalField = new TextField();
        totalField.setPromptText("total amount");
        add(totalField, 2, 3);
        totalField.editableProperty().setValue(false);

        // calculate button
        calculateButton = new Button("Calculate");
        add(calculateButton, 2, 4);

        // add event handler to the button
        calculateButton.setOnAction(event -> calculateTip());

        // set font of labels bigger
        billLabel.setStyle("-fx-font-size: 20px;");
        tipLabel.setStyle("-fx-font-size: 20px;");
        totalField.setStyle("-fx-font-size: 20px;");
        // set font of textfields bigger
        billField.setStyle("-fx-font-size: 20px;");
        tipField.setStyle("-fx-font-size: 20px;");
        totalLabel.setStyle("-fx-font-size: 20px;");
        totalField.setStyle("-fx-font-size: 20px;");
        // set font of button bigger
        calculateButton.setStyle("-fx-font-size: 20px;");

        // event handler for tip percentage input
        tipField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double tipPercentage = Double.parseDouble(newValue);
                if (tipPercentage < 20) {
                    tipLabel.setTextFill(Color.RED);
                    tipLabel.setText("Tip Percent:\nTip should be at least 20%)");
                } else if (tipPercentage > 20) {
                    tipLabel.setTextFill(Color.GREEN);
                    tipLabel.setText("Tip Percent: " + (calculate.getTip()));
                } else
                    tipLabel.setTextFill(Color.BLACK);
            } catch (NumberFormatException e) {

                //
            }
        });

    }

    // method that calculates the tip
    private void calculateTip() {
        try {
            // get the bill amount
           // double billAmount = calculate.getBill();             //old code didn't work
            //calculate.setBill(Double.parseDouble(billField.getText()));
            //double tipPercentage = calculate.getTip();  //didn;t work
            //calculate.setTip(Double.parseDouble(tipField.getText()));
            //double tipPercentage = Double.parseDouble(tipField.getText());
            
          
            double billAmount = Double.parseDouble(billField.getText());
            System.out.println(billAmount);
            double tipPercentage = Double.parseDouble(tipField.getText());
            System.out.println(tipPercentage);
            double tipAmount = billAmount * tipPercentage / 100;
            double totalAmount = billAmount + tipAmount;
            
            // display the total
            calculate.setTotal(totalAmount);// set total in calculate object 

            //totalField.setText(String.format("$%.2f", totalAmount));
            totalField.setText(String.format("$%.2f", totalAmount));
    

            /// Image element
            imageview = new ImageView("https://itxdesign.com/wp-content/uploads/2016/05/6072965_s-300x251.jpg");
            // display the imageview url
            System.out.println(imageview.getImage().getUrl());
            this.add(imageview, 2, 5);
            imageview.setFitHeight(400);
            imageview.setFitWidth(400);
            imageview.setPreserveRatio(true);

        } catch (NumberFormatException e) {
            // ignore invalid input

        }

    }
}
