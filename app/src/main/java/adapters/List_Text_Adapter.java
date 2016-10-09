package adapters;

import android.app.Activity;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.sinapsis.rizoma.*;

import DTO.DTO_General;


/**
 * Created by DIEGO H  CASALLAS on 8/10/2016.
 */

public class List_Text_Adapter extends ArrayAdapter<DTO_General> {

    private final Activity activity;
    private ArrayList<DTO_General> generalArrayList;
    private View row;
    public DTO_General dto_general;

    public List_Text_Adapter(Activity activity, ArrayList<DTO_General> arrayList) {
        super(activity, R.layout.row_text_layout, arrayList);
        // TODO Auto-generated constructor stub

        this.activity = activity;
        this.generalArrayList = arrayList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        dto_general = getItem(position);
        row = convertView;
        ViewHolderText mainviewHolder = null;

        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(R.layout.row_text_layout, parent, false);
            mainviewHolder = new ViewHolderText(row);
            row.setTag(mainviewHolder);
        } else {
            mainviewHolder = (ViewHolderText) row.getTag();
        }
        mainviewHolder.txtTitle.setText(dto_general.getsTitle());
        mainviewHolder.textDescription.setText(dto_general.getsDescription());

        return row;
    }

    class ViewHolderText {

        TextView txtTitle;
        TextView textDescription;

        public ViewHolderText(View v) {
            this.txtTitle = (TextView) row.findViewById(R.id.textTitle);
            this.textDescription = (TextView) row.findViewById(R.id.textDescription);

        }


    }
}
