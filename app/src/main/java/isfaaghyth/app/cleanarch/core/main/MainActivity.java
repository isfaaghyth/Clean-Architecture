package isfaaghyth.app.cleanarch.core.main;

import android.databinding.DataBindingUtil;

import isfaaghyth.app.cleanarch.R;
import isfaaghyth.app.cleanarch.base.BaseActivity;
import isfaaghyth.app.cleanarch.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainPresenter> implements MainView {

    @Override protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override protected ActivityMainBinding dataBinding() {
        return DataBindingUtil.setContentView(this, contentView());
    }

    @Override protected int contentView() {
        return R.layout.activity_main;
    }

    @Override protected void onActivityLoaded() {

    }

}
