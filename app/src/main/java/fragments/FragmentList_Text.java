package fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.sinapsis.rizoma.R;

import java.util.ArrayList;

import DTO.DTO_General;
import DTO.DTO_Images;
import adapters.List_Text_Adapter;
import class_project.General;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentList_Text extends Fragment {
    private View view;
    private ListView list;
    private Activity activity = General.ACTIVITY;
    private ArrayList<DTO_General> arrayList;
    private DTO_General dto_general;

    private ArrayList<String> sDescription = General.DTO_GENERAL.getsDescriptions();
    private ArrayList<String> sTitle = General.DTO_GENERAL.getsTitles();

    private EditText inputSearch;
    private List_Text_Adapter adapter;


    public FragmentList_Text() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_text, container, false);

        loadView();
        return view;
    }

    private void loadView() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < sTitle.size(); i++) {
            dto_general = new DTO_General();
            dto_general.setsTitle(sTitle.get(i));
            dto_general.setsDescription(sDescription.get(i));
            arrayList.add(dto_general);
            Log.i("dato",dto_general.getsDescription());
        }
        adapter = new List_Text_Adapter(activity, arrayList);
        list = (ListView) view.findViewById(R.id.listText);
        list.setAdapter(adapter);

        inputSearch = (EditText) view.findViewById(R.id.inputSearchText);
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchText(inputSearch.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void searchText(String dataList) {

       /* adapter = new List_Image_Adapter(activity, arrayList);
        list = (ListView) view.findViewById(R.id.listImages);
        list.setAdapter(adapter);*/
        if (dataList.length() >= 1) {
            arrayList.clear();
            for (int i = 0; i < sTitle.size(); i++) {

                String sData = sTitle.get(i).substring(0, dataList.length()).toLowerCase();
                String sSearch = dataList.toLowerCase();

                if (sData.equals(sSearch)) {
                    dto_general = new DTO_General();
                    dto_general.setsTitle(sTitle.get(i));
                    dto_general.setsDescription(sDescription.get(i));
                    arrayList.add(dto_general);

                }
            }
            if (arrayList.size() < 0) {
                clearList();
            } else {
                adapter = new List_Text_Adapter(activity, arrayList);
                list.setAdapter(adapter);
            }
        } else {
            clearList();
            for (int i = 0; i < sTitle.size(); i++) {
                dto_general = new DTO_General();
                dto_general.setsTitle(sTitle.get(i));
                dto_general.setsDescription(sDescription.get(i));
                arrayList.add(dto_general);
            }
            adapter = new List_Text_Adapter(activity, arrayList);
            list.setAdapter(adapter);
        }

    }

    private void clearList() {
        adapter = null;
        list.setAdapter(adapter);
        arrayList.clear();
    }
}
