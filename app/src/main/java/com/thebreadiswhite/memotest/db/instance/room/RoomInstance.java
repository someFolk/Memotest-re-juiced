package com.thebreadiswhite.memotest.db.instance.room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.TypeConverters;
import com.thebreadiswhite.memotest.modules.course.MemotestCourse;
import com.thebreadiswhite.memotest.modules.course.MemotestCourseDAO;
import com.thebreadiswhite.memotest.modules.course.alert.MemotestCourseAlert;
import com.thebreadiswhite.memotest.modules.course.alert.MemotestCourseAlertDAO;
import com.thebreadiswhite.memotest.modules.memotest.Memotest;
import com.thebreadiswhite.memotest.modules.stack.MemotestStack;
import com.thebreadiswhite.memotest.modules.memotest.MemotestDao;
import com.thebreadiswhite.memotest.modules.stack.MemotestStackConverter;
import com.thebreadiswhite.memotest.modules.stack.MemotestStackDAO;
import com.thebreadiswhite.memotest.outsystems.positionable.db.PositionableDao;

// Database annotation
@Database(entities = {Memotest.class, MemotestStack.class, MemotestCourse.class, MemotestCourseAlert.class}, version = 1, exportSchema = false)

// Type Converters
@TypeConverters(MemotestStackConverter.class)

public abstract class RoomInstance extends androidx.room.RoomDatabase
{

    private static final String DATABASE_NAME = "progit";

    // Room Instance
    private static RoomInstance INSTANCE;

    public static RoomInstance getAppDatabase(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), RoomInstance.class, DATABASE_NAME)

                            // allow queries on the main thread.
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }

    // System Daos
    public abstract MemotestDao memotest();
    public abstract MemotestStackDAO memotestStack();
    public abstract MemotestCourseDAO memotestCourse();
    public abstract MemotestCourseAlertDAO memotestCourseAlert();

    //    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
    //        @Override
    //        public void migrate(SupportSQLiteDatabase database) {
    //            //database.execSQL("ALTER TABLE users "
    //            //        +"ADD COLUMN address TEXT");
    //
    //        }
    //    };

    public abstract PositionableDao positionable();
}