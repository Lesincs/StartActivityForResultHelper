package com.github.lesincs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * author: cs丶
 * date: 2019/4/3
 * description:
 */
public class TransferV4Fragment extends Fragment {

  protected void startActivityForResult(int requestCode, Intent intent, Bundle options,
                                        ActivityResultCallback callback){
    StartActivityForResultHelper.requestCodeToCallback.put(requestCode,callback);
    startActivityForResult(intent,requestCode,options);
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
     ActivityResultCallback callback =  StartActivityForResultHelper.requestCodeToCallback
       .get(requestCode);

    if (callback!=null){
      callback.onResult(resultCode,data);
      StartActivityForResultHelper.requestCodeToCallback.remove(requestCode);
    }
  }
}
