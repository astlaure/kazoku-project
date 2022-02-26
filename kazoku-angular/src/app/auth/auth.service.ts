import { Injectable } from '@angular/core';
import { BehaviorSubject, catchError, map, of, tap } from 'rxjs';
import { ProfileDto } from './models/profile.dto';
import { HttpClient, HttpParams } from '@angular/common/http';
import { LoginDto } from './models/login.dto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  profile = new BehaviorSubject<ProfileDto | null>(null);
  profileLoaded = false;

  constructor(private httpClient: HttpClient) { }

  getProfile() {
    return this.httpClient.get<ProfileDto>('api/auth/profile')
      .pipe(
        map((value) => {
          this.profile.next(value);
          return value;
        }),
        catchError(() => {
          this.profile.next(null);
          return of(null);
        }),
        tap(() => this.profileLoaded = true),
      );
  }

  postLogin(login: LoginDto) {
    const httpParams = new HttpParams({
      fromObject: { ...login },
    });
    return this.httpClient.post('api/auth/login', httpParams);
  }

  postLogout() {
    return this.httpClient.post('api/auth/logout', undefined);
  }
}
