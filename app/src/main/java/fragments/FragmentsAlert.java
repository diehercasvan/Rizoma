package fragments;

import android.app.DialogFragment;
import android.app.FragmentManager;

import class_project.General;

/**
 * Created by DIEGO CASALLAS on 7/08/2016.
 */
public  class FragmentsAlert {

    public static FragmentManager fm = General.ACTIVITY.getFragmentManager();

    public static void setDialogFragment(int iType) {
        DialogFragment dialogFragment=null;
        switch (iType) {
            case 0:
                FragmentImageGridView fragmentImageGridView = new FragmentImageGridView();
                dialogFragment=fragmentImageGridView;

                break;
            case 1:
                FragmentToolText fragmentToolText = new FragmentToolText();
                dialogFragment=fragmentToolText;
                break;
            case 3:
                FragmentToolImage fragmentToolImage = new FragmentToolImage();
                dialogFragment=fragmentToolImage;
                break;
            case 4:
                FragmentCardViewDescription fragmentCardViewDescription = new FragmentCardViewDescription();
                dialogFragment=fragmentCardViewDescription;
                break;
        }
        dialogFragment.show(fm, "Sample Fragment");

    }
}
