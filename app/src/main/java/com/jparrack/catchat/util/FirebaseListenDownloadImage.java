package com.jparrack.catchat.util;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import static com.jparrack.catchat.ui.login.LoginFragment.EMAIL;

/**
 * Created by phanthuhao on 11/29/17.
 */

public class FirebaseListenDownloadImage {
    private static final String TAG = FirebaseListenDownloadImage.class.getName();
    public static FirebaseListenDownloadImage firebaseListenDownloadImage;
    private static OnListenImage onListenImage;
    public FirebaseListenDownloadImage(OnListenImage OnListenImage){
        if(firebaseListenDownloadImage == null){
            onListenImage = OnListenImage;
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("image");

            mDatabase.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());
                    Log.d(TAG,"Another User upload a image: " + dataSnapshot.getValue());
                    ObjectImage objectImage = dataSnapshot.getValue(ObjectImage.class);
                    Log.d(TAG, "onChildAdded: url: " + objectImage.getUrl());
                    if(!objectImage.getEmail().equals(EMAIL)) {
                        onListenImage.listenImage(objectImage.getUrl());
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

    public interface OnListenImage{
        public void listenImage(String url);
    }
}
