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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by chjh0 on 2017-06-06.
 */

public class MainRockscissorspaper extends Fragment implements View.OnClickListener {

    ImageView[] imgArr = new ImageView[1];
    int[] imageArray = {R.drawable.rock, R.drawable.scissors, R.drawable.paper};
    Button startButton;
    ImageButton rockButton, scissorsButton, paperButton;
    TextView resultmsg;
    RadioGroup radgroup;
    RadioButton onewinbutton, twowinbutton;
    boolean first = true;
    boolean win = false;
    boolean lose = false;
    boolean draw = false;
    int j = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView2 = (ViewGroup) inflater.inflate(R.layout.rockscissorspaper_main, container, false);

        imgArr[0] = (ImageView) rootView2.findViewById(R.id.imgView);

        resultmsg = (TextView) rootView2.findViewById(R.id.resultmsg);
        rockButton = (ImageButton) rootView2.findViewById(R.id.rockButton);
        scissorsButton = (ImageButton) rootView2.findViewById(R.id.scissorsButton);
        paperButton = (ImageButton) rootView2.findViewById(R.id.paperButton);
        startButton = (Button) rootView2.findViewById(R.id.startButton);
        radgroup = (RadioGroup) rootView2.findViewById(R.id.radgroup);
        onewinbutton = (RadioButton) rootView2.findViewById(R.id.onewinbutton);
        twowinbutton = (RadioButton) rootView2.findViewById(R.id.twowinbutton);

        startButton.setOnClickListener(this);
        rockButton.setOnClickListener(this);
        paperButton.setOnClickListener(this);
        scissorsButton.setOnClickListener(this);

        radgroup.setOnClickListener(radClicked);
        onewinbutton.setOnClickListener(radClicked);
        twowinbutton.setOnClickListener(radClicked);

        return rootView2;
    }

    public View.OnClickListener radClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (onewinbutton.isChecked()) {
                boolean win = false;
                boolean lose = false;
                boolean draw = false;
            } else if (twowinbutton.isChecked()) {
                boolean win = false;
                boolean lose = false;
                boolean draw = false;
            }
        }
    };

    Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            Random rad = new Random();
            int i = rad.nextInt(3);
            j = i;

            imgArr[0].setImageResource(imageArray[i]);

            mHandler.sendEmptyMessageDelayed(0, 100);
        }
    };

    @Override
    public void onClick(View v) {
        int n = Integer.parseInt(v.getTag().toString());

        if (onewinbutton.isChecked()) {
            if (n == 4) {
                mHandler.sendEmptyMessage(0);
                startButton.setText("재시작");
                resultmsg.setText("과연~");
            } else if (n == 0) {
                mHandler.removeMessages(0);
                one_Win(imageArray[j], 0);
                first = true;
                rockscissorspaper_Win();
            } else if (n == 1) {
                mHandler.removeMessages(0);
                one_Win(imageArray[j], 1);
                first = true;
                rockscissorspaper_Win();
            } else if (n == 2) {
                mHandler.removeMessages(0);
                one_Win(imageArray[j], 2);
                first = true;
                rockscissorspaper_Win();
            }
        } else if (twowinbutton.isChecked()) {
            if (n == 4) {
                first = true;
                win = false;
                lose = false;
                draw = false;
                mHandler.sendEmptyMessage(0);
                resultmsg.setText("과연~");
            }
                if (n == 0) {
                    if(first) {
                        one_Win(imageArray[j], 0);
                        rockscissorspaper_Win();
                    }else {
                        two_win(imageArray[j], 0);
                    }
                } else if (n == 1) {
                    if(first) {
                        one_Win(imageArray[j], 1);
                        rockscissorspaper_Win();
                    }else {
                        two_win(imageArray[j], 1);
                    }
                } else if (n == 2) {
                    if(first) {
                        one_Win(imageArray[j], 2);
                        rockscissorspaper_Win();
                    }else {
                        two_win(imageArray[j], 2);
                    }
                }
            }


    }

    public void rockscissorspaper_Win() {
        if (win)
            resultmsg.setText("승!");
        else if (lose)
            resultmsg.setText("패!");
        else if (draw)
            resultmsg.setText("무승부!");
    }

    public void one_Win(int computer, int player) {
        first = false;
        if (computer == imageArray[0]) {
            if (player == 0) {
                win = false;
                lose = false;
                draw = true;
            } else if (player == 1) {
                win = false;
                lose = true;
                draw = false;
            } else if (player == 2) {
                win = true;
                lose = false;
                draw = false;
            }
        } else if (computer == imageArray[1]) {
            if (player == 0) {
                win = true;
                lose = false;
                draw = false;
            } else if (player == 1) {
                win = false;
                lose = false;
                draw = true;
            } else if (player == 2) {
                win = false;
                lose = true;
                draw = false;
            }
        } else if (computer == imageArray[2]) {
            if (player == 0) {
                win = false;
                lose = true;
                draw = false;
            } else if (player == 1) {
                win = true;
                lose = false;
                draw = false;
            } else if (player == 2) {
                win = false;
                lose = false;
                draw = true;
            }
        }
    }

    public void two_win(int computer, int player) {
        if (win) {
            if (computer == imageArray[0]) {
                if (player == 0) {
                    mHandler.removeMessages(0);
                    resultmsg.setText("이겼습니다!");
                } else if (player == 1) {
                    win = false;
                    lose = true;
                    draw = false;
                    resultmsg.setText("현재상태 :패!");
                } else if (player == 2) {
                    win = true;
                    lose = false;
                    draw = false;
                    resultmsg.setText("현재상태 :승!");
                }
            } else if (computer == imageArray[1]) {
                if (player == 0) {
                    win = true;
                    lose = false;
                    draw = false;
                    resultmsg.setText("현재상태 :승!");
                } else if (player == 1) {
                    mHandler.removeMessages(0);
                    resultmsg.setText("이겼습니다!");
                } else if (player == 2) {
                    win = false;
                    lose = true;
                    draw = false;
                    resultmsg.setText("현재상태 :패!");
                }
            } else if (computer == imageArray[2]) {
                if (player == 0) {
                    win = false;
                    lose = true;
                    draw = false;
                    resultmsg.setText("현재상태 :패!");
                } else if (player == 1) {
                    win = true;
                    lose = false;
                    draw = false;
                    resultmsg.setText("현재상태 :승!");
                } else if (player == 2) {
                    mHandler.removeMessages(0);
                    resultmsg.setText("이겼습니다!");
                }
            }
        }else if(lose){
            if (computer == imageArray[0]){
                if (player == 0) {
                    mHandler.removeMessages(0);
                    resultmsg.setText("졌습니다!");
                } else if (player == 1) {
                    win = false;
                    lose = true;
                    draw = false;
                    resultmsg.setText("현재상태 :패!");
                } else if (player == 2) {
                    win = true;
                    lose = false;
                    draw = false;
                    resultmsg.setText("현재상태 :승!");
                }
            } else if (computer == imageArray[1]) {
                if (player == 0) {
                    win = true;
                    lose = false;
                    draw = false;
                    resultmsg.setText("현재상태 :승!");
                } else if (player == 1) {
                    mHandler.removeMessages(0);
                    resultmsg.setText("졌습니다!");
                } else if (player == 2) {
                    win = false;
                    lose = true;
                    draw = false;
                    resultmsg.setText("현재상태 :패!");
                }
            } else if (computer == imageArray[2]) {
                if (player == 0) {
                    win = false;
                    lose = true;
                    draw = false;
                    resultmsg.setText("현재상태 :패!");
                } else if (player == 1) {
                    win = true;
                    lose = false;
                    draw = false;
                    resultmsg.setText("현재상태 :승!");
                } else if (player == 2) {
                    mHandler.removeMessages(0);
                    resultmsg.setText("졌습니다!");
                }
            }

        }else if(draw){
            if (computer == imageArray[0]){
                if (player == 0) {
                    win = false;
                    draw = true;
                    lose = false;
                } else if (player == 1) {
                    win = false;
                    lose = true;
                    draw = false;
                    resultmsg.setText("현재상태 :패!");
                } else if (player == 2) {
                    win = true;
                    lose = false;
                    draw = false;
                    resultmsg.setText("현재상태 :승!");
                }
            } else if (computer == imageArray[1]) {
                if (player == 0) {
                    win = true;
                    lose = false;
                    draw = false;
                    resultmsg.setText("현재상태 :승!");
                } else if (player == 1) {
                    draw = true;
                    win = false;
                    lose = false;
                } else if (player == 2) {
                    win = false;
                    lose = true;
                    draw = false;
                    resultmsg.setText("현재상태 :패!");
                }
            } else if (computer == imageArray[2]) {
                if (player == 0) {
                    win = false;
                    lose = true;
                    draw = false;
                    resultmsg.setText("현재상태 :패!");
                } else if (player == 1) {
                    win = true;
                    lose = false;
                    draw = false;
                    resultmsg.setText("현재상태 :승!");
                } else if (player == 2) {
                    draw = true;
                    win = false;
                    lose = false;
                }
            }
        }

    }




}