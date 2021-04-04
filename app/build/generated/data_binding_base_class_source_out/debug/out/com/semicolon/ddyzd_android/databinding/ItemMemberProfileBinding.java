// Generated by data binding compiler. Do not edit!
package com.semicolon.ddyzd_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.semicolon.ddyzd_android.R;
import com.semicolon.ddyzd_android.viewmodel.ClubDetailsViewModel;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemMemberProfileBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatTextView captainTv;

  @NonNull
  public final AppCompatTextView nameTv;

  @NonNull
  public final CircleImageView profileImage;

  @Bindable
  protected ClubDetailsViewModel mVm;

  @Bindable
  protected Integer mPosition;

  protected ItemMemberProfileBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatTextView captainTv, AppCompatTextView nameTv, CircleImageView profileImage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.captainTv = captainTv;
    this.nameTv = nameTv;
    this.profileImage = profileImage;
  }

  public abstract void setVm(@Nullable ClubDetailsViewModel vm);

  @Nullable
  public ClubDetailsViewModel getVm() {
    return mVm;
  }

  public abstract void setPosition(@Nullable Integer position);

  @Nullable
  public Integer getPosition() {
    return mPosition;
  }

  @NonNull
  public static ItemMemberProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_member_profile, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemMemberProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemMemberProfileBinding>inflateInternal(inflater, R.layout.item_member_profile, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMemberProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_member_profile, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemMemberProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemMemberProfileBinding>inflateInternal(inflater, R.layout.item_member_profile, null, false, component);
  }

  public static ItemMemberProfileBinding bind(@NonNull View view) {
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
  public static ItemMemberProfileBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemMemberProfileBinding)bind(component, view, R.layout.item_member_profile);
  }
}
