# Problem Set 8: Travelling Salesman Problem

This repository is solely meant for NUS students who are taking CS2040S. The purpose of this
repository is to provide a test file for students' implementation of TSPGraph.java.

1. Note that time complexity tests does not test for the correctness of the algorithm. It only tests for the time complexity of the algorithm.
2. Time complexity test for MST and TSP can run for a long time. It took 1 minute plus for each of them on my PC. You can comment out the time complexity test for 10000 input size if you want to run the test faster. However, to better analyze time complexity, you should perform more tests with larger input sizes (the 10000 one) and observe if the time growth trends towards the expected O(n^2 \* log n) complexity.
3. Time complexity test for isValidTour and tourDistance can occasionally give false negatives due to the randomness of timing recorded. But 9/10 times your code should pass the test. If you are sure that your code is correct, you can comment out the time complexity test for these two methods.

| Test | Time taken   | Expected time growth | Actual time growth |
| ---- | ------------ | -------------------- | ------------------ |
| 1    | 0.016115100  | 5.204120             | 1.118196           |
| 2    | 0.036478400  | 8.161659             | 2.263616           |
| 3    | 0.073478600  | 4.708735             | 2.014304           |
| 4    | 0.886404600  | 150.000000           | 12.063439          |
| 5    | 74.282491200 | 133.333333           | 83.802015          |

## How to Download

### To download the repository, follow these steps

1. Go to the main page of the repository.
2. Click on the green "Code" button on the top-right corner.
3. Select "Download ZIP" from the dropdown menu.
4. Extract the downloaded ZIP file to your desired location.

### Alternatively, you can use Git to clone the repository

```bash
git clone https://github.com/ForAeons/CS2040S_ay2023s2_ps8_testcases.git
```

## How to Contribute

There are two ways to contribute to this repository:

### Fork and Merge Request

Fork the repository by clicking the "Fork" button at the top-right corner of the main page.
Clone your forked repository to your local machine.
Make your changes and commit them to your forked repository.
Create a pull request from your forked repository to the original repository.
Wait for the maintainer to review and accept the merge request.

### Email Contribution

If you prefer not to use the fork and merge request method, you can send your email to the me and I will invite you to be a contributor. You can push changes directly to the repository.

## Description

TSPGraphTester.java is a JUnit test file that contains multiple test cases to check the functionality and performance of the student's implementation of TSPGraph.java. The test cases cover various aspects, such as time complexity, validity of the tour, and tour distance calculation. In addition, there is an encouraging test case at the end, reminding students that they can overcome any challenges they face during the implementation process.
