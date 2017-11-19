package com.jparrack.catchat.data.network.auth;


import com.jparrack.catchat.models.LogOutResponse;
import com.jparrack.catchat.models.LoginResponse;
import com.jparrack.catchat.models.PasswordResetResponse;

import io.reactivex.Observable;

public interface AuthService {

    Observable<LoginResponse>login(String email, String password);

    Observable<LogOutResponse>logout();

    Observable<LoginResponse>register(String email, String password);

    Observable<PasswordResetResponse>resetPassword(String email);
}
