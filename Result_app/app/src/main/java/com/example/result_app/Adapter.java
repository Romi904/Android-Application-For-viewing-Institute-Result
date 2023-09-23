package com.example.result_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<student> {
    Context mctx;
    int ll;
    List<student> studentList;
    SQLiteDatabase mdb;

    public Adapter(Context mctx,int ll,List<student> studentList,SQLiteDatabase mdb){
        super(mctx,ll,studentList);
        this.mctx=mctx;
        this.ll=ll;
        this.studentList=studentList;
        this.mdb=mdb;
    }
    @Override
    public View getView(int pos, @Nullable View contentView, @NonNull ViewGroup parent){
        LayoutInflater inflater=LayoutInflater.from(mctx);
        View view = inflater.inflate(ll,null);
        student data=studentList.get(pos);

        TextView name,roll,cgpa,sgpa,remark,supp,gender;
        name=view.findViewById(R.id.name);
        roll=view.findViewById(R.id.roll);
        cgpa=view.findViewById(R.id.cgpa);
        sgpa=view.findViewById(R.id.sgpa);
        gender=view.findViewById(R.id.gender);
        remark=view.findViewById(R.id.remark);
        supp=view.findViewById(R.id.supp);

        name.setText(data.getName());
        roll.setText(data.getRollNo());
        cgpa.setText(data.getCGPA());
        sgpa.setText(data.getSGPA());
        gender.setText(data.getGender());
        remark.setText(data.getRemarks());
        supp.setText(data.getSupply());

        return view;
    }
}
