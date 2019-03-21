package ca.smireault.shoppinglistapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insert(Product product);

    @Query("DELETE FROM product")
    void deleteAll();

    @Query("SELECT * FROM product WHERE type_id = :type_id")
    LiveData<List<Product>> getProductByType(int type_id);

    @Query("SELECT * FROM product ORDER BY name ASC")
    LiveData<List<Product>> getAllProducts();
}
