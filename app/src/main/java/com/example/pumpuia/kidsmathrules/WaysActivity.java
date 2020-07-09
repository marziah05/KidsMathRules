package com.example.pumpuia.kidsmathrules;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class WaysActivity extends Activity implements View.OnClickListener {
    String operation;
    CheckBox finger , drawing , apple , game , story ;
    Button start , back;

    public  void initialization() {
        finger = (CheckBox) findViewById(R.id.finger);
        drawing = (CheckBox) findViewById(R.id.drawing);
        apple = (CheckBox) findViewById(R.id.apple);
        game = (CheckBox) findViewById(R.id.game);
        story = (CheckBox) findViewById(R.id.story);
        start = (Button) findViewById(R.id.start);
        back = (Button) findViewById(R.id.back);

        finger.setOnClickListener(this);
        drawing.setOnClickListener(this);
        apple.setOnClickListener(this);
        game.setOnClickListener(this);
        story.setOnClickListener(this);
        start.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ways);

        Bundle b = getIntent().getExtras();
        operation = b.getString("operation");
        initialization();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ways, menu);
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

    float buttonActive = (float) 1.0;
    float buttonHide = (float) 0.65;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finger :
                if(finger.isChecked()){
                    drawing.setChecked(false);
                    apple.setChecked(false);
                    game.setChecked(false);
                    story.setChecked(false);
                    start.setEnabled(true);
                    start.setAlpha(buttonActive);
                }
                else {
                    start.setEnabled(false);
                    start.setAlpha(buttonHide);
                }
                break;
            case R.id.drawing :
                if(drawing.isChecked()){
                    finger.setChecked(false);
                    apple.setChecked(false);
                    game.setChecked(false);
                    story.setChecked(false);
                    start.setEnabled(true);
                    start.setAlpha(buttonActive);
                }
                else {
                    start.setEnabled(false);
                    start.setAlpha(buttonHide);
                }
                break;
            case R.id.apple :
                if(apple.isChecked()){
                    drawing.setChecked(false);
                    finger.setChecked(false);
                    game.setChecked(false);
                    story.setChecked(false);
                    start.setEnabled(true);
                    start.setAlpha(buttonActive);
                }
                else {
                    start.setEnabled(false);
                    start.setAlpha(buttonHide);
                }
                break;
            case R.id.game :
                if(game.isChecked()){
                    drawing.setChecked(false);
                    apple.setChecked(false);
                    finger.setChecked(false);
                    story.setChecked(false);
                    start.setEnabled(true);
                    start.setAlpha(buttonActive);
                }
                else {
                    start.setEnabled(false);
                    start.setAlpha(buttonHide);
                }
                break;
            case R.id.story :
                if(story.isChecked()){
                    drawing.setChecked(false);
                    apple.setChecked(false);
                    game.setChecked(false);
                    finger.setChecked(false);
                    start.setEnabled(true);
                    start.setAlpha(buttonActive);
                }
                else {
                    start.setEnabled(false);
                    start.setAlpha(buttonHide);
                }
                break;
            case R.id.start :
                Intent intent;
                if(finger.isChecked()) {
                    intent = new Intent(this, FingerActivity.class);
                    intent.putExtra("operation" , operation);
                    startActivity(intent);
                }
                else if(drawing.isChecked()) {
                    intent = new Intent(this, DrawActivity.class);
                    intent.putExtra("operation" , operation);
                    startActivity(intent);
                }
                else if(apple.isChecked()) {
                    intent = new Intent(this, AppleActivity.class);
                    intent.putExtra("operation" , operation);
                    startActivity(intent);
                }
                else if(game.isChecked()) {
                    intent = new Intent(this, GameActivity.class);
                    intent.putExtra("operation" , operation);
                    startActivity(intent);
                }
                else if(story.isChecked()) {
                    intent = new Intent(this, StoryActivity.class);
                    intent.putExtra("operation" , operation);
                    startActivity(intent);
                }
                break;
            case R.id.back :
                finish();
                break;
        }
    }
}





