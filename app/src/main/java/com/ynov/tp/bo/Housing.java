package com.ynov.tp.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class Housing implements Parcelable {
    String title;
    Float price;
    Picture pic;

    protected Housing(Parcel in) {
        title = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readFloat();
        }
    }

    public static final Creator<Housing> CREATOR = new Creator<Housing>() {
        @Override
        public Housing createFromParcel(Parcel in) {
            return new Housing(in);
        }

        @Override
        public Housing[] newArray(int size) {
            return new Housing[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(price);
        }
    }
}
