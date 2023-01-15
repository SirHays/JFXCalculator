package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Font;

import java.util.*;


public class Controller {

    //left to do:
    //calc will round up after around 7 digits
    //percent button should work as intended with all the functionalities of a percent button.
    //parenthesis

    public static String num1 = "";
    public static double numPercent;
    public static double result =0;
    public static ArrayList<String> nums = new ArrayList<>();
    public static  ArrayList<Integer> ops = new ArrayList<>();
    public static  String equation ="";
    public static boolean isNegative =false;
    public static boolean isPercent =false;
    public static String rString = "";
    public Label label1;
    //all number functions add number to the screen, add the number to num1 which gets added to
    //the nums arraylist later and adds the number to the equation string to be evaluated later.

    //calculation bugs out when multiplying or dividing result after addition or subtraction
    //when adding numbers to negative numbers when they are a result treats the result as positive
    @FXML
    private void button0(ActionEvent event) {

        label1.setText(label1.getText()+ "0");
        num1+= "0";
        equation+="0";
    }


    @FXML
    private void button1(ActionEvent event) {

        label1.setText(label1.getText()+ "1");
        num1+= "1";
        equation+="1";
    }


    @FXML
    private void button2(ActionEvent event) {

        label1.setText(label1.getText()+ "2");
        num1+= "2";
        equation+="2";

    }

    @FXML
    private void button3(ActionEvent event) {

        label1.setText(label1.getText()+ "3");
        num1+= "3";
        equation+="3";

    }

    @FXML
    private void button4(ActionEvent event) {

        label1.setText(label1.getText()+ "4");
        num1+= "4";
        equation+="4";
    }

    @FXML
    private void button5(ActionEvent event) {

        label1.setText(label1.getText()+ "5");
        num1+= "5";
        equation+="5";
    }

    @FXML
    private void button6(ActionEvent event) {

        label1.setText(label1.getText()+ "6");
        num1+= "6";
        equation+="6";
    }

    @FXML
    private void button7(ActionEvent event) {

        label1.setText(label1.getText()+ "7");
        num1+= "7";
        equation+="7";
    }

    @FXML
    private void button8(ActionEvent event) {

        label1.setText(label1.getText()+ "8");
        num1+= "8";
        equation+="8";
    }

    @FXML
    private void button9(ActionEvent event) {
        label1.setText(label1.getText()+ "9");
        num1+= "9";
        equation+="9";
    }
    //all operation functions add operator to the screen, add operator to ops arraylist,
    //add operator to equation string and then depending on if the number was registered
    //as negative, clears num1 or makes isNegative false.
    @FXML
    private void buttonA(ActionEvent event) {
        label1.setText(label1.getText()+ "+");
        if(isNegative){
            ops.add(1);
            equation+="+";
            isNegative =false;
        }
        else {
            nums.add(num1);
            ops.add(1);
            equation+="+";
            num1 = "";
        }

    }

    @FXML
    private void buttonS(ActionEvent event) {
        label1.setText(label1.getText()+ "-");
        if(isNegative){
            ops.add(2);
            equation+="+";
            isNegative =false;
        }
        else {
            nums.add(num1);
            ops.add(2);
            equation+="+";
            num1 = "";
        }

    }

    @FXML
    private void buttonM(ActionEvent event) {
        label1.setText(label1.getText()+ "×");
        if(isNegative){
            //ops.add(3);
            equation+="*";
            isNegative =false;
        }
        else {
            nums.add(num1);
            //ops.add(3);
            equation+="*";
            num1 = "";
        }

    }

    @FXML
    private void buttonD(ActionEvent event) {
        label1.setText(label1.getText()+ "÷");
        if(isNegative){
            //ops.add(4);
            equation+="÷";
            isNegative =false;
        }
        else {
            nums.add(num1);
            //ops.add(4);
            equation+="÷";
            num1 = "";
        }
    }
    //adds dot to screen and equation if there isn't already one in the number.
    @FXML
    private void dot(ActionEvent event) {
        if(!num1.contains(".")){
            label1.setText(label1.getText()+".");
            num1+=".";
            equation+=".";
        }
    }



    //adds percent to the screen, makes numPercent the parseDouble of num1 and makes isPercent true to be used later.
    @FXML
    private void percent(ActionEvent event) {
        label1.setText(label1.getText()+"%");
        numPercent = (Double.parseDouble(num1));
        isPercent = true;


    }
    //first two for loops remove the last character from the label and the equation to not create
    //duplicates and if the number isn't empty, sets number to negative by multiplying it by -1
    //and then adding it back into the equation in addition to setting isNegative to true and adding num1
    //to nums arraylist and clearing it.
    @FXML
    private void negative(ActionEvent event) {
        String label = label1.getText();
        StringBuffer sb= new StringBuffer(label);
        StringBuffer sb2= new StringBuffer(equation);
        for (int i = num1.length(); i >0; i--) {
            sb.deleteCharAt(sb.length()-i);
        }
        for (int i = num1.length(); i >0; i--) {
            sb2.deleteCharAt(sb2.length()-i);
        }
        if(!num1.equals("")){
            label1.setText(sb+"(-"+num1+")");
            equation = String.valueOf(sb2);
            double num1Double = Double.parseDouble(num1);
            num1Double *=-1;
            num1 = String.valueOf(num1Double);
            equation+=num1;
            isNegative =true;
            nums.add(num1);
            num1 ="";
        }

    }
    //clears the screen and all the variables and arraylists that need to be cleared in order to reset the
    //calculator and perform new accurate operations.
    @FXML
    private void clear(ActionEvent event) {
        label1.setText("");
        result =0;
        num1 = "";
        nums.clear();
        ops.clear();
        isNegative = false;
        isPercent = false;
        equation ="";
    }
    //splits equation on "+", replaces each sub operation with its result, and solves normally.
    //for example, 1+2*5-8/2 will split into 1,2*5,8/2 and will replace each sub operation
    //with the result like so: 1+10-4. After that, the program will solve the equation from left to right to get the result 6.
    //(adds negative number instead of subtracting in order to not choke the program when splitting on "-" if negative numbers
    //are in the equation.)

    @FXML
    private void equals(ActionEvent event) {

        if(!isNegative){
            nums.add(num1);
            num1 = "";
        }

        String[] numbers = equation.split("\\+");
        double num1;
        for (String expression : numbers) {
            if (expression.contains("*") || expression.contains("÷")) {
                String[] m = expression.split("[*÷]");
                int count = 1;
                num1 = Double.parseDouble(m[0]);
                for (int k = 0; k < expression.length(); k++) {
                    if (expression.charAt(k) == '*') {
                        num1 *= Double.parseDouble(m[count]);
                        count++;
                    } else if (expression.charAt(k) == '÷') {
                        num1 /= Double.parseDouble(m[count]);
                        count++;
                    }
                }
                equation = equation.replace(expression, String.valueOf(num1));
            }
        }
        String[] numbers2 = equation.split("\\+");
        double result = Double.parseDouble(numbers2[0]);
        double tempNum;
        int j = 0;
        for (int i = 1; i < numbers2.length; i++) {
            tempNum = Double.parseDouble(numbers2[i]);
            int op = ops.get(j);
            if(op==1){
                result += tempNum;
            }
            else{
                result+=tempNum*-1;
            }
            j++;
        }
        //removes .0 ending from double whole number
        if(!isPercent) {
            if ((result - Math.floor(result)) == 0) {
                rString = String.valueOf(result);
                StringBuffer sb = new StringBuffer(rString);
                sb.deleteCharAt(sb.length() - 2);
                sb.deleteCharAt(sb.length() - 1);
                label1.setText(String.valueOf(sb));
                equation = label1.getText();
            } else if ((result - Math.floor(result) != 0)) {
                String resultText = String.valueOf(result);
                if(resultText.length()>13){
                    resultText = resultText.substring(0,12);
                }
                label1.setText(resultText);
                equation = label1.getText();
            }
        }
        // statements below don't really work as intended.
        else if(isPercent && nums.size()>1){
            label1.setText(String.valueOf(result+numPercent-(numPercent*100)));
        }
        else if(isPercent && nums.size()==1){
            label1.setText(String.valueOf(numPercent/100));

        }
    }
}



