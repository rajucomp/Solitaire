Code exercise:

The code base for this exercise is entirely fictional and very crappy on 
purpose. This app represents the back-end for a web app, it isn't really 
functional as a web app, but you should assume that running the App simulates
a user interaction with a web application. You can run it by executing
'mvn exec:java' on the command line in the project root, or by simply running
the main method of App.java.

The purpose of this excercise is to see how you solve the problems within the 
given context. There is no 'right' solution to any of the requests, so feel free
to 'solve' it in what you think is the best manner. Please try to commit early 
and often so we can get a feel for the process you went through. If you feel
there there are moments in which it would be necessary to communicate with the 
product owner please write these down in communications.txt (write down the 
assumed answer used to continue the excercise too).
 

The code represents the back-end of a website which allows the user to virtualy 
eat cheese. In order to supply the most realistic experience the amount of
portions available are based on virtual cheeses in the database, and  prices and
other info are realisticaly provided to the user.


= Request 1 =
Due to scarcity the price of manchego has gone up to 36.50$, this is not 
reflected in the application yet, please adjust it.

= Request 2 =
News of a swiss invention reached headquarters, we need to implement emmentaler 
in the cheese app, with a price of 34.50$ and 48 portions per wheel.


= Request 3 =
Cheese is nice, but appearantly people also like sausages! Please extends our webservice to also serve sausages.
We should at least offer frankfurters and bratwurst. (franfuters have 20 portions per box @ $1.50, bratwurst, 12 @ $2 per portion)

