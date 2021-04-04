// Generated by data binding compiler. Do not edit!
package com.semicolon.ddyzd_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.semicolon.ddyzd_android.R;
import com.semicolon.ddyzd_android.viewmodel.ClubDetailsViewModel;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemClubDetailHeaderBinding extends ViewDataBinding {
  @NonNull
  public final ImageView backImage;

  @NonNull
  public final AppCompatButton button3;

  @NonNull
  public final TextView categoryTv;

  @NonNull
  public final TextView clubNameTv;

  @NonNull
  public final TextView descriptionTv;

  @NonNull
  public final AppCompatButton followBtn;

  @NonNull
  public final CircleImageView profileImage;

  @Bindable
  protected ClubDetailsViewModel mVm;

  protected ItemClubDetailHeaderBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView backImage, AppCompatButton button3, TextView categoryTv, TextView clubNameTv,
      TextView descriptionTv, AppCompatButton followBtn, CircleImageView profileImage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.backImage = backImage;
    this.button3 = button3;
    this.categoryTv = categoryTv;
    this.clubNameTv = clubNameTv;
    this.descriptionTv = descriptionTv;
    this.followBtn = followBtn;
    this.profileImage = profileImage;
  }

  public abstract void setVm(@Nullable ClubDetailsViewModel vm);

  @Nullable
  public ClubDetailsViewModel getVm() {
    return mVm;
  }

  @NonNull
  public static ItemClubDetailHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_club_detail_header, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemClubDetailHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemClubDetailHeaderBinding>inflateInternal(inflater, R.layout.item_club_detail_header, root, attachToRoot, component);
  }

  @NonNull
  public static ItemClubDetailHeaderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_club_detail_header, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemClubDetailHeaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemClubDetailHeaderBinding>inflateInternal(inflater, R.layout.item_club_detail_header, null, false, component);
  }

  public static ItemClubDetailHeaderBinding bind(@NonNull View view) {
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
  public static ItemClubDetailHeaderBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemClubDetailHeaderBinding)bind(component, view, R.layout.item_club_detail_header);
  }
}
