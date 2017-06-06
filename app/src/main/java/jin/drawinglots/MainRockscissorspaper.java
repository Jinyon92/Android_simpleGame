package jin.drawinglots;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chjh0 on 2017-06-06.
 */

public class MainRockscissorspaper extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView2 = (ViewGroup) inflater.inflate(R.layout.rockscissorspaper_main, container, false);

        return rootView2;
    }
}
