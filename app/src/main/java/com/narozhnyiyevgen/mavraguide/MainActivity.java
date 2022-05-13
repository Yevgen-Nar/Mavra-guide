package com.narozhnyiyevgen.mavraguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.narozhnyiyevgen.mavraguide.databinding.ActivityMainBinding;
import com.narozhnyiyevgen.mavraguide.ui.activity.RegisterActivity;
import com.narozhnyiyevgen.mavraguide.ui.fragments.PizzaFragment;
import com.narozhnyiyevgen.mavraguide.ui.objects.AppDrawer;
import com.narozhnyiyevgen.mavraguide.ui.objects.FireBase;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Toolbar mToolBar;
    private AppDrawer appDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initFields();

    }

    @Override
    protected void onStart() {
        super.onStart();

        initFunctions();
    }

    private void initFunctions() {

        if (FireBase.AUTH.getCurrentUser() != null) {
            setSupportActionBar(mToolBar);
            appDrawer.create();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.data_container, new PizzaFragment()).commit();
        } else {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }

    private void initFields() {
        appDrawer = new AppDrawer(MainActivity.this, mToolBar);
        mToolBar = binding.mainToolBar;
        FireBase.init();
    }
}