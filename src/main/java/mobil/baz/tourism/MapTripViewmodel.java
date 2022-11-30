package mobil.baz.tourism;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MapTripViewmodel  extends AndroidViewModel {
    private LiveData<List<responsess>> OpenTripMapApiLiveData;
    private MapTripRepository countriesRepository;
    // No argument constructor
    public MapTripViewmodel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        countriesRepository = new MapTripRepository();
        OpenTripMapApiLiveData = countriesRepository.OpenTripMapApiData();
    }

    public LiveData<List<responsess>> getMapTripResponseApiData() {
        return OpenTripMapApiLiveData;
    }
}

