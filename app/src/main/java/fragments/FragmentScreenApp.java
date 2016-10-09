package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sinapsis.rizoma.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentScreenApp extends Fragment {

    private View view;
    public FragmentScreenApp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_screen_app, container, false);

        return view;
    }

}
