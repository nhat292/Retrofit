package nguyenvannhat.android.com.tempproject.baseapi;

import android.util.Base64;

import nguyenvannhat.android.com.tempproject.configuration.Settings;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by nhat2 on 03/16/2016.
 */
public class BaseRestApi {


    public String getHeader() {
        return "Basic " + Base64.encodeToString(Settings.BASIC_AUTHENTICATION.getBytes(), Base64.NO_WRAP);
    }

    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Settings.REST_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
