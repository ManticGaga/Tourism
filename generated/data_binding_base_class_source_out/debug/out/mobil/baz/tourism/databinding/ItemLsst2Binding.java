// Generated by view binder compiler. Do not edit!
package mobil.baz.tourism.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import mobil.baz.tourism.R;

public final class ItemLsst2Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView CurrencyTxt;

  @NonNull
  public final TextView codeTxt;

  @NonNull
  public final TextView idTxt;

  @NonNull
  public final TextView nameTxt;

  private ItemLsst2Binding(@NonNull ConstraintLayout rootView, @NonNull TextView CurrencyTxt,
      @NonNull TextView codeTxt, @NonNull TextView idTxt, @NonNull TextView nameTxt) {
    this.rootView = rootView;
    this.CurrencyTxt = CurrencyTxt;
    this.codeTxt = codeTxt;
    this.idTxt = idTxt;
    this.nameTxt = nameTxt;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemLsst2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemLsst2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_lsst2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemLsst2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.CurrencyTxt;
      TextView CurrencyTxt = ViewBindings.findChildViewById(rootView, id);
      if (CurrencyTxt == null) {
        break missingId;
      }

      id = R.id.codeTxt;
      TextView codeTxt = ViewBindings.findChildViewById(rootView, id);
      if (codeTxt == null) {
        break missingId;
      }

      id = R.id.idTxt;
      TextView idTxt = ViewBindings.findChildViewById(rootView, id);
      if (idTxt == null) {
        break missingId;
      }

      id = R.id.nameTxt;
      TextView nameTxt = ViewBindings.findChildViewById(rootView, id);
      if (nameTxt == null) {
        break missingId;
      }

      return new ItemLsst2Binding((ConstraintLayout) rootView, CurrencyTxt, codeTxt, idTxt,
          nameTxt);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
