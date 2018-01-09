package isfaaghyth.app.cleanarch.core.main;

import android.databinding.DataBindingUtil;
import android.util.Log;

import java.util.ArrayList;

import isfaaghyth.app.cleanarch.R;
import isfaaghyth.app.cleanarch.base.BaseActivity;
import isfaaghyth.app.cleanarch.databinding.ActivityMainBinding;
import isfaaghyth.app.cleanarch.model.Portfolio;

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

    @Override public void onSuccess(ArrayList<Portfolio> res) {
        for (int i=0; i<res.size(); i++) {
            Log.e("TAG", res.get(i).getDesc());
        }
    }

    @Override public void onError(String msg) {
        Log.e("TAG", msg);
    }
}
