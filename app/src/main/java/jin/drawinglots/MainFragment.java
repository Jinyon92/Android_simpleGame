package jin.drawinglots;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by chjh0 on 2017-06-06.
 */

public class MainFragment extends Fragment implements View.OnClickListener {

    ImageButton imagebutton, imagebutton2, imagebutton3, imagebutton4,imagebutton5;
    Button button;
    TextView result_msg;
    RadioGroup radioGroup;
    int randomNumber;
    RadioButton radioButton,radioButton2,radioButton3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        radioButton = (RadioButton) rootView.findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) rootView.findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) rootView.findViewById(R.id.radioButton3);
        imagebutton = (ImageButton) rootView.findViewById(R.id.imageButton);
        imagebutton2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
        imagebutton3 = (ImageButton) rootView.findViewById(R.id.imageButton3);
        imagebutton4 = (ImageButton) rootView.findViewById(R.id.imageButton4);
        imagebutton5 = (ImageButton) rootView.findViewById(R.id.imageButton5);

        button = (Button) rootView.findViewById(R.id.button);
        result_msg = (TextView) rootView.findViewById(R.id.result_msg);
        randomNumber = new Random().nextInt(4) + 1;

        imagebutton.setOnClickListener(this);
        imagebutton2.setOnClickListener(this);
        imagebutton3.setOnClickListener(this);
        imagebutton4.setOnClickListener(this);
        imagebutton5.setOnClickListener(this);
        button.setOnClickListener(this);


        return rootView;
    }


    @Override
    public void onClick(View v) {
        if(radioButton.isChecked()){
            int n = 0;
            imagebutton4.setVisibility(ImageButton.INVISIBLE);
            imagebutton5.setVisibility(ImageButton.INVISIBLE);
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
            imagebutton5.setVisibility(ImageButton.INVISIBLE);
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
        }else if(radioButton3.isChecked()){
            int n = 0;
            imagebutton4.setVisibility(ImageButton.VISIBLE);
            imagebutton5.setVisibility(ImageButton.VISIBLE);
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
                case R.id.imageButton5:
                    n = 5;
                    break;
                case R.id.button:
                    n = 0;
                    break;
            }

            if (n == 0) {
                randomNumber = new Random().nextInt(5) + 1;
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