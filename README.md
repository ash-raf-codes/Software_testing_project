# SENG 275 Project Description
## Spring 2022

## Learning Objectives and Project Overview

*This group project is to be completed during the last two on campus labs (that is, face to face) with some additional individual work done outside lab hours.*

The goal of this project is for you to gain experience with testing a larger legacy software project and working as part of a team.  You will get a chance to review and reflect on some of the many testing techniques we have already covered in the course, and gain experience with some new methods, tools and technologies (notably database testing and static analysis).

Although writing and testing applications from scratch is important for an engineer to be able to do, the reality is that many engineers need to know how to understand existing code in a legacy system, and be able to evaluate how well tested this code is already, be able to make changes to an existing application, refactor the code that someone else wrote to improve it, and then test those changes and any future changes! Thus in this project, you will need to understand how existing applications and a library are tested.  In particular, for an application that is poorly designed (part of your task is to figure out why!), you will need to refactor this application so that it is "testable" and write tests so that this application is tested well.  You will need to write unit tests and integration tests as this application makes use of a charting library and a database. You will need to use mocks so that you can independently test core functionality in this application. 

Through this project, you will also get the opportunity to write and design a new application that uses an existing charting framework (see below) and a database (sqlite).  You will need to design this code so it is testable, and also write tests for this application and to check that how it interacts with the database is correct. Note that doing a good job on the group part above will make this part easier! 

Finally, you will use a number of tools and apply principles you have learned in this code to evaluate the quality of the code you and others in your team have written, and use insights from this to improve your application code and your tests. 

## Our Case Study for the Project: JFreeChart

The main focus for the project is JFreeChart. JFreeChart is an open source chart creation library (see https://www.jfree.org/jfreechart/) written in Java.  It is used to produce quality charts for a variety of applications and files. JFreeChart offers a programmable API (see 
https://github.com/jfree/jfreechart) for other developers to use and extend.  This framework supports many different (graphical) chart types, including pie charts, bar charts, line charts, histograms, and several other chart types. 
Given that it is designed to be used by other developers, its API is designed to be relatively easy to use.
Note that since JFreeChart is not a standalone program, a user of JFreeChart has created several demo classes which have been created to show off the capabilities of the framework.  These Demo classes have the name Demo appended to the class name.  Note that to do this project you do not need a full understanding of the entire JFreeChart API.  The framework has two main packages: 1) org.jfree.chart and 2) org.jfree.data.  Each of these packages is divided into smaller packages.

In this provided repository, we have included a number of Demo projects so you can explore how JFreeChart works!
You should also explore [JFreeChart](https://github.com/jfree/jfreechart) itself and look at how it is tested!  You will see that it has extensive tests. Although your project does not involve making changes to how JFreeChart itself is tested, you can learn a lot by examining the tests that are used! You can just explore it on GitHub or maybe download it and play with the tests they provide. 

For the purpose of this project, we have created a demo application that you can find in the DBChartSENG275 package (this is the initial system under test). This new demo program also connects to an sqlite database (called Chinook) that we have included also as part of this repository.  This application is poorly designed,  especially from evolution and testable perspectives!  Your first goal is to redesign it so that it is testable (namely by separating concerns). Your second goal is to write tests for the application that independently tests the logic in this program (summing up invoices per country), tests that the database works as expected (by testing adding, updating and deleting record operations from the database). Note the current application you are testing does not provide those methods, so you will need to add those.

More specifically, your goal is to understand and improve both PieChartDemowithDB and PieChartData and write code to test PieChartData (you will need to redesign PieChartData and make some improvements/changes to PieChartDemowithDB to ensure it is testable through a test class called PieChartDataTest).

We hope you can finish most of the above in the lab time - note there should be four of you all helping in parallel even if only one person is writing the code, the other three are working hard to figure out what needs to be done! This is a bit like a hackathon! What can you do in these precious two hours?

After the lab, you will each also write a new application that integrates a different JFreeChart chart and uses different data from the provided Chinook database.  What you do for this part is up to you!  Be creative! High marks will be awarded for creative solutions. You will also need to provide tests for this new application (which should be easier to write if you did a good job in Part1a). 

Finally, in part 2, you will use a number of quality tools and apply the principles you learned (see Week 10b slides and the associated reading) to evaluate the code and tests authored or changed for this project by yourself and the other members in your team.  After the second lab, each of you will write one more tests or improve an existing test in response to the analysis of the test code quality using the tools or by applying the principles from our course.  It is your choice how many tests you write - but to get a passing grade you should write at least one test, two for a B, three or more for an A grade.  

## Detailed description of individual and group tasks

The project consists of two main parts as follows.  

### Part 1a: Complete as a Group in Labs (2%)

Using the idea of [mob programming](https://www.agilealliance.org/pair-programming-versus-mob-programming/) (an extension of pair programming), you will together as a team to:
* redesign the code for PieChartData (keeping intact the logic for creating a pie chart of invoices summed per country) so that it is fully testable.
* You will need to write tests to test this logic in a way that it is independent from the database (you should use mocks for this).

Note: as you redesign this code and write tests, add the following to the documentation before each method: who exactly took turns as drivers and navigators (record times for when you switch - assign someone to be tracking this for you).  Everyone should be a driver for approximately 1/4 of the work done above - but at a minimum everyone should be a driver at some point.  Push your changes everytime you switch.

Due date: Submit what you have completed by the end of lab via Gitlab, and continue working on it if need be until the final deadline for Part 1 (see below). 

### Part 1b:  Individually completed after labs (5%)
* Each member should design and create a new application that uses a new chart type from JFreeChart and uses other data from the chinook database (we have provided some links with more examples of programs that use JFreeChart and there are samples in this repository).  Design this application in such a way that you can test it! As you also need to provide the necessary tests for the new application you write. Note you can likely reuse some tests from Part 1a.  We do not specify what you need to do! This is intentional.  Remember to add your name to the documentation before each of the new sections of code you wrote so that you will get your mark for this task. You should ensure that your code is easy to understand (how it is graded will rely on this aspect). 

Due date: Submit the code for parts 1a and 1b to Gitlab by Wednesday, March 30th at 5pm.  You can continue to make updates after this time and before the final deadline for part 2, but you need to submit something that is largely complete by March 30 or you will be at a disadvantage when working on Part 2.


### Part 2a:  Complete in groups in your lab but with individual responsibilities (3%) 
For this part of the lab, you will gain some experience evaluating the quality of the code you and others on your team have written (the production and test code). 
We will use some new tools we have not seen so far, and part of your work is to figure out how these tools work and what they tell you!  As an engineer you will constantly be exposed to new tools you will need to learn by yourself and will need to decide if those tools really help you.  You will also put the principles you learned about test code quality (from Week 10b) into practice! You need to document your activity for this part of the project in a lab report (shared by all members of the team but with indications of who did/wrote what).  This lab report may be found in the /doc directory in the root of your repository - there are four versions of this file, one for each group member.

* Run the [PMD plugin](https://plugins.jetbrains.com/plugin/1137-pmdplugin) in IntelliJ on the DBChartSENG275 package. In your report write out a description of the results you see (adding one or more screenshots to show us the results you initially saw) and each person in your team should individually describe at least one violation per top level category shown and explain what this violation means and if you consider a change should be made to the code (and why or why not). You can read more about PMD [here](https://pmd.github.io/).  Avoid duplicating your groupmates work - choose different violations.
* Run the [Spotbugs plugin](https://plugins.jetbrains.com/plugin/14014-spotbugs) on the Java package in the repository.  Take a snapshot of what you see and explore the different categories of bugs you see and explore some of them.  Next, run Spotbugs again on the code you and your team wrote. Take a snapshot of the results and add to your lab report. Again each team member should select 1 item for each category of potential buggy code that SpotBugs reports in your team code (note if your code is good you don't see interesting results, feel free to look at bugs that were found in other parts of the project) and describe what this error may mean and any change you may make to the code as a result.  We expect to see at least two or more unique bug reports discussed per team member in the report.   
* In Week 10b we discussed a number of principles for improving Test Code Quality (see the slides and course reading).  Each team member should consider at least three principles (not overlapping) and apply those to the test code a different team member wrote for Part one of the project. Again add your findings to the lab report clearly indicating for each team member which principles they applied and which code they applied them to (note apply these to other code a team member wrote). 
* Run the IntelliJ coverage tools for the tests your team wrote in Part 1. Do you see possibilities for improvements? Each member should add a summary of what you see to your individual report.   

* Before finishing this lab, as a group decide who will do what for Part2b so you do not make conflicting changes or write redundant code! 

For Part 2a, submit an interim version of your report to the teaching team immediately following your lab showing what you completed within the lab time. You can continue to update this until the final due date below.  

## Part 2b: Complete individually after the labs (2%)
* Using the insights from Part 2a, make changes to production code (or perhaps to the test code) that fixes or addresses one or more potential bugs or violations you found in Part 2a. Check if you need new tests or updated code. If no new tests are needed, argue why not in the report.   Submit this code via Gitlab. Make sure you describe in the documentation for this code what prompted you to make the change (from part 2a!).

The code you wrote for Part 2b and the final lab report for Part 2a should be submitted by April 8th, at 5pm.  No late submissions will be marked. Submit your work incrementally, we expect to see lots of commits along the way! 

### Due dates:
Part 1: There are two submissions for Part 1 (group code and individual code).
* Part 1a: The group contribution of code for Part 1a should be submitted by the end of your lab on March 23/24.  You can update this further after this time and resubmit it by Wednesday March 30th at 5pm (but only if you made an initial submission as indicated above).
* Part 1b: The individual code for this part needs to be submitted by Wednesday, March 30th at 5pm.  Again, you may update this before the final due date of April 8, but your work needs to be largely complete by March 30.

Part 2: There are also two submissions for Part 2 (a group report and individual code)
* Part 2a: Submit what you have completed by end of the lab on March 31st/April 1st (that is the early version of the report).  You can continue to improve this and resubmit by the latest Friday April 8th, 5pm (but only if you made an initial submission as indicated above).
* Submit your individual code submissions for Part 2b  by Friday, April 8th, 5pm.

### Submission instructions:
All your work must be part of this group repository, and must be pushed to gitlab by the due date in order to be marked.

### Important Notes:
* Late submissions are not permitted - submit what you have done by the due dates.
* If you or a team member become ill and cannot attend the lab or do their fair share of work, please let us know promptly via Teams - not doing this will lead to extra work for everyone involved. Not letting us know in advance means you may get zero on the project or one of its components.
* The project has individual and group components.  You need to let us know and attest how members contributed to each component and each assigned task (both in the documentation of the submitted code and in the lab report).
* The group aspect of this project is designed so you can learn from each other and help other, but not do the work for other members.  Individual grades will be assigned.
* The grading of this project will be subjective (refer to the [course outline](https://heat.csc.uvic.ca/coview/course/2022011/SENG275) for the grading rubric).  For example: An A level grade will only be awarded for work that is exceptional, outstanding or excellent performance. Doing the bare minimum will get you a passing grade. Show off your "testing chops" and use other concepts you learned throughout the course in creative ways to show you know these concepts (even if they are a bit overkill).  
* The project may, at first glance, seem like a lot of work but if you work incrementally and in the timeframe given, this is very doable! If you wait till the last minute, you will struggle. Ask for help early and consider questions you may have, so you can ask them in the labs.
* The amount of work you should do is not specified. This is to mimic the decisions you have to make in a real job.  But we have given hints above what is the minimum required. If you have questions about this, please ask on our Lab Team Channel so others can see the responses.

### Other programs in this repository

This repository also contains a copy of various demo programs for [JFree](http://www.jfree.org) / [Object Refinery](http://www.object-refinery.com) projects, including:
* [JFreeChart](https://github.com/jfree/jfreechart)
* [JFreeSVG](https://github.com/jfree/jfreesvg)
* [JFree PDF](https://github.com/jfree/jfreepdf)
* [Orson Charts](https://github.com/jfree/orson-charts)

We have copied these programs to this repository so you can explore and play with them! You may want to adapt one of these for Part 1b of your assignment.  If you reuse existing code for this part, make sure to mention this in your documentation! 

### Some useful links: 
* https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/ (we have set this up for you in the current project)
* https://www.jetbrains.com/help/idea/relational-databases.html#first-steps-with-goland
* https://www.javatpoint.com/java-sqlite (some hints in here how to interact with the database)
* https://zetcode.com/java/jfreechart/ (some examples of how to create charts using JFreeChart)
* https://www.tutorialspoint.com/jfreechart/jfreechart_bubble_chart.htm (More examples of how to create charts using JFreeChart)
* https://www.youtube.com/watch?v=BOoJQhDVcWg (more advanced tutorial how to use databases with IntelliJ with lots of useful productivity tips)