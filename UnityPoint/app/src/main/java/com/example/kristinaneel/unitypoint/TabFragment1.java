package com.example.kristinaneel.unitypoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;
import java.util.List;

/**
 * Created by Troy on 11/25/2016.
 */

public class TabFragment1 extends ListFragment {
    private Button myButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_1, container, false);

        try {
            List<Messages> messageList = new JsonReaderMessage((MainActivity) getActivity()).getPersonList();
            Messages[] messages = messageList.toArray(new Messages[messageList.size()]);
            MessageAdapter adapter = new MessageAdapter((MainActivity) getActivity(), messages);
            setListAdapter(adapter);
            myButton = (Button) rootView.findViewById(R.id.newMessageButton);

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