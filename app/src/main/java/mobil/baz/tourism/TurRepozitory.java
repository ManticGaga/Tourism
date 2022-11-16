package mobil.baz.tourism;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import mobil.baz.tourism.database.TurDAO;
import mobil.baz.tourism.database.TurDatabase;
import mobil.baz.tourism.model.Tur;

public class TurRepozitory  {
    private TurDAO turDAO;
    private LiveData<List<Tur>> allTur;
    private Context context;


    public TurRepozitory(Context context){
        this.context = context;
        TurDatabase appDatabase = TurDatabase.getInstance(context);
        turDAO = appDatabase.turDAO();
        allTur = turDAO.getAll();
    }

    public LiveData<List<Tur>> getAllTur(){return allTur;}

}