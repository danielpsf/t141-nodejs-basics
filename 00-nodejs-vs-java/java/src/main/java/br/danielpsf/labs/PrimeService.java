package br.danielpsf.labs;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class PrimeService {

    public long getTotalOfPrimesOf(final long limit) {
        Instant start = Instant.now();
        long primesCount = LongStream
                        .iterate(2, i -> i + 1)
                        .limit(limit)
                        .parallel()
                        .filter(PrimeService::isPrime)
                        .count();
        Instant end = Instant.now();

        System.out.println("Duration: " + Duration.between(start, end).toMillis() + "ms for " + limit);

        return primesCount;
    }

    private static boolean isPrime(final long number) {
        if (number <= 1) return false;
        for (int i = 2; i * i <= number; i++) {
           if (number % i == 0) return false;
        }
        return true;
    }
}
