/**
 * @auther Yaaqov Shkifati
 * @since 4/13/2020
 * @verison 1.0 
 * Description: In this program we are given a text file with data of a ranges 
 * of the world populations corresponding to their years. We will first need to 
 * declare 2 different arrays, One for the years and another for the  world 
 * population. The definition of an array is:"a data structure, which can store 
 * a fixed-size collection of elements of the same data type". This useful 
 * because we store all data of years on one array and all the world Population 
 * data onto anther array. Then will need to create a method that would scan in 
 * the data from the file and populate both arrays and count the number of rows. 
 * However,the data is unorganized so we will need sort the arrays by using the 
 * bubble sort method.Bubble sort is the simplest sorting algorithm, it compares 
 * the first two elements, if the first is greater than the second, swaps them, 
 * continues doing (compares and swaps) for the next pair of adjacent elements. 
 * It then starts again with the first two elements, compares, swaps until no 
 * more swaps are required. Once done sorting we want to print all the
 * millennium Years so will create a method within a condition that years % 1000 
 * if no reminder print the results. Then would want to get the statistics the 
 * mean, median, and standard deviation of the world population for the years 
 * ranging from -5000 to -1000, 1000 to 1900, and 2000 to 2020. Therefore, we 
 * would need to create three different arrays that would store the world 
 * population for the three different time periods. Then will create a method 
 * for the mean, median, and standard deviation and call the methods three 
 * separate times for the three different value parameters range of years. 
 * The mean that will be using is called the Arithmetic mean or sometimes called
 * the average, what it is sums up all the values and divides by how values
 * you have. The purpose of this method is to give us the estimated number of 
 * the world population for the different time periods. The Standard deviation
 * is a number used to tell how measurements for a group are spread out from the
 * average (mean), or expected value. The median is the value separating the 
 * higher half from the lower half or it may be thought of as the "middle" value.
 * Then will create another method called the least Square Regression which is 
 * the line that makes the vertical distance from the data points to the 
 * regression line as small as possible. It's called a “least squares” because 
 * the best line of fit is one that minimizes the variance. This would 
 * approximate the amount of world population as a function of the year if the 
 * growth of the population is liner.
 */
package worldpopulation;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class WorldPopulation {

    public static PrintStream stats;
    public static final int MAXNUMBER = 100;

    public static void main(String[] args) throws Exception {

        double[] year = new double[MAXNUMBER];

        double[] worldPopulation = new double[MAXNUMBER];

        double[] populationRange1 = new double[MAXNUMBER];

        double[] populationRange2 = new double[MAXNUMBER];

        double[] populationRange3 = new double[MAXNUMBER];

        int range1, range2, range3, count;

        stats = new PrintStream("Population.text");

        count = populateArray(year, worldPopulation);

        printMethod(year, worldPopulation, count);

        sortPopulation(year, worldPopulation, count);

        printMethod(year, worldPopulation, count);

        millennuimYears(year, worldPopulation, count);

        System.out.println("\n\n");

        range1 = rangeYears(year, worldPopulation, populationRange1, count, -5000, -1000);

        range2 = rangeYears(year, worldPopulation, populationRange2, count, 1000, 1900);

        range3 = rangeYears(year, worldPopulation, populationRange3, count, 2000, 2020);

        printStatistics(populationRange1, populationRange2, populationRange3, range1, range2, range3);

       leastSquareRegression(year, worldPopulation, count);

    }// End of main.

    // This Method is used to insert the values to the arrays from the text file.
    public static int populateArray(double[] year, double[] worldPopulation) throws Exception {

        int count = 0;
        String header;

        Scanner sc = new Scanner(new File("worldPopulation.txt"));

        header = sc.nextLine();

        while (sc.hasNext()) {
            year[count] = sc.nextDouble();
            worldPopulation[count] = sc.nextDouble();
            count++;
        }
        return count;

    }// End of populateArray Method

    // Method Print used to print the Years and Population.
    public static void printMethod(double[] year, double[] worldPopulation, double count) {

        stats.println("\nYear\t\t Population");
        stats.println("-----\t\t ------------");

        for (int i = 0; i < count; i++) {
            stats.printf("%,.0f\t\t %,.0f\n", year[i], worldPopulation[i]);
        }
        stats.println("------------------------------------");

    }//End of print Method.

    // This method is used to sort the years in ascending order.
    public static void sortPopulation(double[] year, double[] worldPopulation, double count) {
        int j, pass;
        double temp, hold;
        boolean switched = true;

        for (pass = 0; pass < count - 1 && switched; pass++) {
            switched = false;

            for (j = 0; j < count - pass - 1; j++) {

                if (year[j] > year[j + 1]) {

                    switched = true;
                    hold = year[j];
                    year[j] = year[j + 1];
                    year[j + 1] = hold;
                    temp = worldPopulation[j];
                    worldPopulation[j] = worldPopulation[j + 1];
                    worldPopulation[j + 1] = temp;
                }
            }
        }
    }//End of sortPopulation Method.

    // This method is used to print world population for every thounsand years.
    public static void millennuimYears(double[] year, double[] worldPopulation, double count) {

        stats.println("\nThe Millennium Years:");
        stats.println("\nYear\t\t Population");
        stats.println("-----\t\t ------------");

        for (int i = 0; i < count; i++) {
            if (year[i] % 1000 == 0 && !(year[i] == 0)) {
                stats.printf("%,.0f\t\t %,.0f\n", year[i], worldPopulation[i]);
            }
        }
        stats.println("------------------------------------");

    } // End of millennuimYears Method

    /* This method is used to store the world population to a new arrays for the range 
    of  years : -5000 to -1000, 1000 to 1900, and 2000 to 2020.
     */
    public static int rangeYears(double[] year, double[] worldPopulation, double[] populationRange,
            double count, double begining, double end) {

        int count2 = 0;

        for (int i = 0; i < count; i++) {

            if (year[i] >= begining && year[i] <= end) {

                populationRange[count2] = worldPopulation[i];

                count2++;
            }

        }
        return count2;
    }// End of RangeYears

    // The Method is used to calcuate the average of the World Population.
    public static double mean(double[] worldPopulation, double count) {

        double sum = 0, average;

        for (int i = 0; i < count; i++) {
            sum += worldPopulation[i];
        }
        average = sum / count;

        return average;

    }//End of Mean Method

    // The Method is used to calcuate the Standard Deviation of the World Population.
    public static double standardDeviation(double[] worldPopulation, double count) {

        double standerDv = 0, average;

        average = mean(worldPopulation, count);

        for (int i = 0; i < count; i++) {

            standerDv += Math.pow(worldPopulation[i]-average, 2);
        }
        standerDv = Math.sqrt(standerDv / count);

        return standerDv;

    }//End of Standered Deviation method 

    // The Method is used to calcuate the Median of the World Population.
    public static double median(double[] worldPopulation, int count) {

        double sumOfMiddleElements, median;

        medianSort(worldPopulation, count);

        if (count % 2 == 0) {
            sumOfMiddleElements = worldPopulation[count / 2] + worldPopulation[(count - 1) / 2];

            median = sumOfMiddleElements / 2;
        } else {
            median = worldPopulation[count / 2];
        }

        return median;

    }//End of Median method

    // This method is used to sort the world population in ascending order.
    public static void medianSort(double[] worldPopulation, double count) {
        int j, pass;
        double hold;
        boolean switched = true;

        for (pass = 0; pass < count - 1 && switched; pass++) {

            switched = false;

            for (j = 0; j < count - pass - 1; j++) {

                if (worldPopulation[j] > worldPopulation[j + 1]) {

                    switched = true;
                    hold = worldPopulation[j];
                    worldPopulation[j] = worldPopulation[j + 1];
                    worldPopulation[j + 1] = hold;
                }
            }
        }
    }// End of sortPopulation method.

    // This method is used to print the Statistical data of the world population for all 3 different time range.
    public static void printStatistics(double[] populationRange1, double[] populationRange2, double[] populationRange3,
            int range1, int range2, int range3) {

        stats.println("\nThe Statistics for the years -5000 through -1000:\n");

        stats.printf("Mean = %,.0f\t", mean(populationRange1, range1));

        stats.printf("Standard Deviation = %,.4f\t", standardDeviation(populationRange1, range1));

        stats.printf("Median = %,.0f\n", median(populationRange1, range1));

        stats.println("------------------------------------------");

        stats.println("\nThe Statistics for the years 1000 through 1900:\n");

        stats.printf("Mean = %,.0f\t", mean(populationRange2, range2));

        stats.printf("Standard Deviation = %,.4f\t", standardDeviation(populationRange2, range2));

        stats.printf("Median = %,.0f\n", median(populationRange2, range2));

        stats.println("------------------------------------------");

        stats.println("\nStatistics for the years 2000 through 2020:\n");

        stats.printf("Mean = %,.0f\t", mean(populationRange3, range3));

        stats.printf("Standard Deviation = %,.4f\t", standardDeviation(populationRange3, range3));

        stats.printf("Median = %,.0f\n", median(populationRange3, range3));

        stats.println("------------------------------------------");

    }// End of printStatistics.
   
    // This method is used to estimate the liner approximation of the world population as a function of years.
    public static void leastSquareRegression(double[] year, double[] worldPopulation, int count) {

        double[] yearSquare = new double[MAXNUMBER];

        double[] yearsPopulation = new double[MAXNUMBER];

        double sumXsquare, sumXy, sumX, sumY, slope, yAxis, yIntersept, xAxis;

        Scanner sc2 = new Scanner(System.in);

        sumX = sumYears(year, count);

        sumY = sumPopulation(worldPopulation, count);

        sumXsquare = sumYearsSqure(year, yearSquare, count);

        sumXy = sumYearsPopulation(year, worldPopulation, yearsPopulation, count);

       slope = slope(count,sumX,sumY,sumXsquare, sumXy );

       yIntersept= yIntersept(sumX, sumY, slope, count);

        stats.println("Please Enter the year you wish to get an estimated world population.");

        stats.println("Enter a zero when you want to stop.\n");

        xAxis = sc2.nextDouble();

        while (xAxis > 0) {

            stats.printf("For the year = %,.0f :\n", xAxis);

            yAxis = slope * xAxis + yIntersept;

            stats.printf("The estimated liner world population= %,.0f\n\n", yAxis);

            xAxis = sc2.nextDouble();
        }

    }// End of linerApproximation.

    // Method to calculate the Sum of all the years.
    public static double sumYears(double[] year, int count) {
        double sumYears = 0;
        for (int i = 0; i < count; i++) {
            sumYears += year[i];
        }
        stats.printf("\nsumYears= %,.0f\n\n", sumYears);

        return sumYears;

    }// End of sumYears.
   
    // Method to calculate the Sum of all the world Population.
    public static double sumPopulation(double[] worldPopulation, int count) {

        double sumPopulation = 0;

        for (int i = 0; i < count; i++) {
            sumPopulation += worldPopulation[i];
        }

        stats.printf("sumPopulation= %,.0f\n\n", sumPopulation);

        return sumPopulation;

    }// End of sumPopulation.
        
         // Method to calculate the Sum of all the years squared.
    public static double sumYearsSqure(double[] year, double[] yearSquare, int count) {

        int count2 = 0;
        double sumYearsSqure = 0;

        for (int i = 0; i < count; i++) {

            yearSquare[count2] = year[i] * year[i];

            sumYearsSqure += yearSquare[count2];

            count2++;
        }

        stats.printf("sumXsqure= %,.0f\n\n", sumYearsSqure);

        return sumYearsSqure;
    }// End of  sumYearsSqure.
    
         // Method to calculate the Sum of all the years multiplied by all the world population.
    public static double sumYearsPopulation(double[] year, double[] worldPopulation, double[] yearsPopulation, int count) {
        int count3 = 0;
        double sumyearsPopulation = 0;

        for (int i = 0; i < count; i++) {

            yearsPopulation[count3] = year[i] * worldPopulation[i];

            sumyearsPopulation += yearsPopulation[count3];

            count3++;
        }
        stats.printf("sumXy= %,.0f\n\n", sumyearsPopulation);

        return sumyearsPopulation;
    }// End of sumYearsPopulation.
    
       // Method to calculate the slope.
    public static double slope(int count, double  sumX, double sumY, double  sumXsquare, double sumXy ){
        
        double slope;
        
         slope = (count * sumXy - sumX * sumY) / (count * sumXsquare - sumX * sumX);
         
          stats.printf("slope= %,.0f\n\n", slope);
        
          return slope;
    }// End of slope.
    
    // Method to  calculate the yIntersept.
    public static double yIntersept(double sumX, double sumY, double slope, int count){
        
        double yIntersept;
        
       yIntersept = (sumY - slope * sumX) / count;
       
       stats.printf("yIntersept= %,.0f\n\n",  yIntersept);
       
        return  yIntersept;
        
    }//End of yIntersept.
    
    
}
