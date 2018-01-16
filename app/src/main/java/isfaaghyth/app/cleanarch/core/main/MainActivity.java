package isfaaghyth.app.cleanarch.core.main;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.github.nitrico.lastadapter.LastAdapter;

import java.util.List;

import isfaaghyth.app.cleanarch.BR;
import isfaaghyth.app.cleanarch.R;
import isfaaghyth.app.cleanarch.base.BaseActivity;
import isfaaghyth.app.cleanarch.databinding.ActivityMainBinding;
import isfaaghyth.app.cleanarch.model.Portfolio;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainPresenter> implements MainView {

    @Override protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override protected ActivityMainBinding contentView() {
        return DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override protected void onCreated() {
        presenter.getHome();
        setup();
    }

    @Override public void onSuccess(List<Portfolio> res) {
        new LastAdapter(res, BR.item)
                .map(Portfolio.class, R.layout.item_portfolio)
                .into(view.lstPortfolio);
    }

    //@TODO("tricky mode whahaha")
    public void onPortClicked(View view) {
        Portfolio portfolio = (Portfolio) view.getTag();
        Toast.makeText(this, "item:"+portfolio.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private void setup() {
        view.lstPortfolio.setLayoutManager(new LinearLayoutManager(this));
    }
}
