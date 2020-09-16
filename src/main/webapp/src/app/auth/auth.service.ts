import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
  }

  login(loginForm: { username: string, password: string }): Observable<any> {
    const fd = new FormData();
    fd.append('username', loginForm.username);
    fd.append('password', loginForm.password);

    return this.http.post<any>(environment.API_URL + '/authenticate', fd)
      .pipe(
        map((userData) => {
          sessionStorage.setItem('username', loginForm.username);
          const tokenStr = 'Bearer ' + userData.token;
          sessionStorage.setItem('token', tokenStr);
          return userData;
        })
      );
  }

  logOut(): void {
    sessionStorage.removeItem('username');
  }

  isUserLoggedIn(): boolean {
    const user = sessionStorage.getItem('username');
    // console.log(!(user === null))
    return user !== null;
  }
}
