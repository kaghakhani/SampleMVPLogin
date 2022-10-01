package ir.aghakhaniedu.samplemvplogin.presenter;

import ir.aghakhaniedu.samplemvplogin.model.User;
import ir.aghakhaniedu.samplemvplogin.view.IViewBase;

public class BasePresenter implements IBasePresenter {
    IViewBase view;

    public BasePresenter(IViewBase view) {
        this.view = view;
        start();
    }

    @Override
    public void onLogin(String username, String password) {
        User user = new User(username, password);

            int loginCode = user.isValid(user);
            // 0 username is empty
            // 1 check for email match pattern
            // 2 password is empty
            // 3 password under 6
            if (loginCode == 0) {
                view.onLoginFailed("Please enter Email!!");
            } else if (loginCode == 1) {
                view.onLoginFailed("Please enter Valid Email!!");
            } else if (loginCode == 2) {
                view.onLoginFailed("Please enter password!!");
            } else if (loginCode == 3) {
                view.onLoginFailed("Please enter password uper 6 character!!");
            } else if (loginCode == 4) {
                view.onLoginFailed("username incorrect");
            } else if (loginCode == 5) {
                view.onLoginFailed("password incorrect");
            } else {
                view.onLoginSuccess("Login is Success");

            }



    }

    @Override
    public void start() {
        view.initView();
        view.setupListener();
    }
}
