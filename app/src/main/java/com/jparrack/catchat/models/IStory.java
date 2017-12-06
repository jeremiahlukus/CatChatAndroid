package com.jparrack.catchat.models;

import java.util.List;

/**
 * Created by jparrack on 9/6/17
 */

public interface IStory {
    public boolean hasUnwatchedItems();

    public User getSource();

    public List<? extends IStoryItem> getStoryItems();

    public IStoryItem getCurrentStoryItem();
}
