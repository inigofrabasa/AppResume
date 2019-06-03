# App Resume

<b>App Resume</b> is an Android Application for create a Resume Profile with the chance to add different listed skills</b>

This project uses the <b>MVVM Architectural Pattern</b> with <b>SOLID principles.</b>

# Responsibility of each Layer in the Architecture Pattern

<b>The Model Layer:</b> This layer contains at the <b>the Business Model</b> a <b>Repository</b> and <b>Data Access Object</b> for the <b>Data Base</b> entity.
These entities are used for map the data for handling and is also resposible for fetching it from an API dummy.

<b>The ModelView Layer:</b> the responsability of this layer is to serve the data from the respository to the view and also to notify it when a change exist inside this data. Also handles changes on the data logic, like mutating the data doing operatios on them from the repository.

<b>The View Layer:</b> the responsability of this layer is only for display user interface and handle user input, is the visual communicaton from the user to the application, this layer is aware of data changing to represent it in a reactive form. Also it handles animations and transitions between views.

# SpecialMovies uses following Features

- Android<br />
- Kotlin<br />
- Jetpack<br />
- Architectural Components<br />
- MVVM<br />
- LiveData<br />
- DataBinding<br />
- Reactive Programming<br />
- Activity<br />
- Fragment<br />
- ROOM
- Dao
- WorkManager
- SOLID<br />

# App Screenshots

<table style="width:100%">
  <tr>
    <th><img src="https://github.com/inigofrabasa/AppResume/blob/master/0001.png" width="250"/></th>
    <th><img src="https://github.com/inigofrabasa/AppResume/blob/master/0002.png" width="250"/></th>
    <th><img src="https://github.com/inigofrabasa/AppResume/blob/master/0003.png" width="250"/></th>
    <th><img src="https://github.com/inigofrabasa/AppResume/blob/master/0004.png" width="250"/></th>
  </tr>
</table>
