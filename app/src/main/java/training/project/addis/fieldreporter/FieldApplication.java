package training.project.addis.fieldreporter;

import android.app.Application;

import training.project.addis.fieldreporter.repos.helper.ApplicationHelper;

/**
 * Created by addis on 12/29/17.
 */

public class FieldApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationHelper.getInstance().init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ApplicationHelper.getInstance().destroy();
    }
}
