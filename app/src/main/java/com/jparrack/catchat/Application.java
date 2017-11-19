package com.jparrack.catchat;

import com.google.firebase.auth.FirebaseAuth;
import com.jparrack.catchat.util.Print;

/**
 * Created by jparrack on 11/15/17
 */

public class Application extends android.app.Application {

    private FirebaseAuth firebaseAuth;

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Print.init("CatChat", true, null);
        VideoCache.init(getApplicationContext(), null);
        firebaseAuth = FirebaseAuth.getInstance();
    }
}
