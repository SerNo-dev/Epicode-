import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  invalidLogin = false; 
  errorText = '';

  constructor(private authSrv: AuthService, private router: Router) {}

  login(form: NgForm) {
      if (form.invalid) {
          return; 
      }
      
      this.authSrv.login(form.value).subscribe(
          () => {
              this.router.navigate(['/']);
          },
          (error) => {
              console.error(error);
              this.invalidLogin = true;
              this.errorText = error; 
          }
      );
  }
}
