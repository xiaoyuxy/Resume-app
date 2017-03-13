# Resume-app
This is an android mobile application developed by an android studio. This app mainly uses to show personal resume through mobile, to showcase some of the newer Material Design features, third-party libraries, etc. The data in this app is independent with UI. You can instead of the content for your resume via JSON file.

# Components
This application including:
- Homepage: The brief introduction of myself
- Navigation bar:  provide up navigation in this app, provide navigation forward and backward between an application.
- Education Page: show your education experiences 
- Work Page: show your work experiences
- Project Page: list school project experiences
- Awards Page: show awards
- Share feature: share my resume
- Send me Email feature: contact me through Email.

# Library
This application uses below library:
- Picasso
- appcompat
- design
- recyclerview
- junit.

# Code 
Java file :
- MainActivity.java: application entrance
- CircleTransform.java: mainly to resize the avatar
- Resume.java:parse the json file into lists
- UI:\*Education.java
   \*Work.java
   \*Project.java
   \*Award.java
   \*Share.java
   \*Send.java

Assets folder: 
- resume.json : data json file, replace your own resume here

Res folder:all the xml file are store in this folder

Mainfests folder:
- AndroidMainfest.xml : category of my app

Gradle Scripts: 
- app libraries are declared here
   



