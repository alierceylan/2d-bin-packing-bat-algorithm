# 2D Bin Packing Using Simplified Discrete Bat Algorithm

This project focuses on solving the two-dimensional bin packing problem using a modified discrete bat algorithm.

## Overview

The goal is to place rectangles of different sizes into a fixed area while minimizing unused space.  

A simplified discrete version of the Bat Algorithm is proposed and compared with a Genetic Algorithm (GA).

## Features
- Solution of the 2D bin packing problem
- Implementation of Next-Fit Decreasing Height (NFDH) strategy
- Modified discrete Bat Algorithm (BA)
- Comparison with Genetic Algorithm (GA)
- Performance evaluation on multiple datasets

## Implementation
- Designed a simplified discrete Bat Algorithm adapted for combinatorial optimization
- Used NFDH strategy for rectangle placement
- Compared results with Genetic Algorithm
- Evaluated performance across multiple datasets
- Analyzed convergence speed and solution quality

## Technologies
- Java
- Evolutionary / metaheuristic algorithms
- Optimization techniques

## Description

The 2D bin packing problem is a well-known NP-hard optimization problem.  

This project proposes a modified version of the Bat Algorithm adapted for discrete optimization problems and demonstrates its effectiveness compared to traditional methods.

## Notes

The proposed algorithm achieves similar or better solutions compared to Genetic Algorithms, often reaching optimal solutions in fewer iterations.

## How to Run
- Compile the project:
```bash
javac *.java
```
- Run the program:
```bash
java BAT
```
