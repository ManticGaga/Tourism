package mobil.baz.tourism;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenTripMapAPI {

    @GET("{lang}/places/geoname")
    Call<trip> getOpenMapAPIdata(@Path("lang") String lang, @Query("name") String name, @Query("apikey") String apikey);
}
