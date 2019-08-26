package com.thebreadiswhite.memotest.modules.course;

import android.content.Context;
import com.thebreadiswhite.memotest.db.DatabaseHolder;

import java.util.List;

public class MemotestCourseDBH extends DatabaseHolder<MemotestCourse>
{
    public static final String TABLE_NAME = "course";
    public static final String SERVER_APP_PREFIX = "memotest";
    public static final Class BASE_CLASS = MemotestCourse.class;

    // The dao we use to
    MemotestCourseDAO dao;

    @SuppressWarnings("unchecked")
    public MemotestCourseDBH(Context context)
    {
        super(
                context,
                "MemotestCourseDBH",
                TABLE_NAME,
                MemotestCourse.class
        );

        // Call immediately
        super.init((DatabaseHolder)this,BASE_CLASS, SERVER_APP_PREFIX);
        dao = db.getRoomInstance().memotestCourse();

    }

    public List<MemotestCourse> selectAllChilds(int parentID)
    {
        return dao.getAllChilds(parentID);
    }

    @Override
    public MemotestCourse selectById(int id)
    {
        return dao.getByClientId(id);
    }

    @Override
    public List<MemotestCourse> selectAll()
    {
        return dao.getAll();
    }

    @Override
    public void update(MemotestCourse course)
    {
        dao.update(course);
    }

    @Override
    public int insert(MemotestCourse course)
    {
        String key = firestoreInsert(course);
        course.setServerKey(key);
        long id = dao.insert(course);
        return (int) id;
    }

    @Override
    public void delete(MemotestCourse course)
    {
        dao.delete(course);
    }

    public int count()
    {
        return dao.count();
    }
}