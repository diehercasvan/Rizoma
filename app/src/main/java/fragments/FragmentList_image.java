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

import com.sinapsis.rizoma.*;

import java.util.ArrayList;

import DTO.DTO_Images;

import adapters.List_Image_Adapter;
import class_project.General;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentList_image extends Fragment {

    private View view;
    private ListView list;
    private Activity activity = General.ACTIVITY;
    private ArrayList<DTO_Images> arrayList;
    private DTO_Images dto_images;
    private ArrayList<Integer> iImgId = General.DTO_GENERAL.getiUriImages();
    private ArrayList<Integer> iImgSignaling = General.DTO_GENERAL.getiUriImagesSignal();

    private ArrayList<String> sDescription = General.DTO_GENERAL.getsDescriptions();
    private ArrayList<String> sTitle = General.DTO_GENERAL.getsTitles();

    private EditText inputSearch;
    private List_Image_Adapter adapter;


    public FragmentList_image() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_image, container, false);

        loadView();
        return view;
    }

    private void loadView() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < iImgId.size(); i++) {
            dto_images = new DTO_Images();
            dto_images.setiURL(iImgId.get(i));
            dto_images.setsTitle(sTitle.get(i));
            dto_images.setsDescription(sDescription.get(i));
            dto_images.setiURLSignaling(iImgSignaling.get(i));
            arrayList.add(dto_images);
        }
        adapter = new List_Image_Adapter(activity, arrayList);
        list = (ListView) view.findViewById(R.id.listImages);
        list.setAdapter(adapter);

        inputSearch = (EditText) view.findViewById(R.id.inputSearch);


        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                //searchText(inputSearch.getText().toString());

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchText(inputSearch.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                ///searchText(inputSearch.getText().toString());
            }
        });

    }

    private void searchText(String dataList) {

       /* adapter = new List_Image_Adapter(activity, arrayList);
        list = (ListView) view.findViewById(R.id.listImages);
        list.setAdapter(adapter);*/
        if (dataList.length() >= 1) {
            arrayList.clear();
            for (int i = 0; i < iImgId.size(); i++) {

                String sData = sTitle.get(i).substring(0, dataList.length()).toLowerCase();
                String sSearch = dataList.toLowerCase();

                Log.i("data", "0 " + sData);
                Log.i("data", "1 " + sSearch);
                if (sData.equals(sSearch)) {

                    dto_images = new DTO_Images();
                    dto_images.setiURL(iImgId.get(i));
                    dto_images.setsTitle(sTitle.get(i));
                    dto_images.setsDescription(sDescription.get(i));
                    dto_images.setiURLSignaling(iImgSignaling.get(i));
                    arrayList.add(dto_images);



                }
            }
            if (arrayList.size() < 0) {
                clearList();
            } else {
                adapter = new List_Image_Adapter(activity, arrayList);
                list.setAdapter(adapter);
            }
        } else {
            clearList();
            for (int i = 0; i < iImgId.size(); i++) {
                dto_images = new DTO_Images();
                dto_images.setiURL(iImgId.get(i));
                dto_images.setsTitle(sTitle.get(i));
                dto_images.setsDescription(sDescription.get(i));
                dto_images.setiURLSignaling(iImgSignaling.get(i));
                arrayList.add(dto_images);
            }
            adapter = new List_Image_Adapter(activity, arrayList);
            list.setAdapter(adapter);
        }

    }

    private void clearList() {
        adapter = null;
        list.setAdapter(adapter);
        arrayList.clear();
    }

}
