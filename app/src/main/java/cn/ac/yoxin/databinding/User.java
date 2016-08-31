package cn.ac.yoxin.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by zhengyoxin on 16-8-30.
 */
public class User extends BaseObservable {
    public static final int UN_CHECK = 0;
    public static final int CHECKING = 1;

    String email;
    String password;
    int checkState;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    @Bindable
    public int getCheckState() {
        return checkState;
    }

    public void setCheckState(int checkState) {
        this.checkState = checkState;
        notifyPropertyChanged(cn.ac.yoxin.databinding.BR.checkState);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(cn.ac.yoxin.databinding.BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(cn.ac.yoxin.databinding.BR.password);
    }


}
