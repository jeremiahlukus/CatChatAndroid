package com.jparrack.catchat.models;

/**
 * Created by jparrack on 3/6/17
 */

public interface IStoryItem {

    public boolean isViewed();

    public void setViewed(boolean watched);

    public String getImageUrl();

    public String getVideoUrl();

    public long getDuration();

}
