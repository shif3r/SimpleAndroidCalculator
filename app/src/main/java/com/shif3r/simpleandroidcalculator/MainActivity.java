package com.shif3r.simpleandroidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean secondNumberActive = false;
    TextView resultOut;
    String strResult, strNumber1, strNumber2;
    Button plusButton, minusButton, divideButton, multiplyButton, deleteButton, changeButton;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    int number1 = 0, number2 = 0, resultNumber = 0;
    public void numbersClear(){
        strNumber1 = "0";
        strNumber2 = "0";
        strResult = "0";
        number1 = 0;
        number2 = 0;
        resultNumber = 0;
        secondNumberActive = false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultOut=findViewById(R.id.resultView);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        button0=findViewById(R.id.button0);
        plusButton=findViewById(R.id.buttonPlus);
        minusButton=findViewById(R.id.buttonMinus);
        divideButton=findViewById(R.id.buttonDivide);
        multiplyButton=findViewById(R.id.buttonMultiply);
        deleteButton=findViewById(R.id.deleteButton);
        changeButton=findViewById(R.id.changeNumberButton);
        View.OnClickListener numberClick = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(!secondNumberActive){
                    String text = ((TextView) view).getText().toString();
                    strNumber1 = String.valueOf(number1);
                    if(strNumber1.length()==10) Toast.makeText(getBaseContext(), "Превышена максимальная длинна числа", Toast.LENGTH_LONG).show();
                    else {
                        if(!strNumber1.equals("0")) strNumber1 = strNumber1 + text;
                        if(strNumber1.equals("0")) strNumber1 = text;
                        number1 = Integer.parseInt(strNumber1);
                        resultOut.setText(strNumber1);
                    }
                }
                else {
                    String text = ((TextView) view).getText().toString();
                    strNumber2 = String.valueOf(number2);
                    if(strNumber2.length()==10)Toast.makeText(getBaseContext(), "Превышена максимальная длинна числа", Toast.LENGTH_LONG).show();
                    else {
                        if(!strNumber2.equals("0")) strNumber2 = strNumber2 + text;
                        if(strNumber2.equals("0")) strNumber2 = text;
                        number2 = Integer.parseInt(strNumber2);
                        resultOut.setText(strNumber2);
                    }
                }
            }
        };
        View.OnClickListener operatorClick = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text = ((TextView)view).getText().toString();
                switch (text){
                    case "+":
                        resultNumber = number1 + number2;
                        strResult = Integer.toString(resultNumber);
                        if(strResult.length()==10) Toast.makeText(getBaseContext(), "Превышена максимальная длинна числа", Toast.LENGTH_LONG).show();
                        else {
                            resultOut.setText(strResult);
                            numbersClear();
                        }
                        break;
                    case "-":
                        resultNumber = number1 - number2;
                        strResult = Integer.toString(resultNumber);
                        if(strResult.length()==10) Toast.makeText(getBaseContext(), "Превышена максимальная длинна числа", Toast.LENGTH_LONG).show();
                        else {
                            resultOut.setText(strResult);
                            numbersClear();
                        }
                        break;
                    case "/":
                        if(number2==0){
                            Toast.makeText(getBaseContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                            strResult = "Error";
                            resultOut.setText(strResult);
                        } else {
                            resultNumber = number1 / number2;
                            strResult = Integer.toString(resultNumber);
                            if(strResult.length()==10) Toast.makeText(getBaseContext(), "Превышена максимальная длинна числа", Toast.LENGTH_LONG).show();
                            else {
                                resultOut.setText(strResult);
                            }
                        }
                        numbersClear();
                        break;
                    case "*":
                        resultNumber = number1 * number2;
                        strResult = Integer.toString(resultNumber);
                        if(strResult.length()==10) Toast.makeText(getBaseContext(), "Превышена максимальная длинна числа", Toast.LENGTH_LONG).show();
                        else {
                            resultOut.setText(strResult);
                            numbersClear();
                        }
                        break;
                    case "NUM":
                        if(secondNumberActive){
                            Toast.makeText(getBaseContext(), "Первое число", Toast.LENGTH_SHORT).show();
                            secondNumberActive = false;
                            resultOut.setText(strNumber1);
                        }
                        else {
                            Toast.makeText(getBaseContext(), "Второе число", Toast.LENGTH_SHORT).show();
                            secondNumberActive = true;
                            resultOut.setText(strNumber2);
                        }
                        break;
                    case "<-":
                        if(!secondNumberActive){
                            strNumber1 = String.valueOf(strNumber1);
                            if(strNumber1.length()>1) strNumber1 = strNumber1.substring(0, strNumber1.length()-1);
                            else strNumber1 = "0";
                            number1 = Integer.parseInt(strNumber1);
                            resultOut.setText(strNumber1);
                        }
                        else {
                            strNumber2 = String.valueOf(strNumber2);
                            if(strNumber2.length()>1) strNumber2 = strNumber2.substring(0, strNumber2.length()-1);
                            else strNumber2 = "0";
                            number2 = Integer.parseInt(strNumber2);
                            resultOut.setText(strNumber2);
                        }
                        break;
                    default:
                }
            }
        };
        button1.setOnClickListener(numberClick);
        button2.setOnClickListener(numberClick);
        button3.setOnClickListener(numberClick);
        button4.setOnClickListener(numberClick);
        button5.setOnClickListener(numberClick);
        button6.setOnClickListener(numberClick);
        button7.setOnClickListener(numberClick);
        button8.setOnClickListener(numberClick);
        button9.setOnClickListener(numberClick);
        button0.setOnClickListener(numberClick);
        plusButton.setOnClickListener(operatorClick);
        minusButton.setOnClickListener(operatorClick);
        divideButton.setOnClickListener(operatorClick);
        multiplyButton.setOnClickListener(operatorClick);
        deleteButton.setOnClickListener(operatorClick);
        changeButton.setOnClickListener(operatorClick);
    }
}
