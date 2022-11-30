package mobil.baz.tourism;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import androidx.lifecycle.LiveData;


import java.util.List;

@Dao
public interface TurDAO {
    ///12
    @Insert
    void AddTur(Tur tur);

    @Delete
    void DeleteTur(Tur tur);
    @Query("DELETE FROM Tur")
    void deleteAll();

    @Update
    void UpdateTur(Tur tur);

    @Query("SELECT * FROM tur")
    LiveData<List<Tur>> getAllTurs();

    @Query("select * from tur where name ==:name ")
    public Tur  getTur(String name);

    @Query("select * from tur")
    public LiveData<List<Tur>> getAllTursLive();


}
