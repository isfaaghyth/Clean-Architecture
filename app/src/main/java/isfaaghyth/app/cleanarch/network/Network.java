package isfaaghyth.app.cleanarch.network;

import com.google.gson.GsonBuilder;

import isfaaghyth.app.cleanarch.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

public class Network {

    public static Retrofit builder() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.MAIN_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
