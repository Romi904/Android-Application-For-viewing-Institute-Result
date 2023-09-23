package com.example.result_app;

import android.content.Context;
import android.service.autofill.RegexValidator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class oAdapter extends RecyclerView.Adapter<oAdapter.MyViewHolder> {
    private Context context;
    private List<oModel> oModelList;
    private List<oModel> filteruserDataList; //for Search method

    public oAdapter(Context context) {
        this.context = context;
        oModelList = new ArrayList<>();
        this.filteruserDataList=oModelList;
    }


    public void addModel(oModel model) {
        oModelList.add(model);
        notifyDataSetChanged();
    }
    public void clear(){
        oModelList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public oAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dycard,parent,false);

        return new MyViewHolder(view);
    }

    private void filterList(List<oModel> filterlist){
        oModelList = filterlist;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull oAdapter.MyViewHolder holder, int position) {
        holder.bindViews(filteruserDataList.get(position)); // if you want to delete search function replace filteruserDataList to oModelList

        animation(holder.itemView,position);
    }

    @Override
//    public int getItemCount() {
//        return oModelList.size();
//    } //oModelList
 public int getItemCount(){return filteruserDataList.size();} // if you want to delete search function replace filteruserDataList to oModelList
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView Roll_No,NAME,GEN,SGPA,CGPA,Remarks,Supple_in;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            NAME=itemView.findViewById(R.id.name);
            Roll_No=itemView.findViewById(R.id.roll);
            GEN=itemView.findViewById(R.id.gender);
            SGPA=itemView.findViewById(R.id.sgpa);
            CGPA=itemView.findViewById(R.id.cgpa);
            Remarks=itemView.findViewById(R.id.remark);
            Supple_in=itemView.findViewById(R.id.supp);
        }
        public void bindViews(oModel oModel){
            NAME.setText(oModel.getNAME());
            Roll_No.setText(oModel.getRoll_No());
            GEN.setText(oModel.getGEN());
            SGPA.setText(oModel.getSGPA());
            CGPA.setText(oModel.getCGPA());
            Remarks.setText(oModel.getRemarks());
            Supple_in.setText(oModel.getSupple_in());
        }

    }

    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String Key = constraint.toString();
                if(Key.isEmpty()){
                    filteruserDataList = oModelList;
                }else{
                    List<oModel> lstFiltered = new ArrayList<>();
                    for(oModel row : oModelList ){
                        if(row.getNAME().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);
                        } else if (row.getRoll_No().toUpperCase().contains(Key.toUpperCase())){
                            lstFiltered.add(row);
                        }
                    }
                    filteruserDataList = lstFiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteruserDataList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteruserDataList = (List<oModel>)results.values;
                notifyDataSetChanged();
            }
        };
    }
    int lastposition = -1; // to avoid repetation

    public void animation(View view , int position){
        if(position>lastposition){
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            view.startAnimation(slideIn);
            lastposition = position;
        }
    }
}
