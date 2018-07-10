package com.shif3r.simpleandroidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultOut;
    boolean flagchanges = false;
    String strResult, strFirstNumber;
    Button plusButton, minusButton, divideButton, multiplyButton, resultButton, deleteButton;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    int firstNumber = 0;// secondNumber = 0;
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
        resultButton=findViewById(R.id.resultButton);
        deleteButton=findViewById(R.id.deleteButton);
        View.OnClickListener numberClick = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String text = ((TextView) view).getText().toString();
                strFirstNumber = String.valueOf(firstNumber);
                if(!strFirstNumber.equals("0")){
                    strFirstNumber = strFirstNumber + text;
                }
                if(strFirstNumber.equals("0")) {
                    strFirstNumber = text;
                    //flagchanges = true;
                }
                firstNumber = Integer.parseInt(strFirstNumber);
                resultOut.setText(strFirstNumber);
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
        View.OnClickListener operatorClick = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String text = ((TextView)view).getText().toString();
                switch (text){
                    case "+":
                        break;
                    case "-":
                        break;
                    case "/":
                        break;
                    case "*":
                        break;
                    default:

                }
            }
        };
        plusButton.setOnClickListener(operatorClick);
        minusButton.setOnClickListener(operatorClick);
        divideButton.setOnClickListener(operatorClick);
        multiplyButton.setOnClickListener(operatorClick);
        View.OnClickListener delete = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strFirstNumber = String.valueOf(firstNumber);
                if(strFirstNumber.length()>1) strFirstNumber = strFirstNumber.substring(0, strFirstNumber.length()-1);
                else strFirstNumber = "0";
                firstNumber = Integer.parseInt(strFirstNumber);
                resultOut.setText(strFirstNumber);
            }
        };
        deleteButton.setOnClickListener(delete);
    }
}
