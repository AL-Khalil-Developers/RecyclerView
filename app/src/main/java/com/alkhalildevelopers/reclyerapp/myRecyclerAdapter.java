package com.alkhalildevelopers.reclyerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    String [] AndroidVersion;
    public myRecyclerAdapter(Context context,String[]AndroidVersion){
        this.context=context;
        this.AndroidVersion=AndroidVersion;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.list_android_version_layout,parent,false);
        AndroidVersion myViewHolder = new AndroidVersion(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
//        ((AndroidVersion)holder).listTitleText.setText(AndroidVersion[position]);
//        ((AndroidVersion)holder).listDescriptionText.setText(AndroidVersion[position]);
        ((AndroidVersion)holder).listTitleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Select  : "+ position + " Android Version", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return AndroidVersion.length;
    }

    public class AndroidVersion extends RecyclerView.ViewHolder{
            ImageView listItemIcon;
            TextView listTitleText,listDescriptionText;
        public AndroidVersion(@NonNull View itemView) {
            super(itemView);
            listItemIcon=itemView.findViewById(R.id.iconImageId);
            listTitleText=itemView.findViewById(R.id.listTitleID);
            listDescriptionText=itemView.findViewById(R.id.listDesciptionID);
        }
    }
}
