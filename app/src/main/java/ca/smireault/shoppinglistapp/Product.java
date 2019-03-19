package ca.smireault.shoppinglistapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Type.class, parentColumns = "id", childColumns = "type_id"))
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int type_id;
}
