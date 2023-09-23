package com.example.result_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ee,mm, cs,me;
        ee=findViewById(R.id.ee);
        mm=findViewById(R.id.mm);
        cs=findViewById(R.id.cs);
        me=findViewById(R.id.me);

        cs.setOnClickListener(v->{
            Intent intent =new Intent(this,computer.class);
            startActivity(intent);
//            finish();
        });
        ee.setOnClickListener(v->{
            Intent intent =new Intent(this,electrical.class);
            startActivity(intent);
//            Toast.makeText(this, " Coming Soon .....😪😪😪", Toast.LENGTH_SHORT).show();
        });

        mm.setOnClickListener(v->{
            Intent intent =  new Intent(this,mechanical.class);
            startActivity(intent);
//            Toast.makeText(this, " Coming Soon .....😪😪😪", Toast.LENGTH_SHORT).show();
        });
        me.setOnClickListener(v->{
//            Toast.makeText(this, " Coming Soon .....😪😪😪", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,testimage.class);
            startActivity(intent);
            finish();
        });
    }
}