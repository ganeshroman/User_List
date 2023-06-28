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

#### Screenshots


<img src="https://github.com/ganeshroman/User_List/blob/6fc1f11e89713147eec613d967bd5bf35490fa8d/Screenshot_20230628_150547.png" width="250" height="450">

<img src="https://github.com/ganeshroman/User_List/blob/6fc1f11e89713147eec613d967bd5bf35490fa8d/Screenshot_20230628_150630.png" width="250" height="450">

<img src="https://github.com/ganeshroman/User_List/blob/6fc1f11e89713147eec613d967bd5bf35490fa8d/Screenshot_20230628_150707.png" width="250" height="450">







