package com.doubtech.openweathermapservice.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aaron on 10/10/14 7:00 PM
 */
public class Wind implements Parcelable {
    public float speed;
    public float deg;

    public Wind(Parcel parcel) {
        speed = parcel.readFloat();
        deg = parcel.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(speed);
        parcel.writeFloat(deg);
    }

    public Parcelable.Creator<Wind> CREATOR
            = new Parcelable.Creator<Wind>() {
        public Wind createFromParcel(Parcel in) {
            return new Wind(in);
        }

        public Wind[] newArray(int size) {
            return new Wind[size];
        }
    };
}
