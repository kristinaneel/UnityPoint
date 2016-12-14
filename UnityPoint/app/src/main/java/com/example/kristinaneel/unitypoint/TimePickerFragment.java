package com.example.kristinaneel.unitypoint;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by kristinaneel on 11/22/2016.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private String format = "";


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default time in the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);



        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hour, int minute) {
        // Do something with the time chosen by the user

       if (hour == 0){
           hour +=12;
           format = "AM";
       }else if(hour == 12){
           format = "PM";
       }else if(hour > 12){
           hour -= 12;
           format = "PM";
       }else{
           format = "AM";
       }


        TextView tv2= (TextView) getActivity().findViewById(R.id.textview2);
        tv2.setText(new StringBuilder().append(hour).append(" : ").append(minute)
        .append(" ").append(format));

    }



}
