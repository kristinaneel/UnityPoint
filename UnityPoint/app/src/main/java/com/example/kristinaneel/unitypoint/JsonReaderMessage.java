package com.example.kristinaneel.unitypoint;

import android.app.Activity;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Zach on 12/5/16.
 */

public class JsonReaderMessage {
    private ArrayList<Messages> mMessageList;
    private Context mContext;
    private static final String TAG = JsonReader.class.getSimpleName();

    public JsonReaderMessage(Activity context) { this.mContext = context; }

    public ArrayList<Messages> getPersonList()  throws IOException {
        mMessageList = new ArrayList<>();
        String personJson;

        try {
            //Get the asset file from assets folder
            InputStream inputStream = mContext.getAssets().open("messages.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];

            inputStream.read(buffer);
            inputStream.close();
            personJson = new String(buffer, "UTF-8");
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }

        try {
            JSONObject personJsonObject = new JSONObject(personJson);
            JSONArray peopleJsonArray = personJsonObject.getJSONArray(messageConstant.JSON_MESSAGES);

            for (int i = 0; i < peopleJsonArray.length(); i++){
                JSONObject personObject = peopleJsonArray.getJSONObject(i);
                String sender = personObject.getString(messageConstant.JSON_SENDER);
                String text = personObject.getString(messageConstant.JSON_TEXT);

                Messages message = new Messages(sender, text);
                mMessageList.add(message);
            }
        } catch (JSONException e){
            e.printStackTrace();
            return null;
        }
        return mMessageList;
    }

}
