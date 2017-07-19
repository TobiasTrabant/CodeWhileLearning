package com.company;

import java.util.List;

/**
 * Created by Tobias on 04.06.2017.
 */
public abstract class ListItem {

    protected ListItem previousItem;
    protected ListItem nextItem;
    protected Object value;

    public ListItem(Object value){
        this.value = value;
    }

    abstract ListItem setPreviousItem(ListItem previousItem);

    abstract ListItem setNextItem(ListItem nextItem);

    abstract ListItem moveNext();

    abstract ListItem movePrevious();

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
