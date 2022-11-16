package mobil.baz.tourism.ui.dashboard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import mobil.baz.tourism.ServiceLocator;
import mobil.baz.tourism.TurRepozitory;
import mobil.baz.tourism.model.Tur;

public class CityViewModel extends AndroidViewModel {

    private TurRepozitory mRepository;
    private LiveData<List<Tur>> mTur;

    public CityViewModel(@NonNull Application application) {
        super(application);

        mRepository = ServiceLocator.getInstance().getRepository();
        mTur = mRepository.getAllTur();
    }

    public LiveData<List<Tur>> getAllTurs(){
        return mTur;
    }
}