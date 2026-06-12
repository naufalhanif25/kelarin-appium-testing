package com.kelarin.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddTaskTest extends AndroidTest {
    @Test
    public void addNewTask() {
        // Make sure the task list is empty
        {

            boolean isTaskListEmpty = findElementOrNull(
                By.xpath("//android.view.View[@resource-id=\"page_task_list_empty_task\"]")
            );
            Assertions.assertEquals(
                true, 
                isTaskListEmpty, 
                "Task list is not empty"
            );
        }

        // Click on add task button
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_add_task\"]")
        ).click();

        // Fill the task title text field
        {
            // Find task title text field element
            WebElement taskTitle = driver.findElement(
                By.xpath("//android.widget.EditText[@resource-id=\"tf_task_title\"]")
            );

            // Send key to task title element
            taskTitle.clear();
            taskTitle.sendKeys(defaultTitle);

            // Make sure the task title text field is filled
            Assertions.assertEquals(
                defaultTitle, 
                taskTitle.getAttribute("text"), 
                "Task title does not match"
            );
        }

        // Fill the task description text field
        {
            // Find task description text field element
            WebElement taskDescription = driver.findElement(
                By.xpath("//android.widget.EditText[@resource-id=\"tf_task_description\"]")
            );

            // Send key to task description element
            taskDescription.clear();
            taskDescription.sendKeys(defaultDescription);

            // Click on undo button
            driver.findElement(
                By.xpath("//android.view.View[@resource-id=\"btn_editor_undo\"]")
            ).click();
            // Click on redo button
            driver.findElement(
                By.xpath("//android.view.View[@resource-id=\"btn_editor_redo\"]")
            ).click();

            // Make sure the task description text field is filled
            Assertions.assertEquals(
                defaultDescription, 
                taskDescription.getAttribute("text"), 
                "Task description does not match"
            );
        }

        // Select task priority
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_editor_priority\"]")
        ).click();
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"dd_editor_priority_item_0\"]")
        ).click();

        // Make sure the task priority is setted
        {
            WebElement priorityText = driver.findElement(
                By.xpath("//android.widget.TextView[@resource-id=\"text_editor_priority\"]")
            );
            Assertions.assertEquals(
                defaultPriority, 
                priorityText.getAttribute("text"), 
                "Task priority does not match"
            );
        }

        // Select task deadline (click on dismiss button)
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_editor_deadline\"]")
        ).click();
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_datetime_dismiss\"]")
        ).click();

        // Select task deadline (click on confirm button)
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_editor_deadline\"]")
        ).click();
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_datetime_confirm\"]")
        ).click();

        // Make sure the task deadline is setted
        {
            WebElement deadlineText = driver.findElement(
                By.xpath("//android.widget.TextView[@resource-id=\"text_editor_deadline\"]")
            );
            Assertions.assertNotEquals(
                "Add Deadline", 
                deadlineText.getAttribute("text"), 
                "Task deadline not setted yet"
            );
        }

        // Apply changes
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_editor_apply_changes\"]")
        ).click();
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_editor_back\"]")
        ).click();

        // Make sure the task box is exist
        {
            boolean isTaskExist = findElementOrNull(
                By.xpath("//android.view.View[@resource-id=\"task_box_0\"]")
            );
            Assertions.assertEquals(
                true, 
                isTaskExist, 
                "Task is not exist"
            );
        }

        // Make sure the task title is match
        {
            WebElement taskBoxTitle = driver.findElement(
                By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_title\"]")
            );
            Assertions.assertEquals(
                defaultTitle, 
                taskBoxTitle.getAttribute("text"), 
                "Task title does not match"
            );
        }

        // Make sure the task description is match
        {
            WebElement taskBoxDesc = driver.findElement(
                By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_description\"]")
            );
            Assertions.assertEquals(
                defaultDescription, 
                taskBoxDesc.getAttribute("text"), 
                "Task description does not match"
            );
        }

        // Make sure the task priority is match
        {
            WebElement taskBoxPriority = driver.findElement(
                By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_priority\"]")
            );
            Assertions.assertEquals(
                defaultPriority, 
                taskBoxPriority.getAttribute("text"), 
                "Task priority does not match"
            );
        }

        // Make sure the task deadline is setted
        {
            WebElement taskBoxDeadline = driver.findElement(
                By.xpath("//android.widget.TextView[@resource-id=\"task_box_0_text_task_deadline\"]")
            );
            Assertions.assertNotEquals(
                defaultDeadline, 
                taskBoxDeadline.getAttribute("text"), 
                "Task deadline not setted yet"
            );
        }
    }
}
