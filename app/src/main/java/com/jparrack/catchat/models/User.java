package com.jparrack.catchat.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jparrack on 10/3/17
 */

public class User {

    @SerializedName("chat_ids")
    private List<Integer> mChatIds;
    private Story mStory;

    private String mName;
    private int mId;
    private String mImageUrl;
    private String mEmail;

}
