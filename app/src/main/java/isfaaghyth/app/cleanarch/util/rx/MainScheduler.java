package isfaaghyth.app.cleanarch.util.rx;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

public class MainScheduler<T> extends SchedulerTransformer<T> {

    public MainScheduler() {
        super(Schedulers.io(), AndroidSchedulers.mainThread());
    }

}
