package mobil.baz.tourism;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TurRepozitory  {
    private TurDAO turDAO;
    private LiveData<List<Tur>> allTur;
    private Context context;


    public TurRepozitory(Context context){
        this.context = context;
        TurDatabase appDatabase = TurDatabase.getInstance(context);
        turDAO = appDatabase.turDAO();
        allTur = TurDAO.getAll();
    }

    public LiveData<List<Tur>> getAllEmployee(){return allTur;}

}