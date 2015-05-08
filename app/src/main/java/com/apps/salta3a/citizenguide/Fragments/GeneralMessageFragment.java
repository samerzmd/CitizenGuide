package com.apps.salta3a.citizenguide.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.apps.salta3a.citizenguide.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class GeneralMessageFragment extends Fragment {
    public static String raw_res_KEY ="RAW_RES";
    public static GeneralMessageFragment newInstance(String rawRes){
        GeneralMessageFragment fragment = new GeneralMessageFragment();
        Bundle args = new Bundle();
        args.putString(raw_res_KEY, rawRes);
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
}
