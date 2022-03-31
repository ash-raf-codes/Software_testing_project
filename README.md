# SENG 275 Project Description
## Spring 2022
## Updated March 31th, 2022! 

Update: you now have a Part_2_Plan.txt file in your top-level directory - use this to document your plans for part 2.  Which chart type will you use, and what are you planning to use from the database?  How will you divide up the work?

You also have a new package folder in the src/main tree of your repository, named SENG275_Part2.  Write your application for Part 2 in this package.

## Learning Objectives and Project Overview

*This group project is to be completed during the last two on campus labs (that is, face to face) with some additional individual work done outside lab hours.*

The goal of this project is for you to gain experience with testing a larger legacy software project and working as part of a team.  You will get a chance to review and reflect on some of the many testing techniques we have already covered in the course, and gain experience with some new methods, tools and technologies (notably database testing and static analysis).

Although writing and testing applications from scratch is important for an engineer to be able to do, the reality is that many engineers need to know how to understand existing code in a legacy system, and be able to evaluate how well tested this code is already, be able to make changes to an existing application, refactor the code that someone else wrote to improve it, and then test those changes and any future changes! Thus in this project, you will need to understand how existing applications and a library are tested.  In particular, for an application that is poorly designed (part of your task is to figure out why!), you will need to refactor this application so that it is "testable" and write tests so that this application is tested well.  You will need to write unit tests and integration tests as this application makes use of a charting library and a database. You will need to use mocks so that you can independently test core functionality in this application. 

Through this project, you will also get the opportunity to write and design a new application that uses an existing charting framework (see below) and a database (sqlite).  You will need to design this code so it is testable, and also write tests for this application and to check that how it interacts with the database is correct. Note that doing a good job on the group part above will make this part easier! 

## Our Case Study for the Project: JFreeChart

The main focus for the project is JFreeChart. JFreeChart is an open source chart creation library (see https://www.jfree.org/jfreechart/) written in Java.  It is used to produce quality charts for a variety of applications and files. JFreeChart offers a programmable API (see 
https://github.com/jfree/jfreechart) for other developers to use and extend.  This framework supports many different (graphical) chart types, including pie charts, bar charts, line charts, histograms, and several other chart types. 
Given that it is designed to be used by other developers, its API is designed to be relatively easy to use.
Note that since JFreeChart is not a standalone program, a user of JFreeChart has created several demo classes which have been created to show off the capabilities of the framework.  These Demo classes have the name Demo appended to the class name.  Note that to do this project you do not need a full understanding of the entire JFreeChart API (actually for the most part you don't need to know much of it at all!).  The framework has two main packages: 1) org.jfree.chart and 2) org.jfree.data.  Each of these packages is divided into smaller packages.

In this provided repository, we have included a number of Demo projects so you can explore how JFreeChart works!
You should also explore [JFreeChart](https://github.com/jfree/jfreechart) itself and look at how it is tested!  You will see that it has extensive tests. Although your project does not involve making changes to how JFreeChart itself is tested, you can learn a lot by examining the tests that are used! You can just explore it on GitHub or maybe download it and play with the tests they provide. 

For the purpose of this project, we have created a demo application that you can find in the DBChartSENG275 package (this is the initial system under test). This new demo program also connects to an sqlite database (called Chinook) that we have included also as part of this repository.  This application is poorly designed,  especially from evolution and testable perspectives!  Your first goal is to redesign it so that it is testable (namely by separating concerns). Your second goal is to write tests for the application that independently tests the logic in this program (summing up invoices per country). 

More specifically, your goal is to understand and improve both PieChartDemowithDB and PieChartData and write code to test PieChartData (you will need to redesign PieChartData and make some improvements/changes to PieChartDemowithDB so that it will still work with the changes you make to PieChartData (so that PieChartData is tested).  Note: your focus is to test PieChartData *not* PieChartDemowithDB. 

We hope you can finish most of the above in the lab time - note there should be four of you all helping in parallel even if only one person is writing the code, the other three are working hard to figure out what needs to be done! This is a bit like a hackathon! What can you do in these precious two hours?  But you can continue as a group after the lab (as long as you committed at the end of your lab!) and make even more improvements to how it is tested!  For this, we need you to keep track of individual contributions so we can award high marks to the people that go above and beyond the bare minimum. 

In the second lab, you will together design and write a new application that integrates a different JFreeChart chart and uses different data from the provided Chinook database.  What you do for this part is up to you!  Be creative! High marks will be awarded for creative solutions. You will also need to provide tests for this new application (which should be easier to write if you did a good job in Part1).  Again, you can continue working on this until the deadline (see below) but again we ask you to keep track of individual contributions as high marks will be awarded for those extra features and tests you add!  Recall the course is about testing, so focus more on testing aspects than fancy visualizations! 

## Detailed description of individual and group tasks

The project consists of two main parts as follows.  

### Part 1: Complete as a Group in Labs (2%) and continue after the lab as a group or as individuals (4%)

Using the idea of [mob programming](https://www.agilealliance.org/pair-programming-versus-mob-programming/) (an extension of pair programming), you will together as a team to:
* redesign the code for PieChartData (keeping intact the logic for creating a pie chart of invoices summed per country) so that it is fully testable.
* You will need to write tests to test this logic in a way that it is independent from the database (you should use mocks for this).

Note: as you redesign this code and write tests, add the following to the documentation before each method: who exactly took turns as drivers and navigators (record times for when you switch - assign someone to be tracking this for you).  Everyone should be a driver for approximately 1/4 of the work done above - but at a minimum everyone should be a driver at some point.  Push your changes everytime you switch.

Due date: Submit what you have completed by the end of lab via Gitlab, and continue working on it if need be until the final deadline for Part 1 (see below). 

### Part 2:  Started as group in lab (2%) and continued as a group or individually completed after labs (4%)
* Each group should design and create a new application that uses a new chart type from JFreeChart and uses other data from the chinook database (we have provided some links with more examples of programs that use JFreeChart and there are samples in this repository).  Design this application in such a way that you can test it! As you also need to provide the necessary tests for the new application you write. Note you can likely reuse some tests from Part 1.  We do not specify what you need to do! This is intentional.  Remember to add your name to the documentation before each of the new sections of code you wrote so that you will get your mark for this task. You should ensure that your code is easy to understand (how it is graded will rely on this aspect). 

Due dates: Submit the code for part1 to Gitlab by Wednesday, March 30th at 5pm.  You can continue to make updates after this time and before the final deadline for part 2, but you need to submit something that is largely complete by March 30 or you will be at a disadvantage when working on Part 2.
Submit your work for Part 2 at the end of the lab, and submit the final code and reports by 
April 8th, at 5pm.  No late submissions will be marked. Submit your work incrementally, we expect to see lots of commits along the way! 

### Due dates:
Part 1: Submit what your group has completed by the end of your lab on March 23/24.  You can continue to make changes until March 30th at 5pm  
(but only if you made an initial submission as indicated above).

Part 2: Again, 
Submit what you have completed by end of the lab on March 31st/April 1st.  You can continue to improve this and resubmit by the latest Friday April 8th, 5pm (but only if you made an initial submission as indicated above).

### Submission instructions:
All your work must be part of this group repository, and must be pushed to gitlab by the due date in order to be marked.  You must put comments in your code as you work to indicate which of your group members have contributed to each section of code you write or modify.  Augment these comments with commit messages reporting who has done which part of the commit.  We will use this information to help us evaluate how effectively your group has shared the labour. 

### Important Notes:
* Late submissions are not permitted - submit what you have done by the due dates.
* If you or a team member become ill and cannot attend the lab or do their fair share of work, please let us know promptly via Teams - not doing this will lead to extra work for everyone involved. Not letting us know in advance means you may get zero on the project or one of its components.
* If groups have fewer members we will take this into account in our grading. 
* Grades may not be evenly distributed among group members.  You need to document who does what and when to receive any grades.  This should be clear in the comments of your code and in your commit messages.  
* The group aspect of this project is designed so you can learn from each other and help other, but not do the work for other members.  Individual grades will be assigned.
* The grading of this project will be subjective (refer to the [course outline](https://heat.csc.uvic.ca/coview/course/2022011/SENG275) for the grading rubric).  For example: An A level grade will only be awarded for work that is exceptional, outstanding or excellent performance. Doing the bare minimum will get you a passing grade. Show off your "testing chops" and use other concepts you learned throughout the course in creative ways to show you know these concepts (even if they are a bit overkill).  
* The project may, at first glance, seem like a lot of work but if you work incrementally and in the timeframe given, this is very doable! If you wait till the last minute, you will struggle. Ask for help early and consider questions you may have, so you can ask them in the labs.
* The amount of work you should do is not specified. This is to mimic the decisions you have to make in a real job.  But we have given hints above what is the minimum required. If you have questions about this, please ask on our Lab Team Channel so others can see the responses.
* If you are using IntelliJ Ultimate, you can view the contents and structure of the database (chinook.db) using the Database tab, which is along the right edge of your IDE (you will need to 'add a data source from path' using the plus icon, and might need to download some drivers).  If you're using the community edition instead, you can install a plugin for IntelliJ (Settings/Preferences -> Plugins) called Database Navigator from the Marketplace pane.  Again you'll need to specify the path to the database in the DB Navigator pane that will appear on the left edge of your IDE.

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