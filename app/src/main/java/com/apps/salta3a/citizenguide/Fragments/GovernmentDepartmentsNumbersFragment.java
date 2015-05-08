package com.apps.salta3a.citizenguide.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.apps.salta3a.citizenguide.Activities.MainActivity;
import com.apps.salta3a.citizenguide.Adapters.DepartmentListAdapter;
import com.apps.salta3a.citizenguide.R;


public class GovernmentDepartmentsNumbersFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static GovernmentDepartmentsNumbersFragment newInstance(int sectionNumber) {
        GovernmentDepartmentsNumbersFragment fragment = new GovernmentDepartmentsNumbersFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    public GovernmentDepartmentsNumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_government_departments_numbers_fragments, container, false);
        ListView deptList= (ListView) view.findViewById(R.id.numbersList);
        deptList.setAdapter(new DepartmentListAdapter(getActivity()));

        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }



}
