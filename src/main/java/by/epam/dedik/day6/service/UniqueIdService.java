package by.epam.dedik.day6.service;

import java.util.Random;

public class UniqueIdService {
    private UniqueIdService() {
    }

    public static int getId() {
        return new Random().nextInt();
    }
}
