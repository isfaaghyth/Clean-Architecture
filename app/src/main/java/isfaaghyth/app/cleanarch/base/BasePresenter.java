package isfaaghyth.app.cleanarch.base;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

public class BasePresenter<V> {
    public V view;

    public void attachView(V view) {
        this.view = view;
    }

    public void dettachView() {
        this.view = null;
    }
}
