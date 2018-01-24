# Team 1701 (Robocubs) FIRST Power Up Robot Code

Welcome! This is our 2018 robot code for FIRST Power Up.

## New This Year

* We switched to Gradle and GradleRIO from [**@JacisNonsense**](https://github.com/JacisNonsense).
* We now use the Limelight vision coprocessor, instead of a RYO solution with an Nvidia Jetson TX1.
* We switched away from Eclipse to IntelliJ IDEA for perfect refactoring support and much better assistance in general. Thank you [**@JetBrains**](https://github.com/JetBrains)!

## Getting Started

Here is our not-so-famous 2-Step Setup~~®~~ (three, if you count IDE setup):

1. Open a terminal and clone the repository: `git clone https://github.com/Robocubs/2018RobotCode`
2. Set up Gradle:
    * On Windows platforms: `./gradlew.bat build`
    * On *valid* computing platforms: `./gradlew build`
3. (optional) Set up your IDE with `./gradlew idea`.

## Other Useful Gradle Targets

* `./gradlew build` simply builds the target, and downloads any new dependencies.
* `./gradlew build deploy` builds the target and deploys it to the roboRIO.
* `./gradlew --offline build deploy` builds the target and deploys it to the roboRIO *without checking for updates*. This is very useful at competition.

## Contact

* There is no guarantee of assistance, but if you need help, file an issue.
* This project is licensed under a 3-Clause BSD license (SPDX identifier BSD-3-Clause).
