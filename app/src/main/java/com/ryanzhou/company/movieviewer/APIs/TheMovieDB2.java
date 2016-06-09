package com.ryanzhou.company.movieviewer.APIs;

import com.ryanzhou.company.movieviewer.BuildConfig;
import com.ryanzhou.company.movieviewer.model.MovieReviews;
import com.ryanzhou.company.movieviewer.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ryanzhou on 6/9/16.
 */
public interface TheMovieDB2 {

    //https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit
    String VERSION = "/3";
    String MOVIE_SERVICE = "/movie";
    String REVIEWS_FEATURE = "/reviews";
    String POPULAR_FEATURE = "/popular";
    String TOP_RATED_FEATURE = "/top_rated";
    String BASE_URL = "https://api.themoviedb.org";
    String QUERY = "?";
    String API_KEY_PARAM = "api_key=";
    String API_KEY = BuildConfig.API_KEY;
    String END_QUERY_API_KEY_API = QUERY + API_KEY_PARAM + API_KEY;

    //
    public final static String BASE_IMAGE_URL =  "https://image.tmdb.org/t/p/";
    public final static String IMAGE_NOT_AVAILABLE_URL =
            "https://upload.wikimedia.org/wikipedia/commons/6/64/Poster_not_available.jpg";

    public final static String IMAGE_SIZE_LARGE = "w342";
    public final static String IMAGE_SIZE_SMALL = "w185";
    // "w92", "w154", "w185", "w342", "w500", "w780", "original"

    @GET(VERSION + MOVIE_SERVICE + "/{movieID}" + REVIEWS_FEATURE + END_QUERY_API_KEY_API)
    Call<MovieReviews> loadMovieReviews(@Path("movieID") String id);

    //http://api.themoviedb.org/3/movie/top_rated
    @GET(VERSION + MOVIE_SERVICE + TOP_RATED_FEATURE + END_QUERY_API_KEY_API)
    Call<Movies> loadTopRatedMovies();

    //http://api.themoviedb.org/3/movie/popular
    @GET(VERSION + MOVIE_SERVICE + POPULAR_FEATURE + END_QUERY_API_KEY_API)
    Call<Movies> loadPopularMovies();

    //http://api.themoviedb.org/3/movie/49026/reviews?api_key=499e327a20a603ac8193ae2bf20a2702
}
