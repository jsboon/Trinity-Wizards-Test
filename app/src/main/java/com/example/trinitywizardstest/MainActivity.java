package com.example.trinitywizardstest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact_Model> contact_models = new ArrayList<>();
    RecyclerView recyclerView;
    Contact_Adapter contact_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            String id, first_name, last_name, email, phone;
            JSONArray array = new JSONArray(readJSON());
            for (int i = 0; i < array.length(); i++) {

                JSONObject jsonObject = array.getJSONObject(i);

                id = jsonObject.getString("id");
                first_name = jsonObject.getString("firstName");
                last_name = jsonObject.getString("lastName");
                email = checkNull(jsonObject, "email");
                phone = checkNull(jsonObject, "phone");


                Contact_Model model = new Contact_Model(first_name, last_name, email, phone);
                contact_models.add(model);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        contact_adapter = new Contact_Adapter(this, contact_models);
        recyclerView.setAdapter(contact_adapter);

    }

    private String readJSON() {
        String json = null;
        try {
            // Opening data.json file
            InputStream inputStream = getAssets().open("data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            // read values in the byte array
            inputStream.read(buffer);
            inputStream.close();
            // convert byte to string
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public String checkNull(JSONObject json, String key){
        if (json.isNull(key))
            return null;
        else
            return json.optString(key, null);
    }

}
