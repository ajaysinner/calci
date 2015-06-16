package com.example.aj.cal;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.examle.aj.R;

import java.lang.*;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    TextView display;
    Button num0,num1,num2,num3,num4,num5,num6,num7,num8,num9;
    Button add,subtract,multiply,divide,equals,del,decimal;

    String calculate[]={"0","","0"};
    String operator="";
    String text="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        display= (TextView) findViewById(R.id.displayId);

        Intent intent=getIntent();
        if(intent.hasExtra("text"))
            text = intent.getExtras().getString("text");
        display.setText(text);

        num0= (Button) findViewById(R.id.number0Id);
        num1= (Button) findViewById(R.id.number1Id);
        num2= (Button) findViewById(R.id.number2Id);
        num3= (Button) findViewById(R.id.number3Id);
        num4= (Button) findViewById(R.id.number4Id);
        num5= (Button) findViewById(R.id.number5Id);
        num6= (Button) findViewById(R.id.number6Id);
        num7= (Button) findViewById(R.id.number7Id);
        num8= (Button) findViewById(R.id.number8Id);
        num9= (Button) findViewById(R.id.number9Id);

        add= (Button) findViewById(R.id.operationAddId);
        subtract=(Button) findViewById(R.id.operationSubtractId);
        multiply= (Button) findViewById(R.id.operationMultiplyId);
        divide=(Button) findViewById(R.id.operationDivideId);
        equals=(Button) findViewById(R.id.operationEqualsId);
        del=(Button) findViewById(R.id.operationDelId);
        decimal=(Button) findViewById(R.id.decimalId);

        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);


        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equals.setOnClickListener(this);
        del.setOnClickListener(this);
        decimal.setOnClickListener(this);

    }

    public void calculate(){

        if(calculate[1] == "") { // For first time
            calculate[0] = text;
            calculate[1] = operator;
            text="";
        }
        else { // If there's an operator in array, evaluate it first
            calculate[2] = text;
            if(calculate[2]=="")calculate[2]="0";
            switch (calculate[1]) {
                case "+":
                    if(calculate[0]=="")calculate[0]="0";
                    text = String.valueOf(Double.parseDouble(calculate[0]) + Double.parseDouble(calculate[2]));
                    break;
                case "-":
                    if(calculate[0]=="")calculate[0]="0";
                    text = String.valueOf(Double.parseDouble(calculate[0]) - Double.parseDouble(calculate[2]));
                    break;
                case "*":
                    if(calculate[0]=="")calculate[0]="0";
                    text = String.valueOf(Double.parseDouble(calculate[0]) * Double.parseDouble(calculate[2]));
                    break;
                case "/":
                    if(calculate[0]=="")calculate[0]="0";
                    text = String.valueOf(Double.parseDouble(calculate[0]) / Double.parseDouble(calculate[2]));
                    break;
            }
            displayScreen();
            calculate[1] = operator;
            calculate[0] = text;
            calculate[2] = "0";
            text = "";
        }

    }

    public void displayScreen(){
        if( text.startsWith("0")&& text.length()>1 ) {
            text = text.substring(1, text.length());
        }
        display.setText(text);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.number0Id)text+="0";
        else if(v.getId()==R.id.number1Id)text+="1";
        else if(v.getId()==R.id.number2Id)text+="2";
        else if(v.getId()==R.id.number3Id)text+="3";
        else if(v.getId()==R.id.number4Id)text+="4";
        else if(v.getId()==R.id.number5Id)text+="5";
        else if(v.getId()==R.id.number6Id)text+="6";
        else if(v.getId()==R.id.number7Id)text+="7";
        else if(v.getId()==R.id.number8Id)text+="8";
        else if(v.getId()==R.id.number9Id)text+="9";
        else if(v.getId()==R.id.decimalId)text+=".";
        else if(v.getId()==R.id.operationDelId)text = text.substring(1, text.length());
        displayScreen();

        if( v.getId() == R.id.operationAddId ){
            operator="+";
            calculate();
        }
        else if( v.getId() == R.id.operationSubtractId ){
            operator="-";
            calculate();
        }
        if( v.getId() == R.id.operationMultiplyId ){
            operator="*";
            calculate();
        }
        else if( v.getId() == R.id.operationDivideId ){
            operator="/";
            calculate();
        }
        else if( v.getId() == R.id.operationEqualsId ){
            calculate();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_scientific) {
            Toast.makeText(this,"Scientific Mode",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this,Scientific.class);
            intent.putExtra("text",display.getText().toString());
            startActivity(intent);
            finish();
            return true;
        }

        else return super.onOptionsItemSelected(item);
    }


}
