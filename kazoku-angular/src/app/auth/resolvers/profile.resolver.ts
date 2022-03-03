import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { AuthService } from '../auth.service';
import { ProfileDto } from '../models/profile.dto';

@Injectable({
  providedIn: 'root'
})
export class ProfileResolver implements Resolve<ProfileDto|null> {
  constructor(private authService: AuthService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ProfileDto|null> {
    return this.authService.getProfile();
  }
}
