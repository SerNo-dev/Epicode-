import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  @Output() searchUserInput: EventEmitter<string> = new EventEmitter<string>();

  searchUser(userName: string) {
    this.searchUserInput.emit(userName);
  }
}
