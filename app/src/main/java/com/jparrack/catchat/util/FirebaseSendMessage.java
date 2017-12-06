package com.jparrack.catchat.util;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.jparrack.catchat.ui.login.LoginFragment.EMAIL;
import static com.jparrack.catchat.ui.login.LoginFragment.URL_IMAGE;


public class FirebaseSendMessage {
    public static void sendMessage(String emailReceive, String message){
        ObjectMessage objectMessage = new ObjectMessage(EMAIL,emailReceive,message, URL_IMAGE);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("message").push().setValue(objectMessage);
    }
}
