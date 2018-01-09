package isfaaghyth.app.cleanarch.core.main;

import isfaaghyth.app.cleanarch.R;
import isfaaghyth.app.cleanarch.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @Override protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override protected int contentView() {
        return R.layout.activity_main;
    }

    @Override protected void onActivityLoaded() {
        
    }

}
