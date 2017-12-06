package com.jparrack.catchat.util;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONObject;

import static com.jparrack.catchat.ui.login.LoginFragment.EMAIL;
import static com.jparrack.catchat.ui.login.LoginFragment.URL_IMAGE;


public class FirebaseSendUrlImage {

    public static void sendUrlImage(String url){
        URL_IMAGE = url;
        ObjectImage objectImage = new ObjectImage(EMAIL, url);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("image").push().setValue(objectImage);
    }
}
