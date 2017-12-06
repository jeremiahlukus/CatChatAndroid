package com.jparrack.catchat.util;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.jparrack.catchat.ui.login.LoginFragment.EMAIL;
import static com.jparrack.catchat.ui.login.LoginFragment.URL_IMAGE;


public class FirebaseListenDownloadImage {
    private static final String TAG = FirebaseListenDownloadImage.class.getName();
    public static FirebaseListenDownloadImage firebaseListenDownloadImage;
    private static OnListenImage onListenImage;
    private static List<ObjectImage> listImage;
    public FirebaseListenDownloadImage(OnListenImage OnListenImage){
        if(firebaseListenDownloadImage == null){
            onListenImage = OnListenImage;
            listImage = new ArrayList<>();
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("image");

            mDatabase.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());
                    Log.d(TAG,"Another User upload a image: " + dataSnapshot.getValue());
                    ObjectImage objectImage = dataSnapshot.getValue(ObjectImage.class);
                    Log.d(TAG, "onChildAdded: url: " + objectImage.getUrl());
                    listImage.add(objectImage);

                    if(!objectImage.getEmail().equals(EMAIL)) {
                        onListenImage.listenImage(objectImage.getEmail(), objectImage.getUrl());
                    }
                    else{
                        URL_IMAGE = objectImage.getUrl();
                    }

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d(TAG, "onCancelled:" + databaseError.toException());
                }
            });

            firebaseListenDownloadImage = this;
        }
    }

    public static String getUrlImageFromEmail(String email){
        for(ObjectImage objectImage: listImage){
            if(objectImage.getEmail().equals(email)){
                return objectImage.getUrl();
            }
        }
        return null;
    }

    public interface OnListenImage{
        public void listenImage(String email, String url);
    }
}
