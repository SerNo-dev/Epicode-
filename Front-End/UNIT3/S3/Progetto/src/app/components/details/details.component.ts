import { Component, OnInit } from '@angular/core';
import { AuthData } from 'src/app/models/auth-data.interface'; // Importa l'interfaccia AuthData

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss'],
})
export class DetailsComponent implements OnInit {
  utenteCorrente: AuthData | null = null;
  constructor() {}

  ngOnInit(): void {
    const userFromLocalStorage = localStorage.getItem('user');
    if (userFromLocalStorage) {
      this.utenteCorrente = JSON.parse(userFromLocalStorage);
    }
    console.log('user', this.utenteCorrente);
  }
}
