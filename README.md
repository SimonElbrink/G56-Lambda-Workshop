# 📘 Workshop Lambda

First, create the necessary implementations inside `DataStorageImpl`.  
⚠️ *Note: One implementation is already present — it might help you get started!*

Once implementations are complete, proceed with the following exercises from the `Exercises` class.  
🧠 *You’ll need to define lambda expressions cleverly to succeed!*

---

## 🧪 Exercises

1. **🔍 Find by First Name**
  - Find everyone with `firstName: "Erik"` using `findMany()`.

2. **🚺 Find by Gender**
  - Find all **females** in the collection using `findMany()`.

3. **📅 Find by Birthdate**
  - Find everyone **born on or after** `2000-01-01` using `findMany()`.

4. **🆔 Find by ID**
  - Find the person with `id: 123` using `findOne()`.

5. **📝 Find and Map to String**
  - Find the person with `id: 456` and convert to the string:  
    `"Name: Nisse Nilsson born 1999-09-09"`  
    Use `findOneAndMapToString()`.

6. **👨‍💼 Filter & Map to String**
  - Find all **males** whose names start with “E”, and convert each to a string using `findManyAndMapEachToString()`.

7. **👶 Find Young People**
  - Find all people **under the age of 10** and convert to a string like:  
    `"Olle Svensson 9 years"`  
    Use `findManyAndMapEachToString()`.

8. **📣 Print by First Name**
  - Use `findAndDo()` to print all people with `firstName: "Ulf"`.

9. **🧩 Find Names within Names**
  - Use `findAndDo()` to print everyone whose `lastName` contains their `firstName`.

10. **🔁 Find Palindromes**
  - Use `findAndDo()` to print the `firstName` and `lastName` of everyone whose `firstName` is a **palindrome**.

11. **🗂️ Sort by Birthdate**
  - Use `findAndSort()` to find everyone whose `firstName` starts with “A”, **sorted by birthdate**.

12. **⏳ Sort Born Before 1950**
  - Use `findAndSort()` to find everyone **born before 1950**, **sorted in reverse** (latest to earliest).

13. **🔢 Custom Sort**
  - Use `findAndSort()` to sort everyone in the following order:  
    `lastName > firstName > birthdate`.