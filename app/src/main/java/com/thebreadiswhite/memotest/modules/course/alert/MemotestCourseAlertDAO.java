package com.thebreadiswhite.memotest.modules.course.alert;

import androidx.room.*;

import java.util.List;

@Dao
public interface MemotestCourseAlertDAO {

    @Query("SELECT * FROM course_alert")
    List<MemotestCourseAlert> getAll();

    @Query("SELECT * FROM course_alert WHERE client_key = :id")
    MemotestCourseAlert getByClientId(int id);

    @Query("SELECT * FROM course_alert WHERE server_key = :key")
    MemotestCourseAlert getByServerKey(String key);

    @Query("SELECT * FROM course_alert WHERE courseid = :courseid")
    List<MemotestCourseAlert> getAllChilds(int courseid);

    @Query("SELECT COUNT(*) from course_alert")
    int count();

    @Insert
    Long insert(MemotestCourseAlert alert);

    @Delete
    void delete(MemotestCourseAlert alert);

    @Update
    void update(MemotestCourseAlert alert);
}