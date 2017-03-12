import org.junit.*;

public class Project0Tests {

    @Test
    public void testAppleGetColor()
    {
        Apple a = new Apple("red", 55);
        try
        {
            Assert.assertEquals("Failed when testing Apple.getColor(). The expected value was red, the value returned was " +
                    a.getColor(), a.getColor(), "red");
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Exception thrown when testing Apple.getColor(). The Exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testAppleGetMass()
    {
        Apple a = new Apple("red", 55);
        try
        {
            Assert.assertEquals("Failed when testing Apple.getMass(). The expected value was 55, the value returned was " +
                    a.getMass(), a.getMass(), 55, 0);
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Exception thrown when testing Apple.getMass(). The Exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testAppleTakeBite55G()
    {
        Apple a = new Apple("red", 55);
        try
        {
            a.takeBite();
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Exception thrown when testing Apple.takeBite(). The Exception was:\n" + e.getMessage());
        }
        Assert.assertEquals("Failed when testing Apple.takeBite(). The expected mass after a bite is taken from a " +
                "55 gram apple is 45 grams, the value returned was " + a.getMass(), a.getMass(), 45, 0);
    }

    @Test
    public void testAppleTakeBite30G()
    {
        Apple a = new Apple("red", 30);
        try
        {
            a.takeBite();
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Exception thrown when testing Apple.takeBite(). The Exception was:\n" + e.getMessage());
        }
        Assert.assertEquals("Failed when testing Apple.takeBite(). The expected mass after a bite is taken from a " +
                "30 gram apple is 25 grams, the value returned was " + a.getMass(), a.getMass(), 25, 0);
    }

    @Test
    public void testDuckGetColor()
    {
        Duck d = new Duck("brown", 1100);
        try
        {
            Assert.assertEquals("Failed when testing Duck.getColor(). The expected value was brown, the value returned was " +
                    d.getColor(), d.getColor(), "brown");
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Exception thrown when testing Duck.getColor(). The Exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testDuckGetMass()
    {
        Duck d = new Duck("brown", 1100);
        try
        {
            Assert.assertEquals("Failed when testing Duck.getMass(). The expected value was 1100, the value returned was " +
                    d.getMass(), d.getMass(), 1100, 0);
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Exception thrown when testing Duck.getMass(). The Exception was:\n" + e.getMessage());
        }
    }

    @Test (expected = QuackException.class)
    public void testDuckTakeBite() throws Exception
    {
        Duck d = new Duck("brown", 1100);
        d.takeBite();
        Assert.fail("Failed: Expected a QuackException to be thrown while testing Duck.takeBite(), but it was not.");

    }

    @Test
    public void testAppleBagInsertAndToString() {
        IBag<Apple> apple_bag = new Bag();
        Apple a_one = new Apple("red", 100);
        Apple a_two = new Apple("green", 175);

        apple_bag.create(500);
        try {
            apple_bag.insert(a_one);
            apple_bag.insert(a_two);
        } catch (Exception e) {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<Apple>.insert(). The exception was:\n" + e.getMessage());
        }
        try {
            Assert.assertEquals("Failed when testing Bag<Apple>.toString(): The expected value was:\n\n" +
                    "Bag:\n" +
                    "A red apple with a mass of 100.0 grams\n" +
                    "A green apple with a mass of 175.0 grams\n" +
                    "but the value returned was:\n\n" +
                    apple_bag.toString(), apple_bag.toString(), "Bag:\n" +
                    "A red apple with a mass of 100.0 grams\n" +
                    "A green apple with a mass of 175.0 grams\n");
        } catch (Exception e) {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<Apple>.toString(). The exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testAppleBagGetMass()
    {
        IBag<Apple> apple_bag = new Bag();
        Apple a_one = new Apple("red", 100);
        Apple a_two = new Apple("green", 175);

        apple_bag.create(500);
        try
        {
            apple_bag.insert(a_one);
            apple_bag.insert(a_two);
            Assert.assertEquals("Failed when testing Bag<Apple>.getMass(): The expected value was 275, but the value returned was " + apple_bag.getMass(), apple_bag.getMass(), 275, 0);
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<Apple>.getMass(). The exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testAppleBagGetRemainingCapacity()
    {
        IBag<Apple> apple_bag = new Bag();
        Apple a_one = new Apple("red", 100);
        Apple a_two = new Apple("green", 175);

        apple_bag.create(500);
        try
        {
            apple_bag.insert(a_one);
            apple_bag.insert(a_two);
            Assert.assertEquals("Failed when testing Bag<Apple>.getRemainingCapacity(): The expected value was 225, but the value returned was " + apple_bag.getRemainingCapacity(), apple_bag.getRemainingCapacity(), 225, 0);
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<Apple>.getRemainingCapacity(). The exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testAppleBagRemove()
    {
        IBag<Apple> apple_bag = new Bag();
        Apple a_one = new Apple("red", 100);
        Apple a_two = new Apple("green", 100);

        apple_bag.create(500);
        try
        {
            apple_bag.insert(a_one);
            apple_bag.insert(a_two);
            apple_bag.remove();
            Assert.assertEquals("Failed when testing Bag<Apple>.remove(): The expected value (remaining mass) was 100, but the value returned was " + apple_bag.getMass(), apple_bag.getMass(), 100, 0);
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<Apple>.remove(). The exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testDuckBagInsertAndToString() {
        IBag<Duck> duck_bag = new Bag();
        Duck d_one = new Duck("brown", 1100);
        Duck d_two = new Duck("white", 1275);

        duck_bag.create(3000);
        try {
            duck_bag.insert(d_one);
            duck_bag.insert(d_two);
        } catch (Exception e) {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<Duck>.insert(). The exception was:\n" + e.getMessage());
        }
        try {
            Assert.assertEquals("Failed when testing Bag<Duck>.toString(): The expected value was:\n\n" +
                    "Bag:\n" +
                    "A brown duck with a mass of 1100.0 grams\n" +
                    "A white duck with a mass of 1275.0 grams\n" +
                    "but the value returned was:\n\n" +
                    duck_bag.toString(), duck_bag.toString(), "Bag:\n" +
                    "A brown duck with a mass of 1100.0 grams\n" +
                    "A white duck with a mass of 1275.0 grams\n");
        } catch (Exception e) {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<Duck>.toString(). The exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testDuckBagGetMass()
    {
        IBag<Duck> duck_bag = new Bag();
        Duck d_one = new Duck("brown", 1100);
        Duck d_two = new Duck("white", 1275);

        duck_bag.create(3000);
        try {
            duck_bag.insert(d_one);
            duck_bag.insert(d_two);
            Assert.assertEquals("Failed when testing Bag<Duck>.getMass(): The expected value was 2375, but the value returned was " + duck_bag.getMass(), duck_bag.getMass(), 2375, 0);
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<Duck>.getMass(). The exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testDuckBagGetRemainingCapacity()
    {
        IBag<Duck> duck_bag = new Bag();
        Duck d_one = new Duck("brown", 1100);
        Duck d_two = new Duck("white", 1275);

        duck_bag.create(3000);
        try {
            duck_bag.insert(d_one);
            duck_bag.insert(d_two);
            Assert.assertEquals("Failed when testing Bag<Duck>.getRemainingCapacity(): The expected value was 625, but the value returned was " + duck_bag.getRemainingCapacity(), duck_bag.getRemainingCapacity(), 625, 0);
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<Duck>.getRemainingCapacity(). The exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testDuckBagRemove()
    {
        IBag<Duck> duck_bag = new Bag();
        Duck d_one = new Duck("brown", 1100);
        Duck d_two = new Duck("white", 1100);

        duck_bag.create(3000);
        try {
            duck_bag.insert(d_one);
            duck_bag.insert(d_two);
            duck_bag.remove();
            Assert.assertEquals("Failed when testing Bag<Duck>.remove(): The expected value (remaining mass) was 1100, but the value returned was " + duck_bag.getMass(), duck_bag.getMass(), 1100, 0);
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<Duck>.remove(). The exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testIThingBagInsertAndToString() {
        IBag<IThing> thing_bag = new Bag();
        IThing t_one = new Duck("brown", 1100);
        IThing t_two = new Apple("red", 100);

        thing_bag.create(1500);
        try {
            thing_bag.insert(t_one);
            thing_bag.insert(t_two);
        } catch (Exception e) {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<IThing>.insert(). The exception was:\n" + e.getMessage());
        }
        try {
            Assert.assertEquals("Failed when testing Bag<IThing>.toString(): The expected value was:\n\n" +
                    "Bag:\n" +
                    "A brown duck with a mass of 1100.0 grams\n" +
                    "A red apple with a mass of 100.0 grams\n" +
                    "but the value returned was:\n\n" +
                    thing_bag.toString(), thing_bag.toString(), "Bag:\n" +
                    "A brown duck with a mass of 1100.0 grams\n" +
                    "A red apple with a mass of 100.0 grams\n");
        } catch (Exception e) {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<I4>.toString(). The exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testIThingBagGetMass()
    {
        IBag<IThing> thing_bag = new Bag();
        IThing t_one = new Duck("brown", 1100);
        IThing t_two = new Apple("red", 100);

        thing_bag.create(1500);
        try {
            thing_bag.insert(t_one);
            thing_bag.insert(t_two);
            Assert.assertEquals("Failed when testing Bag<IThing>.getMass(): The expected value was 1200, but the value returned was " + thing_bag.getMass(), thing_bag.getMass(), 1200, 0);
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<IThing>.getMass(). The exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testIThingBagGetRemainingCapacity()
    {
        IBag<IThing> thing_bag = new Bag();
        IThing t_one = new Duck("brown", 1100);
        IThing t_two = new Apple("red", 100);

        thing_bag.create(1500);
        try {
            thing_bag.insert(t_one);
            thing_bag.insert(t_two);
            Assert.assertEquals("Failed when testing Bag<IThing>.getRemainingCapacity(): The expected value was 300, but the value returned was " + thing_bag.getRemainingCapacity(), thing_bag.getRemainingCapacity(), 300, 0);
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<IThing>.getRemainingCapacity(). The exception was:\n" + e.getMessage());
        }
    }

    @Test
    public void testIThingBagRemove()
    {
        IBag<IThing> thing_bag = new Bag();
        IThing t_one = new Duck("brown", 500);
        IThing t_two = new Apple("red", 500);

        thing_bag.create(1500);
        try {
            thing_bag.insert(t_one);
            thing_bag.insert(t_two);
            thing_bag.remove();
            Assert.assertEquals("Failed when testing Bag<IThing>.remove(): The expected value (remaining mass) was 500, but the value returned was " + thing_bag.getMass(), thing_bag.getMass(), 500, 0);
        }
        catch (Exception e)
        {
            Assert.fail("Failed: Unexpected exception thrown when testing Bag<IThing>.remove(). The exception was:\n" + e.getMessage());
        }
    }


}
