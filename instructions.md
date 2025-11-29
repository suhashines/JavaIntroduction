# Java Installation for windows

## [Click on this link if you are using linux](https://youtu.be/UwytmFFQF6Y?si=a71aj1We_oe-oUGN)


# 1) Pick & install a JDK (Java Development Kit)

You need a JDK to compile and run Java code. Two safe options are the official OpenJDK builds or vendor builds (Microsoft Build of OpenJDK, Oracle, Temurin, etc.). I’ll point to OpenJDK and Microsoft as examples — both are production-ready.

1. Open a browser and download a JDK:

   * OpenJDK builds: go to the [this link](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html) and download the **Windows x64** installer `.msi`/`.exe`.
   
   

2. Run the installer you downloaded:

   * Double-click the `.msi` or `.exe`.
   * Accept the license, choose the default install folder (e.g. `C:\Program Files\Java\jdk-...`) and finish the installer.

3. Verify the install (Command Prompt):

   * Open **Start → type `cmd` → Enter** to open a Command Prompt.
   * Type:

     ```
     java -version
     javac -version
     ```

     You should see version output (e.g. `openjdk version "18.0.2.1"` or similar). If both commands print versions, the JDK is installed and on your PATH.

If `java` or `javac` is not found, continue to next step to set environment variables.

---

# 2) (If needed) Set `JAVA_HOME` and put Java on your PATH

Some tools expect `JAVA_HOME` to be set. Windows often sets `java` automatically, but here’s how to set it manually.

1. Find the JDK installation folder — usually:
   `C:\Program Files\Java\jdk-<version>` or similar (check the folder you noted during install).

2. Open System Environment Variables:

   * Press **Windows key**, type **“Environment Variables”**, then select **Edit the system environment variables**.
   * In the System Properties window click **Environment Variables…**

3. Add `JAVA_HOME`:

   * Under **System variables** click **New…**
   * Variable name: `JAVA_HOME`
   * Variable value: the JDK folder path, e.g. `C:\Program Files\Java\jdk-18.0.2.1`
   * Click **OK**.

4. Add `%JAVA_HOME%\bin` to PATH:

   * In **System variables** find `Path`, select it and click **Edit…**
   * Click **New**, paste: `%JAVA_HOME%\bin`
   * Click **OK** all the way out.

5. Open a new Command Prompt (important — it picks up updated variables) and run:

   ```
   java -version
   javac -version
   ```

   Both should now report versions.


---

# 3) Install IntelliJ IDEA (Community Edition)

IntelliJ is a very popular IDE for Java. The Community edition is free and fine for learning Java.


1. Download IntelliJ IDEA Community:

   * Go to JetBrains' download page and choose **Community/Ultimate** for Windows.
   [Follow this link for premium edition](https://www.jetbrains.com/idea/download/other.html) <br>
   [Follow this link for community edition](https://www.jetbrains.com/idea/download/?section=windows)

2. Run the IntelliJ installer:

   * Double-click the downloaded `.exe`.
   * During setup you can:

     * Create Start Menu entry — your choice.
     * Add **“Open Folder as Project”** (handy).
     * Add the launcher to PATH? (optional)
     * Associate `.java` files — optional.
   * Finish install and launch IntelliJ.

3. First launch:

   * IntelliJ may ask about settings/imports. For a fresh install choose **Do not import settings**.
   * You’ll see the Welcome screen.


---

# 4) Create your first Java project in IntelliJ and run Hello World

I’ll give the exact clicks from the IntelliJ Welcome screen.

1. From IntelliJ Welcome screen click **New Project**.

   * In the New Project dialog choose **Java** on the left.
   * For **Project SDK** choose the JDK you installed. If the SDK list is empty click **Add JDK** and navigate to the JDK folder (`C:\Program Files\Java\jdk-...`).
   * Leave the build system as IntelliJ (or Gradle/Maven if you want, but not necessary for Hello World).
   * Click **Next** or **Create**.

2. Create a package and Java class:

   * In the Project tool window (left side) right-click `src` → **New → Package**. Give it a name like `com.example.helloworld` (or skip packages and use default).
   * Right-click the package → **New → Java Class** and name it `Main` (or `HelloWorld`).

3. Type the Hello World program (IntelliJ may auto-generate a `main` for you if you choose “Create main class”):

   ```java
   package com.example.helloworld; // only if you created a package

   public class Main {
       public static void main(String[] args) {
           System.out.println("Hello, World!");
       }
   }
   ```

4. Run the program:

   * Right-click inside the editor and choose **Run 'Main.main()'**, or click the green run triangle in the gutter next to the `main` method, or press **Shift+F10** (default).
   * The **Run** tool window will open at the bottom and show:

     ```
     Hello, World!
     ```
   * If you see that, congrats — your Java program built and ran.


