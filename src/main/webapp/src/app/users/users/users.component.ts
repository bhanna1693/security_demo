import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {ActivatedRoute} from '@angular/router';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  user$ = this.getUser();
  mgmtUsers$ = this.managementGetUsers();

  constructor(private http: HttpClient,
              private activatedRoute: ActivatedRoute) {
  }

  get id(): string {
    return this.activatedRoute.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
  }

  getUser(): Observable<any> {
    return this.http.get(environment.API_URL + '/users/' + this.id);
  }

  managementGetUsers(): Observable<any> {
    return this.http.get(environment.MANAGEMENT_API_URL + '/users');
  }

}
