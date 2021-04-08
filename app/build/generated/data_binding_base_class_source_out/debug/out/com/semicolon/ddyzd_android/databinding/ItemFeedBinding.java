// Generated by data binding compiler. Do not edit!
package com.semicolon.ddyzd_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.semicolon.ddyzd_android.R;
import com.semicolon.ddyzd_android.viewmodel.MainFeedViewModel;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemFeedBinding extends ViewDataBinding {
  @NonNull
  public final CardView cardView;

  @NonNull
  public final CircleImageView imageView3;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final ImageView imageView7;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final AppCompatTextView textView3;

  @NonNull
  public final AppCompatTextView textView4;

  @NonNull
  public final AppCompatTextView textView5;

  @NonNull
  public final View view;

  @Bindable
  protected MainFeedViewModel mVm;

  @Bindable
  protected Integer mPosition;

  protected ItemFeedBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CardView cardView, CircleImageView imageView3, ImageView imageView5, ImageView imageView7,
      TextView textView2, AppCompatTextView textView3, AppCompatTextView textView4,
      AppCompatTextView textView5, View view) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cardView = cardView;
    this.imageView3 = imageView3;
    this.imageView5 = imageView5;
    this.imageView7 = imageView7;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.view = view;
  }

  public abstract void setVm(@Nullable MainFeedViewModel vm);

  @Nullable
  public MainFeedViewModel getVm() {
    return mVm;
  }

  public abstract void setPosition(@Nullable Integer position);

  @Nullable
  public Integer getPosition() {
    return mPosition;
  }

  @NonNull
  public static ItemFeedBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_feed, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemFeedBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemFeedBinding>inflateInternal(inflater, R.layout.item_feed, root, attachToRoot, component);
  }

  @NonNull
  public static ItemFeedBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_feed, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemFeedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemFeedBinding>inflateInternal(inflater, R.layout.item_feed, null, false, component);
  }

  public static ItemFeedBinding bind(@NonNull View view) {
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
  public static ItemFeedBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemFeedBinding)bind(component, view, R.layout.item_feed);
  }
}