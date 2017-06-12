package jin.drawinglots;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by chjh0 on 2017-06-06.
 */

public class MainRockscissorspaper extends Fragment implements View.OnClickListener{

   ImageView[] imgArr = new ImageView[1];
    int[] imageArray = {R.drawable.rock, R.drawable.scissors,R.drawable.paper};
    Button startButton;
    ImageButton rockButton,scissorsButton,paperButton;
    TextView resultmsg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView2 = (ViewGroup) inflater.inflate(R.layout.rockscissorspaper_main, container, false);

       imgArr[0] = (ImageView)rootView2.findViewById(R.id.imgView);

        resultmsg = (TextView)rootView2.findViewById(R.id.resultmsg);
        rockButton = (ImageButton) rootView2.findViewById(R.id.rockButton);
        scissorsButton = (ImageButton) rootView2.findViewById(R.id.scissorsButton);
        paperButton = (ImageButton) rootView2.findViewById(R.id.paperButton);
        startButton = (Button)rootView2.findViewById(R.id.startButton);
        startButton.setOnClickListener(this);

        rockButton.setOnClickListener(this);
        paperButton.setOnClickListener(this);
        scissorsButton.setOnClickListener(this);

        return rootView2;
    }

    int j = 0;

    Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg){

            Random rad = new Random();
            int i = rad.nextInt(3);
            j=i;

            imgArr[0].setImageResource(imageArray[i]);

            mHandler.sendEmptyMessageDelayed(0,100);
        }
    };

    @Override
    public void onClick(View v) {
        int n = Integer.parseInt(v.getTag().toString());


        if(n==4){
            mHandler.sendEmptyMessage(0);
            startButton.setText("재시작");
            resultmsg.setText("과연~");
        }else if (n == 0) {
            mHandler.removeMessages(0);
            research_Win(imageArray[j],0);
        } else if (n == 1) {
            mHandler.removeMessages(0);
            research_Win(imageArray[j],1);
        } else if (n == 2) {
            mHandler.removeMessages(0);
            research_Win(imageArray[j],2);
        }
    }

    public void research_Win(int computer, int player){
        if(computer == imageArray[0]){
            if(player == 0){
                resultmsg.setText("무승부!");
            }else if(player == 1){
                resultmsg.setText("패!");
            }else if(player == 2){
                resultmsg.setText("승!");
            }
        }else if(computer == imageArray[1]){
            if(player == 0){
                resultmsg.setText("승!");
            }else if(player == 1){
                resultmsg.setText("무승부!");
            }else if(player == 2){
                resultmsg.setText("패!");
            }
        }else if(computer == imageArray[2]){
            if(player == 0){
                resultmsg.setText("패!");
            }else if(player == 1){
                resultmsg.setText("승!");
            }else if(player == 2){
                resultmsg.setText("무승부!");
            }
        }
    }

}
