import java.util.Scanner;

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
    // code for lab4
    public void start(){
        Scanner scanner = new Scanner(System.in);
        // accept input of assignment number
        System.out.println("Please enter the assignment number");
        int N = Integer.parseInt(scanner.nextLine());
        int i = N;
        // resize the arrays
        totalPoints = new Double[N];
        earnedPoints = new Double[N];
        percentages = new Double[N];
        // fill total point
        while (i > 0){
            System.out.println("Please enter " + i + " total point");
            totalPoints[i - 1] = Double.valueOf(scanner.nextLine());
            i--;
        }
        System.out.println(generatString(totalPoints, "total point"));
        i = N;
        // fill earned point
        while (i > 0){
            System.out.println("Please enter " + i + " earned point");
            earnedPoints[i - 1] = Double.valueOf(scanner.nextLine());
            i--;
        }
        System.out.println(generatString(earnedPoints, "earned point"));
        boolean isValid = false;
        // fill percentage, if the input percentage is not valid(sum to 100), ask user to do it again
        while(!isValid){
            i = N;
            while(i > 0){
                System.out.println("Please enter " + i + " percentage");
                percentages[i - 1] = Double.valueOf(scanner.nextLine());
                i--;
            }
            Double total = 0D;
            for (Double p : percentages){
                total += p;
            }
            if (total == 100D) {
                isValid = true;
            }else {
                System.out.println("InValid percentage input, please try again, the sum of percentage must be 100");
            }
        }
        // print the final score
        this.calculateTotalWeightedGrade();
    }

    public String generatString(Double[] arr, String name){
        StringBuilder sb = new StringBuilder("The input "+ name +" are: [");
        for (int j = arr.length - 1; j >= 0; j--){
            sb.append(arr[j] + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}
