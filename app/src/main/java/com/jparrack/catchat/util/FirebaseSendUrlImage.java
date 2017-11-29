package com.jparrack.catchat.util;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONObject;

import static com.jparrack.catchat.ui.login.LoginFragment.EMAIL;

/**
 * Created by phanthuhao on 11/29/17.
 */

public class FirebaseSendUrlImage {

    public static void sendUrlImage(String url){
        ObjectImage objectImage = new ObjectImage(EMAIL, url);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("image").push().setValue(objectImage);
    }
}
