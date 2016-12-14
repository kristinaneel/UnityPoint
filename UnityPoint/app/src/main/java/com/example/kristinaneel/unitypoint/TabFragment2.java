package com.example.kristinaneel.unitypoint;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Troy on 11/25/2016.
 */

public class TabFragment2 extends Fragment {
        String [] doctor = {"Select a doctor","Dr.Jacob Lawernce", "Dr.Kenneth Ross", "Dr.Kathrine Miller", "Courtney Simmons, RN", "Todd Jankins, LPN",};
    private FragmentActivity myContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_2, container, false);
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, doctor);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return v;
    }






}
