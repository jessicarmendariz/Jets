# Jets

### Overview
Jets is an application where data for Cargo Planes and Fighter Jets can be stored and viewed. The United States Military utilizes a variety of aircraft for a diverse mission set. The information in the following application can help logistics decide which aircraft to use.


### How To Use
Jets will open up with a 10 option menu. The options are as follows: 
1) List Fleet - This option will list all the current aircrafts in your fleet. It will print out the Model, Speed, Range, and Price of each aircraft. 
2) Fly All Jets - How Long Can They Fly? This option will calculate the maximum air time for each aircraft based on the maximum speed and maximum combat range of each aircraft.
3) View Fastest Jet - This option will print out the fastest aircraft in your current fleet in terms of miles per hour (MPH). 
4) View Fastest Jet in MACH SPEED - This option will also print out the fastest aircraft in your current fleet, the only difference is it will print the speed in terms of MACH SPEED.
5) View Jet with Longest Combat Range - This option will print the aircraft with the longest combat range in terms of miles.
6) Load All Cargo Planes - This option prepares all Cargo Planes to be fueled up and ready to receive Paratroopers. Jumping out of a spacious Cargo Plane beats a cramped one any day.
7) DOGFIGHT! - This option will begin a simulation where the Fighter Jets get to show off their skills and practice some new maneuvers. You'll recognize the sound of their engines whizzing by and hear the pilots announce "FOX 2, Fight's On" which initiates the simulation or canned exercise.
8) Add Jet - This option will allow the user to update their fleet and add any new aircrafts. They will enter the model, speed, range, and price.
9) Remove Jet - This option will allow the user to remove any aircraft that they no longer have in their fleet. It is a quick option which allows users to always have the most up to date data.
10) Quit - This option ends the application. Thanks for Flying with Armendariz Airways!


### Building Jets
I started building Jets in my head in the beginning. I read through all the User Stories and tried to figure out how many classes I would need, which methods I would need to run, and how I could structure the application. I struggled with an initial outline and had to go back a few times and rewrite and rework some of the framework. The pieces that I struggled the most with were the classes and methods. 

Using the interfaces and implementing two unique methods (Load All Cargo Planes & DOGFIGHT) were so much simpler than I had thought they would be in my head. I messed around with different code for a long time before I was finally able to create something short and sweet. These two methods have their own classes - something I find to be very confusing and it still throws my organization out of whack. I am not personally a fan of UML diagrams so it wasn't something I used in my outline for these two classes.

Problem: I could not get Menu Option 2 to work. I wasn't sure why after selecting Option 2 the only Sysout was "Fly All Jets". 
Solution: I forgot to actually call the method "fly()" and just added a Sysout that said "Fly All Jets". Coding when tired can be dangerous.

Problem: For the life of me I could not import the text file. I tried moving it around, renaming it, creating a stack trace to see where I went wrong. I googled importing files on Java and tried multiple solutions listed on Oracle and other resource sites. I could not get it to work.
Solution: In the end, I slacked out a request for help and a classmate of mine made a simple suggestion: move it to the root directory - it worked.

It would have been nice to work on the Stretch Goals and User Stories 12-15 but I ran out of time and hopefully will be able to come back to it later.