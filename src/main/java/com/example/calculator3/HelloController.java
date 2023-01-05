package com.example.calculator3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txt_result;

    String op="";
    Long number1;
    Long number2;

    @FXML
    public void onNumberClick(ActionEvent ae) {

        String number=((Button)ae.getSource()).getText(); //getSource() Visszaadja azt az objektumot, amelyen az esemény történt.
        txt_result.setText(txt_result.getText()+number); //több számjegy beírásának lehetősége

    }

    @FXML
    public void onOperationClick(ActionEvent ae){

        String operation= ((Button)ae.getSource()).getText();


        //7 + 2 = 9
        if(!operation.equals("=")) {
            if (!op.equals("")) {
                return;
            }
            op = operation;
            number1 = Long.parseLong(txt_result.getText());
            txt_result.setText("");

        }else {
            if(op.equals("")){
                return;
            }
            number2=Long.parseLong(txt_result.getText());
            calculate(number1, number2, op);
            op="";
        }
    }

    public void calculate(Long n1, Long n2, String op) {

        switch (op){
            case "+": txt_result.setText(n1+n2+""); break;
            case "-": txt_result.setText(n1-n2+""); break;
            case "*": txt_result.setText(n1*n2+""); break;
            case "/":
                 if(n1==0){
                     txt_result.setText("0"); break;
            }
                txt_result.setText((n1/n2)+""); break;
        }
    }

    @FXML
    public void delete(){
        txt_result.setText("");
    }

}