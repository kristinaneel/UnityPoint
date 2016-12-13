package com.example.kristinaneel.unitypoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.io.IOException;
import java.util.List;

/**
 * Created by Troy on 11/25/2016.
 */

public class TabFragment1 extends Fragment {
    private Button myButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_2, container, false);
        try {
            List<Messages> messageList = new JsonReaderMessage((MainActivity) getActivity()).getPersonList();
            Messages[] messages = messageList.toArray(new Messages[messageList.size()]);
            ArrayAdapter<Messages> adapter = new ArrayAdapter<Messages>
                    ((MainActivity) getActivity(), android.R.layout.simple_list_item_1, messages);
            myButton = (Button) rootView.findViewById(R.id.button2);

            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent((MainActivity) getActivity(), MessageActivity.class);
                    startActivity(intent);
                }
            });
        }catch (IOException e) {
            e.printStackTrace();
        }

        return rootView;
    }
}