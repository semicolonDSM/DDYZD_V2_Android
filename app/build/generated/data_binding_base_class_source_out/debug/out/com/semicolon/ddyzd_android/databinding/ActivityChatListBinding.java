// Generated by data binding compiler. Do not edit!
package com.semicolon.ddyzd_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.semicolon.ddyzd_android.R;
import com.semicolon.ddyzd_android.viewmodel.ChatListViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityChatListBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton chatListBackBtn;

  @NonNull
  public final RecyclerView chatListRv;

  @NonNull
  public final AppCompatSpinner chatListSpin;

  @NonNull
  public final TextView chatListTitleTv;

  @Bindable
  protected ChatListViewModel mVm;

  @Bindable
  protected Integer mPositon;

  protected ActivityChatListBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatButton chatListBackBtn, RecyclerView chatListRv, AppCompatSpinner chatListSpin,
      TextView chatListTitleTv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.chatListBackBtn = chatListBackBtn;
    this.chatListRv = chatListRv;
    this.chatListSpin = chatListSpin;
    this.chatListTitleTv = chatListTitleTv;
  }

  public abstract void setVm(@Nullable ChatListViewModel vm);

  @Nullable
  public ChatListViewModel getVm() {
    return mVm;
  }

  public abstract void setPositon(@Nullable Integer positon);

  @Nullable
  public Integer getPositon() {
    return mPositon;
  }

  @NonNull
  public static ActivityChatListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_chat_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityChatListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityChatListBinding>inflateInternal(inflater, R.layout.activity_chat_list, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityChatListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_chat_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityChatListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityChatListBinding>inflateInternal(inflater, R.layout.activity_chat_list, null, false, component);
  }

  public static ActivityChatListBinding bind(@NonNull View view) {
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
  public static ActivityChatListBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityChatListBinding)bind(component, view, R.layout.activity_chat_list);
  }
}
