package com.alarstudios.testTask.view.main.adapter;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.alarstudios.testTask.R;
import com.alarstudios.testTask.data.model.Item;
import com.alarstudios.testTask.view.main.ItemClickListener;
import com.alarstudios.testTask.view.main.MainActivity;
import com.alarstudios.testTask.view.main.OnBottomListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>{

    private static final String TAG = "ItemsAdapter";
    
    private MainActivity mainActivity;
    private List<Item> items;
    OnBottomListener onBottomListener;

    public ItemsAdapter(MainActivity mainActivity, List<Item> items){
        this.mainActivity = mainActivity;
        this.items = items;
    }

    public void setOnBottom(OnBottomListener onBottom){
        this.onBottomListener = onBottom;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.name.setText(item.getName());

        Glide.with(mainActivity)
                .load(item.getImageUrl()).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        })

                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onItemClick(position);
            }
        });

        if (position == items.size()-1){
            Log.d(TAG, "onBindViewHolder: end");
            onBottomListener.onBottomListener();
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;

        public ViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
        }
    }
}
