package com.thebreadiswhite.memotest.modules.course;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import com.thebreadiswhite.memotest.db.DatabaseAdapter;
import com.thebreadiswhite.memotest.util.GeneralConsts;

@Entity(tableName = "course")
public class MemotestCourse extends DatabaseAdapter
{

    // For the purpose of knowing which stack should be played
    @ColumnInfo(name = "stackid")
    private int stackid;

    // The number of days
    @ColumnInfo(name = "duration")
    private int numberOfDays;

    // Represent the last Alert of that course
    // which indicates if this course is active
    @ColumnInfo(name = "deadline")
    private long deadLine;

    public MemotestCourse(int clientKey, int stackid, int numberOfDays, long deadLine)
    {
        this.clientKey = clientKey;
        this.stackid = stackid;
        this.numberOfDays = numberOfDays;
        this.deadLine = deadLine;
    }

    public int getStackid()
    {
        return stackid;
    }

    public int getNumberOfDays()
    {
        return numberOfDays;
    }

    public long getDeadLine()
    {
        return deadLine;
    }
}
