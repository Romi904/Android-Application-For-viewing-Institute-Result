package com.example.result_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.result_app.databinding.ActivityComputerBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class computer extends AppCompatActivity {
    ActivityComputerBinding binding;
    private oAdapter oadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityComputerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        oadapter = new oAdapter(this);

        binding.recycleviewData.setAdapter(oadapter);
        binding.recycleviewData.setLayoutManager(new LinearLayoutManager(this));
        getData();

        // Dynamic Search Field in ListView
//        EditText search = findViewById(R.id.search);
//        Button ok = findViewById(R.id.ok);
//        ok.setOnClickListener(v->{
//            Toast.makeText(this, ""+search.getText().toString(), Toast.LENGTH_SHORT).show();
//        });
        SearchView searchview = findViewById(R.id.search);
        searchview.clearFocus();
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            CharSequence search="";
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                    oadapter.getFilter().filter(s);
                    search = s;
                return true;
            }
        });
//        For normal edit Text
//        EditText searchview = findViewById(R.id.search);
//        searchview.addTextChangedListener(new TextWatcher() {
//            CharSequence search="";
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                oadapter.getFilter().filter(s);
//                search = s;
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });



    }

    public void getData(){
        String URL ="https://script.google.com/macros/s/AKfycbxxeOeCQVhntqU9KxJ7vAAYR75TPnTBmnpCdPTRCIsg5Vuua9mogeiyqLtx8j5dBfu_/exec?"+"sheet=Sheet1";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("records");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
//                        String id = object.getString("id");
                        String name = object.getString("NAME");
//                        String reg = object.getString("Reg_No");
                        String roll = object.getString("Roll_No");
                        String gen = object.getString("GEN");
                        String sgpa = object.getString("SGPA");
                        String cgpa = object.getString("CGPA");
                        String remark = object.getString("Remarks");
                        String sup= object.getString("Supple_in");

                        oModel omodel = new oModel(roll,name,gen,sgpa,cgpa,remark,sup);
                        oadapter.addModel(omodel);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(computer.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(computer.this, "No Internet", Toast.LENGTH_SHORT).show(); //e.getMessage()
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonObjectRequest);
    }
}