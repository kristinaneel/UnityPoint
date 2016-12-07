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

public class JsonReader {
    private ArrayList<User> mPersonList;
    private Context mContext;
    private static final String TAG = JsonReader.class.getSimpleName();

    public JsonReader(Activity context) { this.mContext = context; }

    public ArrayList<User> getPersonList()  throws IOException {
        mPersonList = new ArrayList<>();
        String personJson;

        try {
            //Get the asset file from assets folder
            InputStream inputStream = mContext.getAssets().open("user.json");
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
            JSONArray peopleJsonArray = personJsonObject.getJSONArray(Constant.JSON_USERS);

            for (int i = 0; i < peopleJsonArray.length(); i++){
                JSONObject personObject = peopleJsonArray.getJSONObject(i);
                String personFirstName = personObject.getString(Constant.JSON_FIRSTNAME);
                String personLastName = personObject.getString(Constant.JSON_LASTNAME);
                String password = personObject.getString(Constant.JSON_PASSWORD);
                int userId = personObject.getInt(Constant.JSON_USERID);
                User user = new User(personLastName, personFirstName, userId, password);
                mPersonList.add(user);
            }
        } catch (JSONException e){
            e.printStackTrace();
            return null;
        }
        return mPersonList;
    }

}
