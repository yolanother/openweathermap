package com.doubtech.openweathermapservice.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aaron Jackson on 10/10/14 6:43 PM
 */
public class Weather implements Parcelable {
    public int id;
    public String icon;
    public String description;
    public String main;

    public Weather(Parcel parcel) {
        id = parcel.readInt();
        icon = parcel.readString();
        description = parcel.readString();
        main = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(icon);
        parcel.writeString(description);
        parcel.writeString(main);
    }

    public Parcelable.Creator<Weather> CREATOR
            = new Parcelable.Creator<Weather>() {
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };
}
