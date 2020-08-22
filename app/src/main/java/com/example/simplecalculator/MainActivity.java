package com.example.simplecalculator;
import android.view.Window;
import android.view.WindowManager;
import net.objecthunter.exp4j.ExpressionBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    private TextView txtDisplay;
    Controller controller=new Controller();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);

    }
    public void numericListener(View view){
        txtDisplay =findViewById(R.id.textViewOutput);
                Button button =(Button) view;
                if(txtDisplay.getText().toString().matches("0")){
                    txtDisplay.setText(button.getText());
                }else{
                txtDisplay.append(button.getText());
                }
    }
    public void operationalListener(View view){
        txtDisplay =findViewById(R.id.textViewOutput);
        Button button =(Button) view;
        if(!txtDisplay.getText().toString().matches("0")){
            txtDisplay.append(button.getText());
        }
    }
    public void equalListener(View view){
        txtDisplay =findViewById(R.id.textViewOutput);
        String input=txtDisplay.getText().toString();
        String inputUpdated= controller.replaceMultiplyAndDivideWithProperSymbols(input);
            ExpressionBuilder expression = new ExpressionBuilder(inputUpdated);
            try {
                double result = expression.build().evaluate();
                txtDisplay.setText(Double.toString(result));
            } catch (ArithmeticException e) {
                e.printStackTrace();
            }
       }


    public void clearListener(View view){
        txtDisplay =findViewById(R.id.textViewOutput);
        txtDisplay.setText("0");
    }




}