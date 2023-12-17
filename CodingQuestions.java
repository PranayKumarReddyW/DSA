import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class CodingQuestions {
    public static void main(String[] args) {
        // BranchRegistrations();
        // MajorityParticpantsBranch();
        // arrangeColors();
        // maximumBloodTransfussions();
        // thirdMostExpensive();
        // sumOfMinMax();

    }

    public static void BranchRegistrations() {

        // 2.ADVITIYA - An event conducted by department of CSE(DS), is conducting
        // technical events and
        // non technical events.there are n participants participating in both technical
        // and non technical
        // events. ith index consists of department of ith participant. Now the head
        // organisers Manjunath
        // and Kareem wants to know the number of participants from each branch. Write a
        // program to help
        // Manjunath and Kareem in knowing the number of participants from each branch.
        // Input Format:
        // First line consists of integer n - n represents number of participants in
        // ADVITIYA.
        // Second line consists of n space separated names of branches.
        // Output Format:
        // Return each branch and its respective number of registrations
        // Test cases :
        // Input 1:
        // 10
        //
        // Output 1:
        // CE 1
        // CSE 4
        // EEE 1
        // ECE 2
        // ME 2

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of particpants: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Branches Separated by Spaces: ");
        String[] branches = new String[n];
        for (int i = 0; i < branches.length; i++) {
            branches[i] = sc.next();
        }
        sc.close();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < branches.length; i++) {
            map.put(branches[i], map.getOrDefault(branches[i], 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String branch = entry.getKey();
            int count = entry.getValue();
            System.out.println(branch + " " + count);
        }
    }

    public static void MajorityParticpantsBranch() {

        // 3.ADVITIYA - An event conducted by department of CSE(DS), is conducting
        // technical event and
        // non technical events.There are n number of participants participating in the
        // event. A department
        // is said to have majority participation if the number of participants of
        // particular branch is more than
        // half of the total number of participants.
        // The branch is denoted with its respective codes.
        // ECE - 4
        // CSE - 5
        // CSE(DS) - 32
        // MECH - 3
        // EEE - 2
        // CIVIL - 1
        // Find Whether any branch have majority participation, If yes print yes and
        // code of branch else print
        // no.
        // Input Format:
        // First line consists of integer n - n represents number of participants.
        // Second line consists of n space separated codes of branches.
        // Output Format:
        // If majority participation branch exists, print Yes and code of branch
        // Else print No

        // Test cases :
        // Input 1:
        // 10
        // 4 4 32 4 3 4 4 3 2 4
        // Output 1:
        // Yes 4

        // We use the Boyer-Moore Majority Vote Algorithm
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of particpants: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] branches = new String[n];
        System.out.println("Enter Branches Separated by Spaces: ");
        for (int i = 0; i < branches.length; i++) {
            branches[i] = sc.next();
        }
        sc.close();
        int votes = 1;
        String majorityBranch = branches[0];
        for (int i = 1; i < branches.length; i++) {
            if (votes == 0) {
                majorityBranch = branches[i];
                votes = 1;
            } else if (majorityBranch.equals(branches[i])) {
                votes++;
            } else {
                votes--;
            }

        }

        if (votes >= 1) {
            System.out.print("YES" + " ");
            System.out.println(majorityBranch);

        } else {
            System.out.println("NO");
        }

    }

    public static void arrangeColors() {
        // 4. While developing websites we use CSS for styling. As a part of styling in
        // CSS, a color can be
        // speci ed as an RGB value. There are n buckets of colors. Each bucket contains
        // only either red or
        // green or blue. We need to arrange the buckets in such a way that all red
        // buckets should be before
        // green and all green buckets should be before blue.
        // Input Format:
        // First line consists of integer n - n represents number of buckets.
        // Second line consists of n space separated colors representing color of
        // particular bucket.
        // Output Format:
        // Return all the buckets in Red Green Blue order.
        // Test cases :
        // Input 1 :
        // 6
        // blue red blue green green red
        // Output 1:
        // red red green green blue blue

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of colors: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter colors separated by spaces: ");
        String[] colors = new String[n];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = sc.next();
        }
        sc.close();
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (high >= mid) {
            if (colors[mid].equals("green")) {
                mid++;
            } else if (colors[mid].equals("red")) {
                String tempColor = colors[mid];
                colors[mid] = colors[low];
                colors[low] = tempColor;
                low++;
                mid++;
            } else {
                String tempColor = colors[mid];
                colors[mid] = colors[high];
                colors[high] = tempColor;
                high--;
                mid++;
            }
        }
        for (int i = 0; i < colors.length; i++) {
            System.out.print(colors[i] + " ");
        }
        sc.close();

    }

    public static void maximumBloodTransfussions() {
        // 5. Department of CSE(DS) conducted blood donation camp last year. In that
        // donation camp, the
        // following blood types are compatible :
        // - Blood type A donors can donate to recipients with blood types A and AB.
        // - Blood type B donors can donate to recipients with blood types B and AB.
        // - Blood type AB donors can donate to recipients with blood types AB only.
        // - Blood type O donors can donate to recipients with blood types A, B, AB and
        // O.
        // There are N people in the campus where the blood type of ith person is
        // denoted by Bi. Note that
        // the value of Bi can be A, B, AB, or O only.
        // A chain is formed when a donor can donate blood to a recipient, who in turn
        // can donate blood to
        // another recipient and so on.
        // Find the maximum number of people that can form a chain of blood
        // transfusions.
        // Input Format :
        // - First line contains a single Integer N, representing total number of
        // people.
        // - The next line contains N space separated strings Bi, denoting the blood
        // group of each person.
        // Output Format :
        // Print maximum number of people that can form a chain of blood transfusions.
        // Test cases :
        // Input 1 :
        // 3
        // A B A
        // Output 1 :
        // 2

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of people: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the blood groups of each person separated by spaces: ");
        String[] bloodGroups = new String[n];
        for (int i = 0; i < bloodGroups.length; i++) {
            bloodGroups[i] = sc.next();
        }

        int maxTransfussions = 0;
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < bloodGroups.length; i++) {
            if (bloodGroups[i].equals("O") || bloodGroups[i].equals("AB")) {
                maxTransfussions++;
            } else if (bloodGroups[i].equals("A")) {
                countA++;
            } else if (bloodGroups[i].equals("B")) {
                countB++;
            }

        }
        sc.close();
        System.out.println(maxTransfussions + Math.max(countA, countB));
    }

    public static void thirdMostExpensive() {
        // 6. ADVITIYA - An event conducted by department of CSE(DS), also want the
        // students of RGMCET
        // to develop their entrepreneur skills. As a part of this they allowed students
        // to establish stalls in the
        // ground. A student names Suresh established an ice-cream stall. There are N
        // types of ice-creams
        // with various costs. Surendra, other student wants to buy the 3rd most
        // expensive ice-cream from
        // top. i.e if there are ice-creams of cost 10,20,30,40 he would prefer eating
        // ice-cream with cost 20
        // because it is 3rd most expensive ice-cream from top. Surendra is confused
        // what would be the
        // cost of that ice cream, Help him nd the cost of it by writing a code.
        // Note : N will always be greater than 2.
        // Input Format:
        // - First line contains a single Integer N, N represents number of types of
        // ice-creams in the stall.
        // - Second line contains n space separated integers representing cost of each
        // ice cream.
        // Output Format:
        // Print the cost of third most expensive ice-cream
        // Test Cases :
        // Input 1 :
        // 3
        // 10 20 30
        // Output 1 :
        // 10

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of types of ice creams: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the cost of each ice cream, separated by space");
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
        }
        sc.close();

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < costs.length; i++) {
            set.add(costs[i]);
        }

        int count = 0;
        for (Integer num : set) {
            if (count == set.size() - 3) {
                System.out.println(num);
                break;
            }
            count++;
        }

    }

    public static void sumOfMinMax() {
        // 9. You are given an array of positive and negative integers of length N. Your
        // task is to add
        // maximum positive integer, maximum negative integer, minimum positive integer
        // and minimum
        // negative integer.
        // Note : if array contains only a single negative/positive integers, it is
        // treated as both maximum and
        // minimum.
        // Input Format :
        // - First line contains a single Integer N, where N represents length of Array.
        // - Second line contains N space separated Integers.
        // Output Format :
        // - Print the sum of maximum positive integer, maximum negative integer,
        // minimum positive integer
        // and minimum negative integer.
        // Test Cases :
        // Input 1 :
        // 5
        // 10 -10 20 -20 5
        // Output 1:
        // 0

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements separated by spaces: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int maxPositive = Integer.MIN_VALUE;
        int minPostive = Integer.MAX_VALUE;
        int maxNegative = Integer.MIN_VALUE;
        int minNegative = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (arr[i] < minPostive) {
                    minPostive = arr[i];
                } else if (arr[i] > maxPositive) {
                    maxPositive = arr[i];
                }
            } else if (arr[i] < 0) {
                if (arr[i] > maxNegative) {
                    maxNegative = arr[i];
                } else if (arr[i] < minNegative) {
                    minNegative = arr[i];
                }
            }

        }
        System.out.println(minNegative + +maxNegative + maxPositive + minPostive);
        sc.close();

    }

}
