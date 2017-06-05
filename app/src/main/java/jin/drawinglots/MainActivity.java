package jin.drawinglots;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imagebutton,imagebutton2,imagebutton3,imagebutton4;
    Button button;
    TextView result_msg;
    RadioGroup radioGroup;
    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        imagebutton  = (ImageButton) findViewById(R.id.imageButton);
        imagebutton2  = (ImageButton) findViewById(R.id.imageButton2);
        imagebutton3  = (ImageButton) findViewById(R.id.imageButton3);
        imagebutton4  = (ImageButton) findViewById(R.id.imageButton4);
        button = (Button)findViewById(R.id.button);
        result_msg = (TextView)findViewById(R.id.result_msg);
        randomNumber = new Random().nextInt(4)+1;

        imagebutton.setOnClickListener(this);
        imagebutton2.setOnClickListener(this);
        imagebutton3.setOnClickListener(this);
        imagebutton4.setOnClickListener(this);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        if(radioButton.isChecked()){
            int n = 0;
            imagebutton4.setVisibility(ImageButton.INVISIBLE);
            switch (v.getId()) {
                case R.id.imageButton:
                    n = 1;
                    break;
                case R.id.imageButton2:
                    n = 2;
                    break;
                case R.id.imageButton3:
                    n = 3;
                    break;
                case R.id.button:
                    n = 0;
                    break;
            }

            if (n == 0) {
                randomNumber = new Random().nextInt(3) + 1;
                button.setVisibility(Button.INVISIBLE);
                result_msg.setText("두두두두둥~");
            } else {
                if (randomNumber == n) {
                    result_msg.setText("당첨~!");
                    button.setVisibility(Button.VISIBLE);
                } else {
                    result_msg.setText("패스~!");
                }
            }
        }
        else if (radioButton2.isChecked()) {
            int n = 0;
            imagebutton4.setVisibility(ImageButton.VISIBLE);
            switch (v.getId()) {
                case R.id.imageButton:
                    n = 1;
                    break;
                case R.id.imageButton2:
                    n = 2;
                    break;
                case R.id.imageButton3:
                    n = 3;
                    break;
                case R.id.imageButton4:
                    n = 4;
                    break;
                case R.id.button:
                    n = 0;
                    break;
            }

            if (n == 0) {
                randomNumber = new Random().nextInt(4) + 1;
                button.setVisibility(Button.INVISIBLE);
                result_msg.setText("두두두두둥~");
            } else {
                if (randomNumber == n) {
                    result_msg.setText("당첨~!");
                    button.setVisibility(Button.VISIBLE);
                } else {
                    result_msg.setText("패스~!");
                }
            }
        }
    }
}
