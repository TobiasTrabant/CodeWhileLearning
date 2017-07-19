package com.company;

import java.util.List;

/**
 * Created by Tobias on 04.06.2017.
 */
public class NodeList {

    private ListItem rootItem = null;

    public boolean addItem(ListItem item) {
        if (rootItem == null) {
            rootItem = item;
            return true;
        }
        ListItem currentItem = rootItem;
        boolean finished = false;
        while (!finished) {
            if (item.compareTo(currentItem) > 0 && currentItem.moveNext() != null) {
                if (item.compareTo(currentItem.moveNext()) < 0) {
                    item.setPreviousItem(currentItem);
                    item.setNextItem(currentItem.moveNext());
                    currentItem.moveNext().setPreviousItem(item);
                    currentItem.setNextItem(item);
                    finished = true;
                } else {
                    currentItem = currentItem.moveNext();
                }
            }
            if (item.compareTo(currentItem) > 0 && currentItem.moveNext() == null) {
                item.setPreviousItem(currentItem);
                currentItem.setNextItem(item);
                finished = true;
            }
            if (item.compareTo(currentItem) < 0) {
                if (currentItem.movePrevious() == null) {
                    currentItem.setPreviousItem(item);
                    item.setNextItem(currentItem);
                    rootItem = item;
                    finished = true;
                } else {
                    item.setNextItem(currentItem);
                    item.setPreviousItem(currentItem.movePrevious());
                    currentItem.movePrevious().setNextItem(item);
                    currentItem.setPreviousItem(item);
                    finished = true;
                }
            }

        }
        return true;
    }

    public void traverse(){
        ListItem currentItem = rootItem;
        while(currentItem.moveNext() != null){
            System.out.println(currentItem.getValue());
            currentItem = currentItem.moveNext();
        }
        System.out.println(currentItem.getValue());
    }

    public ListItem getRoot(){
        System.out.println(rootItem.getValue());
        return rootItem;
    }

    public void removeItem(String item){
        ListItem currentItem = rootItem;
        boolean finished = false;
        while(currentItem.moveNext() != null && !finished){
            if(currentItem.getValue().equals(item)){
                ListItem item1 = currentItem.movePrevious();
                ListItem item2 = currentItem.moveNext();
                item1.setNextItem(item2);
                item2.setPreviousItem(item1);
                System.out.println("removed " + currentItem.getValue());
                finished = true;
            }else {
                currentItem = currentItem.moveNext();
            }
        }
    }
}
