package isfaaghyth.app.cleanarch.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import isfaaghyth.app.cleanarch.network.Network;
import isfaaghyth.app.cleanarch.network.Routes;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

public class BasePresenter<V> {

    public V view;
    protected Routes service;
    private CompositeDisposable compositable;

    public void attachView(V view) {
        this.view = view;
        service = Network.builder().create(Routes.class);
    }

    public void dettachView() {
        this.view = null;
        if (compositable != null) {
            compositable.clear();
        }
    }

    protected void subscribe(Disposable disposable) {
        if (compositable == null) compositable = new CompositeDisposable();
        compositable.add(disposable);
    }

}
