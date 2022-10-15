class Main {
    public static void main(String[] args) {
        // the input is Double array according to lab requirement, can be set to int or double as well
        Double[] earnedGrades = {20D, 30D, 40D, 50D, 60D, 100D, 100D, 300D};
        Double[] grades = {20D, 30D, 40D, 50D, 60D, 100D, 200D, 300D};
        Double[] percentages = {10D, 10D, 10D, 10D, 10D, 10D, 15D, 25D};
        WeightGrades weightGrades = new WeightGrades();
        weightGrades.setEarnedPoint(earnedGrades);
        weightGrades.setPercentage(percentages);
        weightGrades.setTotalPoint(grades);
        weightGrades.calculateTotalWeightedGrade();

        weightGrades.start();
    }
}