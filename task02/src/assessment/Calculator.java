package assessment;

public class Calculator {

    private float results;

    public Calculator() {
    }

    public float addition(float a, float b) {
        return a + b;
    }

    public float subtraction(float a, float b) {
        return a - b;
    }

    public float multiplication(float a, float b) {
        return a * b;
    }

    public float division(float a, float b) {
        return a / b;
    }

    public void setResults(float results) {
        this.results = results;
    }

    public float getResults() {
        return results;
    }

}
