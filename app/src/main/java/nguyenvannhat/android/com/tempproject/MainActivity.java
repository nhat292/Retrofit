package nguyenvannhat.android.com.tempproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import nguyenvannhat.android.com.tempproject.masterdata.callback.MasterDataCallBack;
import nguyenvannhat.android.com.tempproject.masterdata.service.MasterDataService;

public class MainActivity extends AppCompatActivity {
    MasterDataService masterDataService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        masterDataService = new MasterDataService();
        masterDataService.getMasterData(null, new MasterDataCallBack(this, true, false, "Loading..."));


    }
}
