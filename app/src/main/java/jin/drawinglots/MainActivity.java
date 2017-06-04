package jin.drawinglots;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imagebutton,imagebutton2,imagebutton3,imagebutton4;
    Button button;
    TextView result_msg;
    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        int n = 0;

        switch (v.getId()){
            case R.id.imageButton: n=1; break;
            case R.id.imageButton2: n=2; break;
            case R.id.imageButton3: n=3; break;
            case R.id.imageButton4: n=4; break;
            case R.id.button: n=0; break;
        }

        if(n==0){
            randomNumber = new Random().nextInt(4)+1;
            button.setVisibility(Button.INVISIBLE);
            result_msg.setText("두두두두둥~");
        }else{
            if(randomNumber == n){
                result_msg.setText("당첨~!");
                button.setVisibility(Button.VISIBLE);
            }else{
                result_msg.setText("패스~!");
            }
        }
    }
}
