// Generated by data binding compiler. Do not edit!
package com.semicolon.ddyzd_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.semicolon.ddyzd_android.R;
import com.semicolon.ddyzd_android.viewmodel.ChattingPageViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemClubApplicationChatBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout constraintLayout3;

  @NonNull
  public final TextView textView20;

  @NonNull
  public final TextView textView9;

  @Bindable
  protected ChattingPageViewModel mVm;

  @Bindable
  protected Integer mPosition;

  protected ItemClubApplicationChatBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout constraintLayout3, TextView textView20,
      TextView textView9) {
    super(_bindingComponent, _root, _localFieldCount);
    this.constraintLayout3 = constraintLayout3;
    this.textView20 = textView20;
    this.textView9 = textView9;
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
  public static ItemClubApplicationChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_club_application_chat, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemClubApplicationChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemClubApplicationChatBinding>inflateInternal(inflater, R.layout.item_club_application_chat, root, attachToRoot, component);
  }

  @NonNull
  public static ItemClubApplicationChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_club_application_chat, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemClubApplicationChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemClubApplicationChatBinding>inflateInternal(inflater, R.layout.item_club_application_chat, null, false, component);
  }

  public static ItemClubApplicationChatBinding bind(@NonNull View view) {
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
  public static ItemClubApplicationChatBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemClubApplicationChatBinding)bind(component, view, R.layout.item_club_application_chat);
  }
}
