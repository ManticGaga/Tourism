package mobil.baz.tourism;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TurRepozitory  {

    private TurDAO mTurDao;
    private LiveData<List<Tur>> mAllTurs ;

    public TurRepozitory (Application application){
         TurDatabase db =  TurDatabase.getDatabase(application);
        mTurDao = db.turDAO();
        mAllTurs = mTurDao.getAllTursLive();
    }

    public void insert(Tur tur){
        new InsertTursAsyncTask(mTurDao).execute(tur);
    }

    public void update(Tur tur){
        new UpdateTursAsyncTask(mTurDao).execute(tur);
    }

    public void delete(Tur tur){
        new DeleteTursAsyncTask(mTurDao).execute(tur);
    }

    public void deleteAll()  {  new deleteAllWordsAsyncTask(mTurDao).execute();}

    public LiveData<List<Tur>> getAllTurs(){
        return mAllTurs;
    }

    private static class InsertTursAsyncTask extends AsyncTask< Tur, Void, Void>{
        private TurDAO turDAO;
        private InsertTursAsyncTask(TurDAO turDAO){
            this.turDAO = turDAO;
        }

        @Override
        protected Void doInBackground( Tur... turs) {
            turDAO.AddTur(turs[0]);
            return null;
        }
    }

    private static class UpdateTursAsyncTask extends AsyncTask< Tur, Void, Void>{
        private TurDAO turDAO;
        private UpdateTursAsyncTask(TurDAO turDAO){
            this.turDAO = turDAO;
        }

        @Override
        protected Void doInBackground( Tur... turs) {
            turDAO.UpdateTur(turs[0]);
            return null;
        }
    }

    private static class DeleteTursAsyncTask extends AsyncTask<Tur, Void, Void>{
        private TurDAO turDAO;
        private DeleteTursAsyncTask(TurDAO turDAO){
            this.turDAO = turDAO;
        }

        @Override
        protected Void doInBackground(Tur... turs) {
            turDAO.DeleteTur(turs[0]);
            return null;
        }
    }

    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private TurDAO mAsyncTaskDao;

        deleteAllWordsAsyncTask(TurDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }

    }
}