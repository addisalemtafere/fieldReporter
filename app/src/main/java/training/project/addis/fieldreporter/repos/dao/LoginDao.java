package training.project.addis.fieldreporter.repos.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import training.project.addis.fieldreporter.repos.entitiy.Login;

/**
 * Created by addis on 12/29/17.
 */

@Dao
public interface LoginDao {

    @Query("select * from Login")
    List<Login> getAll();
}
