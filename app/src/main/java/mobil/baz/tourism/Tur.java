package mobil.baz.tourism;
import android.widget.EditText;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Tur {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name" )
    public String name;

    @ColumnInfo(name = "recept")
    public String recept;

    public Tur(String name, String recept){
        this.name = name;
        this.recept = recept;

    }
    public String getName() {
        return name;
    }

    public void getName(String name) {
        this.name = name;
    }

    public String getRecept() {
        return recept;
    }

    public void setRecept(String recept) {
        this.recept = recept;
    }



}




