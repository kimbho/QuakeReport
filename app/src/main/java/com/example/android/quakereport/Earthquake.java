package com.example.android.quakereport;

public class Earthquake {

    private String mMagnitude, mLocation, mDate;

    public Earthquake(String mag, String loc, String date) {

        mMagnitude = mag;
        mLocation = loc;
        mDate = date;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }
}
