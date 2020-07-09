package com.example.pumpuia.kidsmathrules;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity implements View.OnClickListener {
    String operation;
    TextView digitOperand1, digitOperand2, digitResult , digitOperator, rules ;
    Button button1, button2, button3, button4, button5, button6 ;
    Button answer, back;
    ImageView rightSign;

    public  void initialization(){
        digitOperand1 = (TextView)findViewById(R.id.digitOperand1);
        digitOperand2 = (TextView)findViewById(R.id.digitOperand2);
        digitOperator = (TextView)findViewById(R.id.digitOperator);
        digitResult = (TextView)findViewById(R.id.digitResult);
        rightSign = (ImageView)findViewById(R.id.rightSign);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        rules = (TextView)findViewById(R.id.rules);
        answer = (Button)findViewById(R.id.answer);
        back = (Button)findViewById(R.id.back);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        answer.setOnClickListener(this);
        back.setOnClickListener(this);
    }
    int operand1 = 3, operand2 = 2;
    int result = operand1 + operand2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Bundle bundle = getIntent().getExtras();
        operation = bundle.getString("operation");

        initialization();
        answer.setAlpha(buttonHide);
        if(operation.equalsIgnoreCase("subtraction")) {
            digitOperator.setText("-");
            rules.setText("Click 3 Buttons to find 3 Balloons.Then Click 2 Balloons to hide 2 Balloons.Count the Balloons.");
            result = operand1 - operand2 ;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
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

    int button1State = -1;
    int button2State = -1;
    int button3State = -1;
    int button4State = -1;
    int button5State = -1;
    int button6State = -1;
    float buttonOff = (float) 1.0;
    float buttonOn = (float) 0.0;
    float buttonHide = (float) 0.65;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                button1State = button1State * (-1);
                if (button1State == 1) {
                    button1.setAlpha(buttonOn);
                    answer.setAlpha(buttonOff);
                }
                else
                    button1.setAlpha(buttonOff);
                break;
            case R.id.button2:
                button2State = button2State * (-1);
                if (button2State == 1){
                    button2.setAlpha(buttonOn);
                    answer.setAlpha(buttonOff);
                }
                else
                    button2.setAlpha(buttonOff);
                break;
            case R.id.button3:
                button3State = button3State * (-1);
                if (button3State == 1){
                    button3.setAlpha(buttonOn);
                    answer.setAlpha(buttonOff);
                }
                else
                    button3.setAlpha(buttonOff);
                break;
            case R.id.button4:
                button4State = button4State * (-1);
                if (button4State == 1){
                    button4.setAlpha(buttonOn);
                    answer.setAlpha(buttonOff);
                }
                else
                    button4.setAlpha(buttonOff);
                break;
            case R.id.button5:
                button5State = button5State * (-1);
                if (button5State == 1){
                    button5.setAlpha(buttonOn);
                    answer.setAlpha(buttonOff);
                }
                else
                    button5.setAlpha(buttonOff);
                break;
            case R.id.button6:
                button6State = button6State * (-1);
                if (button6State == 1){
                    button6.setAlpha(buttonOn);
                    answer.setAlpha(buttonOff);
                }
                else
                    button6.setAlpha(buttonOff);
                break;
            case R.id.answer:
                if (answer.getText() == "Do Again") {
                    getDifferentOperand();
                    reset(operand1, operand2);
                    answer.setText("Match Answer");
                    answer.setAlpha(buttonHide);
                    rightSign.setImageResource(0);
                }
                else{
                    int allButtonStateIsOff = (button1State + button2State + button3State + button4State + button5State + button6State);
                    if(allButtonStateIsOff == -6 ) {
                        Toast.makeText(this, "At first READ", Toast.LENGTH_SHORT).show();
                        answer.setAlpha(buttonHide);
                    }
                    else {
                        digitResult.setText(result + "");
                        rightSign.setImageResource(R.drawable.rightsign);
                        switch (result){
                            case 1 :
                                button1.setAlpha(buttonOn);
                                button2.setAlpha(buttonOff);
                                button3.setAlpha(buttonOff);
                                button4.setAlpha(buttonOff);
                                button5.setAlpha(buttonOff);
                                button6.setAlpha(buttonOff);
                                break;
                            case 2 :
                                button1.setAlpha(buttonOn);
                                button2.setAlpha(buttonOn);
                                button3.setAlpha(buttonOff);
                                button4.setAlpha(buttonOff);
                                button5.setAlpha(buttonOff);
                                button6.setAlpha(buttonOff);
                                break;
                            case 3 :
                                button1.setAlpha(buttonOn);
                                button2.setAlpha(buttonOn);
                                button3.setAlpha(buttonOn);
                                button4.setAlpha(buttonOff);
                                button5.setAlpha(buttonOff);
                                button6.setAlpha(buttonOff);
                                break;
                            case 4 :
                                button1.setAlpha(buttonOn);
                                button2.setAlpha(buttonOn);
                                button3.setAlpha(buttonOn);
                                button4.setAlpha(buttonOn);
                                button5.setAlpha(buttonOff);
                                button6.setAlpha(buttonOff);
                                break;
                            case 5 :
                                button1.setAlpha(buttonOn);
                                button2.setAlpha(buttonOn);
                                button3.setAlpha(buttonOn);
                                button4.setAlpha(buttonOn);
                                button5.setAlpha(buttonOn);
                                button6.setAlpha(buttonOff);
                                break;
                            case 6 :
                                button1.setAlpha(buttonOn);
                                button2.setAlpha(buttonOn);
                                button3.setAlpha(buttonOn);
                                button4.setAlpha(buttonOn);
                                button5.setAlpha(buttonOn);
                                button6.setAlpha(buttonOn);
                                break;
                        }
                        answer.setText("Do Again");
                    }
                }
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    int s = 0, i = 3, j = 1, k = 3, m = 0, n = 6;
    public void getDifferentOperand(){
        s = i;
        i = j;
        j = k;
        k = s;
        m = m + i;
        if(m >= 3)
            m = 0;
        operand1 = n - m;
        operand2 = m;
        n = n - 1;
        if(n < 3)
            n = 6;
    }

    public void reset(int operand1, int operand2){
        button1.setAlpha(buttonOff);
        button2.setAlpha(buttonOff);
        button3.setAlpha(buttonOff);
        button4.setAlpha(buttonOff);
        button5.setAlpha(buttonOff);
        button6.setAlpha(buttonOff);
        button1State = -1;
        button2State = -1;
        button3State = -1;
        button4State = -1;
        button5State = -1;
        button6State = -1;

        if (operation.equalsIgnoreCase("addition")) {
            rules.setText("Click " + operand1 + " Buttons to find " + operand1 + " Balloons.Then Click " + operand2 + " Buttons to find "
                    + operand2 + " Balloons.Count the Balloons.");
            result = operand1 + operand2;
        }
        else if (operation.equalsIgnoreCase("subtraction")){
            if(operand1 < operand2) {
                int put = operand1;
                operand1 = operand2;
                operand2 = put;
            }
            rules.setText("Click " + operand1 + " Buttons to find " + operand1 + " Balloons.Then Click " + operand2 + " Balloons to hide "
                    + operand2 + " Balloons.Count the Balloons.");
            result = operand1 - operand2;
        }
        digitOperand1.setText(operand1 + "");
        digitOperand2.setText(operand2 + "");
        digitResult.setText("");
    }
}
