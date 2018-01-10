package isfaaghyth.app.cleanarch.core.main;

import android.databinding.DataBindingUtil;
import android.util.Log;

import java.util.ArrayList;

import isfaaghyth.app.cleanarch.R;
import isfaaghyth.app.cleanarch.base.BaseActivity;
import isfaaghyth.app.cleanarch.databinding.ActivityMainBinding;
import isfaaghyth.app.cleanarch.model.Portfolio;
import isfaaghyth.app.cleanarch.util.GlideAdapter;

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

    @Override protected void onCreated() {
        presenter.getHome();
    }

    @Override public void onSuccess(ArrayList<Portfolio> res) {
        for (Portfolio p: res) {
            view.txtTitle.setText(
                    view.txtTitle.getText().toString() +
                    p.getDesc() + " " + p.getTitle()
            );
        }
        GlideAdapter.load(view.imgTest, res.get(0).getImg());
    }

    @Override public void onError(String msg) {
        Log.e("TAG", msg);
    }
}
