package mobil.baz.tourism;

import android.content.Intent;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import mobil.baz.tourism.databinding.ItemListBinding;


public class TurAdapter extends RecyclerView.Adapter<TurAdapter.MyViewHolder>{
    ///12
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
        }
        public void bindView(Tur tur){
            binding.cityRUTxt.setText(tur.getTur_name());
            binding.cityENGTxt.setText(tur.getName());
            itemView.findViewById(R.id.cldr).setOnClickListener(view ->{
                Log.d("Calendar", "Begin func");
                Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                Toast.makeText(itemView.getContext(),"Вы выбрали " + binding.cityRUTxt.getText().toString(),Toast.LENGTH_SHORT).show();
                Calendar cal = Calendar.getInstance();
                long startTime = cal.getTimeInMillis() + 24*60*60*1000*7;
                long endTime = startTime + 60 * 180 * 1000*7;
                calendarIntent.putExtra(CalendarContract.Events.TITLE, "Тур");
                calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, binding.cityRUTxt.getText().toString());
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);
                itemView.getContext().startActivity(calendarIntent);
                Log.d("Calendar", "End func");
            } );
        }
    }
}

