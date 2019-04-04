package com.github.lesincs;

import android.content.Intent;

/**
 * author: cs丶
 * date: 2019/4/3
 * description:
 */
public interface ActivityResultCallback {
  void onResult(int resultCode, Intent intent);
}
