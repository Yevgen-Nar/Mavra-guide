package com.narozhnyiyevgen.mavraguide.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.narozhnyiyevgen.mavraguide.MainActivity;
import com.narozhnyiyevgen.mavraguide.R;
import com.narozhnyiyevgen.mavraguide.databinding.FragmentEnterPhoneBinding;
import com.narozhnyiyevgen.mavraguide.ui.objects.FireBaseHelper;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class EnterPhoneFragment extends Fragment {
    private FragmentEnterPhoneBinding binding;
    private String phoneNumber;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks authCallbacks;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEnterPhoneBinding.inflate(getLayoutInflater(), container, false);
        View v = binding.getRoot();

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        authCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                FireBaseHelper.AUTH
                        .signInWithCredential(phoneAuthCredential)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(getContext(), "Добро пожаловать.", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                requireActivity().finish();
                                startActivity(intent);
                            }
                        });
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String id, @NonNull PhoneAuthProvider.ForceResendingToken token) {
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction()
                        .replace(R.id.registerDataContainer, new EnterCodeFragment(phoneNumber, id))
                        .addToBackStack(null)
                        .commit();
            }
        };

        binding.registerBtnNext.setOnClickListener(this::sendCode);

    }

    private void sendCode(View view) {
        if (Objects.requireNonNull(binding.etEnterYourNumberPhone.getText()).toString().isEmpty()) {
            Toast.makeText(getContext(), R.string.register_enter_your_phone, Toast.LENGTH_SHORT).show();
        } else {
            authUser();
        }
    }

    private void authUser() {

        phoneNumber = Objects.requireNonNull(binding.etEnterYourNumberPhone.getText()).toString();

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                requireActivity(),
                authCallbacks
        );
    }

    @Override
    public void onStop() {
        super.onStop();
        binding.etEnterYourNumberPhone.setText(null);
    }


}