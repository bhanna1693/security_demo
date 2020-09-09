import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm = new FormGroup({
    username: new FormControl(null),
    password: new FormControl(null)
  });

  constructor() {
  }

  ngOnInit(): void {
  }

  login(): void {
    const fd = new FormData();
    fd.append('username', this.loginForm.get('username').value);
    fd.append('password', this.loginForm.get('password').value);
    return;
  }

}
