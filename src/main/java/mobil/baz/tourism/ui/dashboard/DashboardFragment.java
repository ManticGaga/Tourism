package mobil.baz.tourism.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import mobil.baz.tourism.Tur;
import mobil.baz.tourism.TurAdapter;
import mobil.baz.tourism.TurViewmodel;
import mobil.baz.tourism.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    TurViewmodel model;
    Button mButton;
    public Context mContext;
    ///12
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);


        return binding.getRoot();





    }

    //
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {



        model = new ViewModelProvider(this).get(TurViewmodel.class);
        binding.tutorialRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.tutorialRecycler.setHasFixedSize(true);
        TurAdapter turAdapter = new TurAdapter();
        binding.tutorialRecycler.setAdapter(turAdapter);



        model.getAllTurs().observe(getViewLifecycleOwner(), new Observer<List<Tur>>() {
            @Override
            public void onChanged(List<Tur> turs) {
                turAdapter.setTur(turs);
            }
        });


    }
    //  final TextView textView = binding.textDashboard;
    //  dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}