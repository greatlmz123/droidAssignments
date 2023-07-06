package com.example.myapplication;

import static java.lang.Math.sqrt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TextView input;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = this.findViewById(R.id.input);
        result = this.findViewById(R.id.result);
    }
    String input1 = "";
    String oper = "";
    String input2 = "";
    boolean flag = false;
    boolean input1_flag = false;
    boolean input1_pt = false;
    boolean input2_pt = false;
    public void oneOnClick(View view){
        if(view instanceof TextView){
            String oneText = ((TextView)view).getText().toString();
            if(flag){
                if ("C".equals(oneText)) {
                    input.setText("");
                    result.setText("");
                    input1 = "";
                    input2 = "";
                    oper = "";
                    input1_flag = false;
                    flag = false;
                }
            }else{
                switch (oneText){
                    case "+/-":
                        if(!input1_flag){
                            if(input1.charAt(0)!='-') input1 = "-"+input1;
                            else input1=input1.substring(1);
                            input.setText(input1);
                        }else{
                            if(input2.charAt(0)!='-') input2 = "-"+input2;
                            else input2=input2.substring(1);
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "%":
                        if(!input1_flag){
                            input1=String.valueOf(Double.valueOf(input1).floatValue()/100);
                            input.setText(input1);
                        }else{
                            input2=String.valueOf(Double.valueOf(input2).floatValue()/100);
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "√":
                        if(!input1_flag){
                            if(input1.charAt(0)=='-') Toast.makeText(MainActivity.this, "只支持实数范围运算。", Toast.LENGTH_LONG).show();
                            else input1=String.valueOf(sqrt(Double.valueOf(input1).floatValue()));
                            input.setText(input1);
                        }else{
                            if(input2.charAt(0)=='-') Toast.makeText(MainActivity.this, "只支持实数范围运算。", Toast.LENGTH_LONG).show();
                            input2=String.valueOf(sqrt(Double.valueOf(input2).floatValue()));
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "1":
                        if(!input1_flag){
                            input1 += "1";
                            input.setText(input1);
                        }else{
                            input2 += "1";
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "2":
                        if(!input1_flag){
                            input1 += "2";
                            input.setText(input1);
                        }else{
                            input2 += "2";
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "3":
                        if(!input1_flag){
                            input1 += "3";
                            input.setText(input1);
                        }else{
                            input2 += "3";
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "4":
                        if(!input1_flag){
                            input1 += "4";
                            input.setText(input1);
                        }else{
                            input2 += "4";
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "5":
                        if(!input1_flag){
                            input1 += "5";
                            input.setText(input1);
                        }else{
                            input2 += "5";
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "6":
                        if(!input1_flag){
                            input1 += "6";
                            input.setText(input1);
                        }else{
                            input2 += "6";
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "7":
                        if(!input1_flag){
                            input1 += "7";
                            input.setText(input1);
                        }else{
                            input2 += "7";
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "8":
                        if(!input1_flag){
                            input1 += "8";
                            input.setText(input1);
                        }else{
                            input2 += "8";
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "9":
                        if(!input1_flag){
                            input1 += "9";
                            input.setText(input1);
                        }else{
                            input2 += "9";
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case "0":
                        if(!input1_flag){
                            input1 += "0";
                            input.setText(input1);
                        }else{
                            input2 += "0";
                            input.setText(input1+oper+input2);
                        }
                        break;
                    case ".":
                        if(!input1_flag){
                            if(!input1_pt) input1 += ".";
                            input1_pt=true;
                            input.setText(input1);
                        }else{
                            if(!input2_pt) input2 += ".";
                            input2_pt=true;
                            input.setText(input1+oper+input2);
                        }
                        break;}
                if(!Objects.equals(input1, "")) switch (oneText){
                    case "÷":
                        oper = "÷";
                        input1_flag = true;
                        input.setText(input1+oper+input2);
                        break;
                    case "×":
                        oper = "×";
                        input1_flag = true;
                        input.setText(input1+oper+input2);
                        break;
                    case "-":
                        oper = "-";
                        input1_flag = true;
                        input.setText(input1+oper+input2);
                        break;
                    case "+":
                        oper = "+";
                        input1_flag = true;
                        input.setText(input1+oper+input2);
                        break;
                    case "=":
                        if(!Objects.equals(input2, "")){
                        if(input1.charAt(0)=='.') input1="0"+input1;
                        if(input2.charAt(0)=='.') input2="0"+input2;
                        if(input1.substring(0,1)=="-.") input1="-0"+input1.substring(1);
                        if(input2.substring(0,1)=="-.") input2="-0"+input2.substring(1);
                        float num1 = Float.valueOf(input1).floatValue();
                        float num2 = Float.valueOf(input2).floatValue();
                        if(oper.equals("+")){
                            flag = true;
                            result.setText(String.valueOf(num1+num2));
                        }
                        else if(oper.equals("-")){
                            flag = true;
                            result.setText(String.valueOf(num1-num2));
                        }
                        else if(oper.equals("×")){
                            flag = true;
                            result.setText(String.valueOf(num1*num2));
                        }
                        if(oper.equals("÷")){
                            if (num2 == 0) {
                                Toast.makeText(MainActivity.this, "除数不能为0。", Toast.LENGTH_LONG).show();
                            }else{
                                flag = true;
                                result.setText(String.valueOf(num1/num2));
                            }
                        }}
                        break;
                }
            }

        }
    }
}