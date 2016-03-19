package nguyenvannhat.android.com.tempproject.masterdata.api;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

import nguyenvannhat.android.com.tempproject.baseapi.BaseCallback;
import nguyenvannhat.android.com.tempproject.baseapi.BaseRestApi;
import nguyenvannhat.android.com.tempproject.masterdata.entities.MasterDataResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.QueryMap;

/**
 * Created by nhat2 on 03/16/2016.
 */
public class MasterDataRestApi extends BaseRestApi {
    private static final String URL_GET_MASTERDATA = "/v1/Customer/getMasterData";

   public interface MasterDataServiceApi{

       @GET(URL_GET_MASTERDATA)
       Call<MasterDataResponse> getMasterData(@Header("Authorization") String authorization, @QueryMap() Map<String,String> params);
   }

    private MasterDataServiceApi restApi = null;
    public MasterDataRestApi(){
        restApi = getRetrofit().create(MasterDataServiceApi.class);
    }

    public void getMasterData(Map<String,String> params,BaseCallback<MasterDataResponse> callback)
            throws InvalidKeyException, SignatureException, NoSuchAlgorithmException {
        Call<MasterDataResponse> call = restApi.getMasterData(getHeader(), params);
        call.enqueue(callback);
    }

}
