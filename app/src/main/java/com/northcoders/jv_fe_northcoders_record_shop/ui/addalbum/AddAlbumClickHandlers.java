package com.northcoders.jv_fe_northcoders_record_shop.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.northcoders.jv_fe_northcoders_record_shop.model.Album;
import com.northcoders.jv_fe_northcoders_record_shop.ui.mainactivity.MainActivityViewModel;
import com.northcoders.jv_fe_northcoders_record_shop.ui.mainactivity.MainActivity;

public class AddAlbumClickHandlers {

    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;

    public AddAlbumClickHandlers(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onSubmitButton(View view) {
        // Check if any fields are empty
        if (album.getTitle() == null || album.getTitle().isEmpty() ||
                album.getDescription() == null || album.getDescription().isEmpty() ||
                album.getArtist() == null || album.getArtist().getName() == null ||
                album.getArtist().getRole() == null ||
                album.getGenre() == null || album.getPrice() <= 0 ||
                album.getInStock() < 0) {

            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new Album object with the current data
        Album newAlbum = new Album(
                album.getId(),
                album.getTitle(),
                album.getDescription(),
                album.getReleased(),
                album.getArtist(),
                album.getGenre(),
                album.getPrice(),
                album.getInStock()
        );

        // Pass the new Album to the ViewModel
        viewModel.addAlbum(newAlbum);

        // Switch to MainActivity
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void onFabBack(View view) {
        // Switch back to MainActivity without any actions
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}