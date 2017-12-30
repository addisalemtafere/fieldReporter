package training.project.addis.fieldreporter.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import training.project.addis.fieldreporter.R;
import training.project.addis.fieldreporter.presenter.SignInImpl;
import training.project.addis.fieldreporter.presenter.SignInPresenter;
import training.project.addis.fieldreporter.view.SignView;


/**
 * Created by addis on 12/23/17.
 */

public class LoginActivity extends AppCompatActivity implements SignView {
    public static final String TAG = "LoginActivity";
    public static final int REQUEST_SIGNUP = 0;

    private SignInPresenter signInPresenter;

    //    @Bind(R.id.email)
    EditText textEmail;

    //    @Bind(R.id.password)
    EditText textPassword;

    //    @Bind(R.id.btn_login)
    Button btnLogin;

    //    @Bind(R.id.link_SignUp)
    TextView linkSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
//        ButterKnife.bind(this);

        btnLogin = (Button) findViewById(R.id.btn_login);
        textEmail = (EditText) findViewById(R.id.email);
        textPassword = (EditText) findViewById(R.id.password);
        linkSignup = (TextView) findViewById(R.id.link_SignUp);



        signInPresenter = new SignInImpl(LoginActivity.this);


        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = textEmail.getText().toString();
                String password = textPassword.getText().toString();
                signInPresenter.signIn(email,password);
            }
        });

        linkSignup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

    }


    public void login() {
        Log.d(TAG, "Login");

//        if (!validate()) {
//            showValidationError();
//            return;
//        }

        btnLogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = textEmail.getText().toString();
        String password = textPassword.getText().toString();

        // TODO: Implement your own authentication logic here.

        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        signInSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }



    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }






    @Override
    public void showValidationError(String message) {

        String email = textEmail.getText().toString();
        String password = textPassword.getText().toString();
        textEmail.setError(message);
//        textPassword.setError();

        Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_LONG).show();
        btnLogin.setEnabled(true);

    }

    @Override
    public void signInSuccess() {
        Toast.makeText(LoginActivity.this, "signSuccess", Toast.LENGTH_LONG).show();
        btnLogin.setEnabled(true);
        finish();

    }

    @Override
    public void sigInError() {
        String email = textEmail.getText().toString();
        String password = textPassword.getText().toString();

        Toast.makeText(LoginActivity.this, "sign in failed due to wrong credential", Toast.LENGTH_LONG).show();

    }
}