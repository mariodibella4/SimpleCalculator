package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import javax.ejb.EJB;

public class MainActivity extends AppCompatActivity {
    private TextView txtDisplay;
    @EJB
    private BackEndSimpleCalcRemote remote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
            e.getMessage();
        }
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
        remote.getSolution(input);
       }


    public void clearListener(View view){
        txtDisplay =findViewById(R.id.textViewOutput);
        txtDisplay.setText("0");
    }




}