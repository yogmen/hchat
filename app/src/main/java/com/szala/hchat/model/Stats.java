package com.szala.hchat.model;

/**
 * Created by robert on 22/01/2017.
 */

public class Stats {
    private int negativity;
    private int downVotes;
    private int upVotes;

    public Stats() {
    }

    public int getNegativity() {
        return negativity;
    }

    public void setNegativity(int negativity) {
        this.negativity = negativity;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public String getUpVotesAsString() {
        return String.valueOf(upVotes);
    }
}
