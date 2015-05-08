package com.apps.salta3a.citizenguide.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.apps.salta3a.citizenguide.R;

/**
 * Created by Samer on 01/05/2015.
 */
public class DepartmentListAdapter extends BaseAdapter {
    Context mContext;
    String [] deptNumbers;
    String [] deptNames;
    public  DepartmentListAdapter(Context context)
    {
        mContext=context;
        deptNames=context.getResources().getStringArray(R.array.deptNames);
        deptNumbers=context.getResources().getStringArray(R.array.deptNumbers);
    }
    @Override
    public int getCount() {
        return deptNames.length;
    }

    @Override
    public String getItem(int position) {
        return deptNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

            convertView =inflater.inflate(R.layout.numbers_list_item, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.deptNumberTxv = (TextView) convertView.findViewById(R.id.deptNumber);
            viewHolder.deptNameTxv = (TextView) convertView.findViewById(R.id.deptName);
            convertView.setTag(viewHolder);
            }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

            viewHolder.deptNumberTxv.setText(deptNumbers[position]);
            viewHolder.deptNumberTxv.setTag(deptNumbers[position]);

            viewHolder.deptNameTxv.setText(deptNames[position]);
            viewHolder.deptNameTxv.setTag(deptNames[position]);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + deptNumbers[position].toString()));
                    mContext.startActivity(callIntent);
                }
            });

        return convertView;

    }
    static class ViewHolder {

        TextView deptNumberTxv;
        TextView deptNameTxv;
    }
}
