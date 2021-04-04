// Generated by data binding compiler. Do not edit!
package com.semicolon.ddyzd_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.semicolon.ddyzd_android.R;
import com.semicolon.ddyzd_android.viewmodel.ChattingPageViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemScheduleChatBinding extends ViewDataBinding {
  @NonNull
  public final TextView textView22;

  @NonNull
  public final TextView textView23;

  @NonNull
  public final TextView textView6;

  @Bindable
  protected ChattingPageViewModel mVm;

  @Bindable
  protected Integer mPosition;

  protected ItemScheduleChatBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView textView22, TextView textView23, TextView textView6) {
    super(_bindingComponent, _root, _localFieldCount);
    this.textView22 = textView22;
    this.textView23 = textView23;
    this.textView6 = textView6;
  }

  public abstract void setVm(@Nullable ChattingPageViewModel vm);

  @Nullable
  public ChattingPageViewModel getVm() {
    return mVm;
  }

  public abstract void setPosition(@Nullable Integer position);

  @Nullable
  public Integer getPosition() {
    return mPosition;
  }

  @NonNull
  public static ItemScheduleChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_schedule_chat, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemScheduleChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemScheduleChatBinding>inflateInternal(inflater, R.layout.item_schedule_chat, root, attachToRoot, component);
  }

  @NonNull
  public static ItemScheduleChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_schedule_chat, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemScheduleChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemScheduleChatBinding>inflateInternal(inflater, R.layout.item_schedule_chat, null, false, component);
  }

  public static ItemScheduleChatBinding bind(@NonNull View view) {
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
  public static ItemScheduleChatBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemScheduleChatBinding)bind(component, view, R.layout.item_schedule_chat);
  }
}
