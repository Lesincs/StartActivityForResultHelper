package com.github.lesincs;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: cs丶
 * date: 2019/4/3
 * description:
 */
public class StartActivityForResultHelper {

  private static final String TRANSFER_FRAGMENT_TAG = "TRANSFER_FRAGMENT_TAG";
  private static final String TRANSFER_V4_FRAGMENT_TAG = "TRANSFER_V4_FRAGMENT_TAG";
  private static final AtomicInteger requestCodeCreator = new AtomicInteger(1);
  static final SparseArray<ActivityResultCallback> requestCodeToCallback
    = new SparseArray<>();

  // ------------- fragment --------------
  private static void startActivityForResult(FragmentManager fragmentManager, Intent intent,
                                             Bundle options, ActivityResultCallback callback) {
    TransferFragment transferFragment = ((TransferFragment)
      fragmentManager.findFragmentByTag(TRANSFER_FRAGMENT_TAG));

    if (transferFragment == null) {
      transferFragment = new TransferFragment();

      fragmentManager
        .beginTransaction()
        .add(transferFragment, TRANSFER_FRAGMENT_TAG)
        .commitAllowingStateLoss();

      fragmentManager.executePendingTransactions();
    } else if (transferFragment.isDetached()) {
      fragmentManager
        .beginTransaction()
        .attach(transferFragment)
        .commitAllowingStateLoss();

      fragmentManager.executePendingTransactions();
    }

    transferFragment.startActivityForResult(requestCodeCreator.getAndIncrement(), intent, options,
      callback);
  }

  public static void startActivityForResult(Activity activity, Intent intent,
                                            Bundle options, ActivityResultCallback callback) {
    startActivityForResult(activity.getFragmentManager(), intent, options, callback);
  }

  public static void startActivityForResult(Activity activity, Intent intent,
                                            ActivityResultCallback callback) {
    startActivityForResult(activity.getFragmentManager(), intent, null, callback);
  }

  public static void startActivityForResult(Fragment fragment, Intent intent,
                                            Bundle options, ActivityResultCallback callback) {
    startActivityForResult(fragment.getChildFragmentManager(), intent, options, callback);
  }

  public static void startActivityForResult(Fragment fragment, Intent intent,
                                            ActivityResultCallback callback) {
    startActivityForResult(fragment.getChildFragmentManager(), intent, null, callback);
  }

  // ------------- fragmentV4 --------------

  private static void startActivityForResult(android.support.v4.app.FragmentManager fragmentManager,
                                             Intent intent, Bundle options, ActivityResultCallback callback) {
    TransferV4Fragment transferV4Fragment = ((TransferV4Fragment)
      fragmentManager.findFragmentByTag(TRANSFER_V4_FRAGMENT_TAG));

    if (transferV4Fragment == null) {
      transferV4Fragment = new TransferV4Fragment();

      fragmentManager
        .beginTransaction()
        .add(transferV4Fragment, TRANSFER_V4_FRAGMENT_TAG)
        .commitAllowingStateLoss();

      fragmentManager.executePendingTransactions();
    } else if (transferV4Fragment.isDetached()) {
      fragmentManager
        .beginTransaction()
        .attach(transferV4Fragment)
        .commitAllowingStateLoss();

      fragmentManager.executePendingTransactions();
    }

    transferV4Fragment.startActivityForResult(requestCodeCreator.getAndIncrement(), intent,
      options, callback);
  }

  public static void startActivityForResult(FragmentActivity fragmentActivity, Intent intent,
                                            Bundle options, ActivityResultCallback callback) {
    startActivityForResult(fragmentActivity.getSupportFragmentManager(), intent, options, callback);
  }

  public static void startActivityForResult(FragmentActivity fragmentActivity, Intent intent,
                                            ActivityResultCallback callback) {
    startActivityForResult(fragmentActivity.getSupportFragmentManager(), intent, null, callback);
  }

  public static void startActivityForResult(android.support.v4.app.Fragment fragmentV4, Intent intent,
                                            Bundle options, ActivityResultCallback callback) {
    startActivityForResult(fragmentV4.getChildFragmentManager(), intent, options, callback);
  }

  public static void startActivityForResult(android.support.v4.app.Fragment fragment, Intent intent,
                                            ActivityResultCallback callback) {
    startActivityForResult(fragment.getChildFragmentManager(), intent, null, callback);
  }


}
