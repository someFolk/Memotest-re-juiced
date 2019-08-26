package com.thebreadiswhite.memotest.outsystems.notifier;

import java.util.ArrayList;

public class NotifierMultiBundle
{
    public enum MultiBundleType { STRING,INT }

    private String key;
    private Object object;
    private boolean hasNext = false;
    private NotifierMultiBundle next;
    private  MultiBundleType type;


    public NotifierMultiBundle(String key, int object)
    {
        this.key = key;
        this.object = object;
        type = MultiBundleType.INT;
    }

    public NotifierMultiBundle(String key, String object)
    {
        this.key = key;
        this.object = object;
        type = MultiBundleType.STRING;
    }

    public void addNext(NotifierMultiBundle next)
    {
        this.next = next;
        hasNext = true;
    }

    public MultiBundleType getType()
    {
        return type;
    }

    public NotifierMultiBundle getNext()
    {
        return next;
    }

    public boolean hasNext()
    {
        return hasNext;
    }

    public String getKey()
    {
        return key;
    }

    public Object getObject()
    {
        return object;
    }
}
