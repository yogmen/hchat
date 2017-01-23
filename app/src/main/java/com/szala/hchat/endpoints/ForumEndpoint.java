package com.szala.hchat.endpoints;

import com.szala.hchat.model.CoreObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by robert on 22/01/2017.
 */

public interface ForumEndpoint {

    @GET("forum/{slugOrUUID}")
    Call<CoreObject> getForum(@Path("slugOrUUID") String slugOrUUID);

    @GET("forum/{slugOrUUID}/post")
    Call<List<CoreObject>> getForumPosts(@Path("slugOrUUID") String slugOrUUID);
}
