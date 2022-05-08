package com.narozhnyiyevgen.mavraguide.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.narozhnyiyevgen.mavraguide.R;
import com.narozhnyiyevgen.mavraguide.databinding.FragmentEnterPhoneBinding;


public class EnterPhoneFragment extends Fragment {

    private FragmentEnterPhoneBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEnterPhoneBinding.inflate(getLayoutInflater(), container, false);
        View v = binding.getRoot();

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        binding.registerBtnNext.setOnClickListener(this::sendCode);

    }

    private void sendCode(View view) {
        if (binding.etEnterYourNumberPhone.getText().toString().isEmpty()){
            Toast.makeText(getContext(), "Введите свой номер телефона", Toast.LENGTH_SHORT).show();
        }else{
            getFragmentManager().beginTransaction()
                    .replace(R.id.registerDataContainer, new EnterCodeFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }

}