package ca.smireault.shoppinglistapp;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {Product.class, Type.class}, version = 1, exportSchema = false)
public abstract class AppRoomDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
    public abstract TypeDao typeDao();

    private static volatile AppRoomDatabase INSTANCE;

    static AppRoomDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppRoomDatabase.class, "app_database").build();
                }
            }
        }
        return INSTANCE;
    }



}
