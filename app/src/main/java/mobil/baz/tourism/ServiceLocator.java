package mobil.baz.tourism;

import android.content.Context;

public class ServiceLocator {
    private static ServiceLocator serviceLocator;

    private TurRepozitory mRepository;

    private Context context;

    private ServiceLocator(Context context){
        serviceLocator = this;

        mRepository = new TurRepozitory(context);
    }

    public static ServiceLocator getInstance(){
        return serviceLocator;
    }

    public static void init (Context context){
        serviceLocator = new ServiceLocator(context);
    }

    public TurRepozitory getRepository(){
        return mRepository;
    }
}
