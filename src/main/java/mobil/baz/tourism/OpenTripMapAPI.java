package mobil.baz.tourism;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenTripMapAPI {

    @GET("0.1/ru/places/geoname?name=name%20%3D%20set%20value%20&apikey=5ae2e3f221c38a28845f05b65151d94ca3a9d4e304250ab91e4aceb1")
    Call<trip> getOpenMapAPIdata(@Query("name") String name, @Path("lang") String lang);
}
