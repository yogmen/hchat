package com.szala.hchat.endpoints;

import com.szala.hchat.model.CoreObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by robert on 22/01/2017.
 */

public interface ForumService {

    @GET("forum/{slugOrUUID}")
    Observable<CoreObject> getForum(@Path("slugOrUUID") String slugOrUUID);

    @GET("forum/{slugOrUUID}/post")
    Observable<CoreObject> getForumPosts(@Path("slugOrUUID") String slugOrUUID);
}
