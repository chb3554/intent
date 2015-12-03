package inintent.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();
        String calc = (inIntent.getStringExtra("C"));

        int calValue = 0;

        if(calc.equals("+")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                     + inIntent.getIntExtra("Num2", 0);
        }
        else if(calc.equals("-")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                     - inIntent.getIntExtra("Num2", 0);
        }
        else if(calc.equals("*")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                     * inIntent.getIntExtra("Num2", 0);
        }
        else if(calc.equals("/")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                     / inIntent.getIntExtra("Num2", 0);
        }

        final int retValue = calValue;

        Button btnReturn = (Button) findViewById(R.id.btnback);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Sum", retValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });

    }
}