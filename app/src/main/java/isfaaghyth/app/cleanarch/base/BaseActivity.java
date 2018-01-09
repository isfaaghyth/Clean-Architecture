package isfaaghyth.app.cleanarch.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

abstract public class BaseActivity<T, P extends BasePresenter> extends AppCompatActivity {

    protected T view;
    protected P presenter;
    protected abstract T view();
    protected abstract int contentView();
    protected abstract P initPresenter();
    protected abstract void onActivityLoaded();

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = view();
        binding();
    }

    private void binding() {
        presenter = initPresenter();
        onActivityLoaded();
    }

    protected void Toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
