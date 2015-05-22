package com.apps.salta3a.citizenguide.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.salta3a.citizenguide.Activities.MainActivity;
import com.apps.salta3a.citizenguide.Activities.MapActivity;
import com.apps.salta3a.citizenguide.R;

public class DepartmentListAdapter extends BaseAdapter {
    Context mContext;
    String [] deptNumbers;
    String [] deptNames;
    double [][] deptLoc;
    public  DepartmentListAdapter(Context context)
    {
        mContext=context;
        deptNames=context.getResources().getStringArray(R.array.deptNames);
        deptNumbers=context.getResources().getStringArray(R.array.deptNumbers);
        deptLoc=new double[deptNames.length][2];

        deptLoc[0][0]=31.9565778;
        deptLoc[0][1]=35.9456951;

        deptLoc[1][0]=31.9565778;
        deptLoc[1][1]=35.9456951;

        deptLoc[2][0]=31.9565778;
        deptLoc[2][1]=35.9456951;

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
            viewHolder.locBtn=(ImageView)convertView.findViewById(R.id.locationBtn);
            viewHolder.callBtn=(ImageView)convertView.findViewById(R.id.callBtn);
            convertView.setTag(viewHolder);
            }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

            viewHolder.deptNumberTxv.setText(deptNumbers[position]);
            viewHolder.deptNumberTxv.setTag(deptNumbers[position]);

            viewHolder.deptNameTxv.setText(deptNames[position]);
            viewHolder.deptNameTxv.setTag(deptNames[position]);

            viewHolder.callBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + deptNumbers[position].toString()));
                    mContext.startActivity(callIntent);
                }
            });
            viewHolder.locBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent o=new Intent(mContext, MapActivity.class);
                    o.putExtra(MapActivity.locLatArgs,deptLoc[position][0]);
                    o.putExtra(MapActivity.locLonArgs,deptLoc[position][1]);
                    mContext.startActivity(o);
                }
            });

        return convertView;

    }
    static class ViewHolder {
        ImageView callBtn;
        ImageView locBtn;
        TextView deptNumberTxv;
        TextView deptNameTxv;
    }
}
