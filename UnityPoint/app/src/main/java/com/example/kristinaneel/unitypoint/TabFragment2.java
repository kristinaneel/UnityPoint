package com.example.kristinaneel.unitypoint;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Troy on 11/25/2016.
 */

public class TabFragment2 extends Fragment {
        String [] doctor = {"Dr.Jacob Lawernce", "Dr.Kenneth Ross", "Dr.Kathrine Miller", "Courtney Simmons, RN", "Todd Jankins, LPN",};
    private FragmentActivity myContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment_2, container, false);
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        //spinner.setOnItemSelectedListener(this.getActivity());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item,doctor);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

        return inflater.inflate(R.layout.tab_fragment_2, container, false);
    }



    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        String item = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent){

    }





//    public void open(View v){
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//        alertDialogBuilder.setMessage("Thank you for submitting an appointment request");
//        alertDialogBuilder.setPositiveButton("Home", new DialogInterface.OnClickListener(){
//            public void onClick(DialogInterface dialog, int which){
//                Intent intent = new Intent(this, HomeActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    this.startActivity(intent);
//            }
//        });
//
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//    }


}
