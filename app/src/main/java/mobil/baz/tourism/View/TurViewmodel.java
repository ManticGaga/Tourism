package mobil.baz.tourism.View;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import mobil.baz.tourism.ServiceLocator;
import mobil.baz.tourism.TurRepozitory;
import mobil.baz.tourism.model.Tur;

public class TurViewmodel extends AndroidViewModel {

    private TurRepozitory mTur;
    private LiveData<List<Tur>> mTurs;

    public TurViewmodel(@NonNull Application application) {
        super(application);

        mTur = ServiceLocator.getInstance().getRepository();
        mTurs = mTur.getAllTur();
    }

    public LiveData<List<Tur>> getAllTurs() {
        return mTurs;
    }
}
