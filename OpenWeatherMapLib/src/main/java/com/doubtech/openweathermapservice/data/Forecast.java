package com.doubtech.openweathermapservice.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aaron on 10/10/14 7:22 PM
 */
public class Forecast implements Parcelable {
    public long id;
    public long dt;
    public Clouds clouds;
    public Coord coord;
    public Wind wind;
    public int cod;
    public Sys sys;
    public String name;
    public String base;
    public Weather[] weather;
    public Main main;

    public Forecast(Parcel parcel) {
        id = parcel.readLong();
        dt = parcel.readLong();
        clouds = parcel.readParcelable(Clouds.class.getClassLoader());
        coord = parcel.readParcelable(Coord.class.getClassLoader());
        wind = parcel.readParcelable(Wind.class.getClassLoader());
        cod = parcel.readInt();
        sys = parcel.readParcelable(Sys.class.getClassLoader());
        name = parcel.readString();
        base = parcel.readString();
        //weather = parcel.readParcelableArray(Weather.class.getClassLoader());
        main = parcel.readParcelable(Main.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeLong(dt);
        parcel.writeParcelable(clouds, clouds.describeContents());
        parcel.writeParcelable(coord, coord.describeContents());
        parcel.writeParcelable(wind, wind.describeContents());
        parcel.writeInt(cod);
        parcel.writeParcelable(sys, sys.describeContents());
        parcel.writeString(name);
        parcel.writeString(base);
        parcel.writeParcelableArray(weather, 0);
        parcel.writeParcelable(main, main.describeContents());
    }

    public Parcelable.Creator<Forecast> CREATOR
            = new Parcelable.Creator<Forecast>() {
        public Forecast createFromParcel(Parcel in) {
            return new Forecast(in);
        }

        public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };
}