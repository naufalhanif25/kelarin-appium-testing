package com.kelarin.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditTaskTest extends AndroidTest {
    private String newTitle = "Belajar Framework Appium";
    private String newDescription = "Implementasi automation testing menggunakan Appium.";
    private String newPriority = "Delegate";

    @Test
    public void editAvailableTask() {
        // Make sure the task list is empty
        {
            boolean isTaskListEmpty = findElementOrNull(By.xpath("//android.view.View[@resource-id=\"page_task_list_empty_task\"]"));
            Assertions.assertEquals(true, isTaskListEmpty, "Task list is not empty");
        }
        // Click on add task button
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"btn_add_task\"]")).click();

        // Fill the task title text field
        {
            // Find task title text field element
            WebElement taskTitle = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"tf_task_title\"]"));

            // Send key to task title element
            taskTitle.clear();
            taskTitle.sendKeys(defaultTitle);

            // Make sure the task title text field is filled
            Assertions.assertEquals(defaultTitle, taskTitle.getAttribute("text"), "Task title does not match");
        }
        // Fill the task description text field
        {
            // Find task description text field element
            WebElement taskDescription = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"tf_task_description\"]"));

            // Send key to task description element
            taskDescription.clear();
            taskDescription.sendKeys(defaultDescription);

            // Make sure the task description text field is filled
            Assertions.assertEquals(defaultDescription, taskDescription.getAttribute("text"), "Task description does not match");
        }
        // Apply changes
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"btn_editor_apply_changes\"]")).click();
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"btn_editor_back\"]")).click();

        // Make sure the task box is exist
        {
            boolean isTaskExist = findElementOrNull(By.xpath("//android.view.View[@resource-id=\"task_box_0\"]"));
            Assertions.assertEquals(true, isTaskExist, "Task is not exist");
        }
        // Make sure the task title is match
        {
            WebElement taskBoxTitle = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_title\"]"));
            Assertions.assertEquals(defaultTitle, taskBoxTitle.getAttribute("text"), "Task title does not match");
        }
        // Make sure the task description is match
        {
            WebElement taskBoxDesc = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_description\"]"));
            Assertions.assertEquals(defaultDescription, taskBoxDesc.getAttribute("text"), "Task description does not match");
        }
        // Make sure the task priority is match
        {
            WebElement taskBoxPriority = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_priority\"]"));
            Assertions.assertEquals(defaultPriority, taskBoxPriority.getAttribute("text"), "Task priority does not match");
        }
        // Make sure the task deadline is not setted yet
        {
            WebElement taskBoxDeadline = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_deadline\"]"));
            Assertions.assertEquals(defaultDeadline, taskBoxDeadline.getAttribute("text"), "Task deadline not setted yet");
        }
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"task_box_0_btn_options\"]")).click();  // Open options dropdown
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"task_box_0_dd_options_item_1\"]")).click();  // Click on edit task button

        // Fill the task title text field with new value
        {
            // Find task title text field element
            WebElement taskTitle = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"tf_task_title\"]"));

            // Send key to task title element
            taskTitle.clear();
            taskTitle.sendKeys(newTitle);

            // Make sure the task title text field is filled
            Assertions.assertEquals(newTitle, taskTitle.getAttribute("text"), "Task title does not match");
        }
        // Fill the task description text field with new value
        {
            // Find task description text field element
            WebElement taskDescription = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"tf_task_description\"]"));

            // Send key to task description element
            taskDescription.clear();
            taskDescription.sendKeys(newDescription);

            // Make sure the task description text field is filled
            Assertions.assertEquals(newDescription, taskDescription.getAttribute("text"), "Task description does not match");
        }
        // Select task priority
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"btn_editor_priority\"]")).click();
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"dd_editor_priority_item_2\"]")).click();

        // Make sure the task priority is setted
        {
            WebElement priorityText = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"text_editor_priority\"]"));
            Assertions.assertEquals(newPriority, priorityText.getAttribute("text"), "Task priority does not match");
        }
        // Select task deadline
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"btn_editor_deadline\"]")).click();
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"btn_datetime_confirm\"]")).click();

        // Make sure the task deadline is setted
        {
            WebElement deadlineText = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"text_editor_deadline\"]"));
            Assertions.assertNotEquals("Add Deadline", deadlineText.getAttribute("text"), "Task deadline not setted yet");
        }
        // Apply changes
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"btn_editor_back\"]")).click();

        // Make sure the task title is match
        {
            WebElement taskBoxTitle = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_title\"]"));
            Assertions.assertEquals(newTitle, taskBoxTitle.getAttribute("text"), "Task title does not match");
        }
        // Make sure the task description is match
        {
            WebElement taskBoxDesc = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_description\"]"));
            Assertions.assertEquals(newDescription, taskBoxDesc.getAttribute("text"), "Task description does not match");
        }
        // Make sure the task priority is match
        {
            WebElement taskBoxPriority = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_priority\"]"));
            Assertions.assertEquals(newPriority, taskBoxPriority.getAttribute("text"), "Task priority does not match");
        }
        // Make sure the task deadline is setted
        {
            WebElement taskBoxDeadline = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_deadline\"]"));
            Assertions.assertNotEquals(defaultDeadline, taskBoxDeadline.getAttribute("text"), "Task deadline not setted yet");
        }
    }
}
