package com.narozhnyiyevgen.mavraguide.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.narozhnyiyevgen.mavraguide.MainActivity;
import com.narozhnyiyevgen.mavraguide.databinding.FragmentEnterCodeBinding;
import com.narozhnyiyevgen.mavraguide.ui.objects.FireBase;

import java.util.Objects;


public class EnterCodeFragment extends Fragment {
    private FragmentEnterCodeBinding binding;
    private String phoneNumber;
    private String id;

    public EnterCodeFragment(String phoneNumber, String id) {
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEnterCodeBinding.inflate(getLayoutInflater(), container, false);
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
                String code = Objects.requireNonNull(binding.registerCodeEtEnterYourCode.getText()).toString();
                if (code.length() == 6) {
                    enterCode();
                }
            }
        });
    }

    private void enterCode() {
        String code = Objects.requireNonNull(binding.registerCodeEtEnterYourCode.getText()).toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(id, code);

        FireBase.getAUTH()
                .signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getContext(), "Добро пожаловать.", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

