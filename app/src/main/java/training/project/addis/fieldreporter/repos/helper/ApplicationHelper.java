package training.project.addis.fieldreporter.repos.helper;

import android.arch.persistence.room.Room;
import android.content.Context;

import training.project.addis.fieldreporter.repos.database.FieldReporter;

/**
 * Created by addis on 12/29/17.
 */

public class ApplicationHelper {

    private FieldReporter database;

    private final static class InstanceHolder {
        private final static ApplicationHelper INSTANCE = new ApplicationHelper();
    }

    public static ApplicationHelper getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void init(Context context) {
        this.database = Room.databaseBuilder(context.getApplicationContext(), FieldReporter.class, "field-database")
                // allow queries on the main thread.
                // Don't do this on a real app! See PersistenceBasicSample for an example.
                .allowMainThreadQueries()
                .build();
    }

    public FieldReporter getDatabase() {
        return database;
    }

    public void destroy() {
        this.database = null;
    }
}
