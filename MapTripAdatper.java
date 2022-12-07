package mobil.baz.tourism;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mobil.baz.tourism.databinding.ItemLsst2Binding;

public class MapTripAdatper extends RecyclerView.Adapter<MapTripAdatper.CountriesViewHolder> {
    private List<responsess> mCountries = new ArrayList<>();

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLsst2Binding binding =  ItemLsst2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CountriesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        responsess responsess = mCountries.get(position);
        holder.bindView(responsess);
    }

    @Override
    public int getItemCount() {
        return mCountries.size();
    }

    public void setCountries(List<responsess> mCountries) {
        this.mCountries = mCountries;
        notifyDataSetChanged();
    }


    public static class CountriesViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView,titleTextView1,titleTextView2,titleTextView3;
        ItemLsst2Binding binding;


        public CountriesViewHolder( ItemLsst2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
            titleTextView2 = itemView.findViewById(R.id.cityname);
            titleTextView1 = itemView.findViewById(R.id.lon);
            titleTextView = itemView.findViewById(R.id.lat);

        }

        public void bindView(responsess responsess){

            binding.cityname.setText(responsess.getNameResponse());
            binding.lon.setText(String.valueOf(responsess.getLat()));
            binding.lat.setText(String.valueOf(responsess.getLon()));
        }

    }

}
