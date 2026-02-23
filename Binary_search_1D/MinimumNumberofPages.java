package Binary_search_1D;
// Problem Statement:Given an array‘arr of integer numbers,‘ar[i]’represents the number of pages in the‘i-th’book.There are a‘m’number of students,and the task is to allocate all the books to the students.Allocate books in such a way that:

// Each student gets at least one book.Each book should be allocated to only one student.Book allocation should be in a contiguous manner.

// You have to allocate the book to‘m’students such that the maximum number of pages assigned to a student is minimum.If the allocation of books is not possible.return-1
public class MinimumNumberofPages {
    public static void main(String[] args) {
        int arr[] = { 25, 46, 28, 49, 24 };
        int m = 4;

        // int ans = brute(arr, m);
        int ans = optimal(arr, m);
        System.out.println("minimum maximum pages allocated  " + ans);
    }

    // m is the number of students
    // brute force is simple we try from maximum the single person can hold whose
    // value is maximum element from the array
    // till where the ranage goes ? when we allocate every book to single person
    // which is summation of every element in the array
    public static int brute(int[] arr, int m) {

        // answer not possible in this scnerio
        if (m > arr.length)
            return -1;

        // finding low and high

        int maxElem = Integer.MIN_VALUE;
        int sumElem = 0;
        for (int x : arr) {
            if (x > maxElem) {
                maxElem = x;
            }
            sumElem += x;
        }

        int low = maxElem;
        int high = sumElem;

        // now we got the range, we design a new functin which will return the count of
        // student for given pages we assign

        for (int i = low; i <= high; i++) {

            if (m == countStudents(arr, i))
                return i;
        }
        return -1;
    }

    public static int countStudents(int[] arr, int pages) {

        int student = 1;
        int countpageWstudent = 0;
        for (int i = 0; i < arr.length; i++) {
            if (countpageWstudent + arr[i] <= pages) {
                countpageWstudent += arr[i];
            } else {
                student++;
                countpageWstudent = arr[i];
            }
        }
        return student;
    }

    // optimising this is simple we have range of answers we have to find the
    // minimum number of maximum pages pages
    // for any given specific page mid if we get the answer we trim down the right
    // search space to see if we can minimixe the pages allocation
    // if we don;t get the answer we trim down the left search space and try to
    // increase the count of page and find the answer

    public static int optimal(int[] arr, int m) {
        if (m > arr.length)
            return -1;

        int maxElem = Integer.MIN_VALUE;
        int sumElem = 0;
        for (int x : arr) {
            if (x > maxElem) {
                maxElem = x;
            }
            sumElem += x;
        }

        int low = maxElem;
        int high = sumElem;
        int minAns = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            int countofStudent = countStudents(arr, mid);
            if (countofStudent <= m) {
                if (mid < minAns) {
                    minAns = mid;
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return minAns != Integer.MAX_VALUE ? minAns : -1;
    }

}
