package ir.aghakhaniedu.samplemvplogin.view;

public interface IViewBase {
    void initView();
    void setupListener();
    void onLoginSuccess(String message);
    void onLoginFailed(String message);
}
