
package com.narozhnyiyevgen.mavraguide.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.narozhnyiyevgen.mavraguide.R;
import com.narozhnyiyevgen.mavraguide.databinding.ActivityRegistrBinding;
import com.narozhnyiyevgen.mavraguide.ui.fragments.EnterPhoneFragment;
import com.narozhnyiyevgen.mavraguide.ui.objects.FireBaseHelper;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegistrBinding binding;
    private Toolbar regToolbar;
    private FireBaseHelper fireBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fireBaseHelper = new FireBaseHelper();
        fireBaseHelper.init();
        regToolbar = binding.registerActivityToolBar;

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