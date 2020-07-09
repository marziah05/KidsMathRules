package com.example.pumpuia.kidsmathrules;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    public  void   initialization(){
        Button startAddition=(Button)findViewById(R.id.startAddition);
        Button startSubtraction=(Button)findViewById(R.id.startSubtraction);
        startAddition.setOnClickListener(this);
        startSubtraction.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String operation=null;
        switch (view.getId()) {
            case  R.id.startAddition :
                operation="addition";
                break;
            case  R.id.startSubtraction:
                operation="subtraction";
                break;
        }
        Intent intent = new Intent(this, WaysActivity.class);
        intent.putExtra("operation",operation);
        startActivity(intent);
    }
}
