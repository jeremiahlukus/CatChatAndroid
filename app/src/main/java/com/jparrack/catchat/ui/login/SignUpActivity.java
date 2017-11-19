package com.jparrack.catchat.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jparrack.catchat.Application;
import com.jparrack.catchat.MainActivity;
import com.jparrack.catchat.R;
import com.jparrack.catchat.data.network.auth.FireBaseAuthService;
import com.jparrack.catchat.models.LoginResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "SignupActivity";

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseAuth = ((Application) getApplication()).getFirebaseAuth();
        addFragment(SignUpFragment.newInstance());

    }

    @Override
    protected void onResume() {
        super.onResume();
//        FirebaseUser user = firebaseAuth.getCurrentUser();
//        if (user != null) {
//            String id = user.getUid();
//            if (id != null) {
//                startActivity(new Intent(this, MainActivity.class));
//            }
//        }
//
//        else addFragment(SignUpFragment.newInstance());
    }

    private void addFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment)
                .addToBackStack(SignUpActivity.class.getName())
                .commit();
    }
}
