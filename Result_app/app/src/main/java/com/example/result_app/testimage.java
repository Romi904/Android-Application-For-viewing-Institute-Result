package com.example.result_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class testimage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimage);

        ImageView img =findViewById(R.id.imageView);
        SearchView search = findViewById(R.id.search);
        search.setQueryHint("Search here");

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Glide.with(testimage.this).load("https://source.unsplash.com/340x400/?"+newText).into(img);
                return true;
            }
        });
    }
}