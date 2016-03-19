package nguyenvannhat.android.com.tempproject.baseapi;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.widget.Toast;

import java.util.logging.LogRecord;

import dmax.dialog.SpotsDialog;
import nguyenvannhat.android.com.tempproject.R;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by nhat2 on 03/16/2016.
 */
public abstract class BaseCallback<T> implements Callback<T> {

    private Context context;
    private AlertDialog progressDialog;

    public BaseCallback(Context context, boolean showProgressDialog, boolean canCancelProgressDialog, String progressMessage) {
        this.context = context;
        if(showProgressDialog){
            startProgress(canCancelProgressDialog, progressMessage);
        }
    }


    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {
        if (response.isSuccess()) {
            Log.d("FINISH_SUCCESS: ", "SUCCESS");
            onFinishWithSuccess(response.body(), retrofit);
            endProgress();
        } else {
            endProgress();
            onFinishWithError(response.message(), response.code());
        }
    }

    @Override
    public void onFailure(Throwable t) {
        endProgress();
        onError(t.getMessage());
    }


    private void startProgress(boolean cancel, String message) {
        progressDialog = new SpotsDialog(context);
        progressDialog.setCancelable(cancel);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    private void endProgress() {
        if (progressDialog != null) {
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }

    private void onFinishWithError(String message, int errorCode) {
        showDialogError(errorCode + " - " + message);
        Log.d("FINISH_ERROR: ", "MESSAGE: " + message + ",CODE: " + errorCode);
    }

    private void onError(String message) {
        showDialogError(message);
        Log.d("ERROR: ", "MESSAGE: " + message);
    }

    private void showDialogError(String message) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this.context);
        if(isOnline()){
            alertBuilder.setMessage(message);
        }else{
            alertBuilder.setMessage("No internet connection");
        }
        alertBuilder.setTitle("App Name");
        alertBuilder.setIcon(R.drawable.error_internet);
        alertBuilder.setCancelable(false);
        alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(!isOnline()){
                    System.exit(0);
                }
            }
        });
        AlertDialog alert = alertBuilder.create();
        alert.show();

    }

    public  boolean isOnline() {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }

    protected abstract void onFinishWithSuccess(T result, Retrofit retrofit);
}
