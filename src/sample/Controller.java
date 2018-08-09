package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label result;
    private double number1 = 0;
    private String operator= "";
    private boolean start = true;
    private Model model = new Model();

    public  void processNumbers(ActionEvent event){
        if (start){
            result.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText()+ value);
    }
    public void processOperator(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if (!value.equals("=")){
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Double.parseDouble(result.getText());
            //number1 = Long.parseLong(result.getText());
            result.setText("");
        }
        else {
            if(operator.isEmpty()){
                return;
            }
            double number2 = Double.parseDouble(result.getText());
            //long number2 = Long.parseLong(result.getText());
            double output = model.calculate(number1, number2, operator);
            result.setText((String.valueOf(output)));
            operator = "";
            start = true;
        }
    }

}
