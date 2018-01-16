package isfaaghyth.app.cleanarch.base;

import android.support.annotation.StringRes;

/**
 * Created by isfaaghyth on 1/17/18.
 * github: @isfaaghyth
 */

public interface BaseView {
    void showLoading();
    void hideLoading();
    void onError(String message);
    void onError(@StringRes int resId);
    boolean isNetworkConnected();
    void hideKeyboard();
    void logOut();
}
