package com.narozhnyiyevgen.mavraguide.ui.objects;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.narozhnyiyevgen.mavraguide.models.User;

public class FireBaseHelper {
    public static FirebaseAuth AUTH;
    public static DatabaseReference REF_DATA_ROOT;
    public static String UID;
    public static User USER;

    public FireBaseHelper() {
    }

    public void init() {
        AUTH = FirebaseAuth.getInstance();
        REF_DATA_ROOT = FirebaseDatabase.getInstance().getReference();
        USER = new User();
        if (AUTH.getCurrentUser() != null) {
            UID = AUTH.getCurrentUser().getUid();
        }
    }

    public void changeFullName(String fullname, FragmentManager fragment) {
        REF_DATA_ROOT
                .child(NodeEnum.NODE_MAIN.getNODE_NAME())
                .child(NodeEnum.NODE_PIZZERIA.getNODE_NAME())
                .child(NodeEnum.NODE_USERS.getNODE_NAME())
                .child(FireBaseHelper.UID)
                .child(UserFields.FULL_NAME.getUSER_FIELDS_VALUE())
                .setValue(fullname)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FireBaseHelper.USER.setFullName(fullname);
                        fragment.popBackStack();
                    }
                });
    }

    public void initUser() {
        FireBaseHelper.REF_DATA_ROOT
                .child(NodeEnum.NODE_MAIN.getNODE_NAME())
                .child(NodeEnum.NODE_PIZZERIA.getNODE_NAME())
                .child(NodeEnum.NODE_USERS.getNODE_NAME())
                .child(FireBaseHelper.UID)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        FireBaseHelper.USER = snapshot.getValue(User.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }
}
