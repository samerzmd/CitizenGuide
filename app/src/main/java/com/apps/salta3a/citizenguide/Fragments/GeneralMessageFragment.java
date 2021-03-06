package com.apps.salta3a.citizenguide.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.apps.salta3a.citizenguide.Activities.MainActivity;
import com.apps.salta3a.citizenguide.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class GeneralMessageFragment extends Fragment {
    public static String raw_res_KEY ="RAW_RES";
    private static final String ARG_SECTION_NUMBER = "section_number";
    public static GeneralMessageFragment newInstance(String rawRes,int sectionNumber){
        GeneralMessageFragment fragment = new GeneralMessageFragment();
        Bundle args = new Bundle();
        args.putString(raw_res_KEY, rawRes);
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    public GeneralMessageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_general_message, container, false);
        WebView webView= (WebView) v.findViewById(R.id.htmlDocRenderer);
        String resToreadFrom=getArguments().getString(raw_res_KEY);
        webView.loadUrl("file:///android_asset/"+resToreadFrom);
        return v;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
        catch (Exception c){

        }
    }
}
