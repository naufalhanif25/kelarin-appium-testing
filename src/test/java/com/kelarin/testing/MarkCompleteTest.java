package com.kelarin.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MarkCompleteTest extends AndroidTest {
    @Test
    public void markTaskAsComplete() {
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

        // Open sidebar menu
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_open_sidebar\"]")
        ).click();

        // Open completed page
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_sidebar_completed\"]")
        ).click();

        // Make sure the task list is empty
        {
            boolean isTaskListEmpty = findElementOrNull(
                By.xpath("//android.view.View[@resource-id=\"page_completed_empty_task\"]")
            );
            Assertions.assertEquals(
                true, 
                isTaskListEmpty, 
                "Task list is not empty"
            );
        }

        // Open sidebar menu
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_open_sidebar\"]")
        ).click();

        // Open dashboard page
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_sidebar_dashboard\"]")
        ).click();

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

        // Apply changes
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

        // Open options dropdown
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"task_box_0_btn_options\"]")
        ).click();

        // Mark task as done (complete)
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"task_box_0_dd_options_item_0\"]")
        ).click();

        // Open sidebar menu
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_open_sidebar\"]")
        ).click();

        // Open completed page
        driver.findElement(
            By.xpath("//android.view.View[@resource-id=\"btn_sidebar_completed\"]")
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
    }
}
