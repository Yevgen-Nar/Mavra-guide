package com.narozhnyiyevgen.mavraguide.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.narozhnyiyevgen.mavraguide.R;
import com.narozhnyiyevgen.mavraguide.databinding.FragmentEnterCodeBinding;


public class EnterCodeFragment extends Fragment {
private FragmentEnterCodeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEnterCodeBinding.inflate(getLayoutInflater(),container,false);
        View v = binding.getRoot();

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        binding.registerCodeEtEnterYourCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String code = binding.registerCodeEtEnterYourCode.getText().toString();
                if (code.length() == 6){
                    Toast.makeText(getContext(), "Okk", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}