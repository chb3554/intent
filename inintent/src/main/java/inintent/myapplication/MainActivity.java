package inintent.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        final EditText edtNum1 = (EditText) findViewById(R.id.editNum1);
        final EditText edtNum2 = (EditText) findViewById(R.id.editNum2);
        final RadioGroup rdoGroup = (RadioGroup) findViewById(R.id.rdoGroup);
        Button btnNewActivity = (Button) findViewById(R.id.btnact);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                switch (rdoGroup.getCheckedRadioButtonId()) {
                    case R.id.btnplus:
                        intent.putExtra("C", "+");
                        break;
                    case R.id.btnminus:
                        intent.putExtra("C", "-");
                        break;
                    case R.id.btnmul:
                        intent.putExtra("C", "*");
                        break;
                    case R.id.btndiv:
                        intent.putExtra("C", "/");
                        break;
                    default:
                        break;
                }

                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            int Sum = data.getIntExtra("Sum", 0);
            Toast.makeText(getApplicationContext(), "결과 :" + Sum, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}