package com.thebreadiswhite.memotest.modules.course.alert;

import android.content.Context;
import com.thebreadiswhite.memotest.db.DatabaseHolder;
import com.thebreadiswhite.memotest.modules.course.MemotestCourse;
import com.thebreadiswhite.memotest.modules.course.MemotestCourseDAO;

import java.util.List;

public class MemotestCourseAlertDBH extends DatabaseHolder<MemotestCourseAlert>
{
    public static final String TABLE_NAME = "course_alert";
    public static final String SERVER_APP_PREFIX = "memotest";
    public static final Class BASE_CLASS = MemotestCourseAlert.class;

    // The dao we use to
    MemotestCourseAlertDAO dao;

    @SuppressWarnings("unchecked")
    public MemotestCourseAlertDBH(Context context)
    {
        super(
                context,
                "MemotestCourseAlertDBH",
                TABLE_NAME,
                MemotestCourseAlert.class
        );

        // Call immediately
        super.init((DatabaseHolder)this,BASE_CLASS, SERVER_APP_PREFIX);
        dao = db.getRoomInstance().memotestCourseAlert();

    }

    public List<MemotestCourseAlert> selectAllChilds(int parentID)
    {
        return dao.getAllChilds(parentID);
    }

    @Override
    public MemotestCourseAlert selectById(int id)
    {
        return dao.getByClientId(id);
    }

    @Override
    public List<MemotestCourseAlert> selectAll()
    {
        return dao.getAll();
    }

    @Override
    public void update(MemotestCourseAlert alert)
    {
        dao.update(alert);
    }

    @Override
    public int insert(MemotestCourseAlert alert)
    {
        String key = firestoreInsert(alert);
        alert.setServerKey(key);
        long id = dao.insert(alert);
        return (int) id;
    }

    @Override
    public void delete(MemotestCourseAlert alert)
    {
        dao.delete(alert);
    }

    public int count()
    {
        return dao.count();
    }
}