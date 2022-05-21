package com.narozhnyiyevgen.mavraguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.narozhnyiyevgen.mavraguide.databinding.ActivityMainBinding;
import com.narozhnyiyevgen.mavraguide.ui.activity.RegisterActivity;
import com.narozhnyiyevgen.mavraguide.ui.objects.FireBaseHelper;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private DrawerLayout drawerLayout;
    private FireBaseHelper fireBaseHelper;
    private NavController controller;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();

        initFields();
        initFunctions();

    }

    private void initFunctions() {

        if (FireBaseHelper.AUTH.getCurrentUser() != null) {
            setSupportActionBar(toolbar);

            navigationView.setItemIconTintList(null);

            controller = Navigation.findNavController(this, R.id.nav_host_fragment);
            NavigationUI.setupWithNavController(navigationView, controller);

            controller.addOnDestinationChangedListener((navController, navDestination, bundle) -> {
                binding.tvTitle.setText(navDestination.getLabel());

                binding.imageMenu.setOnClickListener(v -> {
                    drawerLayout.openDrawer(GravityCompat.START);
                });
            });
        } else {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }


    }

    private void initFields() {
        toolbar = binding.mainToolbar;
        drawerLayout = binding.layoutDrawer;
        navigationView = binding.navigationView;

        fireBaseHelper = new FireBaseHelper();
        fireBaseHelper.init();

        if (FireBaseHelper.AUTH.getCurrentUser() != null) {
            fireBaseHelper.initUser();
        }

    }


}
