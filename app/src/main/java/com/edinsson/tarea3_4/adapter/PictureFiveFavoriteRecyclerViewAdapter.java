package com.edinsson.tarea3_4.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edinsson.tarea3_4.R;
import com.edinsson.tarea3_4.db.ConstructorCardViewMain;
import com.edinsson.tarea3_4.modelo.CardViewMain;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PictureFiveFavoriteRecyclerViewAdapter extends RecyclerView.Adapter<PictureFiveFavoriteRecyclerViewAdapter.ViewHolder> {

    private ArrayList<CardViewMain> pictures;
    private int resource;
    private Activity activity;

    public PictureFiveFavoriteRecyclerViewAdapter(ArrayList<CardViewMain> pictures, int resource, Activity activity) {
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
        ConstructorCardViewMain constructorCardViewMain = new ConstructorCardViewMain(activity);
        CardViewMain cardViewMain = pictures.get(position);
        holder.name.setText(cardViewMain.getName());
        holder.numRaiting.setText(String.valueOf(constructorCardViewMain.obtenerLikePublisher(cardViewMain)));
        holder.raiting.setChecked(true);
        Picasso.get().load(cardViewMain.getPicture()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name;
        private TextView numRaiting;
        private CheckBox raiting;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_cardview);
            name = (TextView) itemView.findViewById(R.id.name_pet);
            numRaiting = (TextView) itemView.findViewById(R.id.num_rating);
            raiting = (CheckBox) itemView.findViewById(R.id.selector_raiting);
        }
    }
}
