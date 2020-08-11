package com.edinsson.tarea3_4.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edinsson.tarea3_4.R;
import com.edinsson.tarea3_4.modelo.CardViewProfile;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PictureProfileRecyclerViewAdapter extends RecyclerView.Adapter<PictureProfileRecyclerViewAdapter.ViewHolder> {

    private ArrayList<CardViewProfile> pictures;
    private int resource;
    private Activity activity;

    public PictureProfileRecyclerViewAdapter(ArrayList<CardViewProfile> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardViewProfile cardViewProfile = pictures.get(position);
        holder.textView.setText(cardViewProfile.getRaitingNumber());
        Picasso.get().load(cardViewProfile.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_cardview_profile);
            textView = (TextView) itemView.findViewById(R.id.raiting_number_profile);
        }
    }
}
