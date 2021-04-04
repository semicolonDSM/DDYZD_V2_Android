// Generated by data binding compiler. Do not edit!
package com.semicolon.ddyzd_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.semicolon.ddyzd_android.R;
import com.semicolon.ddyzd_android.viewmodel.ChattingPageViewModel;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityChattingPageBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton chatPageBcBtn;

  @NonNull
  public final CircleImageView chatPageProfileIv;

  @NonNull
  public final RecyclerView chatPageRv;

  @NonNull
  public final LinearLayout chatPageSendContainer;

  @NonNull
  public final AppCompatButton chatPageSupportBtn;

  @Bindable
  protected ChattingPageViewModel mVm;

  protected ActivityChattingPageBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatButton chatPageBcBtn, CircleImageView chatPageProfileIv, RecyclerView chatPageRv,
      LinearLayout chatPageSendContainer, AppCompatButton chatPageSupportBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.chatPageBcBtn = chatPageBcBtn;
    this.chatPageProfileIv = chatPageProfileIv;
    this.chatPageRv = chatPageRv;
    this.chatPageSendContainer = chatPageSendContainer;
    this.chatPageSupportBtn = chatPageSupportBtn;
  }

  public abstract void setVm(@Nullable ChattingPageViewModel vm);

  @Nullable
  public ChattingPageViewModel getVm() {
    return mVm;
  }

  @NonNull
  public static ActivityChattingPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_chatting_page, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityChattingPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityChattingPageBinding>inflateInternal(inflater, R.layout.activity_chatting_page, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityChattingPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_chatting_page, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityChattingPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityChattingPageBinding>inflateInternal(inflater, R.layout.activity_chatting_page, null, false, component);
  }

  public static ActivityChattingPageBinding bind(@NonNull View view) {
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
  public static ActivityChattingPageBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityChattingPageBinding)bind(component, view, R.layout.activity_chatting_page);
  }
}
