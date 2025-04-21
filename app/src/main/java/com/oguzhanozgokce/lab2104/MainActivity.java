package com.oguzhanozgokce.lab2104;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oguzhanozgokce.lab2104.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupRecyclerView();
        loadSampleData();
    }

    private void setupRecyclerView() {
        itemAdapter = new ItemAdapter();
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);
    }

    private void loadSampleData() {
        List<Footballer> staticFootballerList = new ArrayList<>();
        staticFootballerList.add(new Footballer(UUID.randomUUID().toString(), "Lionel Messi", "Inter Miami", "Argentina", 36, 93));
        staticFootballerList.add(new Footballer(UUID.randomUUID().toString(), "Cristiano Ronaldo", "Al Nassr", "Portugal", 39, 90));
        staticFootballerList.add(new Footballer(UUID.randomUUID().toString(), "Kylian Mbappé", "Paris Saint-Germain", "France", 25, 91));
        staticFootballerList.add(new Footballer(UUID.randomUUID().toString(), "Erling Haaland", "Manchester City", "Norway", 23, 91));
        staticFootballerList.add(new Footballer(UUID.randomUUID().toString(), "Kevin De Bruyne", "Manchester City", "Belgium", 32, 91));
        staticFootballerList.add(new Footballer(UUID.randomUUID().toString(), "Neymar Jr.", "Al Hilal", "Brazil", 32, 89));
        staticFootballerList.add(new Footballer(UUID.randomUUID().toString(), "Robert Lewandowski", "FC Barcelona", "Poland", 35, 90));
        staticFootballerList.add(new Footballer(UUID.randomUUID().toString(), "Mohamed Salah", "Liverpool", "Egypt", 31, 89));
        staticFootballerList.add(new Footballer(UUID.randomUUID().toString(), "Virgil van Dijk", "Liverpool", "Netherlands", 32, 89));
        staticFootballerList.add(new Footballer(UUID.randomUUID().toString(), "Thibaut Courtois", "Real Madrid", "Belgium", 31, 90));

        itemAdapter.setItems(staticFootballerList);
    }
}