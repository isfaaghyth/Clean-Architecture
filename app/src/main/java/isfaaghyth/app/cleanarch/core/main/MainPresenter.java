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
        view().showLoading();
        subscribe(service().getHome()
                .compose(new MainScheduler<>())
                .subscribe(res -> {
                    view().hideLoading();
                    view().onSuccess(res);
                }, err -> {
                    view().hideLoading();
                    handleError(err);
                })
        );
    }

}
