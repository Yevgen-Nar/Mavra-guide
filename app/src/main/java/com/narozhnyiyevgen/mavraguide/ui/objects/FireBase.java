package com.narozhnyiyevgen.mavraguide.ui.objects;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public  class FireBase {
   public static FirebaseAuth AUTH;
   public static DatabaseReference REF_DATA_ROOT;

    public FireBase() {
    }

   public static void init(){
        AUTH = FirebaseAuth.getInstance();
        REF_DATA_ROOT = FirebaseDatabase.getInstance().getReference();
    }

}
