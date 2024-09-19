package com.northcoders.jv_fe_northcoders_record_shop.ui.mainactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.databinding.DataBindingUtil;

import com.northcoders.jv_fe_northcoders_record_shop.R;
import com.northcoders.jv_fe_northcoders_record_shop.databinding.ActivityMainBinding;
import com.northcoders.jv_fe_northcoders_record_shop.model.Album;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Album> albums = new ArrayList<>();
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize ActivityMainBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Initialize MainActivityViewModel
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        // Call method to fetch and observe album data
        getAllAlbums();

        // Edge-to-Edge setup using standard Android functionality
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void getAllAlbums() {
        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromLiveData) {
                // Cast the LiveData list to ArrayList
                albums = new ArrayList<>(albumsFromLiveData);

                // Display albums in the RecyclerView
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView() {
        // Assign RecyclerView from binding
        if (binding.recyclerView != null) {
            // Initialize AlbumAdapter and pass the list of albums
            albumAdapter = new AlbumAdapter(this, albums);

            // Set the adapter to the RecyclerView
            binding.recyclerView.setAdapter(albumAdapter);

            // Set layout manager for RecyclerView
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

            // Set fixed size for better performance
            binding.recyclerView.setHasFixedSize(true);

            // Notify the adapter that data has changed
            albumAdapter.notifyDataSetChanged();
        }
    }
}