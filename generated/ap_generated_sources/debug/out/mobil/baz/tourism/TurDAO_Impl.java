package mobil.baz.tourism;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker.Observer;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class TurDAO_Impl implements TurDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTur;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTur;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTur;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public TurDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTur = new EntityInsertionAdapter<Tur>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Tur`(`uid`,`name`,`tur_name`,`recept`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tur value) {
        stmt.bindLong(1, value.uid);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        if (value.tur_name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.tur_name);
        }
        if (value.recept == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.recept);
        }
      }
    };
    this.__deletionAdapterOfTur = new EntityDeletionOrUpdateAdapter<Tur>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Tur` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tur value) {
        stmt.bindLong(1, value.uid);
      }
    };
    this.__updateAdapterOfTur = new EntityDeletionOrUpdateAdapter<Tur>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Tur` SET `uid` = ?,`name` = ?,`tur_name` = ?,`recept` = ? WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tur value) {
        stmt.bindLong(1, value.uid);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        if (value.tur_name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.tur_name);
        }
        if (value.recept == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.recept);
        }
        stmt.bindLong(5, value.uid);
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Tur";
        return _query;
      }
    };
  }

  @Override
  public void AddTur(Tur tur) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTur.insert(tur);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteTur(Tur tur) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfTur.handle(tur);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateTur(Tur tur) {
    __db.beginTransaction();
    try {
      __updateAdapterOfTur.handle(tur);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Tur>> getAllTurs() {
    final String _sql = "SELECT * FROM tur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Tur>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<Tur> compute() {
        if (_observer == null) {
          _observer = new Observer("tur") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfTurName = _cursor.getColumnIndexOrThrow("tur_name");
          final int _cursorIndexOfRecept = _cursor.getColumnIndexOrThrow("recept");
          final List<Tur> _result = new ArrayList<Tur>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Tur _item;
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpTur_name;
            _tmpTur_name = _cursor.getString(_cursorIndexOfTurName);
            final String _tmpRecept;
            _tmpRecept = _cursor.getString(_cursorIndexOfRecept);
            _item = new Tur(_tmpName,_tmpTur_name,_tmpRecept);
            _item.uid = _cursor.getInt(_cursorIndexOfUid);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public Tur getTur(String name) {
    final String _sql = "select * from tur where name ==? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfTurName = _cursor.getColumnIndexOrThrow("tur_name");
      final int _cursorIndexOfRecept = _cursor.getColumnIndexOrThrow("recept");
      final Tur _result;
      if(_cursor.moveToFirst()) {
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpTur_name;
        _tmpTur_name = _cursor.getString(_cursorIndexOfTurName);
        final String _tmpRecept;
        _tmpRecept = _cursor.getString(_cursorIndexOfRecept);
        _result = new Tur(_tmpName,_tmpTur_name,_tmpRecept);
        _result.uid = _cursor.getInt(_cursorIndexOfUid);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Tur>> getAllTursLive() {
    final String _sql = "select * from tur";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Tur>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<Tur> compute() {
        if (_observer == null) {
          _observer = new Observer("tur") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfTurName = _cursor.getColumnIndexOrThrow("tur_name");
          final int _cursorIndexOfRecept = _cursor.getColumnIndexOrThrow("recept");
          final List<Tur> _result = new ArrayList<Tur>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Tur _item;
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpTur_name;
            _tmpTur_name = _cursor.getString(_cursorIndexOfTurName);
            final String _tmpRecept;
            _tmpRecept = _cursor.getString(_cursorIndexOfRecept);
            _item = new Tur(_tmpName,_tmpTur_name,_tmpRecept);
            _item.uid = _cursor.getInt(_cursorIndexOfUid);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
