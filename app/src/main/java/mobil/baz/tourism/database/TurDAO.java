package mobil.baz.tourism.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import mobil.baz.tourism.model.Tur;

@Dao
public interface TurDAO {

    @Query("SELECT * FROM tur")
    LiveData<List<Tur>> getAll();

    @Query("SELECT * FROM tur WHERE uid = :id")
    Tur getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Tur tur);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Tur[] turs);

    @Update
    void update(Tur tur);

    @Delete
    void delete(Tur tur);



}
