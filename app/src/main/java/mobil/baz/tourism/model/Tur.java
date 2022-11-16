package mobil.baz.tourism.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Tur {
    public Tur(String name, String recept){
        this.name = name;
        this.recept = recept;

    }

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo
    public String name;

    @ColumnInfo
    public String recept;

    public String getName() {
        return name;
    }

    public String getRecept() {
        return recept;
    }

    public void getName(String name) {
        this.name = name;
    }

    public void setRecept(String recept) {
        this.recept = recept;
    }

}




