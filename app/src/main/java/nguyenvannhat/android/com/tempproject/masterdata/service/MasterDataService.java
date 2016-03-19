package nguyenvannhat.android.com.tempproject.masterdata.service;

import java.util.Map;

import nguyenvannhat.android.com.tempproject.baseapi.BaseCallback;
import nguyenvannhat.android.com.tempproject.masterdata.api.MasterDataRestApi;
import nguyenvannhat.android.com.tempproject.masterdata.entities.MasterDataResponse;

/**
 * Created by nhat2 on 03/16/2016.
 */
public class MasterDataService {

    private MasterDataRestApi masterDataRestApi = null;

    public MasterDataService(){
        masterDataRestApi = new MasterDataRestApi();
    }

    public void getMasterData(Map<String,String> params, BaseCallback<MasterDataResponse> callback){
        try{
            masterDataRestApi.getMasterData(params, callback);
        } catch (Exception e){}
    }
}
