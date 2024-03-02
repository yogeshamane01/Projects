package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    double firstnum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button num0 =findViewById(R.id.num0);
        Button num1 =findViewById(R.id.num1);
        Button num2 =findViewById(R.id.num2);
        Button num3 =findViewById(R.id.num3);
        Button num4 =findViewById(R.id.num4);
        Button num5 =findViewById(R.id.num5);
        Button num6 =findViewById(R.id.num6);
        Button num7 =findViewById(R.id.num7);
        Button num8 =findViewById(R.id.num8);
        Button num9 =findViewById(R.id.num9);

        Button on =findViewById(R.id.on);
        Button del =findViewById(R.id.numdel);
        Button div =findViewById(R.id.numDiv);
        Button ac =findViewById(R.id.numAC);
        Button add=findViewById(R.id.numAdd);
        Button equal=findViewById(R.id.numEqual);
        Button dot=findViewById(R.id.numdot);
        Button mul=findViewById(R.id.numMul);
        Button sub=findViewById(R.id.numSub);
        Button mod=findViewById(R.id.numMOD);

        TextView screen =findViewById(R.id.screen);

        ac.setOnClickListener(view -> {
            firstnum = 0;
            screen.setText("0");
        });

        mod.setOnClickListener(view ->screen.setVisibility(View.GONE));
        on.setOnClickListener(View -> {
            screen.setVisibility(View.VISIBLE);
            //screen.setText("0");
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for(Button b : nums){
            b.setOnClickListener(View ->{
                if(screen.getText().toString().equals("0")){
                    screen.setText(b.getText().toString());
                }else{
                    screen.setText(screen.getText().toString()+b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(div);
        opers.add(add);
        opers.add(mul);
        opers.add(sub);
        opers.add(mod);

        for(Button b : opers){
            b.setOnClickListener(view ->{

                firstnum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText(operation);
            });
        }

        del.setOnClickListener(view ->{
            String num = screen.getText().toString();
            if(num.length()>1){
                screen.setText(num.substring(0,num.length()-1));
            }else if (num.length()==1 && !num.equals("0")){
                screen.setText("0");
            }
        });

        dot.setOnClickListener(view -> {
            if (!screen.getText().toString().contains("."));
            screen.setText(screen.getText().toString() + ".");
        });

        equal.setOnClickListener(view -> {
            double secondNum = Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation){
                case "/":
                    result =firstnum/secondNum;
                    break;
                case "*":
                    result = firstnum * secondNum;
                    break;
                case "-":
                    result = firstnum - secondNum;
                    break;
                case "+":
                    result = firstnum + secondNum;
                    break;
                default:
                    result = firstnum % secondNum;
            }
            screen.setText(String.valueOf(result));
            firstnum = result;
        });

    }
}