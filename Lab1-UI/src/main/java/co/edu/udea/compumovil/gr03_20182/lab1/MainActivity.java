package co.edu.udea.compumovil.gr03_20182.lab1;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;




public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

    int Hour;
    int Minute;
    Button food;
    Button drink;
    EditText ehora;
    Button buttonHora;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonHora = (Button) findViewById(R.id.buttonHora);
        buttonHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker" );
            }
        });


        food = (Button)findViewById(R.id.butttonFood);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent food = new Intent(MainActivity.this, FoodsActivity.class);
                startActivity(food);
            }
        });
        drink = (Button)findViewById(R.id.buttonDrink);
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent drink = new Intent(MainActivity.this, DrinksActivity.class);
                startActivity(drink);
            }
        });




    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView ehora = (TextView)findViewById(R.id.ehora);
        ehora.setText("Hour: "+ hourOfDay + " Minute: " + minute);

    }
}
