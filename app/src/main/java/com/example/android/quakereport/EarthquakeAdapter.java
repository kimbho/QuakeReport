package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate
                    (R.layout.earthquake_list_item, parent, false);
        }

        ViewGroup.LayoutParams params = listItemView.getLayoutParams();
        //float factor = listItemView.getContext().getResources().getDisplayMetrics().density;
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, listItemView.getResources().getDisplayMetrics());
        params.height = height;
        listItemView.setLayoutParams(params);

        Earthquake current = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(current.getNumericMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        magnitude.setText(current.getMagnitude());

        TextView time = (TextView) listItemView.findViewById(R.id.time);
        Date dateObject = new Date(current.getDate());

        String formattedDate = formatDate(dateObject);
        time.setText(formatTime(dateObject));
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(formatDate(dateObject));

        //location.setText(current.getLocation());
        String loc = current.getLocation();
        String[] parts = loc.split(" of ");
        String part1, part2;
        if (parts.length >= 2) {
            part1 = parts[0] + " of";
            part2 = parts[1];
        } else {
            part1 = "Near the";
            part2 = parts[0];
        }
        TextView location = (TextView) listItemView.findViewById(R.id.location);
        location.setText(part2);
        TextView area = (TextView) listItemView.findViewById(R.id.area);
        area.setText(part1);


        return listItemView;
    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    public int getMagnitudeColor(int mag) {
        int color;
        switch (mag) {
            case 0:
            case 1:
                color = R.color.magnitude1;
                break;
            case 2:
                color = R.color.magnitude2;
                break;
            case 3:
                color = R.color.magnitude3;
                break;
            case 4:
                color = R.color.magnitude4;
                break;
            case 5:
                color = R.color.magnitude5;
                break;
            case 6:
                color = R.color.magnitude6;
                break;
            case 7:
                color = R.color.magnitude7;
                break;
            case 8:
                color = R.color.magnitude8;
                break;
            case 9:
                color = R.color.magnitude9;
                break;
            default:
                color = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), color);
    }

}
