package my.edu.taruc.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private TextView textViewBMI;
    private ImageView imageViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Linking UI to program
        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewBMI = (TextView)findViewById(R.id.textViewBMI);
        imageViewResult = (ImageView)findViewById(R.id.imageViewResult);
    }


    public void calculateBMI(View view) {
        double weight, height, bmi;

        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());

        bmi = weight / Math.pow((height / 100), 2);

        //set image during run time
        if (bmi <= 18.5) {
            imageViewResult.setImageResource(R.drawable.under);
            textViewBMI.setText(getString(R.string.under_weight) + " " + bmi);
        }

        else if (bmi >= 21)
        {
            imageViewResult.setImageResource(R.drawable.over);
            textViewBMI.setText(getString(R.string.over_weight) + " " + bmi);
        }

        else
            imageViewResult.setImageResource((R.drawable.normal));
            textViewBMI.setText(getString(R.string.normal) + " " + bmi);
    }


    public void reset(View view)
    {
        editTextHeight.setText("");
        editTextWeight.setText("");
        imageViewResult.setImageResource(R.drawable.empty);
    }

}
