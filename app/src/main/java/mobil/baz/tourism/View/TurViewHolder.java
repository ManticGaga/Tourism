package mobil.baz.tourism.View;

import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import mobil.baz.tourism.databinding.ItemListBinding;

public class TurViewHolder extends RecyclerView.ViewHolder {
    Button Button;

    public TurViewHolder(ItemListBinding ceb) {
        super(ceb.getRoot());
    }

    public Button getButton(){
        return Button;
    }
}

