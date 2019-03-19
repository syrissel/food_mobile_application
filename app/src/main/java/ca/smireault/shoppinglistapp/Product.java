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

    public Product(String name, int type_id) {
        this.name = name;
        this.type_id = type_id;
    }

    public void setId(int id) { this.id = id; }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getType_id() {
        return this.type_id;
    }
}
