package com.narozhnyiyevgen.mavraguide.ui.fragments.settingsfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.narozhnyiyevgen.mavraguide.R;
import com.narozhnyiyevgen.mavraguide.databinding.FragmentUserChangeNameBinding;
import com.narozhnyiyevgen.mavraguide.ui.objects.FireBaseHelper;

import java.util.Arrays;
import java.util.List;


public class UserChangeNameFragment extends Fragment {

    private FragmentUserChangeNameBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserChangeNameBinding.inflate(getLayoutInflater(), container, false);
        View v = binding.getRoot();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        setHasOptionsMenu(true);
        if (!FireBaseHelper.USER.getFullName().isEmpty()){
            enterNewFullNameUser();
        }
    }

    private void enterNewFullNameUser() {
        List<String> fullName = Arrays.asList(FireBaseHelper.USER.getFullName().split(" "));
        binding.userChangeNameEtChangeName.setText(fullName.get(0));
        binding.userChangeNameEtChangeSurname.setText(fullName.get(1));
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        requireActivity().getMenuInflater().inflate(R.menu.user_change_name_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.change_name_menu) {
            changeName();
        }
        return true;
    }

    private void changeName() {

        String name = binding.userChangeNameEtChangeName.getText().toString();
        String surname = binding.userChangeNameEtChangeSurname.getText().toString();

        if (name.isEmpty() || surname.isEmpty()) {
            Toast.makeText(getContext(), R.string.user_change_name_inut_fullname, Toast.LENGTH_SHORT).show();
        } else {
            String fullname = name + " " + surname;
            new FireBaseHelper().changeFullName(fullname, getFragmentManager());
            Toast.makeText(getActivity(), R.string.toast_data_updated, Toast.LENGTH_SHORT).show();
        }
    }
}