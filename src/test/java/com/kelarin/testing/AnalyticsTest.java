package com.kelarin.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AnalyticsTest extends AndroidTest {
    @Test
    public void analyticsPageFunctionality() {
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

        // Apply changes
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"btn_editor_back\"]")).click();

        // Make sure the task box is exist
        {
            boolean isTaskExist = findElementOrNull(By.xpath("//android.view.View[@resource-id=\"task_box_0\"]"));
            Assertions.assertEquals(true, isTaskExist, "Task is not exist");
        }
        // Open analytics page
        driver.findElement(By.xpath("//android.view.View[@resource-id=\"btn_footer_analytics\"]")).click();

        // Make sure the chart are filled in
        {
            boolean isElementExist = findElementOrNull(By.xpath("//android.view.View[@resource-id=\"sec_tasks_dist_empty_task\"]"));
            Assertions.assertEquals(false, isElementExist, "Tasks distribution chart is empty");
        }
        // Make sure the list of top 3 urgent tasks are filled in
        {
            boolean isElementExist = findElementOrNull(By.xpath("//android.view.View[@resource-id=\"sec_top3_tasks_empty_task\"]"));
            Assertions.assertEquals(false, isElementExist, "List of top 3 urgent tasks is empty");
        }
    }
}
