package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnClear, btnPlusMinus;
    TextView tv_san, tv_zapis;
    Button btnPlus, btnDivide, btnMultiply, btnMinus, buttonEqual, btnNukte;

    String BirinshiSan, ekinshiSan, znak, zapisText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        sandarMethods();
        oshiruPlusMinusMethod();
        functionMethods();


    }
    public void initViews(){
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnClear = findViewById(R.id.btn_c);
        btnPlusMinus = findViewById(R.id.pd);
        buttonEqual = findViewById(R.id.btnTen);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivide = findViewById(R.id.btnBolu);
        btnMultiply = findViewById(R.id.btnX);
        btnNukte = findViewById(R.id.btnNukte);


        tv_san = findViewById(R.id.tv_san);
        tv_zapis = findViewById(R.id.tv_zapis);
    }
    public void sandarMethods(){
        View.OnClickListener buttonSandar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aldingiSan = tv_san.getText().toString();
                String baasilganSan = "";
                String songiResult = "";

                switch (view.getId()){
                    case R.id.btn0:
                        baasilganSan = "0";
                        break;
                    case R.id.btn1:
                        baasilganSan = "1";
                        break;
                    case R.id.btn2:
                        baasilganSan = "2";
                        break;
                    case R.id.btn3:
                        baasilganSan = "3";
                        break;
                    case R.id.btn4:
                        baasilganSan = "4";
                        break;
                    case R.id.btn5:
                        baasilganSan = "5";
                        break;
                    case R.id.btn6:
                        baasilganSan = "6";
                        break;
                    case R.id.btn7:
                        baasilganSan = "7";
                        break;
                    case R.id.btn8:
                        baasilganSan = "8";
                        break;
                    case R.id.btn9:
                        baasilganSan = "9";
                        break;
                    case R.id.btnNukte:
                        if(aldingiSan.contains(("."))){
                            baasilganSan = "";
                        }else{
                            baasilganSan = ".";
                        }
                        break;
                }
                if(!aldingiSan.equals("0")) songiResult = aldingiSan + baasilganSan;
                else songiResult = baasilganSan;
                tv_san.setText(songiResult);
            }
        };
        btn0.setOnClickListener(buttonSandar);
        btn1.setOnClickListener(buttonSandar);
        btn2.setOnClickListener(buttonSandar);
        btn3.setOnClickListener(buttonSandar);
        btn4.setOnClickListener(buttonSandar);
        btn5.setOnClickListener(buttonSandar);
        btn6.setOnClickListener(buttonSandar);
        btn7.setOnClickListener(buttonSandar);
        btn8.setOnClickListener(buttonSandar);
        btn9.setOnClickListener(buttonSandar);
        btnNukte.setOnClickListener(buttonSandar);

    }
    public void oshiruPlusMinusMethod(){
        View.OnClickListener buttonOshiruPlusMinus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_san.setText("0");
                switch (view.getId()){
                    case R.id.btn_c:
                        tv_san.setText("0");
                        tv_zapis.setText("");
                        break;
                    case R.id.pd:
                        String sanText = tv_san.getText().toString();
                        int san = Integer.parseInt(sanText);

                        if(san > 0) tv_san.setText("-"+sanText);
                        else {
                            san = san * (-1);
                            tv_san.setText("" + san);
                        };
                        break;
                }
            }
        };

        btnClear.setOnClickListener(buttonOshiruPlusMinus);
        btnPlusMinus.setOnClickListener(buttonOshiruPlusMinus);
    }
    public void functionMethods(){
        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BirinshiSan = tv_san.getText().toString();
                switch (view.getId()){
                    case R.id.btnPlus:
                        znak = "+";
                        break;
                    case R.id.btnMinus:
                        znak = "-";
                        break;
                    case R.id.btnBolu:
                        znak = "/";
                        break;
                    case R.id.btnX:
                        znak = "*";
                        break;
                    case R.id.btnPercent:
                        znak = "%";
                        break;
                }
                zapisText = BirinshiSan + znak;
                tv_zapis.setText(zapisText);
                tv_san.setText("0");

            }
        };

        btnPlus.setOnClickListener(btnFunctions);
        btnMinus.setOnClickListener(btnFunctions);
        btnMultiply.setOnClickListener(btnFunctions);
        btnDivide.setOnClickListener(btnFunctions);



        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ekinshiSan = tv_san.getText().toString();
                double res = 0;
                if(tv_san.getText().toString().contains(".")){
                    double san1 = Double.parseDouble(BirinshiSan);
                    double san2 = Double.parseDouble(ekinshiSan);
                    if(znak.equals("+")){
                        res = san1 + san2;
                    }
                    else if(znak.equals("-")){
                        res = san1 - san2;
                    }else if(znak.equals("*")){
                        res = san1 * san2;
                    }else if(znak.equals("/")){
                        res = san1 / san2;
                    }else if(znak.equals("%")){
                        res  = san1 % san2;
                    }
                }else{
                    ekinshiSan = tv_san.getText().toString();
                    int san1 = Integer.parseInt(BirinshiSan);
                    int san2 = Integer.parseInt(ekinshiSan);
                    if(znak.equals("+")){
                        res = san1 + san2;
                    }
                    else if(znak.equals("-")){
                        res = san1 - san2;
                    }else if(znak.equals("*")){
                        res = san1 * san2;
                    }else if(znak.equals("/")){
                        res = san1 / san2;
                    }else if(znak.equals("%")){
                        res  = san1 % san2;
                    }
                }


                zapisText = BirinshiSan + znak + ekinshiSan + " = " + res;
                tv_zapis.setText(zapisText);
                tv_san.setText(""+res);
            }
        });
    }
}