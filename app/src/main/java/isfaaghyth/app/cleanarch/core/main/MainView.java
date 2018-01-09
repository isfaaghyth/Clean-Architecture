package isfaaghyth.app.cleanarch.core.main;

import java.util.ArrayList;

import isfaaghyth.app.cleanarch.model.Portfolio;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

interface MainView {
    void onSuccess(ArrayList<Portfolio> res);
    void onError(String msg);
}
