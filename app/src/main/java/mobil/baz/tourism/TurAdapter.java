package mobil.baz.tourism;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mobil.baz.tourism.databinding.ItemListBinding;
import mobil.baz.tourism.ui.dashboard.DashboardFragment;


public class TurAdapter extends RecyclerView.Adapter<TurViewHolder>{

    private List<String> mTurs;
    private final DashboardFragment dashboardFragment;

    public TurAdapter(DashboardFragment dashboardFragment, List<String> rooms){
        this.dashboardFragment = dashboardFragment;
        this.mTurs = mTurs;
    }

    @NonNull
    @Override
    public TurViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TurViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TurViewHolder holder, int position) {
        holder.getButton().setText(mTurs.get(position));
        holder.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTurs.size();
    }

}

