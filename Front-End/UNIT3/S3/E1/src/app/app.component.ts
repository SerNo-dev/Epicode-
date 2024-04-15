import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { User } from './interface/user.interface';
import { Validators } from '@angular/forms';
import { FormArray } from '@angular/forms';
import { AbstractControl } from '@angular/forms';
import { FormControl } from '@angular/forms';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  title = 'E1';

  form!: FormGroup;
  genere = ['Uomo', 'Donna'];
  user!: User;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    (this.form = this.fb.group({
      nome: this.fb.control(null, [Validators.required,Validators.pattern(/^[a-zA-Z]+$/)]),
      cognome: this.fb.control(null, [Validators.required,Validators.pattern(/^[a-zA-Z]+$/)]),
      password: this.fb.control(null, [
        Validators.required,
        Validators.maxLength(8),
        Validators.minLength(5),
        Validators.pattern(
          '^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$'
        ),
      ]),
      confermaPassword: this.fb.control(null, [Validators.required]),
      immagine: this.fb.control(null, [
        Validators.required,
        Validators.pattern('(https?://.*.(?:png|jpeg|jpg|webp))'),
      ]),
      username: this.fb.control(null, [Validators.pattern(/^[a-zA-Z]+$/)]),
      genere: this.fb.control(''),
      biografia: this.fb.control(null),

      
    })),
      this.form.valueChanges.subscribe((status) => {
        console.log('Stato del form', status);
      });
  }

  getErrorsC(name: string, error: string) {
    return this.form.get(name)?.errors![error];
  }

  getFormC(name: string) {
    return this.form.get(name);
  }

  submit() {
    this.user = this.form.value;
    console.log('Oggetto user:', this.user);
    console.log('Form correttamente inviato');
    this.form.reset();
  }
}
