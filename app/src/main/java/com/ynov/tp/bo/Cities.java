package com.ynov.tp.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Cities implements Parcelable {
    String name, id;

    public Picture getPic() {
        return pic;
    }

    public void setPic(Picture pic) {
        this.pic = pic;
    }

    Picture pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    protected Cities(Parcel in) {
        name = in.readString();
        id = in.readString();
    }

    public static final Creator<Cities> CREATOR = new Creator<Cities>() {
        @Override
        public Cities createFromParcel(Parcel in) {
            return new Cities(in);
        }

        @Override
        public Cities[] newArray(int size) {
            return new Cities[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id);
    }
}