package isfaaghyth.app.cleanarch.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import isfaaghyth.app.cleanarch.util.KeyboardUtils;
import isfaaghyth.app.cleanarch.util.NetworkUtils;
import isfaaghyth.app.cleanarch.util.ProgressLoader;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

abstract public class BaseActivity<T, P extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected T view;
    protected P presenter;
    protected abstract T contentView();
    protected abstract P initPresenter();
    protected abstract void onCreated();

    private ProgressLoader loader;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = contentView();
        loader = new ProgressLoader(this);
        presenter = initPresenter();
    }

    @Override protected void onStart() {
        super.onStart();
        onCreated();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }

    @Override public void showLoading() {
        loader.show();
    }

    @Override public void hideLoading() {
        loader.hide();
    }

    @Override public void onError(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        android.view.View sbView = snackbar.getView();
        TextView textView = sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        snackbar.show();
    }

    @Override public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(this);
    }

    @Override public void hideKeyboard() {
        KeyboardUtils.hideSoftInput(this);
    }

    @Override public void logOut() {
        //ActivityUtils.start(this, LoginActivity.class);
    }

}
