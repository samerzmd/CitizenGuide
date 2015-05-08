package com.apps.salta3a.citizenguide.Fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.salta3a.citizenguide.Activities.DepartmentActivity;
import com.apps.salta3a.citizenguide.Activities.MainActivity;
import com.apps.salta3a.citizenguide.Models.Department;
import com.apps.salta3a.citizenguide.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainSectionFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    public static final String DeptKey = "DeptKey";
    public static MainSectionFragment newInstance(int sectionNumber) {
        MainSectionFragment fragment = new MainSectionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    public MainSectionFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main_section, container, false);

        attachClickListeners(view);

        return view;
    }

    private void attachClickListeners(View view) {
        view.findViewById(R.id.departmentGAMBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o=new Intent(getActivity(), DepartmentActivity.class);
                 Department GAMDept=new Department(1,R.string.GAMName,R.string.GAMDes);
                o.putExtra(DeptKey,GAMDept);
                startActivity(o);
            }
        });

        view.findViewById(R.id.departmentCiBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o=new Intent(getActivity(), DepartmentActivity.class);
                Department CIDept=new Department(2,R.string.CIName,R.string.CIDes);
                o.putExtra(DeptKey,CIDept);
                startActivity(o);
            }
        });
        view.findViewById(R.id.departmentLVBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o=new Intent(getActivity(), DepartmentActivity.class);
                Department LVDept=new Department(3,R.string.LVName,R.string.LVDes);
                o.putExtra(DeptKey,LVDept);
                startActivity(o);
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }


}
