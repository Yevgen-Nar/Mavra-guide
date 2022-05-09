package com.narozhnyiyevgen.mavraguide.ui.objects;

import com.google.firebase.auth.FirebaseAuth;

public  class FireBase {
    static FirebaseAuth AUTH;

    public FireBase() {
    }

    public static void setAUTH(FirebaseAuth AUTH) {
        FireBase.AUTH = AUTH;
    }

    public static FirebaseAuth getAUTH() {
        return AUTH;
    }
}
