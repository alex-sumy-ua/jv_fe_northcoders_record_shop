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

    private ActivityAddNewAlbumBinding binding;
    private MainActivityViewModel viewModel; // Initialize your ViewModel
    private AddAlbumClickHandlers clickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Use DataBindingUtil to set the content view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        // Initialize the Album object and set it to the binding
        Album album = new Album();
        binding.setAlbum(album);

        // Initialize your ViewModel here (adjust as needed)
        viewModel = new MainActivityViewModel(getApplication()); // Replace with actual ViewModel initialization

        // Initialize click handlers
        clickHandlers = new AddAlbumClickHandlers(album, this, viewModel);

        // Set button click listeners
        Button buttonSubmit = binding.buttonSubmit; // Reference the button using binding
        buttonSubmit.setOnClickListener(clickHandlers::onSubmitButton);

        // Set up FAB click listener
        binding.fabBack.setOnClickListener(clickHandlers::onFabBack);

        // Continue with setting the window insets
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}