package observer;

import org.junit.jupiter.api.Test;

class FeedTest {

    @Test
    void observerPatternTest() {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        // This tweet will cause the observers Guardian and LeMonde to react.
        f.notifyObservers("The queen said she'd like to drink wine!");
    }

    @Test
    void observerPatternWithLambdas() {
        Feed f = new Feed();

        // NYTimes
        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });

        // Guardian
        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet more news on London ... " + tweet);
            }
        });

        // LeMonde
        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }

        });

        // This tweet will cause the observers Guardian and LeMonde to react.
        f.notifyObservers("The queen said she'd like to drink wine!");

        // In this situation, it's a good idea to use lambdas because the code to execute is simple and there's no state
        // in the lambdas. In a lot of situations, lambdas will not be the right choice.
    }
}