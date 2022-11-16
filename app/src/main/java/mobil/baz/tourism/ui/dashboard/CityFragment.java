package mobil.baz.tourism.ui.dashboard;

import static java.util.stream.Collectors.toList;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Calendar;

import mobil.baz.tourism.model.Tur;
import mobil.baz.tourism.TurAdapter;
import mobil.baz.tourism.View.TurViewmodel;
import mobil.baz.tourism.databinding.FragmentDashboardBinding;

public class CityFragment extends Fragment {
    private TurViewmodel model;
    FragmentDashboardBinding binding;
    Button btnAddEvent;
    public Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        btnAddEvent = binding.cldr;
        btnAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();
            }
        });
        View v = binding.getRoot();
        binding.tutorialRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        model = new ViewModelProvider(this).get(TurViewmodel.class);
        model.getAllTurs().observe(getViewLifecycleOwner(), turs -> {
            binding.tutorialRecycler.setAdapter(
                    new TurAdapter(
                            this,
                            turs.stream().map(Tur::getName).collect(toList())
                    )
            );
        });
    }
    public void addEvent(){
        Log.d("Calendar", "Begin func");
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        Calendar cal = Calendar.getInstance();
        long startTime = cal.getTimeInMillis() + 24*60*60*1000;
        long endTime = startTime + 60 * 180 * 1000;
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "У вас назначена поездка");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Россия");
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);

        startActivity(calendarIntent);

        Log.d("Calendar", "End func");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}