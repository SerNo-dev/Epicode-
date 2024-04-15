import { Component, Input } from '@angular/core';
import { Todo } from 'src/app/models/todo.interface';
import { Users } from 'src/app/models/users.interface';


@Component({
  selector: 'app-single-todo',
  templateUrl: './single-todo.component.html',
  styleUrls: ['./single-todo.component.scss']
})
export class SingleTodoComponent {
    @Input() todo!: Todo
    @Input() user!: Users;


    toggleComplete(todo: Todo) {
      todo.completed = !todo.completed; 
    }
}
