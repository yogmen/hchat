package com.szala.hchat.endpoints;

import com.szala.hchat.model.Forum;
import com.szala.hchat.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by robert on 22/01/2017.
 */

public interface ForumEndpoint {

    @GET("forum/{slugOrUUID}")
    Call<Forum> getForum(@Path("slugOrUUID") String slugOrUUID);

    @GET("forum/{slugOrUUID}/post")
    Call<List<Post>> getForumPosts(@Path("slugOrUUID") String slugOrUUID);
}
