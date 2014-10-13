package com.doubtech.openweathermapservice.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by a1.jackson on 10/10/14.
 */
public class Coord implements Parcelable {
    public float lat;
    public float lon;

    public Coord(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(lat);
        parcel.writeFloat(lon);
    }

    public Parcelable.Creator<Coord> CREATOR
            = new Parcelable.Creator<Coord>() {
        public Coord createFromParcel(Parcel in) {
            return new Coord(in.readFloat(), in.readFloat());
        }

        public Coord[] newArray(int size) {
            return new Coord[size];
        }
    };

    public float getLat() { return lat; }
    public float getLon() { return lon; }
}
