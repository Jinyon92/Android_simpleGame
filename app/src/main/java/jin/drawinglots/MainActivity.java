package jin.drawinglots;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton imagebutton,imagebutton2,imagebutton3,imagebutton4;
    int ex[] = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       imagebutton  = (ImageButton) findViewById(R.id.imageButton);
        imagebutton2  = (ImageButton) findViewById(R.id.imageButton);
        imagebutton3  = (ImageButton) findViewById(R.id.imageButton);
        imagebutton4  = (ImageButton) findViewById(R.id.imageButton);
    }

    public void randomNumber(int number) {
        ArrayList<Object> randomList = new ArrayList<Object>();

        int random = (int) ((Math.random() * 10)) % number;

        randomList.add(random);

        for (int i = 0; i < number - 1; i++) {
            while (randomList.contains(random)) {
                random = (int) ((Math.random() * 10)) % number;
            }
            randomList.add(random);
        }
        for(int j=0;j<number;j++){
            ex[j] = (int) randomList.get(j);
        }
    }

    public void onClicked(View v){
        if(ex[0]==0) {
            Toast.makeText(getApplicationContext(), "당첨", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "꽝", Toast.LENGTH_SHORT).show();
        }
    }

    public void on2Clicked(View v){
        if(ex[1]==0) {
            Toast.makeText(getApplicationContext(), "당첨", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "꽝", Toast.LENGTH_SHORT).show();
        }
    }
    public void on3Clicked(View v){
        if(ex[2]==0) {
            Toast.makeText(getApplicationContext(), "당첨", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "꽝", Toast.LENGTH_SHORT).show();
        }
    }
    public void on4Clicked(View v){
        if(ex[3]==0) {
            Toast.makeText(getApplicationContext(), "당첨", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "꽝", Toast.LENGTH_SHORT).show();
        }
    }
}
