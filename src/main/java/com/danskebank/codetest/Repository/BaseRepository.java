package com.danskebank.codetest.Repository;

import java.util.Random;

public class BaseRepository {

    public long generateID() {
        Random rand = new Random();

        long id = rand.nextLong();
        return id;
    }
}
