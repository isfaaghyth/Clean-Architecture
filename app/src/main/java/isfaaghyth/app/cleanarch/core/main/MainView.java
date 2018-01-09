package isfaaghyth.app.cleanarch.core.main;

import isfaaghyth.app.cleanarch.model.Home;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

interface MainView {
    void onSuccess(Home res);
    void onError(String msg);
}
