package ir.aghakhaniedu.samplemvplogin.model;

import android.util.Patterns;

public class User implements IUser {
    private String username, password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public int isValid(User user) {
        if (getUsername().isEmpty())
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getUsername()).matches())
            return 1;
        else if (getPassword().isEmpty())
            return 2;
        else if (getPassword().length() < 6)
            return 3;
        else if (!(getUsername().equals("ali@gmail.com")))
        { //Log.i("test",dataUsername);
            return 4;}
        else if (!(getPassword().equals("123456")))
            return 5;

        else return -1;
    }
}
