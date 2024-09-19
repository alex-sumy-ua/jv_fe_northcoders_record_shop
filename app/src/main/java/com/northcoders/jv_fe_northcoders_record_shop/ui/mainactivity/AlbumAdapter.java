package com.northcoders.jv_fe_northcoders_record_shop.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.jv_fe_northcoders_record_shop.databinding.AlbumItemBinding;
import com.northcoders.jv_fe_northcoders_record_shop.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> albumList;
    private Context context;

    // Constructor to initialize the list of albums and context
    public AlbumAdapter( Context context, List<Album> albumList) {
        this.albumList = albumList;
        this.context = context;
    }

    // Static inner class AlbumViewHolder that holds the AlbumItemBinding
    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        private final AlbumItemBinding albumItemBinding;

        public AlbumViewHolder(AlbumItemBinding albumItemBinding) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;
        }

        public void bind(Album album) {
            // Bind the Album object to the albumItemBinding
            albumItemBinding.setAlbum(album);
            albumItemBinding.executePendingBindings();  // This is important to refresh the UI
        }
    }

    // Inflates the item layout and creates a new ViewHolder
    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AlbumItemBinding binding = AlbumItemBinding.inflate(inflater, parent, false);
        return new AlbumViewHolder(binding);
    }

    // Binds the data (Album) to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);  // Get the current album at the position
        holder.bind(album);  // Bind it to the ViewHolder
    }

    // Returns the total number of albums
    @Override
    public int getItemCount() {
        return albumList.size();
    }
}