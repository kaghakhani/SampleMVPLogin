package ir.aghakhaniedu.samplemvplogin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import ir.aghakhaniedu.samplemvplogin.R;
import ir.aghakhaniedu.samplemvplogin.presenter.BasePresenter;
import ir.aghakhaniedu.samplemvplogin.presenter.IBasePresenter;

public class MainActivity extends AppCompatActivity implements IViewBase, View.OnClickListener {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    IBasePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new BasePresenter(this);
      /*  initView();
        setupListener();*/
    }

    @Override
    public void initView() {
        edtUsername = findViewById(R.id.et_username);
        edtPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    @Override
    public void setupListener() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT, true).show();


    }

    @Override
    public void onLoginFailed(String message) {
       // Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Toasty.error(this,  message, Toast.LENGTH_SHORT, true).show();

    }

    @Override
    public void onClick(View view) {
        if (view == btnLogin) {
            presenter.onLogin(edtUsername.getText().toString().trim(),edtPassword.getText().toString());
        }
    }
}