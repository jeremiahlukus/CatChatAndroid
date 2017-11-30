package com.jparrack.catchat.util;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.jparrack.catchat.ui.login.LoginFragment.EMAIL;

/**
 * Created by phanthuhao on 11/30/17.
 */

public class FirebaseListenMessage {
    private static String TAG = FirebaseListenMessage.class.getName();
    private static FirebaseListenMessage firebaseListenMessage;
    private static OnListenMessage onListenMessage;
    public FirebaseListenMessage(OnListenMessage OnListenMessage){
        if(firebaseListenMessage == null){
            onListenMessage = OnListenMessage;
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("message");

            mDatabase.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());
                    Log.d(TAG,"Send message: " + dataSnapshot.getValue());
                    ObjectMessage objectMessage = dataSnapshot.getValue(ObjectMessage.class);

                    //check email send message different email send
                    if(objectMessage.getEmailSend().equals(EMAIL)) {
                        return;
                    }

                    //check email receive

                    //display message
                    onListenMessage.listenMessage(objectMessage.getEmailSend(), objectMessage.getMessage());
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

            firebaseListenMessage = this;
        }
    }

    public interface OnListenMessage{
        public void listenMessage(String emailSend, String message);
    }
}
