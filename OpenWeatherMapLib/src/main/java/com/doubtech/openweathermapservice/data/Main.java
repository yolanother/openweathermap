package com.doubtech.openweathermapservice.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aaron on 10/10/14 6:50 PM
 */
public class Main implements Parcelable {
    public static final String UNITS_METRIC = "metric";
    public static final String UNITS_IMPERIAL = "imperial";

    public int humidity;
    public float pressure;
    public float temp_max;
    public int sea_level;
    public float temp_min;
    public float temp;
    public float grnd_level;

    public Main(Parcel parcel) {
        humidity = parcel.readInt();
        pressure = parcel.readFloat();
        temp_max = parcel.readFloat();
        sea_level = parcel.readInt();
        temp_min = parcel.readFloat();
        temp = parcel.readFloat();
        grnd_level = parcel.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(humidity);
        parcel.writeFloat(pressure);
        parcel.writeFloat(temp_max);
        parcel.writeInt(sea_level);
        parcel.writeFloat(temp_min);
        parcel.writeFloat(temp);
        parcel.writeFloat(grnd_level);
    }

    public Parcelable.Creator<Main> CREATOR
            = new Parcelable.Creator<Main>() {
        public Main createFromParcel(Parcel in) {
            return new Main(in);
        }

        public Main[] newArray(int size) {
            return new Main[size];
        }
    };
}
