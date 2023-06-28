# User List Demo


## Summary
- **Summary:**  Android App showing list of Users, Search/Filter by name and show details on Click of List Item
- **Created Date:** 28 June 2023
- **Last modified:** 28 June 2023 

## Feature
- Retrieve and display a list of items from a RESTful API (https://gorest.co.in/public/v2/users).
- Implement a search functionality to filter the items based on a specific criterion (e.g., gender, status, name).
- Show detailed information about each item when selected from the list.




### Technology Used
- Kotlin
- MVVM
- Retrofit
- Data Binding
- Dialog Fragment
- RecyclerView
- Card View
- Live Data
- Constraint Layout
- TextInputField

### Backend Details

- **Webservice** : https://gorest.co.in/public/v2/users


#### Example Model


```
{
        "id": 3291839,
        "name": "Daevika Pilla Jr.",
        "email": "jr_daevika_pilla@feeney-satterfield.test",
        "gender": "female",
        "status": "active"
    }

```

```
data class User (
    val id:Long,
    val name:String,
    val email:String,
    val gender:String,
    val status:String
)
```

- **Library Imports**
  
```
    def lifecycle_version = "2.2.0"
    def kotlin_version = '1.3.72'
    def retrofit_version = "2.9.0"
    def logging_version = "4.3.1"

    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'

    // - - ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // - - LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    // cardview
    implementation 'com.google.android.material:material:1.2.1'

    // - - Retrofit2
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.squareup.okhttp3:okhttp:$logging_version"
    implementation "com.squareup.okhttp3:logging-interceptor:$logging_version"

```


#### Project Structure



<img src="https://github.com/ganeshroman/User_List/blob/c0c8f88fa66d3e0b603f12a5c8577414ba55d06d/Screenshot%202023-06-28%20at%204.18.52%20PM.png" width="250" height="450">


#### Screenshots


<img src="https://github.com/ganeshroman/User_List/blob/6fc1f11e89713147eec613d967bd5bf35490fa8d/Screenshot_20230628_150547.png" width="250" height="450">

<img src="https://github.com/ganeshroman/User_List/blob/6fc1f11e89713147eec613d967bd5bf35490fa8d/Screenshot_20230628_150630.png" width="250" height="450">

<img src="https://github.com/ganeshroman/User_List/blob/6fc1f11e89713147eec613d967bd5bf35490fa8d/Screenshot_20230628_150707.png" width="250" height="450">







