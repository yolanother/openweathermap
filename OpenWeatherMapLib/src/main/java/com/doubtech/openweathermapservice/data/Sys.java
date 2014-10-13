package com.doubtech.openweathermapservice.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by a1.jackson on 10/10/14.
 */
public class Sys implements Parcelable {
    public float message;
    public String country;
    public long sunrise;
    public long sunset;

    public Sys(Parcel parcel) {
        message = parcel.readFloat();
        country = parcel.readString();
        sunrise = parcel.readLong();
        sunset = parcel.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(message);
        parcel.writeString(country);
        parcel.writeLong(sunrise);
        parcel.writeLong(sunset);
    }

    public Parcelable.Creator<Sys> CREATOR
            = new Parcelable.Creator<Sys>() {
        public Sys createFromParcel(Parcel in) {
            return new Sys(in);
        }

        public Sys[] newArray(int size) {
            return new Sys[size];
        }
    };
}
