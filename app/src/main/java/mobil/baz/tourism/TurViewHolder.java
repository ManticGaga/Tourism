package mobil.baz.tourism;

import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import mobil.baz.tourism.databinding.ItemListBinding;

public class TurViewHolder extends RecyclerView.ViewHolder {
    Button Button;

    public TurViewHolder(ItemListBinding ceb) {
        super(ceb.getRoot());
        Button = ceb.cldr;
    }

    public Button getButton(){
        return Button;
    }
}

