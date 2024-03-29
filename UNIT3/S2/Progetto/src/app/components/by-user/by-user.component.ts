import { Component, OnDestroy, OnInit } from '@angular/core';
import { Todo } from 'src/app/models/todo.interface';
import { TodoService } from 'src/app/service/todo.service';
import { Users } from 'src/app/models/users.interface';
import { UsersService } from 'src/app/service/users.service';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-by-user',
  templateUrl: './by-user.component.html',
  styleUrls: ['./by-user.component.scss']
})
export class ByUserComponent {

  subTodo!: Subscription;
  subUsers!: Subscription;
  
  todos: Todo[] = [];
  users: Users[] = [];
  combinedArray: { todo: Todo; user: Users }[] = [];

  constructor(private todoSrv: TodoService, private usersSrv: UsersService) {}

  ngOnInit(): void {
    this.subTodo = this.todoSrv.getTodos().subscribe(
      (todos: Todo[]) => {
        console.log('Dati ricevuti nel componente todos:', todos);
        this.todos = todos;
        this.combineArrays();
      },
      (error) => {
        console.log(error);
      }
    );

    this.subUsers = this.usersSrv.getUsers().subscribe(
      (users: Users[]) => {
        console.log('Dati ricevuti nel componente users:', users);
        this.users = users;
        this.combineArrays();
      },
      (error) => {
        console.log(error);
      }
    );
  }

  
  combineArrays(): void {
    if (this.todos.length > 0 && this.users.length > 0) {
      this.combinedArray = this.todos.map((todo, index) => ({
        todo,
        user: this.users[index],
      }));
  
    }
  }
}
