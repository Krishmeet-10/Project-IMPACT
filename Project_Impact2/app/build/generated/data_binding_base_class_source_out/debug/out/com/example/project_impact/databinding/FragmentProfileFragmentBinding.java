// Generated by view binder compiler. Do not edit!
package com.example.project_impact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.project_impact.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentProfileFragmentBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ImageView appSettingsVol;

  @NonNull
  public final ImageView editEmail;

  @NonNull
  public final ImageView editJob;

  @NonNull
  public final ImageView editLocation;

  @NonNull
  public final ImageView editPfp;

  @NonNull
  public final ImageView editPhone;

  @NonNull
  public final CardView imageView;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final Button update;

  @NonNull
  public final TextView userEmail;

  @NonNull
  public final TextView userJob;

  @NonNull
  public final TextView userLocation;

  @NonNull
  public final TextView userName;

  @NonNull
  public final ImageView userPfp;

  @NonNull
  public final TextView userPhone;

  private FragmentProfileFragmentBinding(@NonNull FrameLayout rootView,
      @NonNull ImageView appSettingsVol, @NonNull ImageView editEmail, @NonNull ImageView editJob,
      @NonNull ImageView editLocation, @NonNull ImageView editPfp, @NonNull ImageView editPhone,
      @NonNull CardView imageView, @NonNull TextView textView10, @NonNull TextView textView7,
      @NonNull TextView textView8, @NonNull Button update, @NonNull TextView userEmail,
      @NonNull TextView userJob, @NonNull TextView userLocation, @NonNull TextView userName,
      @NonNull ImageView userPfp, @NonNull TextView userPhone) {
    this.rootView = rootView;
    this.appSettingsVol = appSettingsVol;
    this.editEmail = editEmail;
    this.editJob = editJob;
    this.editLocation = editLocation;
    this.editPfp = editPfp;
    this.editPhone = editPhone;
    this.imageView = imageView;
    this.textView10 = textView10;
    this.textView7 = textView7;
    this.textView8 = textView8;
    this.update = update;
    this.userEmail = userEmail;
    this.userJob = userJob;
    this.userLocation = userLocation;
    this.userName = userName;
    this.userPfp = userPfp;
    this.userPhone = userPhone;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentProfileFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentProfileFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_profile_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentProfileFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_settings_vol;
      ImageView appSettingsVol = ViewBindings.findChildViewById(rootView, id);
      if (appSettingsVol == null) {
        break missingId;
      }

      id = R.id.edit_email;
      ImageView editEmail = ViewBindings.findChildViewById(rootView, id);
      if (editEmail == null) {
        break missingId;
      }

      id = R.id.edit_job;
      ImageView editJob = ViewBindings.findChildViewById(rootView, id);
      if (editJob == null) {
        break missingId;
      }

      id = R.id.edit_location;
      ImageView editLocation = ViewBindings.findChildViewById(rootView, id);
      if (editLocation == null) {
        break missingId;
      }

      id = R.id.edit_pfp;
      ImageView editPfp = ViewBindings.findChildViewById(rootView, id);
      if (editPfp == null) {
        break missingId;
      }

      id = R.id.edit_phone;
      ImageView editPhone = ViewBindings.findChildViewById(rootView, id);
      if (editPhone == null) {
        break missingId;
      }

      id = R.id.imageView;
      CardView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.update;
      Button update = ViewBindings.findChildViewById(rootView, id);
      if (update == null) {
        break missingId;
      }

      id = R.id.user_email;
      TextView userEmail = ViewBindings.findChildViewById(rootView, id);
      if (userEmail == null) {
        break missingId;
      }

      id = R.id.user_job;
      TextView userJob = ViewBindings.findChildViewById(rootView, id);
      if (userJob == null) {
        break missingId;
      }

      id = R.id.user_location;
      TextView userLocation = ViewBindings.findChildViewById(rootView, id);
      if (userLocation == null) {
        break missingId;
      }

      id = R.id.user_name;
      TextView userName = ViewBindings.findChildViewById(rootView, id);
      if (userName == null) {
        break missingId;
      }

      id = R.id.user_pfp;
      ImageView userPfp = ViewBindings.findChildViewById(rootView, id);
      if (userPfp == null) {
        break missingId;
      }

      id = R.id.user_phone;
      TextView userPhone = ViewBindings.findChildViewById(rootView, id);
      if (userPhone == null) {
        break missingId;
      }

      return new FragmentProfileFragmentBinding((FrameLayout) rootView, appSettingsVol, editEmail,
          editJob, editLocation, editPfp, editPhone, imageView, textView10, textView7, textView8,
          update, userEmail, userJob, userLocation, userName, userPfp, userPhone);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
