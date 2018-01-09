package isfaaghyth.app.cleanarch.core.main;

import android.util.Log;

import isfaaghyth.app.cleanarch.base.BasePresenter;
import isfaaghyth.app.cleanarch.util.rx.MainScheduler;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

class MainPresenter extends BasePresenter<MainView> {

    MainPresenter(MainView view) {
        super.attachView(view);
    }

    void getHome() {
        subscribe(service.getHome()
                .compose(new MainScheduler<>())
                .subscribe(res -> {
                    if (res.code() == 404 || res.code() == 200) {
                        view.onSuccess(res.body());
                    }
                }, err -> {
                    view.onError(err.getMessage());
                }));
    }
}
