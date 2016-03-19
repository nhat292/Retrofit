package nguyenvannhat.android.com.tempproject.masterdata.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nhat2 on 03/16/2016.
 */
public class MasterDataResponse {

    private static MasterDataResponse instances = null;

    public static synchronized MasterDataResponse getInstances(){
        if(instances == null){
            instances = new MasterDataResponse();
        }
        return instances;
    }

    @SerializedName("error_code")
    private String error_code;
    @SerializedName("message")
    private String message;
    @SerializedName("master_data")
    private MasterDataEntity master_data;

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MasterDataEntity getMaster_data() {
        return master_data;
    }

    public void setMaster_data(MasterDataEntity master_data) {
        this.master_data = master_data;
    }
}
