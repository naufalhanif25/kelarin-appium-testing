# Kelarin Appium Testing

Kelarin is a modern, task management application built for Android that helps users organize their daily workflows using proven productivity frameworks. By combining smart task lifecycle tracking with a structured matrix organization, the application provides users with actionable insights into their responsibilities while maintaining a clean, distraction-free interface. The application leverages the Eisenhower Matrix framework to assist users in making quick decisions regarding task urgency and importance. With an integrated statistics engine, standard task progression states, and granular filtering mechanisms, Kelarin serves as a comprehensive tool to maximize personal efficiency and prevent task overload. The official source code for the application is available at the [Kelarin Repository](https://github.com/naufalhanif25/Kelarin.git).

This automation testing project is designed to validate the core functional behaviors, page navigations, and user workflows of the Kelarin Android application. Built using Java, Appium, and JUnit 5, the test suite executes automated end-to-end regression tests on Android emulators or physical devices to ensure the stability of features such as task creation, matrix prioritizing, and statistics computation.

## Prerequisites

Before running the test suite, ensure that your development environment meets the following requirement specifications:

* **Java Development Kit (JDK):** Version 17.0.12 or higher.
* **Apache Maven:** Version 3.9.16 or higher.
* **Appium Server:** Version 3.5.0 or higher.
* **Android SDK:** Installed with appropriate platform tools and system images.
* **Environment Variables:** 
    * `JAVA_HOME` configured pointing to your JDK installation path.
    * `ANDROID_HOME` configured pointing to your Android SDK installation path.
    * System `PATH` updated to include both JDK and Android SDK platform-tools/tools binaries.
* **Android Emulator / Real Device:** An active Android Virtual Device (AVD) running Android API Level 33 or higher with USB debugging enabled.

## Configuration Setup

Before executing the test suite, create a `.env` file in the root directory of this project to specify your local Appium execution capabilities. Use the following template or modify the `.env.example` file::

```env
APPIUM_URL=[http://127.0.0.1:4723/](http://127.0.0.1:4723/)
APPIUM_PLATFORM_NAME=Android
APPIUM_DEVICE_NAME=Android Emulator
APPIUM_AUTOMATION_NAME=UiAutomator2
APPIUM_APP_PATH=C:/Users/USER/AndroidStudioProjects/Kelarin/app/build/outputs/apk/debug/app-debug.apk
```

## List of Kelarin App Element IDs

The following table documents the resource identifiers used across various application pages and components to locate elements within the Appium automation framework:

| Page/Component | Description | Element ID | Placeholder Information |
|----------------|-------------|------------|-------------------------|
| Task List / Completed / Trash | Filter button | `btn_filter` | - |
| Task List / Completed / Trash | Filter dropdown container | `dd_filter_container` | - |
| Task List / Completed / Trash | Filter dropdown item | `dd_filter_item_%d` | `%d = 0..n (index)` |
| Task List | Add task button | `btn_add_task` | - |
| Task List / Completed / Trash | Task box | `task_box_%d` | `%d = 0..n (index)` |
| Task List / Completed / Trash | Task box options button | `task_box_%d_btn_options` | `%d = 0..n (index)` |
| Task List / Completed / Trash | Task box options dropdown container | `task_box_%d_dd_options_container` | `%d = 0..n (index)` |
| Task List / Completed / Trash | Task box options dropdown item | `task_box_%d1_dd_options_item_%d2` | `%d1 = 0..n (parent_index), %d2 = 0..n (index)` |
| Task List / Completed / Trash | Task box checkbox | `task_box_%d_cb_mark_complete` | `%d = 0..n (index)` |
| Task List / Completed / Trash | Task box title text | `task_box_%d_text_task_title` | `%d = 0..n (index)` |
| Task List / Completed / Trash | Task box description text | `task_box_%d_text_task_description` | `%d = 0..n (index)` |
| Task List / Completed / Trash | Task box deadline text | `task_box_%d_text_task_deadline` | `%d = 0..n (index)` |
| Task List / Completed / Trash | Task box priority text | `task_box_%d_text_task_priority` | `%d = 0..n (index)` |
| Task List / Completed / Trash | Empty task | `%s_empty_task` | `%s = <page_id>` |
| Analytics | Task distribution section | `sec_tasks_dist` | - |
| Analytics | Top 3 urgent tasks section | `sec_top3_tasks` | - |
| Analytics | Empty task | `%s_empty_task` | `%s = <section_id>` |
| Analytics | Priority count detail | `cd_priority_%d` | `%d = 0..n (index)` |
| Analytics | Task status and rate count detail | `cd_task_%d1_%d2` | `%d1 = 0..n (parent_index), %d2 = 0..n (index)` |
| Header | Open sidebar button | `btn_open_sidebar` | - |
| Header | Change theme button | `btn_change_theme` | - |
| Footer | Open Tasks page navigation button | `btn_footer_todo` | - |
| Footer | Footer container | `footer_container` | - |
| Footer | Open Analytics page navigation button | `btn_footer_analytics` | - |
| Sidebar | Sidebar container | `sidebar_container` | - |
| Sidebar | Open Dashboard navigation button | `btn_sidebar_dashboard` | - |
| Sidebar | Open Completed page navigation button | `btn_sidebar_completed` | - |
| Sidebar | Open Trash page navigation button | `btn_sidebar_trash` | - |
| Sidebar | Open Settings page navigation button | `btn_sidebar_settings` | - |
| Sidebar | Close sidebar button | `btn_close_sidebar` | - |
| Settings | Theme selector box | `theme_selector` | - |
| Settings | Open theme selector dropdown button | `theme_selector_btn_setting` | - |
| Settings | Theme selector dropdown container | `theme_selector_dd_setting_container` | - |
| Settings | Theme selector dropdown item | `theme_selector_dd_setting_item_%d` | `%d = 0..n (index)` |
| Alert Popup | Popup container | `popup_alert` | - |
| Alert Popup | Confirm button | `btn_alert_popup_confirm` | - |
| Alert Popup | Dismiss button | `btn_alert_popup_dismiss` | - |
| Page | Analytics page | `page_analytics` | - |
| Page | Completed page | `page_completed` | - |
| Page | Settings page | `page_settings` | - |
| Page | Trash page | `page_trash` | - |
| Page | Task List page | `page_task_list` | - |
| Page | Task Editor page | `page_task_editor` | - |
| Task Editor | Title text field | `tf_task_title` | - |
| Task Editor | Description text field | `tf_task_description` | - |
| Task Editor | Back button | `btn_editor_back` | - |
| Task Editor | Apply changes button | `btn_editor_apply_changes` | - |
| Task Editor | Undo button | `btn_editor_undo` | - |
| Task Editor | Redo button | `btn_editor_redo` | - |
| Task Editor | Add deadline button | `btn_editor_deadline` | - |
| Task Editor | Deadline value text | `text_editor_deadline` | - |
| Task Editor | Add priority button | `btn_editor_priority` | - |
| Task Editor | Priority value text | `text_editor_priority` | - |
| Task Editor | Priority selector dropdown container | `dd_editor_priority_container` | - |
| Task Editor | Priority selector dropdown item | `dd_editor_priority_item_%d` | `%d = 0..n (index)` |
| Deadline Selector | Date-time picker dialog | `dialog_datetime_picker` | - |
| Task Editor (Deadline Selector) | Confirm button | `btn_datetime_confirm` | - |
| Task Editor (Deadline Selector) | Dismiss button | `btn_datetime_dismiss` | - |
| Task Editor (Deadline Selector) | Month wheel picker | `wp_month_selector` | - |
| Task Editor (Deadline Selector) | Day wheel picker | `wp_day_selector` | - |
| Task Editor (Deadline Selector) | Hour wheel picker | `wp_hour_selector` | - |
| Task Editor (Deadline Selector) | Minute wheel picker | `wp_minute_selector` | - |
| Task Editor (Deadline Selector) | Wheel picker item container | `%s_item_container` | `%s = <wheel_picker_id>` |

## How to Run the Tests

Follow these step-by-step procedures to trigger the test suite execution:

1. **Launch the Android Emulator or Device:** Start your preferred Android Virtual Device (AVD) from Android Studio Device Manager, or connect a physical Android phone via USB. Verify the connection by running `adb devices` in your terminal.
2. **Start the Appium Server:** Open a separate terminal window and execute the `appium` command to activate the server listener on the default port.
3. **Execute the Test Suite:** Navigate to the root directory of this testing project in your terminal and execute the Maven command to start test execution.
    * To run the tests standardly:
    ```bash
    mvn test
    ```
    * To perform a fresh build and run clean tests:
    ```bash
    mvn clean test
    ```

## Automated Test Scenarios

The test suite contains automated end-to-end regression tests categorized into five core testing classes. Each class validates specific features, user pathways, and UI state constraints within the Kelarin application:

### 1. Task Creation Testing (`AddTaskTest`)
Validates the complete workflow of adding a new task to the task management system, ensuring data integrity from input to storage.
* **Pre-condition Validation:** Verifies that the task list is initially empty before starting the input sequence.
* **Form Input and Integrity:** Asserts that input values for the title and description fields map correctly.
* **State Operations:** Simulates and validates the behavior of the Undo and Redo text editing controls.
* **Component Selectors:** Validates dropdown interaction for selecting priority values and simulates calendar dialog behavior by testing both the dismiss and confirm actions.
* **Post-save Data Matching:** Confirms that the newly generated task card appears on the dashboard with identical properties for title, description, priority, and deadline values.

### 2. Analytics and Visualization Testing (`AnalyticsTest`)
Ensures that metrics engine calculations and active graphs respond dynamically to data insertion.
* **Navigation Flow:** Validates footer component navigation by shifting from the default task page to the statistics display.
* **Data Presentation Assertions:** Confirms that once a task is registered in the system, both the tasks distribution breakdown chart and the top 3 urgent tasks listing transition from an empty state to rendering active visual metrics.

### 3. Task Disposal and Lifecycle Testing (`DeleteTaskTest`)
Verifies the standard lifecycle transition of a task from active execution to temporary deletion, recovery, and final erasure.
* **State Scoping:** Checks that the active task board and the trash bin partition are completely clear before beginning operations.
* **Trash Transition:** Confirms that moving a task to the trash successfully clears it from the main task dashboard.
* **Recovery Mechanism:** Validates the restoration workflow by verifying that recovering a task from the trash successfully populates it back into the active task pool.
* **Destructive Confirmation Popups:** Exercises safe operational constraints by testing the cancel action on the deletion modal before executing the confirmed permanent deletion process.

### 4. Task Modification Testing (`EditTaskTest`)
Ensures that existing task records can be securely edited and that modifications update consistently across the interface.
* **Baseline Verification:** Populates an initial task structure into the database and checks that original properties are mapped accurately to the UI view model.
* **Property Updates:** Overwrites the current entries with updated values for title text, descriptive body paragraphs, matrix priority values, and updated target deadlines.
* **Persistence Assurance:** Navigates back to the main list view to guarantee that the older data is entirely replaced by the modified data structures on the interface view.

### 5. Completion State Tracking Testing (`MarkCompleteTest`)
Validates functional requirements regarding state transformations when a user marks a task item as resolved.
* **State Scopes:** Monitors the isolated scopes between active assignments and completed assignment logs.
* **Status Inversion:** Triggers the mark complete option on the task dropdown menu.
* **Isolation Verification:** Asserts that resolved assignments are systematically moved out of the primary workflow screen and are logged correctly within the dedicated completed tasks view.