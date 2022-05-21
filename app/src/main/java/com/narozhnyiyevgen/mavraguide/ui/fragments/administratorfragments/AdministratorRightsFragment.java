package com.narozhnyiyevgen.mavraguide.ui.fragments.administratorfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.narozhnyiyevgen.mavraguide.databinding.FragmentAdministratorRightsBinding;

public class AdministratorRightsFragment extends Fragment {

    private FragmentAdministratorRightsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdministratorRightsBinding.inflate(getLayoutInflater(), container, false);
        View v = binding.getRoot();



        return v;
    }
}