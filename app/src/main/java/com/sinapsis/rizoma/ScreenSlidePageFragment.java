/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sinapsis.rizoma;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import DTO.DTO_General;
import class_project.General;
import fragments.FragmentCardViewDescription;

public class ScreenSlidePageFragment extends Fragment {
    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";
    private ImageView imageView;
    private TextView txtTitle;
    private TextView txtDescription;
    private ArrayList<DTO_General> arrayList=General.ARRAYLIST_DTO_GENERAL;

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;
    private ViewGroup rootView;
    private DTO_General dto_general=new DTO_General();

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static ScreenSlidePageFragment create(int pageNumber) {

        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ScreenSlidePageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list_image_description, container, false);
        // Set the title view to show the page number.
        //((TextView) rootView.findViewById(android.R.id.text1)).setText(getString(R.string.title_template_step, mPageNumber + 1));
        loadView();
        return rootView;
    }

    private void loadView(){

        imageView=(ImageView)rootView.findViewById(R.id.imgListDescription);
        imageView.setImageResource(arrayList.get(mPageNumber).getiUriImage());

        txtTitle=(TextView) rootView.findViewById(R.id.textTitleDescription);
        txtTitle.setText(arrayList.get(mPageNumber).getsTitle());

        txtDescription=(TextView)rootView.findViewById(R.id.textDescription);
        txtDescription.setText(arrayList.get(mPageNumber).getsDescription());

        General.sSubTITLE=txtTitle.getText().toString();

    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}


