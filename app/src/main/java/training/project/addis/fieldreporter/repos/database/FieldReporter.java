package training.project.addis.fieldreporter.repos.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.RoomDatabase;

import training.project.addis.fieldreporter.repos.dao.LoginDao;
import training.project.addis.fieldreporter.repos.entitiy.Login;

/**
 * Created by addis on 12/29/17.
 */

@Database(entities= Login.class,version = 1)
public abstract class FieldReporter extends RoomDatabase {

    public abstract LoginDao loginDao();
}
