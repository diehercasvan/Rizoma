package class_project;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.sinapsis.rizoma.*;


/**
 * Created by DIEGO CASALLAS on 4/08/2016.
 */
public class Colors implements View.OnClickListener {
    private LinearLayout linearLayout;
    private String sListColor[];
    private Activity activity;
    private int iContId = 0;
    private EditText editText;
    private int iSelection=0;
    private My_Canvas my_canvas;

    public Colors(EditText editText, Activity a) {
        this.editText = editText;
        this.activity = a;
        this.iSelection=0;

    }

    public Colors(Activity a, My_Canvas my_canva) {

        this.activity = a;
        this.iSelection=1;
        this.my_canvas=my_canva;
    }

    public HorizontalScrollView createListColor() {
        if (activity != null) {
            float fSizeButton = activity.getResources().getDimension(R.dimen.sizeButtonColor);
            LinearLayout.LayoutParams parameters = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) fSizeButton);
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(activity);
            horizontalScrollView.setLayoutParams(parameters);
            parameters = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            linearLayout = new LinearLayout(activity);
            linearLayout.setLayoutParams(parameters);
            linearLayout.setPadding(2, 2, 2, 2);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            parameters = new LinearLayout.LayoutParams((int) fSizeButton, (int) fSizeButton);
            parameters.setMargins(5, 0, 0, 0);
            parameters.gravity = Gravity.CENTER_VERTICAL;
            sListColor = activity.getResources().getStringArray(R.array.colors);
            for (int i = 0; i < sListColor.length; i++) {
                Button button = new Button(activity);
                button.setBackgroundColor(Color.parseColor(sListColor[i]));
                button.setId(iContId);
                button.setTag(sListColor[i]);
                button.setLayoutParams(parameters);
                button.setOnClickListener(this);
                iContId++;
                linearLayout.addView(button);
            }
            horizontalScrollView.addView(linearLayout);
            return horizontalScrollView;
        }
        return null;
    }

    @Override
    public void onClick(View view) {
        int iID = view.getId();
        Button button = (Button) view.findViewById(iID);
        String color= General.COLOR_SELECTION_STRING = button.getTag().toString();
        if(iSelection==0){
            editText.setTextColor(Color.parseColor(color));
        }
        else if(iSelection==1){
            my_canvas.setColor(color);
        }



    }
}
