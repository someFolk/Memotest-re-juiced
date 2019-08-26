package com.thebreadiswhite.memotest.modules.course;

import androidx.room.*;
import com.thebreadiswhite.memotest.modules.memotest.Memotest;

import java.util.List;

@Dao
public interface MemotestCourseDAO {

    @Query("SELECT * FROM course")
    List<MemotestCourse> getAll();

    @Query("SELECT * FROM course WHERE client_key = :key")
    MemotestCourse getByClientId(int key);

    @Query("SELECT * FROM course WHERE server_key = :key")
    MemotestCourse getByServerKey(String key);

    @Query("SELECT * FROM course WHERE stackid = :stackid")
    List<MemotestCourse> getAllChilds(int stackid);

    @Query("SELECT COUNT(*) from course")
    int count();

    @Insert
    Long insert(MemotestCourse course);

    @Delete
    void delete(MemotestCourse course);

    @Update
    void update(MemotestCourse course);
}