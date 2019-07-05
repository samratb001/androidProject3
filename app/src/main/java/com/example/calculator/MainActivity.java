package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.function.DoubleUnaryOperator;

public class MainActivity extends AppCompatActivity {

    private Button op;
    private Button cal;
    private TextView result;
    private EditText first;
    private EditText second;
    private int count=0;
    View view;
    public String mode[]={"Addition","Subtraction","Division","Multiply"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         view=this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.gray);
        op=findViewById(R.id.operation);
        cal=findViewById(R.id.Calculate);
        result=findViewById(R.id.result);
        first=findViewById(R.id.firstNum);
        second=findViewById(R.id.secondNum);
    }
    public void onPress(View view){

        count=(count+1)%4;
        op.setText("Mode:" + mode[count]);
    }
    public void onCalpressed(View view){
        double firstnum= Double.parseDouble(first.getText().toString());
        double secondnum=Double.parseDouble(second.getText().toString());
        double res=0;
        if(count==0) {
            res = (firstnum + secondnum);
        }
        else if(count==3) {
            res = firstnum * secondnum;
        }
        else if(count==2) {
          try{
             res = (firstnum /secondnum);
          }
          catch(ArithmeticException ex) {
            result.setText("Illegal Operation");
          }
        }
        else if(count==1) {
            res = (firstnum - secondnum);
        }
        result.setText(String.format("%.2f",res));
       // result.setText(Double.toString(res));
       }
        public void onErase(View view){
             result.setText("");
             first.setText("");
             second.setText("");
        }
}
