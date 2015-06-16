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
import java.math.BigInteger;


public class Scientific extends ActionBarActivity implements View.OnClickListener {
    TextView display;
    Button sin,cos,tan,ln,log,pi,e,percent,factorial,root,power,del;

    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);


        display= (TextView) findViewById(R.id.displayId);

        Intent intent = getIntent();
        text=intent.getExtras().getString("text");
        display.setText(text);

        sin= (Button) findViewById(R.id.operationSinId);
        cos= (Button) findViewById(R.id.operationCosId);
        tan= (Button) findViewById(R.id.operationTanId);
        ln= (Button) findViewById(R.id.operationLnId);
        log= (Button) findViewById(R.id.operationLogId);
        pi= (Button) findViewById(R.id.operationPiId);
        e= (Button) findViewById(R.id.operationEId);
        percent= (Button) findViewById(R.id.operationPercentId);
        factorial= (Button) findViewById(R.id.operationFactorialId);
        root= (Button) findViewById(R.id.operationRootId);
        power= (Button) findViewById(R.id.operationPowerId);
        del= (Button) findViewById(R.id.operationDelId);

        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        ln.setOnClickListener(this);
        log.setOnClickListener(this);
        pi.setOnClickListener(this);
        e.setOnClickListener(this);
        percent.setOnClickListener(this);
        factorial.setOnClickListener(this);
        root.setOnClickListener(this);
        power.setOnClickListener(this);
        del.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.operationDelId){
            text = text.substring(1, text.length());
            display.setText(""+text);
        }else if(v.getId()==R.id.operationSinId){
            double degree=Math.toRadians(Double.parseDouble(String.valueOf(display.getText())));
            display.setText(""+Math.sin(degree));
        }else if(v.getId()==R.id.operationCosId){
            double degree=Math.toRadians(Double.parseDouble(String.valueOf(display.getText())));
            display.setText(""+Math.cos(degree));
        }else if(v.getId()==R.id.operationTanId){
            double degree=Math.toRadians(Double.parseDouble(String.valueOf(display.getText())));
            display.setText(""+Math.tan(degree));
        }else if(v.getId()==R.id.operationLnId){
            double number=Double.parseDouble(String.valueOf(display.getText()));
            display.setText(""+Math.log(number));
        }else if(v.getId()==R.id.operationLogId){
            double number=Double.parseDouble(String.valueOf(display.getText()));
            display.setText(""+Math.log10(number));
        }else if(v.getId()==R.id.operationPiId){
            display.setText(""+Math.PI);
        }else if(v.getId()==R.id.operationEId){
            double number=Double.parseDouble(String.valueOf(display.getText()));
            display.setText(""+Math.exp(number));
        }else if(v.getId()==R.id.operationPercentId){
            double number=Double.parseDouble(String.valueOf(display.getText()));
            display.setText(""+(number/100));
        }else if(v.getId()==R.id.operationFactorialId){
            long fact=1;
            int number=Integer.parseInt(String.valueOf(display.getText()));
            for(int i=1; i<=number ; i++)
                fact=fact*i;
            display.setText(""+fact);
        }else if(v.getId()==R.id.operationRootId) {
            double number = Double.parseDouble(String.valueOf(display.getText()));
            display.setText(""+Math.sqrt(number));
        }else if(v.getId()==R.id.operationPowerId) {
            BigInteger number  = new BigInteger(String.valueOf(display.getText()));
            display.setText(""+number.pow(2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scientific, menu);
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
        if(id==R.id.action_basic){
            Toast.makeText(this,"Basic Mode",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(Scientific.this,MainActivity.class);
            intent.putExtra("text",display.getText().toString());
            startActivity(intent);
            finish();
            return true;
        }
        else return super.onOptionsItemSelected(item);
    }
}
