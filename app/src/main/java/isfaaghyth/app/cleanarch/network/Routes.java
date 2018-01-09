package isfaaghyth.app.cleanarch.network;

import io.reactivex.Observable;
import isfaaghyth.app.cleanarch.model.Home;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

public interface Routes {

    @GET("/")
    Observable<Response<Home>> getHome();
}
