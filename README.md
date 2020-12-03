# WorldPopulation
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
