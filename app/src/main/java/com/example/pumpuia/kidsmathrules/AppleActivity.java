package com.example.pumpuia.kidsmathrules;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AppleActivity extends Activity implements View.OnClickListener {
    String operation;
    TextView digitOperand1, digitOperand2, digitResult, digitOperator, imageOperator, rules;
    ImageView rightSign , imageOperand1, imageOperand2, imageResult;
    Button answer, back;
    int operand1 = 3, operand2 = 2;
    int result = operand1 + operand2;

    public  void initialization(){
        digitOperand1 = (TextView)findViewById(R.id.digitOperand1);
        digitOperand2 = (TextView)findViewById(R.id.digitOperand2);
        digitOperator = (TextView)findViewById(R.id.digitOperator);
        digitResult = (TextView)findViewById(R.id.digitResult);
        rightSign = (ImageView)findViewById(R.id.rightSign);
        imageOperand1 = (ImageView)findViewById(R.id.imageOperand1);
        imageOperand2 = (ImageView)findViewById(R.id.imageOperand2);
        imageOperator = (TextView)findViewById(R.id.imageOperator);
        imageResult = (ImageView)findViewById(R.id.imageResult);
        rules = (TextView)findViewById(R.id.rules);
        answer = (Button)findViewById(R.id.answer);
        back = (Button)findViewById(R.id.back);

        answer.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);
        Bundle bundle = getIntent().getExtras();
        operation = bundle.getString("operation");
        initialization();
        if(operation.equalsIgnoreCase("subtraction")) {
            digitOperator.setText("-");
            imageOperator.setText("-");
            rules.setText("Take 3 Apples for 3. Then Eat out 2 apples for 2.Count the remaining apples.");
            result = operand1 - operand2;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_apple, menu);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.answer:
                if (answer.getText() == "Do Again") {
                    getDifferentOperand();
                    setData(operand1, operand2);
                    answer.setText("Match Answer");
                    rightSign.setImageResource(0);
                }
                else{
                    digitResult.setText(result + "");
                    rightSign.setImageResource(R.drawable.rightsign);
                    switch (result){
                        case 0 :
                            imageResult.setImageResource(R.drawable.zero);
                            break;
                        case 1:
                            imageResult.setImageResource(R.drawable.oneapple);
                            break;
                        case 2:
                            imageResult.setImageResource(R.drawable.twoapples);
                            break;
                        case 3:
                            imageResult.setImageResource(R.drawable.threeapples);
                            break;
                        case 4:
                            imageResult.setImageResource(R.drawable.fourapples);
                            break;
                        case 5:
                            imageResult.setImageResource(R.drawable.fiveapples);
                            break;
                    }
                    answer.setText("Do Again");
                }
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    int s=0 ,i=0,j=1,k=2,m=0,n=5;
    public void getDifferentOperand(){
        s = i;
        i = j;
        j = k;
        k = s;
        m = m + i;
        if(m > 3)
            m = 0;
        operand1 = n - m;
        operand2 = m;
        n = n - 1;
        if(n < 3)
            n = 5;
    }

    public void setData(int operand1, int operand2){
        if (operation.equalsIgnoreCase("addition")) {
            rules.setText("Take " + operand1 + " Apples for " + operand1 + ".Then Take " + operand2 + " apples for " + operand2
                    + ".Count the apples.");
            result = operand1 + operand2;
        }
        else if (operation.equalsIgnoreCase("subtraction")){
            if(operand1<operand2) {
                int put = operand1;
                operand1=operand2;
                operand2=put;
            }
            rules.setText("Take " + operand1 + " Apples for " + operand1 + ".Then Eat out " + operand2 + " apples for " + operand2
                    + ".Count the remaining apples.");
            result = operand1 - operand2;
        }
        digitOperand1.setText(operand1 + "");
        digitOperand2.setText(operand2 + "");
        digitResult.setText("");
        switch (operand1){
            case 0 :
                imageOperand1.setImageResource(R.drawable.zero);
                break;
            case 1:
                imageOperand1.setImageResource(R.drawable.oneapple);
                break;
            case 2:
                imageOperand1.setImageResource(R.drawable.twoapples);
                break;
            case 3:
                imageOperand1.setImageResource(R.drawable.threeapples);
                break;
            case 4:
                imageOperand1.setImageResource(R.drawable.fourapples);
                break;
            case 5:
                imageOperand1.setImageResource(R.drawable.fiveapples);
                break;
        }
        switch (operand2){
            case 0 :
                imageOperand2.setImageResource(R.drawable.zero);
                break;
            case 1:
                imageOperand2.setImageResource(R.drawable.oneapple);
                break;
            case 2:
                imageOperand2.setImageResource(R.drawable.twoapples);
                break;
            case 3:
                imageOperand2.setImageResource(R.drawable.threeapples);
                break;
            case 4:
                imageOperand2.setImageResource(R.drawable.fourapples);
                break;
            case 5:
                imageOperand2.setImageResource(R.drawable.fiveapples);
                break;
        }
        imageResult.setImageResource(0);
    }
}
