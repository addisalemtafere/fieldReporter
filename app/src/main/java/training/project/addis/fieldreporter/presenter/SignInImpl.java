package training.project.addis.fieldreporter.presenter;

import android.text.TextUtils;

import training.project.addis.fieldreporter.presenter.SignInPresenter;
import training.project.addis.fieldreporter.view.SignView;

/**
 * Created by addis on 12/28/17.
 */

public class SignInImpl implements SignInPresenter {

    private SignView signView;

    public SignInImpl(SignView signView) {
        this.signView = signView;
    }

    @Override
    public void signIn(String userName, String password) {

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || !android.util.Patterns.EMAIL_ADDRESS.matcher(userName).matches()){
            signView.showValidationError("Enter valid email address");
        }
        else {
            if ( password.length() < 4 || password.length() > 10) {
                signView.showValidationError("between 4 and 10 alphanumeric characters");


            }
            else{
                if (userName.equalsIgnoreCase("addisalem12@gmail.com") && password.equalsIgnoreCase("addis")){
                    signView.signInSuccess();

                }
                else {
                    signView.sigInError();
                }
            }
        }


    }
}
