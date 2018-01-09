package isfaaghyth.app.cleanarch.network;

import java.util.ArrayList;

import io.reactivex.Observable;
import isfaaghyth.app.cleanarch.model.Portfolio;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

public interface Routes {

    @GET("portfolio.php")
    Observable<Response<ArrayList<Portfolio>>> getHome();

}
