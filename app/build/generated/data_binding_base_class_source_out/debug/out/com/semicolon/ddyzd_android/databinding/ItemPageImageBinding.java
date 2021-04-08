// Generated by data binding compiler. Do not edit!
package com.semicolon.ddyzd_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.semicolon.ddyzd_android.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemPageImageBinding extends ViewDataBinding {
  @Bindable
  protected String mImage;

  protected ItemPageImageBinding(Object _bindingComponent, View _root, int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setImage(@Nullable String image);

  @Nullable
  public String getImage() {
    return mImage;
  }

  @NonNull
  public static ItemPageImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_page_image, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemPageImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemPageImageBinding>inflateInternal(inflater, R.layout.item_page_image, root, attachToRoot, component);
  }

  @NonNull
  public static ItemPageImageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_page_image, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemPageImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemPageImageBinding>inflateInternal(inflater, R.layout.item_page_image, null, false, component);
  }

  public static ItemPageImageBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ItemPageImageBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemPageImageBinding)bind(component, view, R.layout.item_page_image);
  }
}