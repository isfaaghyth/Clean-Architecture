package isfaaghyth.app.cleanarch.core.main;

import java.util.List;

import isfaaghyth.app.cleanarch.base.BaseView;
import isfaaghyth.app.cleanarch.model.Portfolio;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

interface MainView extends BaseView {
    void onSuccess(List<Portfolio> res);
}
