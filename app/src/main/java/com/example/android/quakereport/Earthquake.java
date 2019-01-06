package com.example.android.quakereport;

import java.text.DecimalFormat;

public class Earthquake {

    private String mMagnitude, mLocation;
    long mDate;

    public Earthquake(String mag, String loc, long date) {

        mMagnitude = mag;
        mLocation = loc;
        mDate = date;
    }

    public String getMagnitude() {
        double value = Double.parseDouble(mMagnitude);
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(value);
        return output;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getDate() {
        return mDate;
    }

    public int getNumericMagnitude() {
        double value = Double.parseDouble(mMagnitude);
        return (int)value;
    }
}
