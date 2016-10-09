package class_project;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.sinapsis.rizoma.ScreenSlidePagerActivity;
import com.sinapsis.rizoma.TextFragment;

import DTO.Load_Content_Page;
import fragments.FragmentList_Text;
import fragments.FragmentList_image;
import fragments.GalleryFragment;
import fragments.ImageFragment;
import fragments.VideoFragment;
import fragments.FragmentScreenApp;

/**
 * Created by DIEGO H  CASALLLSA on 7/10/2016.
 */

public class Menu_Item_Project {

    private Activity activity;
    private Intent intent = null;
    private Fragment fragment;
    private Load_Content_Page load_content_page;
    public int iData, iTYpeView;
    public boolean bTypeView;


    public Menu_Item_Project(int iData, int iTYpeView, boolean bTypeView) {
        this.activity = General.ACTIVITY;
        this.fragment = null;
        this.intent = null;
        this.iData = iData;
        this.iTYpeView = iTYpeView;
        this.bTypeView = bTypeView;

        load_content_page = new Load_Content_Page(iData);
    }


    public Fragment loadViewFragment() {

        fragment = null;
        switch (iTYpeView) {

            case 0:
                FragmentList_image fragmentList_image = new FragmentList_image();
                fragment = fragmentList_image;
                break;
            case 1:
                FragmentList_Text fragmentList_text = new FragmentList_Text();
                fragment = fragmentList_text;
                break;
            case 2:
                VideoFragment videoFragment = new VideoFragment();
                fragment = videoFragment;
                break;
            case 3:
                GalleryFragment galleryFragment = new GalleryFragment();
                fragment = galleryFragment;
                break;
            case 4:
                ImageFragment imageFragment  = new ImageFragment();
                fragment = imageFragment;
                break;
            case 5:
                FragmentScreenApp  fragmentScreenApp  = new FragmentScreenApp();
                fragment = fragmentScreenApp;
                break;
            case 6:
                TextFragment textFragment = new TextFragment();
                fragment = textFragment;
                break;
        }
        return fragment;

    }

    public Intent loadViewActivity() {
        intent = null;
        switch (iTYpeView) {
            case 0:
                intent = new Intent(activity, ScreenSlidePagerActivity.class);
                break;
            case 1:
                break;
            case 2:
                break;
        }

        return intent;
    }
}
