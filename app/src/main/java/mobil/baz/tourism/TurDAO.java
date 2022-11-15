package mobil.baz.tourism;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import androidx.lifecycle.LiveData;


import java.util.List;

@Dao
public interface TurDAO {

    @Query("SELECT * FROM tur")
    LiveData<List<Tur>> getAll();

    @Query("SELECT * FROM tur WHERE id = :id")
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
