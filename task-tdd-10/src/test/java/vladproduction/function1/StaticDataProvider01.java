package vladproduction.function1;

import org.testng.annotations.DataProvider;

public class StaticDataProvider01 {

    @DataProvider(name = "dataForFunction")
    public static Object[][] createDataForFunction() {
        return new Object[][]{
                {0.5, 1},
                {2.0, -0.240462},
                {1.0, 0.0}, //not good example, test working(!) without any logic in function
                {1.1, -0.057662},
                {0.7, 1},
                {1.4, -0.329742}
        };
    }

    @DataProvider(name = "dataForSteps")
    public static Object[][] createDataForSteps() {
        return new Object[][]{
                {0.0, 10.0, 0.1, 101},
                {0.0, 3.0, 0.004, 751}
        };
    }

    @DataProvider(name = "dataForWriteX")
    public static Object[][] createDataForWriteX() {
        return new Object[][]{
                {175, 0.7},
                {350, 1.4},
                {750, 3.0}
        };
    }

    @DataProvider(name = "dataForWriteY")
    public static Object[][] createDataForWriteY() {
        return new Object[][]{
                {175, 1.0},
                {350, -0.329742}, //(example how to count): -0.5*(1.4^2)*ln(1.4)
                {750, 0.214242} //Math.exp(a*x)*Math.cos(b*x);--> e^(-1.5)*cos(6)-->e^(-0.5*3)cos(2*3)
        };
    }

    @DataProvider(name = "dataForIndexMinY")
    public static Object[][] createDataForIndexMinY() {
        return new Object[][]{
                {0.0, 3.0, 0.004, 362},
                {0.0, 10.0, 0.01, 145},
                {1.0, 3.0, 0.1, 5},
                {-3.0, 1.0, 0.01, 400}

        };
    }


    @DataProvider(name = "dataForIndexMaxY")
    public static Object[][] createDataForIndexMaxY() {
        return new Object[][]{
                {0.0, 3.0, 0.004, 0},
                {2.0, 10.0, 0.1, 10},
                {3.0, 11.5, 0.25, 0}

        };
    }

    @DataProvider(name = "dataForMinYByX")
    public static Object[][] createDataForMinYByX() {
        return new Object[][]{
                {3.0, 11.5, 0.25, 6},
                {0.0, 10.0, 0.25, 6},
                {0.0, 3.0, 0.004, 362}
        };
    }

    @DataProvider(name = "dataForMaxYByX")
    public static Object[][] createDataForMaxYByX() {
        return new Object[][]{
                {3.0, 11.5, 0.25, 0},
                {0.0, 10.0, 0.25, 0},
                {0.0, 3.0, 0.004, 0}
        };
    }

    @DataProvider(name = "dataForSum")
    public static Object[][] createDataForSum() {
        return new Object[][]{
                {3.0, 11.5, 0.25, 0.319962},
                {0.0, 10.0, 0.25, 2.336445},
                {0.0, 3.0, 0.004, 118.943654}
        };
    }

    @DataProvider(name = "dataForAvg")
    public static Object[][] createDataForAvg() {
        return new Object[][]{
                {3.0, 11.5, 0.25, 0.009141},
                {0.0, 10.0, 0.25, 0.056986},
                {0.0, 3.0, 0.004, 0.158380}
        };
    }

    @DataProvider(name = "dataForSumByX")
    public static Object[][] createDataForSumByX() {
        return new Object[][]{
                {3.0, 11.5, 0.25, 0.319962},
                {0.0, 10.0, 0.25, 2.336445},
                {0.0, 3.0, 0.004, 118.943654}
        };
    }

    @DataProvider(name = "dataForAvgByX")
    public static Object[][] createDataForAvgByX() {
        return new Object[][]{
                {3.0, 11.5, 0.25, 0.009141},
                {0.0, 10.0, 0.25, 0.056986},
                {0.0, 3.0, 0.004, 0.158380}
        };
    }
}
