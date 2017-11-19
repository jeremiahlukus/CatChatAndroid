package com.jparrack.catchat.data.network.auth;


import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jparrack.catchat.models.LogOutResponse;
import com.jparrack.catchat.models.LoginResponse;
import com.jparrack.catchat.models.PasswordResetResponse;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class FireBaseAuthService implements AuthService{

    private FirebaseAuth firebaseAuth;

    public FireBaseAuthService(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public Observable<LoginResponse> login(final String email, final String password) {
        return Observable.create(new ObservableOnSubscribe<LoginResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<LoginResponse> e) throws Exception {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                FirebaseUser user = authResult.getUser();
                                LoginResponse loginResponse =
                                        new LoginResponse(user.getUid(),
                                                "Signed in Successfullty" );
                                e.onNext(loginResponse);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception ex) {

                        e.onError(ex);
                    }
                });
            }
        });

    }

    @Override
    public Observable<LogOutResponse> logout() {
        return Observable.create(new ObservableOnSubscribe<LogOutResponse>() {
            @Override
            public void subscribe(ObservableEmitter<LogOutResponse> e) throws Exception {
                firebaseAuth.signOut();
                e.onNext(new LogOutResponse("Logged out successfully"));
            }
        });
    }

    @Override
    public Observable<LoginResponse> register(final String email, final String password) {
        return Observable.create(new ObservableOnSubscribe<LoginResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<LoginResponse> e) throws Exception {
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                FirebaseUser user = authResult.getUser();
                                LoginResponse loginResponse =
                                        new LoginResponse(user.getUid(),
                                                "Signed in Successfullty" );
                                e.onNext(loginResponse);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception ex) {

                        e.onError(ex);
                    }
                });
            }
        });
    }

    @Override
    public Observable<PasswordResetResponse> resetPassword(String email) {
        return null;
    }
}
