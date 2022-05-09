package com.narozhnyiyevgen.mavraguide.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narozhnyiyevgen.mavraguide.R;
import com.narozhnyiyevgen.mavraguide.databinding.FragmentPizzaBinding;

public class PizzaFragment extends Fragment {

    private FragmentPizzaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPizzaBinding.inflate(getLayoutInflater(), container, false);
        View v = binding.getRoot();

        return v;
    }
}