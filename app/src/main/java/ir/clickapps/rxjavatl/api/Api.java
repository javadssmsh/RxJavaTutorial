package ir.clickapps.rxjavatl.api;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import ir.clickapps.rxjavatl.model.Post;
import retrofit2.http.GET;

public interface Api {

    @GET("getPosts.php")
    Observable<List<Post>> getPosts();
}
