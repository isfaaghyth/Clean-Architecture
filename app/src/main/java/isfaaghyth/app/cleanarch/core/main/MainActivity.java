package isfaaghyth.app.cleanarch.core.main;

import android.databinding.DataBindingUtil;
import android.util.Log;

import isfaaghyth.app.cleanarch.R;
import isfaaghyth.app.cleanarch.base.BaseActivity;
import isfaaghyth.app.cleanarch.databinding.ActivityMainBinding;
import isfaaghyth.app.cleanarch.model.Home;

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
        presenter.getHome();
    }

    @Override public void onSuccess(Home res) {
        Log.d("TAG", res.getMessage());
    }

    @Override public void onError(String msg) {
        Log.e("TAG", msg);
    }
}
