package mobil.baz.tourism;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MapTripRepository {

    private OpenTripMapAPI api;
    private MutableLiveData<List<responsess>> MutableData;



    public MapTripRepository() {
        MutableData = new MutableLiveData<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.opentripmap.com/0.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenTripMapAPI api = retrofit.create(OpenTripMapAPI.class);

        Call<trip> call = api.getOpenMapAPIdata("Тверь", "ru", "5ae2e3f221c38a28845f05b65151d94ca3a9d4e304250ab91e4aceb1");


        call.enqueue(new Callback<trip>() {
            @Override
            public void onResponse(Call<trip> call, Response<trip> response) {
                MutableData.setValue(response.body().getResponses());;
            }

            @Override
            public void onFailure(Call<trip> call, Throwable t) {
                MutableData.setValue(null);

            }
        });

    }

    public LiveData<List<responsess>> OpenTripMapApiData () {
        return MutableData;
    }

}