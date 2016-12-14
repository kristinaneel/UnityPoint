package com.example.kristinaneel.unitypoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Troy on 11/25/2016.
 */

public class TabFragment1 extends Fragment {
    private Button myButton;
    private TextView titleText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_1, container, false);
            final ListView lv = (ListView) rootView.findViewById(R.id.list);
            MessageAdapter adapter = new MessageAdapter(((MainActivity) getActivity()), ((MainActivity) getActivity()).getMessages());
            lv.setAdapter(adapter);
            titleText = (TextView) rootView.findViewById(R.id.titleText);
            myButton = (Button) rootView.findViewById(R.id.newMessageButton);

            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent((MainActivity) getActivity(), MessageActivity.class);
                    startActivity(intent);
                }
            });


        return rootView;
    }
}