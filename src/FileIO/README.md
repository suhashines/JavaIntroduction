<h1 align="center">Coder Vai</h1>
---
<h1 align="center">File I/O</h1>

##  What is File I/O?

File I/O (Input/Output) refers to reading from and writing to files stored on the system. It enables programs to save data permanently, beyond runtime.

| Class                                  | Purpose                               |
| -------------------------------------- | ------------------------------------- |
| **File**                               | Represents a file or directory path   |
| **FileWriter / FileReader**            | Writing/Reading text files            |
| **BufferedWriter / BufferedReader**    | Faster writing/reading with buffering |
| **FileInputStream / FileOutputStream** | Reading/Writing binary data           |
| **Scanner**                            | Convenient file reading               |

##  Common Operations

- Create a file → File.createNewFile()

- Write to a file → FileWriter, BufferedWriter

- Read a file → Scanner, FileReader, BufferedReader

- Delete a file → File.delete()

- Check information → getName(), getAbsolutePath(), length()

##  Best Practices

Always close files (or use try-with-resources).

- Prefer BufferedReader/BufferedWriter for large files.

- Use FileInputStream, FileOutputStream with BufferedInputStream or BufferedOutputStream to read binary files (images,pdf,audio etc).

- Handle IOException properly.

- **Always check if a file exists before reading.**