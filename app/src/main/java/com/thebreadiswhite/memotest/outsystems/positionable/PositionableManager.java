package com.thebreadiswhite.memotest.outsystems.positionable;

import android.content.Context;
import com.thebreadiswhite.memotest.db.instance.multi.MultiDatabase;
import com.thebreadiswhite.memotest.db.instance.room.RoomInstance;

// This class is responsible of getting a positionable object
// and a position needy object and do some magic
public class PositionableManager
{
    private Positionable positionable;
    private PositionableAdapter needyOfPositionable;

    public PositionableManager(Context context, int positionableKey, PositionableAdapter needyOfPositionable)
    {
        this.needyOfPositionable = needyOfPositionable;
       RoomInstance db = MultiDatabase.getInstance(context).getRoomInstance();

    }
}
