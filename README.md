# ML_Android_Application
Senior Design

Project Members:
Hugo Day, Gabby Whitis, B.J. Pemberton

Project Description:
Our project is an android application that uses machine learning models to process camera input and identify trees based on a dataset that we collected ourselves.

Features:
Android Application that uses the camera to get data input for machine learning model. The machine learning model processes the data input, and returns data output. The data output gives us confidence intervals to figure out what tree the data input most likely is. This data is processed and continuously updated and displayed at the bottom of the main app screen. This allows the user to be able to see what type of tree they are most likely looking at. The second screen is a wikipedia esque page about each type of tree.

One main drawback is that our database is not yet fully equipped. We currently have 7 types of trees within our database. If a tree the camera is shown is not one of these 7, then it will just show whatever tree it mostly closely looks like.

Trees currently in Database:
Sugar maple, Red maple, Redbud, Black cherry, Black Walnut, White ash, Yellow poplar

Requirements:
1. Identification accuracy: application accurately displays top 3 most likely tree matches with percentage of confidence
  - Requirement is almost met, but tree model is currently being built and inserted     into design
  
2. Image recognition capabilities: The app should be able to use the phone camera to take a photo of a tree's bark and match it to the closest species in the database.
  - Requirement is almost met, need to test to make sure model is accurate.
  
3. A database of tree 5 popular local Indiana tree species: The app should have a comprehensive and up-to-date database of 5 popular local Indiana tree species, with high-quality images of the bark of each species. We will target 10 trees per species.
  - Requirement is met, dataset is created and being built into a model.
  - Now using 7 types of trees found in West Lafayette.
  
4. User-friendly interface: The app should have a user-friendly interface that is easy to navigate and understand, even for users who are not experts in tree identification.
  - Requirement is met.
  
5. Application will be deployable on an Android phone and available offline
  - Requirement is met.
  
6. Additional information: The app should provide additional information about the tree species including the common and scientific name, geographic range, and interesting facts.
  - Requirement is currently being processed into application, but is basically         completed.
