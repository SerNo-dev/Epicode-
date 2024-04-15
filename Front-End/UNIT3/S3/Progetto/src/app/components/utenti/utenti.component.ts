import { Component, OnInit } from '@angular/core';
import { Register } from 'src/app/models/register.interface';
import { UsersService } from 'src/app/service/users.service';

@Component({
  selector: 'app-utenti',
  templateUrl: './utenti.component.html',
  styleUrls: ['./utenti.component.scss']
})
export class UtentiComponent implements OnInit {
  users: Register[] = [];
  loading = false;

  constructor(private userSrv: UsersService) { }

  ngOnInit(): void {
    this.loading = true; 
    this.userSrv.getUsers().subscribe(
      (data) => {
        this.users = data;
        this.loading = false; 
      },
      (error) => {
        console.error('Errore durante il recupero degli utenti:', error);
        this.loading = false; 
      }
    );
  }
}
