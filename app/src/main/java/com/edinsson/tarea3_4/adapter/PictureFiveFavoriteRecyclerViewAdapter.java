package com.edinsson.tarea3_4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edinsson.tarea3_4.R;
import com.edinsson.tarea3_4.modelo.CardViewMain;
import com.squareup.picasso.Picasso;

public class PictureFiveFavoriteRecyclerViewAdapter extends RecyclerView.Adapter<PictureFiveFavoriteRecyclerViewAdapter.ViewHolder> {

    private CardViewMain [] pictures = new CardViewMain[5];
    private int resource;

    public PictureFiveFavoriteRecyclerViewAdapter(CardViewMain[] pictures, int resource) {
        this.pictures = pictures;
        this.resource = resource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardViewMain cardViewMain = pictures[position];
        holder.name.setText(cardViewMain.getName());
        holder.numRaiting.setText(cardViewMain.getRaitingNumber());
        Picasso.get().load(cardViewMain.getPicture()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name;
        private TextView numRaiting;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_cardview);
            name = (TextView) itemView.findViewById(R.id.name_pet);
            numRaiting = (TextView) itemView.findViewById(R.id.num_rating);
        }
    }
}
