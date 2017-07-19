package com.company;

/**
 * Created by Tobias on 04.06.2017.
 */
public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem setPreviousItem(ListItem previousItem) {
        this.previousItem = previousItem;
        return previousItem;
    }

    @Override
    ListItem setNextItem(ListItem nextItem) {
        this.nextItem = nextItem;
        return nextItem;
    }

    @Override
    ListItem moveNext() {
        return nextItem;
    }

    @Override
    ListItem movePrevious() {
        return previousItem;
    }

    @Override
    int compareTo(ListItem item) {
        if(item != null){
            return ((String) this.getValue()).compareTo((String) item.getValue());
        }
        return -1;
    }
}
