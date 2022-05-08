package com.narozhnyiyevgen.mavraguide.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narozhnyiyevgen.mavraguide.R;
import com.narozhnyiyevgen.mavraguide.databinding.FragmentSettingsBinding;

import java.util.Objects;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(getLayoutInflater(), container, false);
        View v = binding.getRoot();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
    setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        requireActivity().getMenuInflater().inflate(R.menu.settings_actions_menu, menu);
    }
}