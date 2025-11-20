<h1 align="center">Coder Vai</h1>
---
<h1 align="center">Static Modifiers</h1>

---

## What is `static`?

The `static` keyword in Java marks **class-level members**.
This means the member belongs to the **class itself**, not to each object.

---

# Static Variables (Class Variables)

* Shared by **all objects** of the class
* Memory allocated **only once** when the class is loaded
* Changing the value via one object affects all others
* Accessed using the class name

---

# Static Methods

* Can be called **without creating an object**
* Cannot access instance variables or instance methods directly
* Can only access:

    * static variables
    * other static methods

---


# Key Differences: Static vs Instance

| Feature                     | Static         | Instance        |
| --------------------------- | -------------- | --------------- |
| Memory Allocation           | Once per class | Once per object |
| Shared Between Objects      | ✔ Yes          | ✖ No            |
| Access Without Object       | ✔ Yes          | ✖ No            |
| Can Access Instance Members | ✖ No           | ✔ Yes           |

---

# ⭐ Summary

* `static` = **class-level**
* Saves memory, enables utility methods, and allows shared state
* Static methods **cannot use `this` or access non-static members**

---