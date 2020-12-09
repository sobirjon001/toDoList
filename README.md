# Welcome to To Do List Project

you can see markdown syntax [here](https://github.com/marktext/marktext/blob/master/docs/MARKDOWN_SYNTAX.md)

### System Requirements Specification Document

n| User Story | Acceptance criteria
-|-|-
1| As a use I Want to be able to add task | User able to add task    
2| As a use I Want to be able to delete task  | User should be able to delete chosen task  
-| - | Reduction of the number of items
3| As a user I Want to be able to check mark the task  | User able to check mark chosen task
4| As a user I Want to be able to see all task  | User able to see all tasks and their status
5| As a user I Want to be able to sort task according to status | User able to see a list according to chosen status
6| As a user I Want to be informed for invalid entry | Application should inform user about invalid entry and prompt to try again

## Sprint Backlog

- [ ] Create a template for To-Do Task
  - Template have task instance
  - Template have status instance of done or not done
  - Template have ability to change status
  - Template have ability to be printed and display task and status
- [ ] Create a menu
  - List all tasks
  - inform no tasks if tasks list is empty
  - List all options:
    - add task
    - delete task
    - change status
    - show all done tasks
    - show all not done tasks
  - have a logic to check invalid entry
  - call function corresponding to chosen option if tasks list is not empty
  - inform no tasks if tasks list is empty and reload menu
- [ ] Add task
  - add task to List
  - return to menu
- [ ] Delete task from List
  - application asks use what do delete by showing list with indexes
  - chosen task by index is deleted
  - have a logic to check invalid entry
  - return to menu
- [ ] Change status of task
  - application asks use what task to change status by showing list with indexes
  - change status of chosen task index
  - have a logic to check invalid entry
  - return to menu
- [ ] Show all done tasks
  - application lists all done tasks
  - inform no done tasks if so
  - after users command (press Enter) return to menu
- [ ] Show all not done tasks
  - application lists all not done tasks
  - inform no not done tasks if so
  - after users command (press Enter) return to menu
