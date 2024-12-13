# Test Cases for `Person` Class

## 1. Constructor

| **Test Case**      | **Input**                                                                 | **Expected Result**                                 |
|--------------------|---------------------------------------------------------------------------|---------------------------------------------------|
| Valid input        | Name: "Alice", Surname: "Smith", Birthdate: 1990-01-01, Nationality: "British" | Person created successfully                       |
| Empty name         | Name: "", Surname: "Smith", Birthdate: 1990-01-01                        | `IllegalArgumentException`: "Name cannot be empty" |
| Future birthdate   | Birthdate: 2030-01-01                                                   | `IllegalArgumentException`: "Birthdate cannot be in the future" |
| Null birthdate     | Birthdate: `null`                                                       | `IllegalArgumentException`: "Birthdate cannot be null" |

---

## 2. `isAdult` Method

| **Test Case**        | **Input (Birthdate)** | **Expected Result** |
|----------------------|-----------------------|----------------------|
| Exactly 18 years old | Today - 18 years      | `true`               |
| Less than 18 years old | Today - 17 years      | `false`              |
| More than 18 years old | Today - 19 years      | `true`               |

---

## 3. `isEuropean` Method

| **Test Case**          | **Input (Nationality)** | **Expected Result** |
|------------------------|-------------------------|----------------------|
| European nationality   | "British"              | `true`               |
| Non-European nationality | "American"             | `false`              |
| Case-insensitivity test | "british"              | `true`               |

---

## 4. `canEnrollDoctoralProgram` Method

| **Test Case**           | **Input (Degree)** | **Expected Result** |
|-------------------------|--------------------|----------------------|
| Doctorate               | `Degree.DOCTORATE` | `true`               |
| Master's degree         | `Degree.MASTER`    | `true`               |
| Undergraduate degree    | `Degree.GRADUATE`  | `false`              |
| No degree               | `Degree.NONE`      | `false`              |

---

## 5. `getAge` Method

| **Test Case**       | **Input (Birthdate)**   | **Expected Result** |
|---------------------|-------------------------|----------------------|
| Recent birthday     | Today - 25 years       | `25`                 |
| Upcoming birthday   | Today - 25 years + 1 day | `24`                 |
| Leap year birthdate | 2000-02-29             | Correct age (e.g., `24`) |
