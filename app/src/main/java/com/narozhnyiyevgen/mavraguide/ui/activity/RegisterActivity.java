
package com.narozhnyiyevgen.mavraguide.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;

import com.narozhnyiyevgen.mavraguide.R;
import com.narozhnyiyevgen.mavraguide.databinding.ActivityRegistrBinding;
import com.narozhnyiyevgen.mavraguide.ui.fragments.EnterPhoneFragment;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegistrBinding binding;
    private Toolbar regToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    @Override
    protected void onStart() {
        super.onStart();

        setSupportActionBar(regToolbar);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.registerDataContainer, new EnterPhoneFragment())
                .commit();

    }
}