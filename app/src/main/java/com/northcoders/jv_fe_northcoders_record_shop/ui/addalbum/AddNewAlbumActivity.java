package com.northcoders.jv_fe_northcoders_record_shop.ui.addalbum;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import com.northcoders.jv_fe_northcoders_record_shop.R;
import com.northcoders.jv_fe_northcoders_record_shop.databinding.ActivityAddNewAlbumBinding;
import com.northcoders.jv_fe_northcoders_record_shop.model.Album;
import com.northcoders.jv_fe_northcoders_record_shop.ui.mainactivity.MainActivityViewModel;


public class AddNewAlbumActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private AddAlbumClickHandlers addAlbumClickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Use DataBindingUtil to set the content view
        ActivityAddNewAlbumBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        // Initialize the Album object and set it to the binding
        Album album = new Album();
        binding.setAlbum(album);

        // Initialize the ViewModel
        viewModel = new MainActivityViewModel(getApplication());

        // Initialize the click handlers and set it to the binding
        addAlbumClickHandlers = new AddAlbumClickHandlers(album, this, viewModel);
        binding.setAddAlbumClickHandlers(addAlbumClickHandlers);

        // Continue with setting the window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}