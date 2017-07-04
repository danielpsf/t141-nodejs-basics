package br.danielpsf.labs

import spock.lang.Specification
import spock.lang.Unroll

class PrimesServiceSpec extends Specification {

    @Unroll
    def "it should find the primes of #number"() {
        given: "there is a prime service"
        PrimeService service = new PrimeService();

        when: "Calculating the prime number using the naive solution https://helloacm.com/c-coding-exercise-count-primes/"
        long result = service.getTotalOfPrimesOf(number)
        
        then: "values match the result of https://primes.utm.edu/howmany.html"
        result == totalOfPrimes

        where: "the input is"
        number      | totalOfPrimes
        1000        | 168
        10000       | 1229
        100000      | 9592
        1000000     | 78498
    }
}
