import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {AuthService} from '../../auth/auth.service';

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

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
  }

  submitLogin(): void {
    this.authService.login(this.loginForm.value).subscribe();
  }

}
