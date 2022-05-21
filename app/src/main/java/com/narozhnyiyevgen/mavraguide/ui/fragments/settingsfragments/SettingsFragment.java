package com.narozhnyiyevgen.mavraguide.ui.fragments.settingsfragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.narozhnyiyevgen.mavraguide.MainActivity;
import com.narozhnyiyevgen.mavraguide.R;
import com.narozhnyiyevgen.mavraguide.databinding.FragmentSettingsBinding;
import com.narozhnyiyevgen.mavraguide.ui.objects.FireBaseHelper;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(getLayoutInflater(), container, false);
        View v = binding.getRoot();
        return v;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        requireActivity().getMenuInflater().inflate(R.menu.settings_actions_menu,menu);
    }

    @Override
    public void onStart() {
        super.onStart();
        setHasOptionsMenu(true);
        binding.clSettingButtonChangeName.setOnClickListener(this::goToEditing);
        initFieldsUser();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void goToEditing(View view) {
       getParentFragmentManager().beginTransaction()
               .replace(R.id.nav_host_fragment, new UserChangeNameFragment())
               .addToBackStack(null)
               .commit();
    }

    private void initFieldsUser() {
        binding.tvSettingsChangeUsername.setText(FireBaseHelper.USER.getFullName());
        binding.tvSettingsChangeUserPhone.setText(FireBaseHelper.USER.getPHONE());
        binding.tvSettingsChangeUserRank.setText(FireBaseHelper.USER.getRank());
        binding.tvSettingsChangeWorkPlace.setText(FireBaseHelper.USER.getWorkplace());
        binding.tvSettingsUserFullNameHeader.setText(FireBaseHelper.USER.getFullName());
        binding.tvSettingsUserRankHeader.setText(FireBaseHelper.USER.getRank());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings_btn_actions_menu_exit) {
            FireBaseHelper.AUTH.signOut();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            requireActivity().finish();
            startActivity(intent);
        }
        return true;
    }
}