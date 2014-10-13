package com.doubtech.openweathermapservice.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aaron on 10/10/14 7:00 PM
 */
public class Clouds implements Parcelable {
    public int all;

    public Clouds(Parcel parcel) {
        all = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(all);
    }

    public Parcelable.Creator<Clouds> CREATOR
            = new Parcelable.Creator<Clouds>() {
        public Clouds createFromParcel(Parcel in) {
            return new Clouds(in);
        }

        public Clouds[] newArray(int size) {
            return new Clouds[size];
        }
    };
}
