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

    @ColumnInfo(name = "tur_name" )
    public String tur_name;

    @ColumnInfo(name = "recept")
    public String recept;



    public Tur(String name, String tur_name, String recept){
        this.tur_name = tur_name;
        this.name = name;
        this.recept = recept;

    }
    public String getTur_name() {
        return tur_name;
    }

    public void setTur_name(String tur_name) {
        this.tur_name = tur_name;
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




