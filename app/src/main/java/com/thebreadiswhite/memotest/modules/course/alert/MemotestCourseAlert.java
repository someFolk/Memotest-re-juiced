package com.thebreadiswhite.memotest.modules.course.alert;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import com.thebreadiswhite.memotest.db.DatabaseAdapter;

@Entity(tableName = "course_alert")
public class MemotestCourseAlert extends DatabaseAdapter
{
    // The target time of the alert
    @ColumnInfo(name = "time")
    private long time;

    // The course ID this alert belongs to
    @ColumnInfo(name = "courseid")
    private int courseId;

    public MemotestCourseAlert(long time, int courseId)
    {
        this.courseId = courseId;
        this.time = time;
    }

    public long getTime()
    {
        return time;
    }

    public int getCourseId()
    {
        return courseId;
    }
}
