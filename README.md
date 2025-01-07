<h2><em>💎 Key Features 💎</em></h2>
<div>
  🟩 <strong>Graphical User Interface (GUI)</strong><br>
  &emsp;🔸 Built with JavaFX, providing a clean, intuitive interface for managing tasks.<br><br>
</div>
<div>
  🟩 <strong>Add Items</strong><br>
  &emsp;🔸 Easily add tasks or reminders to your to-do list through an input dialog.<br><br>
</div>
<div>
  🟩 <strong>Remove Items</strong><br>
  &emsp;🔸 Remove completed or unnecessary items with a straightforward interface.<br><br>
</div>
<div>
  🟩 <strong>Persistent Data Storage</strong><br>
  &emsp;🔸 Automatically saves your to-do list to a text file and reloads it every time the program starts.<br><br>
</div>
<div>
  🟩 <strong>Customizable Visual Design</strong><br>
  &emsp;🔸 Features hover effects for buttons and a soothing teal background for enhanced user experience.<br><br>
</div>
<div>
  🟩 <strong>Error Handling</strong><br>
  &emsp;🔸 Provides clear feedback for invalid inputs or errors, such as trying to remove non-existent items.<br><br>
</div>

<h2><em></en>✨ Purpose / Inspiration ✨</em></h2>
&emsp;This projects inspiration came from me trying a new way to stay organized by using a to-do list. I first tried to have a physical to-do list where I had a notepad and would write what I had to do. However, I don't like writting too much and my handwritting is not very good. So I then decided to try and use the note pad on my phone/computer. This was much better but I didn't like the feel of it and I didn't like how it looked. That's when I got the idea that I could just make my own using what I knew at the time in Java as this program was made in the summer leading up to my sophmore year of college. Personally I used this a good bit and it was a lot more engaging then other to do list apps as I made it and if I didn't like something or if I wanted to have a new feature I could make those changes right away.

<h2><em>⚙️ How it works ⚙️</em></h2>

&emsp;To start off, I used the JavaFX library to design the graphical user interface (GUI). The application displays a text area listing current tasks and two buttons, "Add" and "Remove". Clicking the "Add" button opens an input dialog where the user can type a task. Once submitted, the task is added to the list, displayed in the text area, and saved to a file named "toDoList.txt". Clicking the "Remove" button prompts the user to enter the exact task they want to delete. If the task exists, it is removed from the list, and the updated list is displayed and saved.  

&emsp;The application reads tasks from the "toDoList.txt" file upon startup. That way it ensures the list is always up-to-date. Any changes are saved back to this file automatically. Alerts provide feedback to the user, confirming successful actions like adding or removing items or notifying of errors if something goes wrong (e.g., trying to remove a task that doesn't exist).  

&emsp;The design also includes hover effects on buttons for better interactivity and a calming teal background for an aesthetically pleasing experience. Simple yet effective, this to-do list program demonstrates core JavaFX features and file I/O while providing an efficient task management tool.
