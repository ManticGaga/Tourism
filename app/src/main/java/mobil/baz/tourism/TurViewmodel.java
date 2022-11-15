package mobil.baz.tourism;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

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
