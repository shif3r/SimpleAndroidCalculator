package com.shif3r.simpleandroidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
    TextView resultOut;
    String strResult;
    Button plusButton, minusButton, divideButton, multiplyButton, resultButton;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    int firstNumber = NULL, secondNumber = NULL;
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
        View.OnClickListener numberClick = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String text = ((TextView) view).getText().toString();
                String strFirstNumber;
                strFirstNumber = String.valueOf(firstNumber);
                strFirstNumber = strFirstNumber + text;
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
    }
}
