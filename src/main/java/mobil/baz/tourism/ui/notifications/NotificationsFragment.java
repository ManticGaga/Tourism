package mobil.baz.tourism.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mobil.baz.tourism.MapTripAdatper;
import mobil.baz.tourism.MapTripViewmodel;
import mobil.baz.tourism.R;
import mobil.baz.tourism.TurViewmodel;
import mobil.baz.tourism.databinding.FragmentNotificationsBinding;
import mobil.baz.tourism.responsess;

public class NotificationsFragment extends Fragment {
    EditText Turname;
    EditText Recepttur;
    MapTripAdatper adapter;
    MapTripViewmodel model2;
    EditText Name;
    Button button;
    TurViewmodel model;
    private FragmentNotificationsBinding binding;
    RecyclerView recyclerView;
    TextView textView, textView1, textView2, textView3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);
        return rootView;

    }


    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.CountriesRecycler);
        textView = view.findViewById(R.id.cityname);
        textView1 = view.findViewById(R.id.lon);
        textView2 = view.findViewById(R.id.lat);
        adapter = new MapTripAdatper();
        model2 = new ViewModelProvider(this).get(MapTripViewmodel.class);
        model2.init();
        binding.CountriesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.CountriesRecycler.setAdapter(adapter);
        model2.getMapTripResponseApiData().observe(getViewLifecycleOwner(), new Observer<List<responsess>>() {
            @Override
            public void onChanged(List<responsess> responses) {
                adapter.setCountries(responses);
            }
        });


    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}