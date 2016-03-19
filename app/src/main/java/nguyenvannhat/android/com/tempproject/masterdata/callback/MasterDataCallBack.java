package nguyenvannhat.android.com.tempproject.masterdata.callback;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import nguyenvannhat.android.com.tempproject.App;
import nguyenvannhat.android.com.tempproject.baseapi.BaseCallback;
import nguyenvannhat.android.com.tempproject.masterdata.entities.MasterDataEntity;
import nguyenvannhat.android.com.tempproject.masterdata.entities.MasterDataResponse;
import retrofit.Retrofit;

/**
 * Created by nhat2 on 03/16/2016.
 */
public class MasterDataCallBack extends BaseCallback<MasterDataResponse> {


    public MasterDataCallBack(Context context, boolean showProgressDialog, boolean canCancelProgressDialog, String progressMessage) {
        super(context, showProgressDialog, canCancelProgressDialog, progressMessage);
    }

    @Override
    protected void onFinishWithSuccess(MasterDataResponse result, Retrofit retrofit) {
        MasterDataEntity entity = result.getMaster_data();
        Toast.makeText(App.getAppContext(), "SUCCESS\n" + "Error code " + result.getError_code() + ", Message " + result.getMessage()
                + "\nURL: " + entity.getApp_content().getPrivacy_policy(), Toast.LENGTH_LONG).show();

        Log.d("DATA: ", result.getMaster_data().toJson().toString());
        Log.d("CALLBACK: ", "FINISH_SUCCSESS");
    }
}
