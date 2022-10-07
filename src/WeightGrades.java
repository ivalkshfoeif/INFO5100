public class WeightGrades {

    private Double[] totalPoints;

    private Double[] earnedPoints;

    private Double[] percentages;

    private int totalWeightedGrade;

    /**
    * @Description: constructor of WeightGrades with attributes
    * @Param: [totalPoint, earnedPoint, percentage]
    * @return:
    */
    public WeightGrades(Double[] totalPoint, Double[] earnedPoint, Double[] percentage){
        this.totalPoints = totalPoint;
        this.earnedPoints = earnedPoint;
        this.percentages = percentage;
    }
    /**
    * @Description: Default constructor
    * @Param: []
    * @return:
    */
    public WeightGrades(){}

    /**
    * @Description: get total point
    * @Param: []
    * @return: int
    */
    public Double[] getTotalPoint() {
        return totalPoints;
    }
    /**
    * @Description: set total point
    * @Param: [totalPoint]
    * @return: void
    */
    public void setTotalPoint(Double[] totalPoint) {
        this.totalPoints = totalPoint;
    }
    /**
    * @Description: get earned point
    * @Param: []
    * @return: int
    */
    public Double[] getEarnedPoint() {
        return earnedPoints;
    }
    /**
    * @Description: set earned point
    * @Param: [earnedPoint]
    * @return: void
    */
    public void setEarnedPoint(Double[] earnedPoint) {
        this.earnedPoints = earnedPoint;
    }
    /**
    * @Description: get percentage
    * @Param: []
    * @return: double
    */
    public Double[] getPercentage() {
        return percentages;
    }
    /**
    * @Description: set percentage
    * @Param: [percentage]
    * @return: void
    */
    public void setPercentage(Double[] percentage) {
        this.percentages = percentage;
    }
    /**
    * @Description: calculate and return the total weighted grade
    * @Param: []
    * @return: double
    */


    /**
    * @Description: overload the calculateTotalWeightedGrade to calculate the total scores based on array input
    * @Param: [grads, percentage]
    * @return: double
    */
    public Double calculateTotalWeightedGrade(){
        double totalWeightedGrade = 0.0;
        // check the input is missing
        if (totalPoints == null || earnedPoints == null || percentages == null){
            System.out.println("Missing Input");
            return null;
        }
        // check the input is valid
        if (totalPoints.length != 8 && totalPoints.length != percentages.length){
            System.out.println("Invalid Input");
            return null;
        }
        // iterate through the input array
        for (int i = 0; i < totalPoints.length; i++){
            totalWeightedGrade += (earnedPoints[i] / totalPoints[i]) * percentages[i];
        }
        String letterGrade = null;
        // if else-if find the letter grade
        if (totalWeightedGrade >= 90.0 && totalWeightedGrade <= 100.0){
            letterGrade = "A";
        }else if (totalWeightedGrade < 90.0 && totalWeightedGrade >= 80.0){
            letterGrade = "B";
        }else if (totalWeightedGrade < 80.0 && totalWeightedGrade >= 70.0){
            letterGrade = "C";
        }else if (totalWeightedGrade < 70.0 && totalWeightedGrade >= 60.0){
            letterGrade = "D";
        }else if (totalWeightedGrade < 60.0){
            letterGrade = "F";
        }else {
            // if not in the 0-100 range, return null
            letterGrade = "NULL";
        }
        System.out.println("The total grade is: " + totalWeightedGrade + ". The letter grade is: " + letterGrade);
        return totalWeightedGrade;

    }
}
