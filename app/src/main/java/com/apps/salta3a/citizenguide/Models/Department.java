package com.apps.salta3a.citizenguide.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Department implements Parcelable {
    public int id;
    public int nameRes;
    public int desRes;
    public Department(int id,int name,int desRes){
        this.id=id;
        this.nameRes=name;
        this.desRes=desRes;
    }

    protected Department(Parcel in) {
        id=in.readInt();
        nameRes = in.readInt();
        desRes = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(nameRes);
        dest.writeInt(desRes);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Department> CREATOR = new Parcelable.Creator<Department>() {
        @Override
        public Department createFromParcel(Parcel in) {
            return new Department(in);
        }

        @Override
        public Department[] newArray(int size) {
            return new Department[size];
        }
    };
}