package k.benasfirst;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by moksleivis on 2018-01-31.
 */

public class User {
    private String username;
    private String password;
    private String email;

    private static final String PREFERENCES_FILE_NAME = "k.benasfirst";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String REMEMBER_ME_KEY = "rememberMe";

    private SharedPreferences sharedPreferences;

//Skirtas register activity naujam vartotojui registruoti
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    //konstruktorius login langui
    public User(Context context){
      this.sharedPreferences = context.getSharedPreferences
              (User.PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
    }
    //GETERIAI SETERIAI SKIRTI LOGINUI ;)
    public String getUsernameForLogin() {
        return this.sharedPreferences.getString(USERNAME_KEY,"");
    }
    public boolean isRemembered(){
        return this.sharedPreferences.getBoolean(REMEMBER_ME_KEY,false);
    }
    public void setRemeberMeKeyForLogin(boolean remeberMe) {
        this.sharedPreferences.edit().putBoolean(REMEMBER_ME_KEY, remeberMe).commit();
    }

    public void setUsernameForLogin(String username) {
        this.sharedPreferences.edit().putString(USERNAME_KEY,username).commit();
    }

    public String getPasswordForLogin() {
        return this.sharedPreferences.getString(PASSWORD_KEY,"");
    }

    public void setPasswordForLogin(String password) {
        this.sharedPreferences.edit().putString(PASSWORD_KEY,password).commit();
    }



    // Registracijos seteriai geteriai
    public String getUsernameForRegister() {
        return username;
    }

    public void setUsernameForRegister(String username) {
        this.username = username;
    }

    public String getPasswordForRegister() {
        return password;
    }

    public void setPasswordForRegister(String password) {
        this.password = password;
    }

    public String getEmailForRegister() {
        return email;
    }

    public void setEmailForRegister(String email) {
        this.email = email;
    }
}