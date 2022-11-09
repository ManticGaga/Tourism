package mobil.baz.tourism;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.ArrayList;

import mobil.baz.tourism.databinding.ItemListBinding;


public class TurAdapter extends RecyclerView.Adapter<TurAdapter.MyViewHolder>{

    private List<Tur> mTurs =  new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tur tur = mTurs.get(position);
        holder.bindView(tur);
    }

    @Override
    public int getItemCount() {
        return mTurs.size();
    }

    public void setTur(List<Tur> tur){
        this.mTurs = tur;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ItemListBinding binding;

        public MyViewHolder(ItemListBinding binding){
            super(binding.getRoot());
            this.binding = binding;
            itemView.findViewById(R.id.cldr).setOnClickListener(view -> {
                Toast.makeText(itemView.getContext(), "Notification set.", Toast.LENGTH_SHORT).show();



            });


        }
        public void bindView(Tur tur){
              binding.cityRUTxt.setText(tur.getRecept());
              binding.cityENGTxt.setText(tur.getName());
        }
    }
}

