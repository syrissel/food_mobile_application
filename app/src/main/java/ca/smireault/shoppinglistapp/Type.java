package ca.smireault.shoppinglistapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Type {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String name;
    private String description;

    public Type(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
}
