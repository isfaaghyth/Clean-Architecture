package isfaaghyth.app.cleanarch.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

abstract public class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;
    protected ViewDataBinding view;
    protected abstract int contentView();
    protected abstract P initPresenter();
    protected abstract void onActivityLoaded();

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(contentView());
    }

    private void binding(int layout) {
        view = DataBindingUtil.setContentView(this, layout);
        presenter = initPresenter();
        onActivityLoaded();
    }

}
