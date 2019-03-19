package ca.smireault.shoppinglistapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface TypeDao {

    @Insert
    void insert(Type type);

    @Query("DELETE FROM type")
    void deleteAll();
}
