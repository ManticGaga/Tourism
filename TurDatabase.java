package mobil.baz.tourism;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

import mobil.baz.tourism.TurDAO;


@Database(entities = { Tur.class},version = 1, exportSchema = false)
public abstract class TurDatabase extends RoomDatabase {
    public static SupportSQLiteStatement databaseWriteExecutor;
    ///12

    public abstract TurDAO turDAO();

    public  static  TurDatabase INSTANCE;

    public  static  TurDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (TurDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TurDatabase.class, "tur-database").fallbackToDestructiveMigration().build();

                }
            }
        }

        return INSTANCE;

    }


}


