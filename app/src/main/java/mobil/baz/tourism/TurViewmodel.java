package mobil.baz.tourism;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TurViewmodel extends AndroidViewModel {

    private TurRepozitory repozitory;
    private LiveData<List<Tur>> turList;

    public TurViewmodel(@NonNull Application application) {
        super(application);
        repozitory = new TurRepozitory(application);
        turList = repozitory.getAllTurs();
    }


    public void insert(Tur tur){ repozitory.insert(tur); }

    public void deleteAll() {repozitory.deleteAll();}

    public LiveData<List<Tur>> getAllTurs(){
        return turList;
    }

    public void update(Tur tur) {
        repozitory.update(tur);
    }

    public void delete(Tur tur){
        repozitory.delete(tur);
    }


}
