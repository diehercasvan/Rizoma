package fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sinapsis.rizoma.*;

import class_project.Animation_general;
import class_project.General;

public class ImageFragment extends Fragment implements View.OnClickListener {

    private ImageView[] imageViews;
    private View view;
    private Animation_general animation_general;
    private Activity activity = General.ACTIVITY;


    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_image, container, false);
        // Inflate the layout for this fragment
        loadView();
        return view;
    }

    private void loadView() {
        imageViews = new ImageView[3];
        imageViews[0] = (ImageView) view.findViewById(R.id.imgBtn);
        imageViews[1] = (ImageView) view.findViewById(R.id.imgTexts);
        imageViews[2] = (ImageView) view.findViewById(R.id.imgContainer);

        imageViews[0].setOnClickListener(this);
        imageViews[2].setOnClickListener(this);
        animation_general = new Animation_general();

        imageViews[1].setImageResource(General.DTO_GENERAL.getiUriImageSignal());
        imageViews[2].setImageResource(General.DTO_GENERAL.getiUriImage());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtn:
                if (imageViews[1].getVisibility() == View.GONE) {
                    imageViews[1].startAnimation(animation_general.selectAnimation(0));
                    imageViews[1].setVisibility(View.VISIBLE);
                    imageViews[0].setRotation(180);


                } else {

                    imageViews[1].startAnimation(animation_general.selectAnimation(1));
                    imageViews[1].setVisibility(View.GONE);
                    imageViews[0].setRotation(0);
                }
                break;
            case R.id.imgContainer:
                General.DRAWABLE = imageViews[2].getDrawable();
                Intent intent = new Intent(activity, FullscreenImage.class);
                activity.startActivity(intent);
                break;
        }

    }


}
